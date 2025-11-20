public class MedicoGeneral extends PersonalMedico {
    private int pacientesAtendidos;
    private int citasAgendadasDia;

    public MedicoGeneral(String nombreCompleto, String horarioTrabajo, int añosExperiencia,
                         int pacientesAtendidos, int citasAgendadasDia) {
        super("Dr. " + nombreCompleto, horarioTrabajo, añosExperiencia);
        this.pacientesAtendidos = pacientesAtendidos;
        this.citasAgendadasDia = citasAgendadasDia;
    }

    @Override
    public void realizarTareas() {
        System.out.println("Atendiendo consultas médicas generales");
    }

    public void mostrarInformacionCompleta() {
        mostrarInformacionBasica();
        System.out.println("Pacientes atendidos: " + pacientesAtendidos);
        System.out.println("Citas agendadas hoy: " + citasAgendadasDia);
    }

    public int getPacientesAtendidos() { return pacientesAtendidos; }
    public int getCitasAgendadasDia() { return citasAgendadasDia; }
}