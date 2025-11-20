public class gerente extends empleado {

     String departamento;


    public gerente(String nombre, int idEmpleado, double salarioBase, String departamento) {

        super(nombre, idEmpleado, salarioBase);
        this.departamento = departamento;
    }


    public void planificarReuniones() {
        System.out.println(super.nombre + " está planificando reuniones para el departamento de " + departamento + ".");
    }


    @Override
    public void trabajar() {
        System.out.println(super.nombre + " está dirigiendo, gestionando y delegando tareas.");
    }


    @Override
    public void mostrarDetalles() {

        super.mostrarDetalles();
        System.out.println("Rol: Gerente");
        System.out.println("Departamento: " + departamento);

        System.out.println("Salario Total (con bono): $" + (salarioBase + 500.00));
    }
}