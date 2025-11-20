public abstract class Transporte {
    int numeroLlantas;
    int numeroPuertas;
    String combustible;


    public Transporte(){}

    public Transporte(int numeroLlantas, int numeroPuertas, String combustible) {
        this.numeroLlantas = numeroLlantas;
        this.numeroPuertas = numeroPuertas;
        this.combustible = combustible;
    }

    public int getNumeroLlantas() {
        return numeroLlantas;
    }

    public void setNumeroLlantas(int numeroLlantas) {
        this.numeroLlantas = numeroLlantas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "numeroLlantas=" + numeroLlantas +
                ", numeroPuertas=" + numeroPuertas +
                ", combustible='" + combustible + '\'' +
                '}';
    }

    public abstract void viaje();
}
