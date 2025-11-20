public class iphone extends Telefono{


    int catidadDeCamaras;
        int memoriaRam;

    public iphone(String marca, String sistemaOperativo, double precio, int catidadDeCamaras, int memoriaRam) {
        super(marca, sistemaOperativo, precio);
        this.catidadDeCamaras = catidadDeCamaras;
        this.memoriaRam = memoriaRam;
    }

    @Override
    public void usar() {
        System.out.println("Tomar fotos");
        System.out.println("Navegar en Internet");
        System.out.println("Realizar llamadas");
    }

    public int getCatidadDeCamaras() {
        return catidadDeCamaras;
    }

    public void setCatidadDeCamaras(int catidadDeCamaras) {
        this.catidadDeCamaras = catidadDeCamaras;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
}









