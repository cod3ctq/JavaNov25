package models;

import DAO.CuentaDAO;
import java.util.List;


public abstract class Atm {
    private String ubicacion;
    private int folioOperacio;
    private List<Cuenta> cuentas;
    private CuentaDAO dao = new CuentaDAO();

    public Atm(){}

    public Atm(String ubicacion, int folioOperacio) {
        this.ubicacion = ubicacion;
        this.folioOperacio = folioOperacio;
        this.cuentas = dao.cargarCuentas();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFolioOperacio() {
        return folioOperacio;
    }

    public void setFolioOperacio(int folioOperacio) {
        this.folioOperacio = folioOperacio;
    }

    //busqueda de la cuenta
    public abstract Cuenta buscarCuenta(int numTarjeta);
    //consulta de saldo
    public abstract void consultarSaldo(long numTarjeta);

    public void mostrarCuentas(){
        for(Cuenta c : this.cuentas){
            System.out.println(c);
        }
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}