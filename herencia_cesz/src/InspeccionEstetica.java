public class InspeccionEstetica extends Vehiculo{
    boolean Pintura;
    boolean Llantas;
    boolean Asientos;
    boolean Cielo;
    boolean Tapiz;

    public InspeccionEstetica(String marca, String submarca, int modelo, String serie, boolean pintura, boolean llantas, boolean asientos, boolean cielo, boolean tapiz) {
        super(marca, submarca, modelo, serie);
        Pintura = pintura;
        Llantas = llantas;
        Asientos = asientos;
        Cielo = cielo;
        Tapiz = tapiz;
    }

    public boolean isPintura() {
        return Pintura;
    }

    public void setPintura(boolean pintura) {
        Pintura = pintura;
    }

    public boolean isLlantas() {
        return Llantas;
    }

    public void setLlantas(boolean llantas) {
        Llantas = llantas;
    }

    public boolean isAsientos() {
        return Asientos;
    }

    public void setAsientos(boolean asientos) {
        Asientos = asientos;
    }

    public boolean isCielo() {
        return Cielo;
    }

    public void setCielo(boolean cielo) {
        Cielo = cielo;
    }

    public boolean isTapiz() {
        return Tapiz;
    }

    public void setTapiz(boolean tapiz) {
        Tapiz = tapiz;
    }

    @Override
    public String toString() {
        return "Inspeccion Estetica: " +
//                "\nMarca = " + Marca +
//                "\nSubmarca = " + Submarca +
//                "\nModelo = " + Modelo +
//                "\nSerie = " + Serie+
                "\nPintura = " + Pintura +
                "\nLlantas = " + Llantas +
                "\nAsientos = " + Asientos +
                "\nCielo = " + Cielo +
                "\nTapiz = " + Tapiz;
    }
}
