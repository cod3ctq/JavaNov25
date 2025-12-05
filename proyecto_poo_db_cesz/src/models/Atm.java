package models;

import DAO.CuentaDAO;

import java.util.List;

public abstract class Atm {

    private String ubicacion;
    private int folioOperacion;
    private List<Cuenta> cuentas;// tabla de la bd
    private CuentaDAO dao = new CuentaDAO();



    public Atm(){}
    public Atm(String ubicacion, int folioOperacion) {
        this.ubicacion = ubicacion;
        this.folioOperacion = folioOperacion;
        //invoca al metodo que carga las cuentas desde la db
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

    //busqueda de la cuenta
    public abstract Cuenta buscarCueta(int numTarjeta);
    // consulta del saldo
    public abstract void consultarSaldo(long numTarjeta);


    public void mostrarCuentas(){
        for (Cuenta c:this.cuentas){
            System.out.println(c);
        }
    }
}
