public class empleado {

    String nombre;
     int idEmpleado;
     double salarioBase;


    public empleado(String nombre, int idEmpleado, double salarioBase) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }


    public void trabajar() {
        System.out.println(nombre + " está realizando sus tareas laborales generales.");
    }


    public void mostrarDetalles() {
        System.out.println("--- Detalles del Empleado ---");
        System.out.println("ID: " + idEmpleado);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario Base: $" + salarioBase);
    }
}