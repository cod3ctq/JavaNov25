public class FacturaCredito extends Factura{
    //si no generas ningun constructor en alguna clase  (heredada o no)
    //te otroga el void (vacio)

    int plazoMeses;
    double interesMnesul;

    public FacturaCredito(String folio, String cliente, double subtotal, double total, int plazoMeses, double interesMnesul) {
        super(folio, cliente, subtotal, total);
        this.plazoMeses = plazoMeses;
        this.interesMnesul = interesMnesul;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getInteresMnesula() {
        return interesMnesul;
    }

    public void setInteresMnesula(double interesMnesula) {
        this.interesMnesul = interesMnesula;
    }

    @Override
    public String toString() {
        return "FacturaCredito{" +
                "plazoMeses=" + plazoMeses +
                ", interesMnesula=" + interesMnesul +
                ", folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }


}
