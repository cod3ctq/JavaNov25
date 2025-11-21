package paquete1;

public class clasevecina {

    claseconceptual con=new claseconceptual();

    public clasevecina(){
        con.accionCompartida();//Invocaccion a un metodo protegido
        con.valorDos="ejdwf"; //protegido
        //con.valorCinco=435; privado (no se puede acceder a menos que se utilice el set "setvalorCinco"
    }
}
