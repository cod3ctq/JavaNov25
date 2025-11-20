public class Autobus extends Transporte{
    double costo;
    String estado;
    int maximoPasajeros;

    @Override
    public void viaje() {
        System.out.println();
        System.out.println("Viaje en autobus");
        System.out.println("Para viajar a "+estado);
        System.out.println("El costo es de  $"+costo+" ");
        System.out.println("el autobus tiene capacidad maxima de  "+maximoPasajeros+" pasajeros");
    }

    public Autobus(int numeroLlantas, int numeroPuertas, String combustible, double costo, String estado, int maximoPasajeros) {
        super(numeroLlantas, numeroPuertas, combustible);
        this.costo = costo;
        this.estado = estado;
        this.maximoPasajeros = maximoPasajeros;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMaximoPasajeros() {
        return maximoPasajeros;
    }

    public void setMaximoPasajeros(int maximoPasajeros) {
        this.maximoPasajeros = maximoPasajeros;
    }
}
