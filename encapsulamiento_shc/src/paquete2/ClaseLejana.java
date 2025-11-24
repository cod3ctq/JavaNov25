package paquete2;

import paquete1.ClaseConceptual;

public class ClaseLejana extends ClaseConceptual{

    public ClaseLejana(){
        // forma incorrecta de acceder a mienbros protegidos o privados
        this.valorTres=234.1; //alcanzable solo cuando se hereda
        // co.valor=324;

        //forma correcta de acceder a mienbros SIN importae su modificador de accesso
        this.setValorTres(234.23);
        this.setValorSeis(23);

    }
}
