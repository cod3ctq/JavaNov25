//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Vehiculo v1 = new Vehiculo("Kia","Seltos",2025,"ASDFGHJ2625");
    InspeccionEstetica iEstetica1 = new InspeccionEstetica("Kia", "Seltos",2025,"ASDFGHJ2625",true,true,true,true,true);
    InspeccionElectrica iElectrica1 = new InspeccionElectrica("Kia","Seltos",2025,"ASDFGHJ2625",true,true,true,true,true);

        System.out.println(v1);
        System.out.println("--------------------");
        System.out.println(iEstetica1);
        System.out.println("--------------------");
        System.out.println(iElectrica1);
    }
}