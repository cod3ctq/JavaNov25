public abstract class PersonalMedico {
    private static int nextId = 1000;

    protected int id;
    protected String nombreCompleto;
    protected String horarioTrabajo;
    protected int añosExperiencia;

    public PersonalMedico(String nombreCompleto, String horarioTrabajo, int añosExperiencia) {
        this.id = nextId++;
        this.nombreCompleto = nombreCompleto;
        this.horarioTrabajo = horarioTrabajo;
        this.añosExperiencia = añosExperiencia;
    }

    public abstract void realizarTareas();

    public void mostrarInformacionBasica() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Horario: " + horarioTrabajo);
        System.out.println("Años de experiencia: " + añosExperiencia);
    }

    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getHorarioTrabajo() { return horarioTrabajo; }
    public int getAñosExperiencia() { return añosExperiencia; }
}