package paquete2;

import paquete1.ClaseConceptual;

public class ClaseLejana extends ClaseConceptual{

    ClaseConceptual co = new ClaseConceptual();

    public ClaseLejana(){

        //forma incorrecta de acceder a miembros protegidos o privados
//        co.valorTres = 2324.1;
//        co.valorSeir = 12.25;

        this.valorTres = 234.1;
        //this.valorCinco = 342;

        //forma correcta de acceder a miembros sin importar su modificador de acceso
        co.setValorTres(234.5);
        co.setValorSeir(23);
    }

}
