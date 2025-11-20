public class corredor extends Deportista{

    double distancia;
    double tiempo;

    public corredor(String disciplina, int horasEntrenamiento, double distancia, double tiempo) {
        super(disciplina, horasEntrenamiento);
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    @Override
    public void entrenar() {
        System.out.println("calentar, flexiones");
        System.out.println("correr por 30 minutos o 2km");
        System.out.println("correr 2 horas o 5 km");
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
}
