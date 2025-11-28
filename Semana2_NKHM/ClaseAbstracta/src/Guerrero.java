public class Guerrero extends Personaje {

    public Guerrero(int fuerza, int destreza, int inteligencia, int fe, int salud, int mana) {
        super(fuerza, destreza, inteligencia, fe, salud, mana);
    }

    @Override
    public void entrenar() {
        fuerza += 5;
        System.out.println("El Guerrero entrena. Fuerza actual: " + fuerza);
    }

}
