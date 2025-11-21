package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClaseConceptual cc = new ClaseConceptual();
        cc.valorUno = "finubionidniun";
        cc.ValorDos = "sdfghj";
        cc.valorTres = 23.45;

        //la forma correcta de acceder a los atributos NO importando
        cc.setValorUno("827iureu");
        cc.setValorDos("fsdfsg");
        cc.setValorTres(215.25);
        cc.setValorCinco(400);
    }
}