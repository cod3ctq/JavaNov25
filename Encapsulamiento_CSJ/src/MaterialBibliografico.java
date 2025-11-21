public abstract class MaterialBibliografico {
    // ✅ TODOS los atributos son PRIVADOS
    private String id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private boolean disponible;

    public MaterialBibliografico(String id, String titulo, String autor, int añoPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.disponible = true;
    }

    // ========== MÉTODOS ABSTRACTOS ==========
    public abstract void prestar();
    public abstract void devolver();
    public abstract void mostrarInformacionEspecifica();

    // ========== MÉTODOS CONCRETOS CON ACCESO CONTROLADO ==========
    public void mostrarInformacionGeneral() {
        // ✅ Usa GETTERS internamente - ni siquiera la misma clase accede directamente
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAñoPublicacion());
        System.out.println("Disponible: " + (isDisponible() ? "Si" : "No"));
    }

    // ========== GETTERS PÚBLICOS ==========
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // ========== SETTERS PROTEGIDOS ==========
    // ✅ Solo las clases hijas pueden modificar el estado, pero mediante métodos controlados
    protected void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Setter protegido para título (por si las hijas necesitan modificarlo)
    protected void setTitulo(String titulo) {
        // ✅ Posibilidad de agregar validaciones
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }
}