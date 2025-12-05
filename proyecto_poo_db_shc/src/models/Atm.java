package models;

import DAO.cuentaDAO;

import java.util.List;

public abstract class Atm {

    private String ubicacion;
    private int folioOperacion;
    private List<Cuenta> cuentas; // base de datos
    private cuentaDAO dao = new cuentaDAO();
    // DB


    public Atm(){}

    public Atm(String ubicacion, int folioOperacion) {
        this.ubicacion = ubicacion;
        this.folioOperacion = folioOperacion;
        // invoca el metodo que carga las cuentas desde la db
        this.cuentas = dao.cargarCuentas();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }


    // Busqueda de la cuenta

    public abstract Cuenta buscarcCuenta(int numTarjeta);

    // consulta de saldo
    public abstract void consultarSaldo(long numTarjeta);


    public void mostarCuentas(){
        for(Cuenta c : this .cuentas){
            System.out.println(c);
        }
    }
}


