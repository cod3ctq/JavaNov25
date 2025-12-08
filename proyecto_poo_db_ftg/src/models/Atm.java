package models;

import DAO.CuentaDAO;

import java.util.List;

public abstract class Atm {

    private String ubicacion;
    private int folioOperacion;
    private List<Cuenta> cuentas;
    private CuentaDAO cuentaDAO = new CuentaDAO();

    public Atm(String ubicacion, int folioOperacion) {
        this.ubicacion = ubicacion;
        this.folioOperacion = folioOperacion;
        this.cuentas = cuentaDAO.cargarCuentas();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public CuentaDAO getCuentaDAO() {
        return cuentaDAO;
    }

    public abstract Cuenta buscarCuenta(long numTarjeta);

    public abstract void consultarSaldo(long numTarjeta);
}
