package Models;

import java.util.List;

import DAO.CuentaDAO;

public abstract class Atm {

    private String ubicacion;
    private int folioOperacion;
    private List<Cuenta> cuentas;//Esto es mi base de datos
    private CuentaDAO dao = new CuentaDAO();
    //DB


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
    public abstract Cuenta buscarCuenta(int numTarjeta);

    //consulta de saldo
    public abstract void consultarSaldo(long numTarjeta);




    public void mostrarCuentas(){
        for (Cuenta c: this.cuentas){
            System.out.println(c);
        }
    }
}
