public abstract class Personaje {

    int fuerza;
    int destreza;
    int inteligencia;
    int fe;
    int salud;
    int mana;
    //contructor vacio

public Personaje(){}

    // Constructor


    public Personaje(int fuerza, int destreza, int inteligencia, int fe, int mana, int salud) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.fe = fe;
        this.mana = mana;
        this.salud = salud;
    }


    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    //to string


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
    public abstract void entrenar();


    }


