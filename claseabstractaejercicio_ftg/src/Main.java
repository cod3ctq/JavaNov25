import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("que monitor deseas registrar?");
        System.out.println("1. monitor gamign");
        System.out.println("2. monitor de oficina");
        int opcion = scan.nextInt();
        scan.nextLine();

        if(opcion == 1){

            System.out.println("marca:");
            String marca = scan.nextLine();

            System.out.println("pulgadas:");
            int pulgadas = scan.nextInt();

            System.out.println("hz:");
            int hz = scan.nextInt();
            scan.nextLine();

            System.out.println("tipo de panel (va - ips - tn1:");
            String panel = scan.nextLine();

            MonitorGaming mg = new MonitorGaming(marca, pulgadas, hz, panel);

            mg.mostrarCaracteristicas();
        } else if(opcion == 2){

            System.out.println("marca:");
            String marca = scan.nextLine();

            System.out.println("pulgadas:");
            int pulgadas = scan.nextInt();

            System.out.println("tiene altavoces? (true/false):");
            boolean altavoces = scan.nextBoolean();

            MonitorOficina mo = new MonitorOficina(marca, pulgadas, altavoces);

 //           mg.mostrarCaracteristicas();
            mo.mostrarCaracteristicas();

        }
    }
}