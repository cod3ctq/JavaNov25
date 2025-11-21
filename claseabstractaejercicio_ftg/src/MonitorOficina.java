public class MonitorOficina extends Monitor {

    boolean altavoces;

    public MonitorOficina(String marca, int pulgadas, boolean altavoces){
        super(marca, pulgadas);
        this.altavoces = altavoces;
    }

    public boolean isAltavoces() {
        return altavoces;
    }

    public void setAltavoces(boolean altavoces) {
        this.altavoces = altavoces;
    }

    @Override
    public void  mostrarCaracteristicas() {
        System.out.println("monitor de oficina");
        System.out.println("marca: " + marca);
        System.out.println("pulgadas: " + pulgadas);
        System.out.println("altavoces integrados: " + (altavoces ? "si" : "no"));
    }
  }
