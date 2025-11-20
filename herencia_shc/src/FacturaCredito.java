public class FacturaCredito  extends Factura{

    // si no generas ningun constructor en alguna clase(heredada o no)
    //java te ortoga el vacio por default

    int plazoMeses;
    double interesMensual;

    public FacturaCredito(){}

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

    // cuando ocupar el extends o cuando hacer herencia?
    // cuando necesite sobrec
}


// las clases adquieren comportamiento de 3 maneras:
// metodo nativos( metodos que se origiann/naven ahi mismo, en la clase)
//
