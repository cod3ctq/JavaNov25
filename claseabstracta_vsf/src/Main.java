
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //oculta detalles
        //base o esqueleto para otras clases
        //no puede instanciarse
        //abstracto

        Deportista d1 = new Corredor("Velosista", 2, 8, 2);
        Deportista d2 = new Nadador("Maratonista", 8, 2.5, 20 );

        d1.entrenar();
        d2.entrenar();



    }
}