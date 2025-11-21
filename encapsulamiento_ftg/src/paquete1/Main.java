package paquete1;

public class Main {
    public static void main(String[] args) {

        //modificadores de acceso
        //private
        //protected
        //public
        ClaseConceptual cc = new ClaseConceptual();
        //cc.getValorCinco() = 10; un valor privado no es accesible desde fuera de la clase

        //aunque si son accesibles, no es correcto acceder directamente a los atributos de esta
        cc.valorUno = "sdhsjhfhsjdfds";
        cc.valorDos = "sjjjdhjghdjhgdf";
//        cc.valorTres = "dkfjgdjhghjdfjkfgd";

                //la forma correcta de accerder a los atributos no importa tanto su modificador de acceso
        //es atraves de los getter y setters
        cc.setValorUno("kjdfkj");
        cc.setValorDos("fsdgdfgdfg");
        cc.setValorTres(24.2323);
        cc.setValorCinco(400); //accedo a un valor privado a traves del setter

    }
}