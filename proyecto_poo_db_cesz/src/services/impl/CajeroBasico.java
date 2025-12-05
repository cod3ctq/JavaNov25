package services.impl;

import Constants.Mensajes;
import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DTO.CuentaTarjetaDTO;
import exceptions.AccountNotExistException;
import exceptions.InsufficientBalanceException;
import exceptions.UnderMinimumException;
import exceptions.WrongNipException;
import models.Atm;
import models.Cuenta;
import models.Movimiento;
import models.Ticket;
import services.OpBasicas;

import java.time.LocalDate;

public class CajeroBasico extends Atm implements OpBasicas {

    private CuentaDAO cuentaDAO = new CuentaDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();

    private int cajeroId;
    public CajeroBasico(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarCueta(int numCuenta) {
            Cuenta aux = null;
            for(Cuenta c: this.getCuentas()) {
                if(c.getNumCuenta() == numCuenta){
                    aux = c;
                    break;
                }
            }
            return aux;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if(cuenta != null) System.out.println("El saldo disponible es: "+cuenta.getSaldo());
        else System.out.println(Mensajes.CUENTA_NO_EXISTE);
        //else System.out.println("No existe una cuenta asociada a esa tarjeta");
    }

    //interface
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
        else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) throw new UnderMinimumException(Mensajes.BAJO_DEL_MINIMO);
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
}
