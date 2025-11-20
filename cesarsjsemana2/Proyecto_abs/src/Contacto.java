import java.util.Arrays;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String[] etiquetas;
    private boolean favorito;

    // Constructores
    public Contacto() {}

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto(String nombre, String telefono, String email, String[] etiquetas, boolean favorito) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.etiquetas = etiquetas;
        this.favorito = favorito;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public boolean isFavorito() {
        return favorito;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    // Método para agregar etiqueta
    public void agregarEtiqueta(String nuevaEtiqueta) {
        if (etiquetas == null) {
            etiquetas = new String[]{nuevaEtiqueta};
        } else {
            String[] nuevasEtiquetas = Arrays.copyOf(etiquetas, etiquetas.length + 1);
            nuevasEtiquetas[etiquetas.length] = nuevaEtiqueta;
            etiquetas = nuevasEtiquetas;
        }
    }

    // Método toString
    @Override
    public String toString() {
        String fav = favorito ? "⭐ " : "";
        return fav + "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", etiquetas=" + (etiquetas != null ? Arrays.toString(etiquetas) : "[]") +
                ", favorito=" + favorito +
                '}';
    }

    // Método mostrarInfoFormateada (opcional)
    public void mostrarInfoFormateada() {
        String fav = favorito ? "⭐ " : "";
        System.out.println(fav + "CONTACTO");
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Teléfono: " + telefono);
        System.out.println("  Email: " + email);
        if (etiquetas != null && etiquetas.length > 0) {
            System.out.println("  Etiquetas: " + Arrays.toString(etiquetas));
        }
        System.out.println("  Favorito: " + (favorito ? "Sí" : "No"));
        System.out.println("────────────────────");
    }
}