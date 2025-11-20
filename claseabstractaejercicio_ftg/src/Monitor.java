public abstract class Monitor {

    String marca;
    int pulgadas;

    public Monitor(){}

    public Monitor(String marca, int pulgadas){
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "marca='" + marca + '\'' +
                ", pulgadas=" + pulgadas +
                '}';
    }

    public abstract void mostrarCaracteristicas ();

   }