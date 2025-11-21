package Paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    ClaseConceptual cc = new ClaseConceptual();
            // cc.valorCinco = 10; Un vALOR PRIVADO NO ES ACCESIBLE DESDE AFUERA DE LA CLASE
        //aunque si son accesibles, No es correcto acceder diretamente a los atributos de esta forma
        cc.valorUno="asadsfasdf";
        cc.valorDos="asdsad";
        cc.valorTres=23.4;
        // la forma correcta de acceder a los atributos, no importando su modificador de acceso
        //es a trabvez de getter y setters
        cc.setValorUno("awsdasd");
        cc.setValorCinco(420);


        }
    }
}