public class DVD extends MaterialBibliografico {
    // ✅ Atributos específicos PRIVADOS
    private int duracionMinutos;
    private String director;
    private String tipo;

    public DVD(String id, String titulo, String autor, int añoPublicacion,
               int duracionMinutos, String director, String tipo) {
        super(id, titulo, autor, añoPublicacion);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
        this.tipo = tipo;
    }

    @Override
    public void prestar() {
        // ✅ Usa GETTERS y SETTERS del padre
        if (isDisponible()) {
            setDisponible(false);
            System.out.println("DVD '" + getTitulo() + "' prestado por 7 dias");
        } else {
            System.out.println("El DVD '" + getTitulo() + "' no esta disponible");
        }
    }

    @Override
    public void devolver() {
        setDisponible(true);
        System.out.println("DVD '" + getTitulo() + "' devuelto correctamente");
    }

    @Override
    public void mostrarInformacionEspecifica() {
        System.out.println("Duracion: " + getDuracionMinutos() + " minutos");
        System.out.println("Director: " + getDirector());
        System.out.println("Tipo: " + getTipo());
    }

    // ========== MÉTODOS ESPECÍFICOS ==========
    public void reproducirTrailer() {
        System.out.println("Reproduciendo trailer de '" + getTitulo() + "'...");
    }

    // ========== GETTERS PÚBLICOS ==========
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getDirector() {
        return director;
    }

    public String getTipo() {
        return tipo;
    }

    // ========== SETTERS CON VALIDACIONES ==========
    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion debe ser positiva");
        }
        this.duracionMinutos = duracionMinutos;
    }

    public void setTipo(String tipo) {
        if (!tipo.equals("Pelicula") && !tipo.equals("Documental") && !tipo.equals("Serie")) {
            throw new IllegalArgumentException("Tipo debe ser: Pelicula, Documental o Serie");
        }
        this.tipo = tipo;
    }
}