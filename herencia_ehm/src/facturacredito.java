public class facturacredito extends factura {
    //si no generas ningun constructor en ninguna clase (heredada o no)
    //Java te otorga el vacio por default

int plazoameses;
double interesmensual;
double calculartotal;

    public facturacredito(String folio, String cliente, double subtotal, double total, int plazoameses, double interesmensual) {
        super(folio, cliente, subtotal, total);
        this.plazoameses = plazoameses;
        this.interesmensual = interesmensual;
    }

    public int getPlazoameses() {
        return plazoameses;
    }

    public void setPlazoameses(int plazoameses) {
        this.plazoameses = plazoameses;
    }

    public double getInteresmensual() {
        return interesmensual;
    }

    public void setInteresmensual(double interesmensual) {
        this.interesmensual = interesmensual;
    }

    @Override
    public String toString() {
        return "facturacredito{" +
                "interesmensual=" + interesmensual +
                ", folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }
    //Cuando ocupar el extends o hacer herencia?
    //Cuando nececite sobreescribir algo
    //Cuando necesite especializar algo

    @Override //Esta anotacion indica que se esta sobreescribiendo el metodo
    public double getCalculartotal(){
        double totalbase= super.calculartotal();
        double interestotal= totalbase+interesmensual*plazoameses;
        return totalbase+ interestotal;
    }
}