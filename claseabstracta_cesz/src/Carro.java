public class Carro extends Transporte{

    int pasajerosMaximos;
    double distanciaMaxima;
    int maletas;


    @Override
    public void viaje() {
        System.out.println();
        System.out.println("Para viajar en carro debe ser:");
        System.out.println("Máximo "+pasajerosMaximos+" pasajeros");
        System.out.println("Máximo "+distanciaMaxima+" kilomentros");
        System.out.println("Caben "+maletas+" maletas");
    }

    public Carro(int numeroLlantas, int numeroPuertas, String combustible, int pasajerosMaximos, double distanciaMaxima, int maletas) {
        super(numeroLlantas, numeroPuertas, combustible);
        this.pasajerosMaximos = pasajerosMaximos;
        this.distanciaMaxima = distanciaMaxima;
        this.maletas = maletas;
    }

    public int getPasajerosMaximos() {
        return pasajerosMaximos;
    }

    public void setPasajerosMaximos(int pasajerosMaximos) {
        this.pasajerosMaximos = pasajerosMaximos;
    }

    public double getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public int getMaletas() {
        return maletas;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }
}
