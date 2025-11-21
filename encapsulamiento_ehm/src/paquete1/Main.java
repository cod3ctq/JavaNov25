package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actio.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //modificadores de acceso
        //private
        //protected
        //public
        //controla la visivilidad y/o el acceso a los mienboros de una
        // clase a traves de 3 modificadores de acceso

        claseconceptual clas=new claseconceptual();
        //clas.valorCinco=10; Un valor privado no es accesible desde afuera de la clase


        //Aunque si son accesibles no es correcto acceder directamente a los atributos de esta manera
        clas.valorUno="gcjhx";
        clas.valorDos="mhgcj";

        //La forma correcta de acceder a los atributos no importando su modificador de acceso
        //es atraves de los getter y setters
        clas.setValorUno("hfxjfz");
        clas.setValorDos("gchx");
        clas.setValorTres(56.9);
        clas.setValorCinco(900);//Accedo a un valor privado a traves del setter



    }
}