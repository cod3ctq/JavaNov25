package services.impl;

import DAO.Movimiento;
import DAO.MovimientoDAO;
import DAO.cuentaDAO;
import DTO.cuentaTarjetaDTO;
import constants.Mensajes;
import exceptions.AccountNotExitException;
import exceptions.InsufficientBalanceException;
import exceptions.UnderMinimunException;
import exceptions.WrongNipException;
import models.Atm;
import models.Cuenta;
import models.Ticket;
import services.OpBasicas;

import java.time.LocalDate;

public class CajeroBasico extends Atm implements OpBasicas {

    private cuentaDAO cuentaDAO = new cuentaDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();
    private int cajeroId;

    public CajeroBasico(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }

    @Override
    public Cuenta buscarcCuenta(int numCuenta) {
        Cuenta aux = null;
        //buscando la cuenta
        for (Cuenta c : this.getCuentas()) {
            if (c.getNumCuenta() == numCuenta) {
                aux = c;
                break;
            }
        }
        return aux;
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
    public Object[] retirar(long numTarjeta, String nip, int monto) throws AccountNotExitException, WrongNipException, InsufficientBalanceException,UnderMinimunException {// Para retirar en un cajero hay que hacer:
        Object[] data = new Object[2]; // objeto de salida[dinero,ticket]
        cuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        if (cuenta == null) {
          //  System.out.println("No existe la cuenta asociada a la tarjeta");
            throw new AccountNotExitException(Mensajes.CUENTA_NO_EXISTE);
        } else if (!(cuenta.getNip().equals(nip))) {
          //  System.out.println("Nip incorrecto");
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);
        } else if (cuenta.getSaldo() < monto) {
        //  System.out.println("Saldo insuficiente");
            throw  new InsufficientBalanceException(Mensajes.SALDO_INCISUFICIENTE);
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldo()) {
           // System.out.println("Retiro No Disponible. Quedaria por debajo del minimo");
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
}

// Busqueda: validar que exista la informacion
// validar el nip

//Que me alcance el efectivo: el que el saldo disponible que sea menor que al monto: saldo < monto
//Que no quede por abajo del minimo : que el saldo disponible tiene que ser menor que el monto y mayor que el minimo
//: saldoDispobible - monto > minimo
// retiro

// saldo, numCuenta,
//

// AL CREAR EXCEPCIONES AHY 2 CAMINOS
// CREAR UNA EXCEPCION INIDIVUAL POR CADA ERROR / EVENTO DEL FLUJO QUE QUIERAS EXPRESAR
// CREAR UNA SOLA CLASE DE EXCEPCION, QUE MANEJE TODOS LOS ERRORES DE NEGOCIO