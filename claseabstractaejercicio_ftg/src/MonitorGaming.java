public class MonitorGaming extends Monitor {

    int hz;
    String panel;

    public MonitorGaming(String marca, int pulgadas, int hz, String panel){
        super(marca, pulgadas);
        this.hz = hz;
        this.panel = panel;
    }

    public int getHz() {
        return hz;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    @Override
    public void mostrarCaracteristicas () {
        System.out.println("monitor gamign");
        System.out.println("marca: " + marca);
        System.out.println("pulgadas: " + pulgadas);
        System.out.println("hz: " + hz);
        System.out.println("panel: " + panel);
    }
}