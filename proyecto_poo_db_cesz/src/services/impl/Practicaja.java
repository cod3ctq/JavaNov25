package services.impl;

import Constants.Mensajes;
import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DAO.ReciboDAO;
import DAO.ServicioDAO;
import DTO.CuentaTarjetaDTO;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import exceptions.*;
import models.Atm;
import models.Cuenta;
import models.Movimiento;
import models.Ticket;
import services.OpAvanzadas;
import services.OpBasicas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Practicaja extends Atm implements OpBasicas, OpAvanzadas {
    private CuentaDAO cuentaDAO = new CuentaDAO();
    private ServicioDAO servicioDAO = new ServicioDAO();
    private ReciboDAO reciboDAO = new ReciboDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();
    private int cajeroId;

    public Practicaja(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarCueta(int numCuenta) {
        return null;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if(cuenta != null) System.out.println("El saldo disponible es: "+cuenta.getSaldo());
        else System.out.println("No existe una cuenta asociada a esa tarjeta");
    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNotExistException, WrongNipException, InsufficientBalanceException, UnderMinimumException {
        Object [] data = new Object[2]; //objeto de salida [dinero,ticket]
        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if(cuenta == null) throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        else if (!(cuenta.getNip().equals(nip))) throw  new WrongNipException(Mensajes.NIP_INCORRECTO);
        else if (cuenta.getSaldo() < monto) throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);
        else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin())  throw new UnderMinimumException(Mensajes.BAJO_DEL_MINIMO);
        else{
            //realizar el retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo()-monto);
            this.setFolioOperacion(this.getFolioOperacion()+1);//actualizar el folio de operacion

            //registrar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),"RETIRO", monto);
            movimientoDAO.registrarMovimiento(m);

            //generar ticket
            ticket = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(), "RETIRO",monto);
            data[0] = monto;
            data[1] = ticket;
        }
        return data;
    }

    @Override
    public Ticket depositar(long numTarjeta, int monto) throws BusinessException {
        CuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        Ticket ticket = null;

        if(cuenta == null) throw new BusinessException(Mensajes.CUENTA_NO_EXISTE);
        else if(monto > cuenta.getSaldoMax()) throw new BusinessException(Mensajes.SOBRE_EL_MAXIMO);
        else if((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) throw new BusinessException(Mensajes.DEPOSITO_EXCEDIDO);
        else{
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo()+monto);
            this.setFolioOperacion(this.getFolioOperacion()+1);//actualizar el folio de operacion

            //registrar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),"DEPOSITO", monto);
            movimientoDAO.registrarMovimiento(m);

            //generar ticket
            ticket = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(), "DEPOSITO",monto);


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
        servicio = servicioDAO.buscarServicio(convenio, referencia);

        //Validar que la cuenta exista
        if(cuenta == null) throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        //Validar que el recibo exista (convenio, referencia, no esté pagado)
        else if(servicio==null) throw new BusinessException("El Recibo indicado no existe o ya fue pagado");
        //Pagar
        else if(cuenta.getSaldo() < servicio.getMonto() || (cuenta.getSaldo() - servicio.getMonto()) < cuenta.getSaldoMax()) throw new BusinessException(Mensajes.BAJO_DEL_MINIMO);
        else{
            reciboDAO.pagarRecibo(referencia);
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), (int)(cuenta.getSaldo()-servicio.getMonto()));//Descontar el monto de la cuenta asociada a la tarjeta
            //Registrar el movimiento => PAGO DE SERVICIOS
            Movimiento m = new Movimiento(cuenta.getCuentaId(),
                    LocalDate.now(),"PAGO DE SERVICIOS", (int)servicio.getMonto());
            movimientoDAO.registrarMovimiento(m);
            //Generar el ticket
            this.setFolioOperacion(this.getFolioOperacion()+1);
            t = new Ticket(this.cajeroId,this.getFolioOperacion(),this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(), "PAGO DE SERVICIOS",(int)servicio.getMonto());
        }
        return t;
    }

    @Override
    public ReporteMovimientosClienteDTO generarReporte(String cliente) throws BusinessException {
        ReporteMovimientosClienteDTO reporte = null;

        reporte = movimientoDAO.generarReportePorCliente(cliente);

        if(reporte != null) return reporte;
        else throw  new BusinessException(Mensajes.REPORTE_INVALIDO);

    }
}
//probar el metodo pagar servicio de la practicaja