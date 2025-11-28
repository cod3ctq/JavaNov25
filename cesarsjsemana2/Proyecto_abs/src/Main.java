public class Main {
    public static void main(String[] args) {
        System.out.println("=== AGENDA DE CONTACTOS (Estilo Profesional) ===");

        // ========== MÉTODO 1: Constructor vacío + Setters ==========
        System.out.println("\n--- Creando contacto con constructor vacío y setters ---");
        Contacto contacto1 = new Contacto();  // Constructor vacío
        contacto1.setNombre("Ana García");     // Setters
        contacto1.setTelefono("123-456-789");
        contacto1.setEmail("ana@email.com");

        System.out.println(contacto1);  // Usa toString() automáticamente

        // ========== MÉTODO 2: Constructor con parámetros ==========
        System.out.println("\n--- Creando contacto con constructor completo ---");
        Contacto contacto2 = new Contacto(
                "Carlos López",
                "987-654-321",
                "carlos@email.com"
        );
        System.out.println(contacto2);

        // ========== MÉTODO 3: Otro contacto ==========
        System.out.println("\n--- Creando tercer contacto ---");
        Contacto contacto3 = new Contacto(
                "María Rodríguez",
                "555-123-456",
                "maria@email.com"
        );
        System.out.println(contacto3);

        // ========== USANDO GETTERS ==========
        System.out.println("\n--- Usando Getters para información específica ---");
        System.out.println("Nombre del contacto 2: " + contacto2.getNombre());
        System.out.println("Teléfono del contacto 3: " + contacto3.getTelefono());
        System.out.println("Email del contacto 1: " + contacto1.getEmail());

        // ========== MODIFICANDO CON SETTERS ==========
        System.out.println("\n--- Modificando contacto con Setters ---");
        System.out.println("ANTES: " + contacto1);
        contacto1.setTelefono("999-888-777");  // Cambiamos el teléfono
        System.out.println("DESPUÉS: " + contacto1);

        // ========== MÉTODO PERSONALIZADO ==========
        System.out.println("\n--- Mostrando información formateada ---");
        contacto1.mostrarInfoFormateada();
        contacto2.mostrarInfoFormateada();
        contacto3.mostrarInfoFormateada();

        System.out.println("Contactos procesados");
    }
}