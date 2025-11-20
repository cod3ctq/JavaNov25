public class Factura {

    String folio;
    String cliente;
    double subtotal;
    double total;

    public Factura(){}

    public Factura(String folio, String cliente, double subtotal, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }

    //Las clases adquieren comportamiento de 3 maneras:
    // 1 Metodo nativos (metodos que se originan/nacen ahi mismo, en la clase)
    // 2 Metodos heredados (metodos que vienen de una clase padre y comunmente se sobreescriben)
    // 3 Metodos implementados (metodos que vienen de interfaces)

    //calcularTotal
    public double calcularTotal(){
        return this.subtotal * 1.16;
    }
}
