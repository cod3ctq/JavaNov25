package paquete1;

public class ClaseConceptual {

    public String valorUno;
    public String ValorDos;

    protected double valorTres;
    protected double valorCuatro;
    private int valorCinco;
    private int valorSeir;

    public ClaseConceptual(){

    }

    public ClaseConceptual(String valorUno, String valorDos, double valorTres, double valorCuatro, int valorCinco, int valorSeir) {
        this.valorUno = valorUno;
        ValorDos = valorDos;
        this.valorTres = valorTres;
        this.valorCuatro = valorCuatro;
        this.valorCinco = valorCinco;
        this.valorSeir = valorSeir;
    }

    public String getValorUno() {
        return valorUno;
    }

    public void setValorUno(String valorUno) {
        this.valorUno = valorUno;
    }

    public String getValorDos() {
        return ValorDos;
    }

    public void setValorDos(String valorDos) {
        ValorDos = valorDos;
    }

    public double getValorTres() {
        return valorTres;
    }

    public void setValorTres(double valorTres) {
        this.valorTres = valorTres;
    }

    public double getValorCuatro() {
        return valorCuatro;
    }

    public void setValorCuatro(double valorCuatro) {
        this.valorCuatro = valorCuatro;
    }

    public int getValorCinco() {
        return valorCinco;
    }

    public void setValorCinco(int valorCinco) {
        this.valorCinco = valorCinco;
    }

    public int getValorSeir() {
        return valorSeir;
    }

    public void setValorSeir(int valorSeir) {
        this.valorSeir = valorSeir;
    }

    protected void accionCompartida(){
        System.out.println("HOLA");
    }
}
