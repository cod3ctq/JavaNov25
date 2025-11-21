public class Nadador extends Deportista {
    double profundidad;
    double  velocidad;

    public Nadador(String disciplina, int horasEntrenamiento, double profundidad, double velocidad) {
        super(disciplina, horasEntrenamiento);
        this.profundidad = profundidad;
        this.velocidad = velocidad;
    }

    @Override   // Metodo de la forma 2:heredado y sobreescrtio
    public void entrenar() {
        System.out.println("flexiones, contralor repiracion");
        System.out.println("Nadar a ritmo leve");
        System.out.println("Recorrer 5 vueltas a la piscina");

    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}
