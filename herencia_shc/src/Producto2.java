public class Producto2 extends Producto {
    double kilometros;
    String marca;

    public Producto2(){}

    public Producto2(String modelo, String color, double precio, String año, double kilometros, String marca) {
        super(modelo, color, precio, año);
        this.kilometros = kilometros;
        this.marca = marca;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto2{" +
                "kilometros=" + kilometros +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", año='" + año + '\'' +
                '}';
    }
}
