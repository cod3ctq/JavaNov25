public class Bibliotecario {
    // ✅ Atributos PRIVADOS
    private String nombre;
    private String idEmpleado;
    private int añosExperiencia;

    public Bibliotecario(String nombre, String idEmpleado, int añosExperiencia) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.añosExperiencia = añosExperiencia;
    }

    // ========== MÉTODOS QUE RESPETAN EL ENCAPSULAMIENTO ==========
    public void prestarMaterial(MaterialBibliografico material, String usuario) {
        System.out.println(nombre + " esta procesando prestamo...");
        System.out.println("Usuario: " + usuario);

        // ✅ Usa el método público del material - no accede a sus atributos directamente
        if (material.isDisponible()) {
            material.prestar();  // ✅ Delega la lógica al objeto
            System.out.println("Prestamo registrado por " + nombre);
        } else {
            System.out.println("No se puede prestar - Material no disponible");
        }
    }

    public void recibirDevolucion(MaterialBibliografico material, String usuario) {
        System.out.println(nombre + " esta procesando devolucion...");
        System.out.println("Usuario: " + usuario);
        material.devolver();  // ✅ Usa método público
        System.out.println("Devolucion registrada por " + nombre);
    }

    public void mostrarInformacionCompleta(MaterialBibliografico material) {
        System.out.println("INFORMACION DEL MATERIAL");
        material.mostrarInformacionGeneral();      // ✅ Método público
        material.mostrarInformacionEspecifica();   // ✅ Método público
        System.out.println("Atendido por: " + nombre);
    }

    public void buscarPorTitulo(MaterialBibliografico[] materiales, String tituloBuscado) {
        System.out.println(nombre + " buscando: '" + tituloBuscado + "'");
        boolean encontrado = false;

        for (MaterialBibliografico material : materiales) {
            // ✅ Usa getter público - no accede directamente al atributo
            if (material.getTitulo().toLowerCase().contains(tituloBuscado.toLowerCase())) {
                System.out.println("Encontrado: " + material.getTitulo() + " (ID: " + material.getId() + ")");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron materiales con ese titulo");
        }
    }

    // ========== GETTERS Y SETTERS ==========
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia < 0) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
        }
        this.añosExperiencia = añosExperiencia;
    }

    public void mostrarInformacionPersonal() {
        System.out.println("BIBLIOTECARIO:");
        System.out.println("Nombre: " + getNombre());           // ✅ Usa getter internamente
        System.out.println("ID Empleado: " + getIdEmpleado());  // ✅ Usa getter internamente
        System.out.println("Años de experiencia: " + getAñosExperiencia());
    }

    public void asistirUsuario(String consulta) {
        System.out.println(getNombre() + " esta ayudando con: '" + consulta + "'");
    }
}