public class factura {

    String folio;
    String cliente;
    double subtotal;
    double total;

    public factura(){}

    public factura(String folio, String cliente, double subtotal, double total) {
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
        return "factura{" +
                "folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }
    //Las clases adquieren comportamiento de 3 maneras:
    //1 metodos nativos (metodos se que originan/ nacen ahi mismo, en la clase)
    //2 metodos heredados (metodos que vienen de una clase padre y comunmente se sobreescriben)
    //3 metodos implementados (metodos que vienen de interfaces)


    //calcular total
    public double calculartotal(){
        return this.subtotal;

    }
}
