//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de la clae padre
        factura f1= new factura("100", "5", 800.00,(800.00*1.16));
        System.out.println(f1.getCliente());
        System.out.println(f1.getSubtotal());

        //objeto de la clase hija (es mas especifico)
        facturacredito fc1 = new facturacredito("200", "luis",
                2000.00, (2000.00*1.16),12,10.0);
        System.out.println(fc1.getCliente());
        System.out.println(fc1.getInteresmensual());

        //Crear un ejemplo donde apliques herencia
        //despues crear sus objetos aqui en la clase Main




    }
}