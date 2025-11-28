public class Cirujano extends PersonalMedico {
    private int operacionesAsignadasDia;
    private String tipoCirugia;

    public Cirujano(String nombreCompleto, String horarioTrabajo, int añosExperiencia,
                    int operacionesAsignadasDia, String tipoCirugia) {
        super("Dr. " + nombreCompleto, horarioTrabajo, añosExperiencia);
        this.operacionesAsignadasDia = operacionesAsignadasDia;
        this.tipoCirugia = tipoCirugia;
    }

    @Override
    public void realizarTareas() {
        System.out.println("Realizando cirugías de " + tipoCirugia);
    }

    public void mostrarInformacionCompleta() {
        mostrarInformacionBasica();
        System.out.println("Operaciones asignadas hoy: " + operacionesAsignadasDia);
        System.out.println("Tipo de cirugía: " + tipoCirugia);
    }

    public int getOperacionesAsignadasDia() { return operacionesAsignadasDia; }
    public String getTipoCirugia() { return tipoCirugia; }
}