package paquete1;

public class claseconceptual {
    public String valorUno;
    public String valorDos;
    protected double valorTres;
    protected double valorCuatro;
    private  int valorCinco;
    private int valorSeis;

    public claseconceptual (){}
    public claseconceptual(String valorUno, String valorDos, double valorTres, double valorCuatro, int valorCinco, int valorSeis) {
        this.valorUno = valorUno;
        this.valorDos = valorDos;
        this.valorTres = valorTres;
        this.valorCuatro = valorCuatro;
        this.valorCinco = valorCinco;
        this.valorSeis = valorSeis;
    }

    public String getValorUno() {
        return valorUno;
    }

    public void setValorUno(String valorUno) {
        this.valorUno = valorUno;
    }

    public String getValorDos() {
        return valorDos;
    }

    public void setValorDos(String valorDos) {
        this.valorDos = valorDos;
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

    public int getValorSeis() {
        return valorSeis;
    }

    public void setValorSeis(int valorSeis) {
        this.valorSeis = valorSeis;
    }
    public void accionCompartida ()
    {
        System.out.println("Hola");
    }
}
