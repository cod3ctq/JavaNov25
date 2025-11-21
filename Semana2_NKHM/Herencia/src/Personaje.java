public class Personaje {

    // Atributos
    int fuerza;
    int destreza;
    int inteligencia;
    int fe;
    int salud;
    int mana;

    // Constructor vacío
    public Personaje() {
    }

    // Constructor lleno
    public Personaje(int fuerza, int destreza, int inteligencia, int fe, int salud, int mana) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.fe = fe;
        this.salud = salud;
        this.mana = mana;
    }

    // Getters
    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getFe() {
        return fe;
    }

    public int getSalud() {
        return salud;
    }

    public int getMana() {
        return mana;
    }

    // Setters
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // Metodos del personaje
    public void entrenar() {
        System.out.println("El personaje está entrenando.");
    }

    public void meditar() {
        System.out.println("El personaje está meditando.");
    }

    public void estudiar() {
        System.out.println("El personaje está estudiando.");
    }

    public void rezar() {
        System.out.println("El personaje está rezando.");
    }

    public void comer() {
        System.out.println("El personaje está comiendo.");
    }

    public void beber() {
        System.out.println("El personaje está bebiendo.");
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "fuerza=" + fuerza +
                ", destreza=" + destreza +
                ", inteligencia=" + inteligencia +
                ", fe=" + fe +
                ", salud=" + salud +
                ", mana=" + mana +
                '}';
    }
}