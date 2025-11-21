//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Que deseas crear?");
        System.out.println("1. computadora");
        System.out.println("2. laptop");
        System.out.print("elige opción: ");
        int opcion = scan.nextInt();
        scan.nextLine();

        if (opcion == 1) {

            System.out.println("\nCREAR COMPUTADORA");

            System.out.print("Marca: ");
            String marca = scan.nextLine();

            System.out.print("procesador: ");
            String procesador = scan.nextLine();

            System.out.print("RAM (GB): ");
            int ram = scan.nextInt();

            System.out.print("Almacenamiento (GB): ");
            int almacenamiento = scan.nextInt();

            Computadora pc = new Computadora(marca, procesador, ram, almacenamiento);

            System.out.println("\nobjeto creado:");
            System.out.println(pc);

        } else if (opcion == 2) {

            System.out.println("\nCREAR LAPTOP");

            System.out.print("Marca: ");
            String marca = scan.nextLine();

            System.out.print("Procesador: ");
            String procesador = scan.nextLine();

            System.out.print("RAM (GB): ");
            int ram = scan.nextInt();

            System.out.print("Almacenamiento (GB): ");
            int almacenamiento = scan.nextInt();

            System.out.print("Peso (kg): ");
            double peso = scan.nextDouble();

            System.out.print("Horas de bateria: ");
            int bateria = scan.nextInt();

            Laptop lap = new Laptop(marca, procesador, ram, almacenamiento, peso, bateria);

            System.out.println("\nObjeto creado:");
            System.out.println(lap);

        } else {
            System.out.println("Opcion no valida.");
        }
    }
}