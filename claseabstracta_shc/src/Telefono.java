public abstract class Telefono {
    String marca;
    String sistemaOperativo;
    double precio;

    //contenedor vacio
    public Telefono() {
    }
    // contanedor lleno
    public Telefono(String marca, String sistemaOperativo, double precio) {
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
    }
    // get y set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
// metodo heredado y sobre escrito
    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", precio=" + precio +
                '}';
    }
    // metodo abstracto
    public abstract void usar();
}


