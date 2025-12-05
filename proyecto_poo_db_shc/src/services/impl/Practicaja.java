package services.impl;

import DAO.*;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import DTO.cuentaTarjetaDTO;
import constants.Mensajes;
import exceptions.*;
import models.Atm;
import models.Cuenta;
import models.Ticket;
import services.OpAvanzadas;
import services.OpBasicas;

import java.time.LocalDate;

public class Practicaja extends Atm implements OpBasicas, OpAvanzadas {
    private int cajeroId;

    // compoentes que componen la base, es para llamar
    private cuentaDAO cuentaDAO = new cuentaDAO();
    private ServiciosDAO serviciosDAO = new ServiciosDAO();
    private ReciboDAO reciboDAO = new ReciboDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();


    private int getCajeroId;

    public Practicaja(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarcCuenta(int numCuenta) {
        return null;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        cuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if (cuenta != null) {
            System.out.println("El saldo disponible es:" + cuenta.getSaldo());
        } else {
            System.out.println("No existe una cuenta asociada a esa tarjeta");
        }
    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto) throws AccountNotExitException, WrongNipException,InsufficientBalanceException, UnderMinimunException {
        Object[] data = new Object[2]; // objeto de salida[dinero,ticket]
        cuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if (cuenta == null) {
            throw new AccountNotExitException(Mensajes.CUENTA_NO_EXISTE);
        } else if (!(cuenta.getNip().equals(nip))) {
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);
        } else if (cuenta.getSaldo() < monto) {
            throw  new InsufficientBalanceException(Mensajes.SALDO_INCISUFICIENTE);
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldo()) {
            throw new UnderMinimunException(Mensajes.BAJO_DEL_MINIMO);
        } else{
            // retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo() - monto);
            this.setFolioOperacion(this.getFolioOperacion() + 1);//actualiza el folio de la operacion
            // Registar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now (),"RETIRO", monto);
            movimientoDAO.registrarMovimiento(m);


            // construir el ticket
            ticket = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(),
                    LocalDate.now(),cuenta.getNumCuenta(),"RETIRO", monto);
            data[0]=monto;
            data[1]=ticket;
        }
        return data;
    }


    @Override
    public Ticket depositar(long numTarjeta, int monto) throws BusinessException {
        //Busqueda: que exita
        // validar que el monto quepa dentro de la cuenta:monto > saldoMax
        // Validar que al depositar no se pase del maximo de la cuenta: (saldo + monto) > saldoMax
        //depositar

        cuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        Ticket ticket = null;
        if (cuenta == null) {
            throw new BusinessException(Mensajes.CUENTA_NO_EXISTE);
        } else if (monto >cuenta.getSaldoMax()) {
            throw new BusinessException(Mensajes.SOBRE_EL_MAXIMO);
        } else if( (cuenta.getSaldo() + monto) > cuenta.getSaldoMax()){
            throw new BusinessException(Mensajes.DEPOSITO_EXCEDIDO);
        } else {
            //deposito
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo() + monto);
            this.setFolioOperacion(this.getFolioOperacion() + 1);
            // Registar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now (),"DEPOSITO", monto);
            movimientoDAO.registrarMovimiento(m);
            ticket = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(),
                    LocalDate.now(),cuenta.getNumCuenta(),"DEPOSITO", monto);
        }

        return ticket;
    }

    @Override
    public Ticket pagarServicios(long numTarjeta, String convenio, String referencia)
    throws AccountNotExitException, BusinessException {
        cuentaTarjetaDTO cuenta = null;
        ServicioDTO servicio = null;
        Ticket t = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        servicio= serviciosDAO.buscarServicio(convenio,referencia);
        if (cuenta == null){
            throw new AccountNotExitException(Mensajes.CUENTA_NO_EXISTE);
        } else if (servicio==null) {
            throw new AccountNotExitException("El recibo indicado no existe o ya fue pagado");
        } else if (cuenta.getSaldo() < servicio.getMonto() ||
                ( cuenta.getSaldo() - servicio.getMonto() < cuenta.getSaldoMin())){
            throw new BusinessException(Mensajes.BAJO_DEL_MINIMO);
        } else {
            reciboDAO.pagarRecibo(referencia);// pago        casteo : conversion directa
            //Descontar el monto de la cuenta asociada a la tarjet
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),(int)(cuenta.getSaldo()- servicio.getMonto()));
            //Registar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now (),"PAGO DE SERVICIOS",(int) servicio.getMonto());
            movimientoDAO.registrarMovimiento(m);
            this.setFolioOperacion(this.getFolioOperacion()+1);
            //Generar el ticket
            t = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(),
                    LocalDate.now(), cuenta.getNumCuenta(),"Pago de servicios", (int)servicio.getMonto());
        }
        return t;
    }

    @Override
    public ReporteMovimientosClienteDTO generarReporte(String cliente) throws BusinessException {
        ReporteMovimientosClienteDTO reporte = null;

        reporte = movimientoDAO.generearReportePorCliente(cliente);

        if(reporte!=null){
            return reporte;

        }else{
            throw new BusinessException(Mensajes.REPORTE_INVALIDO);
        }

    }
}

