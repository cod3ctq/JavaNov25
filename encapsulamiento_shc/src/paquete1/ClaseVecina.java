package paquete1;

public class ClaseVecina {

    ClaseConceptual con=new ClaseConceptual();

    public ClaseVecina(){
        con.accionCompartida();// Invocacion a un metodo protegido
        con.valorDos ="rfsfdts";
        //con.valorCinco = 234; privado
    }

}
