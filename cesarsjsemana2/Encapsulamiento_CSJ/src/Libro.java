public class Libro extends MaterialBibliografico {
    // ✅ Atributos específicos PRIVADOS
    private String isbn;
    private int numeroPaginas;
    private String genero;

    public Libro(String id, String titulo, String autor, int añoPublicacion,
                 String isbn, int numeroPaginas, String genero) {
        super(id, titulo, autor, añoPublicacion);
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    @Override
    public void prestar() {
        // ✅ Usa GETTERS y SETTERS del padre - NO accesos directos
        if (isDisponible()) {
            setDisponible(false);  // ✅ Setter protegido del padre
            System.out.println("Libro '" + getTitulo() + "' prestado por 15 dias");
        } else {
            System.out.println("El libro '" + getTitulo() + "' no esta disponible");
        }
    }

    @Override
    public void devolver() {
        setDisponible(true);  // ✅ Setter protegido del padre
        System.out.println("Libro '" + getTitulo() + "' devuelto correctamente");
    }

    @Override
    public void mostrarInformacionEspecifica() {
        // ✅ Accede a sus propios atributos directamente (están en la misma clase)
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Paginas: " + getNumeroPaginas());
        System.out.println("Genero: " + getGenero());
    }

    // ========== MÉTODOS ESPECÍFICOS ==========
    public void leerResumen() {
        System.out.println("Leyendo resumen del libro '" + getTitulo() + "'...");
    }

    // ========== GETTERS PÚBLICOS ==========
    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getGenero() {
        return genero;
    }

    // ========== SETTERS PÚBLICOS CON VALIDACIONES ==========
    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{3}-\\d{10}")) {
            throw new IllegalArgumentException("ISBN debe tener formato XXX-XXXXXXXXXX");
        }
        this.isbn = isbn;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("El numero de paginas debe ser positivo");
        }
        this.numeroPaginas = numeroPaginas;
    }
}