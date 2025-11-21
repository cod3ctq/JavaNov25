package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    // modificadores de acceso
        //private
        //protected
        //public

        ClaseConceptual cc = new ClaseConceptual();

        //cc.valorCinco = 10; un valor privado no es accesible desde otra clase

        //aunque son accesibles no es correcto llamarlos asi
        cc.valorUno = "bgvfc";
        cc.valorDos = "gvcfed";
        cc.valorTres = 12.34;

        //la forma correcta de acceder a los atributos es a traves de los setters y getters

        cc.setValorUno("kjdfkj");
        cc.setValorDos("fsdgdfgdfg");
        cc.setValorTres(24.2323);
        cc.setValorCinco(400); //accedo a un valor privado con el setter
    }
}