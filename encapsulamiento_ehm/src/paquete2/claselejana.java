package paquete2;

import paquete1.claseconceptual;

public class claselejana extends claseconceptual{
    claseconceptual co = new claseconceptual();

    public claselejana(){

        //forma incorrecta de accesder a miembros protegidos o privados
        this.valorTres=342.98; //alcanzable solo cundo se hereda
        //this.valorCinco=98; lo privado no se hereda
        //co.valorSeis=635;

       //forma correcta de acceder a miembros sin importar su modificador de acceso
        co.setValorTres(65.9);
        co.setValorSeis(659);


    }
}
