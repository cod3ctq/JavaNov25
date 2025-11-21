public class Corredor extends Deportista {

    double distancia;
    double tiempo;

    public Corredor(String disciplina, int horasEntrenamiento, double distancia, double tiempo) {
        super(disciplina, horasEntrenamiento);
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void entrenar(){
        System.out.println("Calentar, flexionar");
        System.out.println("Caminar por 30min");
        System.out.println("Correr por 1hr aprox");
    }
}