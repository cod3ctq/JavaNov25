public class Producto {
    String modelo;
    String color;
    double precio;
    String año;

    public Producto(){}

    public Producto(String modelo, String color, double precio, String año) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.año = año;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", año='" + año + '\'' +
                '}';
    }
}
