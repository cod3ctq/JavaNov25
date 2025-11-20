//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // objeto de la clase padre
//        Factura f1 = new Factura("100","pepe",850.00,(850.00*1.16));
//        System.out.println(f1.getCliente());
//        System.out.println(f1.getSubtotal());
//
//
//     // objeto de la clase hija( mas especifico)
//        FacturaCredito fc1 = new FacturaCredito("200","Luis",2000.00,(200.00*1.16),12,10.0);
//
//       // Crear un ejemplo donde apliques herencia
       // Despues, crear sus objetos aqui en la clase Main

      // objeto de la clase padre
        Producto c1= new Producto("chevy","rojo",25000,"2005");
        System.out.println(c1.getModelo());
        System.out.println(c1.getColor());
        System.out.println(c1.getPrecio());
        System.out.println(c1.getAño());

        // Objeto de la clase hija
        Producto2 c2= new Producto2("chevy","rojo",25000,"2005",15000,"volkswagen");
        System.out.println(c2.getKilometros());
        System.out.println(c2.getMarca());


    }
}