package services.impl;

import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DAO.ReciboDAO;
import DAO.ServicioDAO;
import DTO.CuentaTarjetaDTO;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import constants.Mensajes;
import exception.*;
import models.Atm;
import models.Cuenta;
import models.Movimiento;
import models.Ticket;
import services.OpAvanzadas;
import services.OpBasicas;

import java.time.LocalDate;

public class PractiCaja extends Atm implements OpBasicas, OpAvanzadas {

    private CuentaDAO cuentaDAO = new CuentaDAO();
    private ServicioDAO servicioDAO = new ServicioDAO();
    private ReciboDAO reciboDAO = new ReciboDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();

    private int cajeroId;


    public PractiCaja(String ubicacion, int folioOperacio, int cajeroId) {
        super(ubicacion, folioOperacio);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarCuenta(int numCuenta) {

        return null;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta =  cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta!=null){
            System.out.println("El saldo disponible es: "+cuenta.getSaldo());
        }else{
            System.out.println("No existe una cuenta asociada a esa tarjeta");
        }

    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNotExistException, WrongNipException, InsufficientBalanceException, UnderMinimunException {
        Object[] data = new Object[2];//Objeto de salida [dinero,ticket]
        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        //System.out.println(">>>>>>>>>>>>>>>>>>>"+cuenta);
        if (cuenta==null){
            //System.out.println("No existe la cuenta asociada a la tarjeta: ");
            throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (!(cuenta.getNip().equals(nip))) {//valida el nip
            //System.out.println("NIP incorrecto");
            throw new WrongNipException(Mensajes.CUENTA_NO_EXISTE);
        }else if (cuenta.getSaldo()<monto){
            //.out.println("Saldo insuficiente");
            throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);
        } else if ( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            //System.out.println("Retiro no disponle. Quedaria por debajo del minimo");
            throw new UnderMinimunException(Mensajes.BAJO_EL_MINIMO);

        }else{
            //retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()-monto);
            this.setFolioOperacio(this.getFolioOperacio()+1);//actualizar el folio de operacion
            //registrar movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),
                    "RETIRO",monto);
            movimientoDAO.registrarMovimineto(m);


            //construir el ticket
            ticket = new Ticket(this.cajeroId, this.getFolioOperacio(), this.getUbicacion(),
                    LocalDate.now(), cuenta.getNumCuenta(), "RETIRO", monto);
            data[0] = monto;
            data[1] = ticket;
        }
        return data;
    }

    @Override
    public Ticket despositar(long numTarjeta, int monto) throws BusinessException {
        //busqueda exista
        //validar que el monto quepa dentro de la cuenta : monto > saldoMax
        //valiodar que al depsositar no se pase del maximo de la cuenta : (saldo + monto) > SaldoMax
        //depositar
        CuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        Ticket ticket = null;

        if (cuenta==null){
            //System.out.println("No existe la cuenbta asociada a la tarjeta...");
            throw new BusinessException(Mensajes.CUENTA_NO_EXISTE);
        } else if (monto > cuenta.getSaldoMax()) {
            //System.out.println("La cantidad exede el maximo permitido de la cuenta...");
            throw new BusinessException(Mensajes.SOBRE_EL_MAXIMOI);
        } else if ((cuenta.getSaldo()+monto) > cuenta.getSaldoMax()) {
            //System.out.println("El deposito sumaria una cantidad mayor al maximo permitido...");
            throw new BusinessException(Mensajes.DEPOSITO_EXCEDIDO);
        }else{
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()+monto);
            this.setFolioOperacio(this.getFolioOperacio()+1);
            ticket = new Ticket(this.cajeroId, this.getFolioOperacio(), this.getUbicacion(),
                    LocalDate.now(), cuenta.getNumCuenta(), "DEPOSITO", monto);
            //registrar movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),
                    "RETIRO",monto);
            movimientoDAO.registrarMovimineto(m);
        }
        return ticket;
    }

    @Override
    public Ticket pagarServicio(long numTarjeta, String convenio, String referencia)
    throws AccountNotExistException, BusinessException{
        CuentaTarjetaDTO cuenta = null;
        ServicioDTO servicio = null;
        Ticket t = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        servicio = servicioDAO.buscarServicio(convenio,referencia);
        if (cuenta==null) {
            throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (servicio==null) {
            throw new BusinessException("El recibo indicado no existe o ya fue pagado...");
        }else if (cuenta.getSaldo() < servicio.getMonto()
                || (cuenta.getSaldo() - servicio.getMonto() < cuenta.getSaldoMin())){
            throw new BusinessException(Mensajes.BAJO_EL_MINIMO);

        }else {
            reciboDAO.pagarRcibo(referencia);//pago           casteo : conversion directa :
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), (int)(cuenta.getSaldo()-servicio.getMonto()));
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),
                    "PAGO DE SERVICIOS",(int)servicio.getMonto());
            movimientoDAO.registrarMovimineto(m);
            this.setFolioOperacio(this.getFolioOperacio()+1);
            //Generar ticket
            t = new Ticket(this.cajeroId, this.getFolioOperacio(), this.getUbicacion(),
                    LocalDate.now(), cuenta.getNumCuenta(), "PAGO DE SERVICIOS",
                    (int)servicio.getMonto());

        }
        return t;
    }

    @Override
    public ReporteMovimientosClienteDTO generarReporte(String cliente)
    throws BusinessException{

        ReporteMovimientosClienteDTO reporte =  null;
        reporte = movimientoDAO.generarReportePorCliente(cliente);

        if (reporte!=null){
            return reporte;
        }else{
            throw new BusinessException(Mensajes.REPORTE_INVALIDO);
        }
    }
}
