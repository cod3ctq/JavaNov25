package Paquete1;

public class ClaseConceptual {
    public String valorUno;
    public String valorDos;
    protected double valorTres;
    protected double valorCuatro;
    private int valorCinco;
    private int valorSeis;


    public ClaseConceptual(String valorUno, int valorSeis, int valorCinco, double valorCuatro, double valorTres, String valorDos) {
        this.valorUno = valorUno;
        this.valorSeis = valorSeis;
        this.valorCinco = valorCinco;
        this.valorCuatro = valorCuatro;
        this.valorTres = valorTres;
        this.valorDos = valorDos;
    }

    public String getValorUno() {
        return valorUno;
    }

    public void setValorUno(String valorUno) {
        this.valorUno = valorUno;
    }

    public int getValorSeis() {
        return valorSeis;
    }

    public void setValorSeis(int valorSeis) {
        this.valorSeis = valorSeis;
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

    public double getValorTres() {
        return valorTres;
    }

    public void setValorTres(double valorTres) {
        this.valorTres = valorTres;
    }

    public String getValorDos() {
        return valorDos;
    }

    public void setValorDos(String valorDos) {
        this.valorDos = valorDos;
    }
     protected  void accionCompartida(){
        System.out.println("Hola");
    }
}
