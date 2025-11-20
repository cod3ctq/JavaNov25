public class InspeccionElectrica extends Vehiculo {

    boolean Luces;
    boolean luzDiurna;
    boolean Altas;
    boolean Bajas;
    boolean Limpiaparabrisas;

    public InspeccionElectrica(String marca, String submarca, int modelo, String serie, boolean luces, boolean luzDiurna, boolean altas, boolean bajas, boolean limpiaparabrisas) {
        super(marca, submarca, modelo, serie);
        Luces = luces;
        this.luzDiurna = luzDiurna;
        Altas = altas;
        Bajas = bajas;
        Limpiaparabrisas = limpiaparabrisas;
    }

    public boolean isLuces() {
        return Luces;
    }

    public void setLuces(boolean luces) {
        Luces = luces;
    }

    public boolean isLuzDiurna() {
        return luzDiurna;
    }

    public void setLuzDiurna(boolean luzDiurna) {
        this.luzDiurna = luzDiurna;
    }

    public boolean isAltas() {
        return Altas;
    }

    public void setAltas(boolean altas) {
        Altas = altas;
    }

    public boolean isBajas() {
        return Bajas;
    }

    public void setBajas(boolean bajas) {
        Bajas = bajas;
    }

    public boolean isLimpiaparabrisas() {
        return Limpiaparabrisas;
    }

    public void setLimpiaparabrisas(boolean limpiaparabrisas) {
        Limpiaparabrisas = limpiaparabrisas;
    }

    @Override
    public String toString() {
        return "Inspeccion Electrica:" +
//                "\nMarca = " + Marca +
//                "\nSubmarca = " + Submarca +
//                "\nModelo = " + Modelo +
//                "\nSerie = " + Serie +
                "\nLuces = " + Luces +
                "\nluzDiurna = " + luzDiurna +
                "\nAltas = " + Altas +
                "\nBajas = " + Bajas +
                "\nLimpiaparabrisas = " + Limpiaparabrisas;
    }
}
