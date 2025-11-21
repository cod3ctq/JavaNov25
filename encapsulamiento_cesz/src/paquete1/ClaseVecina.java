package paquete1;

public class ClaseVecina {
    ClaseConceptual con = new ClaseConceptual();

    public ClaseVecina() {
        con.accionCompartida();//invocacion a un metodo protegido
        con.valorDos = "rxtcyvbu"; //protegido
        //con.setValorCinco = 1234; //privadp
}
}
