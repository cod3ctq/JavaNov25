package paquete2;

import paquete1.ClaseConceptual;

public class ClaseLejana extends ClaseConceptual {

//    ClaseConceptual co = new ClaseConceptual();

    public ClaseLejana() {

        //forma incorrecta de accerder a miembros protegidos o privados
        this.valorTres = 234.1;  //alcanzable solo cuando se hereda
//        this.valorCinco = 90;  //lo privado no se hereda
//        co.setValorTres = 234.1;
//        co.valorSeis = 342;

        //forma correcta de acceder a miembros sin importar su modificador de acceso
       this.setValorTres(234.23);
       this.setValorSeis(23);
    }
}
