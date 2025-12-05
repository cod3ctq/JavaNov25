package Services.impl;

import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DAO.ReciboDAO;
import DAO.ServicioDAO;
import DTO.CuentaTarjetaDTO;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import Models.Atm;
import Models.Cuenta;
import Models.Movimiento;
import Models.Ticket;
import Services.OpAvanzadas;
import Services.OpBasicas;
import constants.Mensajes;

import java.time.LocalDate;

public class Practicaja extends Atm implements OpBasicas, OpAvanzadas {

    private CuentaDAO cuentaDAO = new CuentaDAO();
    private ServicioDAO servicioDAO=new ServicioDAO();
    private int cajeroId;
    private ReciboDAO reciboDAO = new ReciboDAO();
    private MovimientoDAO movimientoDAO= new MovimientoDAO();

    public Practicaja(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarCuenta(int numCuenta) {
        return null;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta=cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta!=null) {
            System.out.println("El saldo disponible es: " + cuenta.getSaldo());
        }else{
            System.out.println("No existe una cuenta asociada a esa tarjeta. ");
        }

    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto) throws AccountNoExistException, WrongNipException, InsufficientBalanceException, UnderMinimunException {
        Object[] data = new Object[2]; //objeto de salida
        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta == null) { //si no existe la cuenta
            throw new AccountNoExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (!(cuenta.getNip().equals(nip))) {
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);
        } else if (cuenta.getSaldo() < monto) {
            throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            throw new UnderMinimunException(Mensajes.BAJO_EL_MINIMO);
        } else {
            //retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo() - monto);
            this.setFolioOperacion(this.getFolioOperacion() + 1);//actualiza el folio de operacion
            //construir el ticket
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),"RETIRO",monto);
            movimientoDAO.registrarMovimiento(m);
            ticket = new Ticket(this.cajeroId, this.getFolioOperacion(),
                    this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "RETIRO", monto);
            data[0] = monto;
            data[1] = ticket;
        }

        return data;
    }

    @Override
    public Ticket depositar(long numTarjeta, int monto) throws BusinessException {
        //busqueda: exista
        //validar que el monto quepa dentro de la cuenta: monto > saldoMax
        //validar que al depositar no se pase del maximo de la cuenta: (saldo + monto) >Saldo
        //depositar
        CuentaTarjetaDTO cuenta = null;
       cuenta= cuentaDAO.buscarCuenta(numTarjeta);
       Ticket ticket= null;

        if (cuenta == null) { //si no existe la cuenta
        throw new BusinessException(Mensajes.CUENTA_NO_EXISTE);
        } else if (monto>cuenta.getSaldoMax()) {
        throw new BusinessException(Mensajes.SOBRE_EL_MAXIMO);
        } else if ((cuenta.getSaldo()+monto)>cuenta.getSaldoMax()) {
        throw new BusinessException(Mensajes.DEPOSITO_EXCEDIDO);
        }else {
            //deposito
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo()+monto);
            this.setFolioOperacion(this.getFolioOperacion() + 1);
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),"DEPOSITO",monto);
            movimientoDAO.registrarMovimiento(m);
            ticket = new Ticket(this.cajeroId, this.getFolioOperacion(),
                    this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "DEPOSITO", monto);

        }

        return ticket;
    }

    @Override
    public Ticket pagarServicio(long numTarjeta, String convenio, String referencia)
        throws AccountNoExistException, BusinessException {
        CuentaTarjetaDTO cuenta=null;
        ServicioDTO servicio =null;
        Ticket t=null;
        cuenta=cuentaDAO.buscarCuenta(numTarjeta);
        servicio=servicioDAO.buscarServicio(convenio,referencia);
        if (cuenta==null){//validar que la cuenta exista
            throw new Exception.InsufficientBalanceException.AccountNoExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (servicio==null) {//validar que el recibo exista (convenio, refrencia, que no este pagado)
            throw new BusinessException("El recibo indicado no existe o ya fue pagado");
        }else if (cuenta.getSaldo()< servicio.getMonto()
                || (cuenta.getSaldo()- servicio.getMonto()< cuenta.getSaldoMin())){
          throw new BusinessException(Mensajes.BAJO_EL_MINIMO);
        }else {
            reciboDAO.pagarRecibo(referencia);//Pago         //conversion directa
            //Descontar el monto de la cuenta asociada a la tarjeta
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), (int)(cuenta.getSaldo() - servicio.getMonto()) );
            //Registrar el movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),
                    "PAGO DE SERVICIOS",(int)servicio.getMonto());
            movimientoDAO.registrarMovimiento(m);
            this.setFolioOperacion(this.getFolioOperacion() + 1);
            //Generar el ticket
            t= new Ticket(this.cajeroId, this.getFolioOperacion(),
                    this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "PAGO DE SERVICIOS", (int)servicio.getMonto());
        }
        return t;
    }

    @Override
    public ReporteMovimientosClienteDTO generarReporte(String cliente) throws BusinessException {
       ReporteMovimientosClienteDTO reporte=null;
       reporte=movimientoDAO.generarReportePorCliente(cliente);

       if (reporte!=null){
           return reporte;
       }else{
           throw new BusinessException(Mensajes.REPORTE_INVALIDO);
       }

    }


}