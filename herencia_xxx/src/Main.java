//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto de la clase padre
        Factura f1 = new Factura("100","pepe",850.00,(850.00*1.16));
        System.out.println(f1.getCliente());
        System.out.println(f1.getSubtotal());

        //Objeto de la clase hija (mas especifico)
        FacturaCredito fc1 = new FacturaCredito("200","luis",
                2000.00,(2000.00*1.16),12,10.0);

        fc1.cal

        //Crear un ejemplo donde apliques herencia
        //Despues, crear sus objetos aqui en la clase Main







    }
}