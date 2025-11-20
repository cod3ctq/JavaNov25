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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
}
