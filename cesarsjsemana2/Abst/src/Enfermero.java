public class Enfermero extends PersonalMedico {
    private String medicoAsignado;

    public Enfermero(String nombreCompleto, String horarioTrabajo, int añosExperiencia,
                     String medicoAsignado) {
        super("Enf. " + nombreCompleto, horarioTrabajo, añosExperiencia);
        this.medicoAsignado = medicoAsignado;
    }

    @Override
    public void realizarTareas() {
        System.out.println("Asistiendo al " + medicoAsignado);
    }

    public void mostrarInformacionCompleta() {
        mostrarInformacionBasica();
        System.out.println("Médico asignado: " + medicoAsignado);
    }

    public String getMedicoAsignado() { return medicoAsignado; }
}