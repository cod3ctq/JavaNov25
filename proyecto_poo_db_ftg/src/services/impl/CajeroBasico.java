package services.impl;

import DAO.CuentaDAO;
import DTO.CuentaTarjetaDTO;
import constants.Mensajes;
import exceptions.AccountNotExistException;
import exceptions.InsufficientBalanceException;
import exceptions.UnderMinimunException;
import exceptions.WrongNipException;
import models.Atm;
import models.Cuenta;
import models.Movimiento;
import models.Ticket;
import services.OpBasicas;

import java.time.LocalDate;

public class CajeroBasico extends Atm implements OpBasicas {

    private CuentaDAO cuentaDAO = new CuentaDAO();
    private int cajeroID;

    public CajeroBasico(String ubicacion, int folioOperacion, int cajeroID) {
        super(ubicacion, folioOperacion);
        this.cajeroID = cajeroID;
    }

    @Override
    public Cuenta buscarCuenta(long numTarjeta) {
        CuentaTarjetaDTO dto = getCuentaDAO().buscarCuenta(numTarjeta);
        if (dto == null) {
            return null;
        }

        for (Cuenta c : getCuentas()) {
            if (c.getNumCuenta() == dto.getNumCuenta()) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta != null) {
            System.out.println("el saldo disponible es: " + cuenta.getSaldo());
        } else {
            System.out.println("no existe una cuenta asociada a esta tarjeta");
        }
    }

    public void mostrarCuentas() {
        for (Cuenta c : getCuentas()) {
            System.out.println(c);
        }
    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNotExistException,
            WrongNipException,
            InsufficientBalanceException,
            UnderMinimunException {

        Object[] data = new Object[2];

        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;

        cuenta = cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta == null) {
            throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);

        } else if (!cuenta.getNip().equals(nip)) {
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);

        } else if (cuenta.getSaldo() < monto) {
            throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);

        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            throw new UnderMinimunException(Mensajes.BAJO_EL_MINIMO);

        } else {
            int saldoFinal = cuenta.getSaldo() - monto;
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), saldoFinal);

            this.setFolioOperacion(this.getFolioOperacion() + 1);

            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(), "RETIRO", monto);
            cuentaDAO.registrarMovimiento(m);

            ticket = new Ticket(
                    this.cajeroID,
                    this.getFolioOperacion(),
                    this.getUbicacion(),
                    LocalDate.now(),
                    cuenta.getNumCuenta(),
                    "RETIRO",
                    monto
            );

            data[0] = monto;
            data[1] = ticket;

            System.out.println("Retiro aplicado. Nuevo saldo: " + saldoFinal);
        }

        return data;
    }
}
