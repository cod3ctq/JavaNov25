package services.impl;

import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DAO.ReciboDAO;
import DAO.ServicioDAO;
import DTO.CuentaTarjetaDTO;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import constants.Mensajes;
import exceptions.AccountNotExistException;
import exceptions.BusinessException;
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
    private int cajeroID;

    public PractiCaja(String ubicacion, int folioOperacion, int cajeroID) {
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
            System.out.println("el saldo disponible en PractiCaja es: " + cuenta.getSaldo());
        } else {
            System.out.println("no existe una cuenta asociada a esta tarjeta (Practicaja)");
        }
    }

    public void mostrarCuentas() {
        for (Cuenta c : getCuentas()) {
            System.out.println(c);
        }
    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto) {
        Object[] data = new Object[2];

        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;

        cuenta = cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta == null) {
            System.out.println(Mensajes.CUENTA_NO_EXISTE);

        } else if (!cuenta.getNip().equals(nip)) {
            System.out.println(Mensajes.NIP_INCORRECTO);

        } else if (cuenta.getSaldo() < monto) {
            System.out.println(Mensajes.SALDO_INSUFICIENTE);

        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            System.out.println(Mensajes.BAJO_EL_MINIMO);

        } else {
            int saldoFinal = cuenta.getSaldo() - monto;
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), saldoFinal);

            this.setFolioOperacion(this.getFolioOperacion() + 1);

            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(), "RETIRO", monto);
            movimientoDAO.registrarMovimiento(m);

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

            System.out.println("Retiro aplicado en PractiCaja. Nuevo saldo: " + saldoFinal);
        }

        return data;
    }

    @Override
    public Ticket depositar(long numTarjeta, int monto) throws BusinessException {
        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;

        cuenta = cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta == null) {

            throw new BusinessException(Mensajes.CUENTA_NO_EXISTE);

        } else if (monto > cuenta.getSaldoMax()) {

            throw new BusinessException(Mensajes.SOBRE_EL_MAXIMO);

        } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {

            throw new BusinessException(Mensajes.DEPOSITO_EXCEDIDO);

        } else {
            int saldoFinal = cuenta.getSaldo() + monto;
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), saldoFinal);

            this.setFolioOperacion(this.getFolioOperacion() + 1);

            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(), "DEPOSITO", monto);
            movimientoDAO.registrarMovimiento(m);

            ticket = new Ticket(
                    this.cajeroID,
                    this.getFolioOperacion(),
                    this.getUbicacion(),
                    LocalDate.now(),
                    cuenta.getNumCuenta(),
                    "DEPOSITO",
                    monto
            );

            System.out.println("Depósito aplicado. Nuevo saldo: " + saldoFinal);
        }

        return ticket;
    }

    @Override
    public Ticket pagarServicio(long numTarjeta, String convenio, String referencia)
            throws AccountNotExistException, BusinessException {

        CuentaTarjetaDTO cuenta = null;
        ServicioDTO servicio = null;
        Ticket ticket = null;

        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        servicio = servicioDAO.buscarServicio(convenio, referencia);

        if (cuenta == null) {
            throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (servicio == null) {
            throw new BusinessException(Mensajes.SERVICIO_NO_DISPONIBLE);
        } else if (cuenta.getSaldo() < servicio.getMonto()
                || cuenta.getSaldo() - servicio.getMonto() < cuenta.getSaldoMin()) {
            throw new BusinessException(Mensajes.BAJO_EL_MINIMO);
        } else {
            reciboDAO.pagarRecibo(referencia);

            cuentaDAO.actualizarSaldo(
                    cuenta.getNumCuenta(),
                    (int) (cuenta.getSaldo() - servicio.getMonto())
            );

            Movimiento m = new Movimiento(
                    cuenta.getCuentaId(),
                    LocalDate.now(),
                    "PAGO DE SERVICIOS",
                    (int) servicio.getMonto()
            );
            movimientoDAO.registrarMovimiento(m);

            this.setFolioOperacion(this.getFolioOperacion() + 1);

            ticket = new Ticket(
                    this.cajeroID,
                    this.getFolioOperacion(),
                    this.getUbicacion(),
                    LocalDate.now(),
                    cuenta.getNumCuenta(),
                    "PAGO DE SERVICIOS",
                    (int) servicio.getMonto()
            );
        }

        return ticket;
    }

    @Override
    public ReporteMovimientosClienteDTO generarReporte(String cliente) throws BusinessException {
        ReporteMovimientosClienteDTO reporte = null;

        reporte = movimientoDAO.generarReporteCliente(cliente);

        if (reporte == null) {
            throw new BusinessException(Mensajes.REPORTE_INVALIDO);
        }

        return reporte;
    }
}
