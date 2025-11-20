public class Avion extends Transporte {
    double costo;
    String pais;
    double distancia;

    @Override
    public void viaje() {

        System.out.println();
        System.out.println("Viaje en Avion");
        System.out.println("Para viajar a "+pais);
        System.out.println("Debes recorrer "+distancia+" kilomentros");
        System.out.println("El costo es de  $"+costo+" ");
    }

    public Avion(int numeroLlantas, int numeroPuertas, String combustible, double costo, String pais, double distancia) {
        super(numeroLlantas, numeroPuertas, combustible);
        this.costo = costo;
        this.pais = pais;
        this.distancia = distancia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
