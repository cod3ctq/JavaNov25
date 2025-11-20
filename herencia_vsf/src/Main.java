//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Factura f1 = new Factura();
        System.out.println(f1.getCliente());
        System.out.println(f1.getSubtotal());

        FacturaCredito fc1 = new FacturaCredito("200", "Luis",
                200.00, (2000*1.16), 12, 10.0);





    }
}