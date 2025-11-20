public class FacturaCredito extends Factura{

    //Si no generas ningun constructor en alguna clase (heredada o no)
    //Java te otorga el vacio por default
    int plazoMeses;
    double interesMensual;

    public FacturaCredito(String folio, String cliente, double subtotal, double total, int plazoMeses, double interesMensual) {
        super(folio, cliente, subtotal, total);
        this.plazoMeses = plazoMeses;
        this.interesMensual = interesMensual;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    @Override
    public String toString() {
        return "FacturaCredito{" +
                "plazoMeses=" + plazoMeses +
                ", interesMensual=" + interesMensual +
                ", folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }

    //Cuando ocupar el extends, o cuando hacer herencia ?
    // Cuando necesite sobreescribir algo
    // Cuando necesite especializar algo

    @Override //Esta anotacion indica que se esta sobreescribiendo el metodo
    public double calcularTotal(){
        double totalBase = super.calcularTotal();
        double interesTotal = totalBase + interesMensual * plazoMeses;
        return totalBase + interesTotal;
    }
}
