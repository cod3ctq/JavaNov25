public class Main {
    public static void main(String[] args) {


        empleado empleadoRegular = new empleado("Tzipporah de Moises", 101, 45000.00);

        System.out.println();
        System.out.println("OBJETO 1: EMPLEADO REGULAR");
        empleadoRegular.mostrarDetalles();
        empleadoRegular.trabajar();
        System.out.println();


        gerente gerenteVentas = new gerente("Oseias de Nun", 205, 80000.00, "TI");

        System.out.println();
        System.out.println("OBJETO 2: GERENTE");


        gerenteVentas.mostrarDetalles();


        gerenteVentas.trabajar();


        gerenteVentas.planificarReuniones();
        System.out.println();
    }
}