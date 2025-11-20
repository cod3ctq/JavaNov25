public class Samsumg extends Telefono {
 String pantalla;
 String beteria;

    public Samsumg(String marca, String sistemaOperativo, double precio, String pantalla, String beteria) {
        super(marca, sistemaOperativo, precio);
        this.pantalla = pantalla;
        this.beteria = beteria;
    }

    @Override
    public void usar() {
        System.out.println("Poner una alarma");
        System.out.println("Escuchar Musica");
        System.out.println("Navegar en redes sociales");

    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getBeteria() {
        return beteria;
    }

    public void setBeteria(String beteria) {
        this.beteria = beteria;
    }
}



