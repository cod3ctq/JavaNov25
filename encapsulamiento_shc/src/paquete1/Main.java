package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    // Modificadores de acceso
        //Private
        //Protected
        //Public


        ClaseConceptual cc = new ClaseConceptual();
 // cc. valorCinco = 10; Un valor privado no es accesible desde fuera de la clase


        //Aunque si son accesible, No es correcto acceder directamente a los atriutos de esto
        cc.valorUno="";
        cc.valorDos="";
        cc.valorTres=87;


        // la forma correcta de accedere a los atribustos NO improtanto su modificador de acceso
        // es a traves de los getter y setter
        cc.setValorUno("bfjsbhf");
        cc.setValorDos("fjbsjf");
        cc.setValorTres(543);
        cc.setValorCuatro(55);


    }
}