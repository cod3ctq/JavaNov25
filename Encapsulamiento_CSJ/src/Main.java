public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE BIBLIOTECA CON ENCAPSULAMIENTO COMPLETO");

        try {
            // ========== CREACIÓN DE OBJETOS ==========
            System.out.println("Creando materiales bibliograficos...");

            Libro libro1 = new Libro(
                    "LIB-001",
                    "Cien años de soledad",
                    "Gabriel Garcia Marquez",
                    1967,
                    "978-8437604947",
                    471,
                    "Realismo magico"
            );

            DVD dvd1 = new DVD(
                    "DVD-001",
                    "El Padrino",
                    "Mario Puzo",
                    1972,
                    175,
                    "Francis Ford Coppola",
                    "Pelicula"
            );

            // ========== CREACIÓN DE BIBLIOTECARIO ==========
            Bibliotecario bibliotecario = new Bibliotecario("Ana Garcia", "BIB-123", 5);

            // ========== DEMOSTRACIÓN DE ENCAPSULAMIENTO ==========
            System.out.println("\n=== DEMOSTRANDO ENCAPSULAMIENTO ===");

            // ✅ ACCESO CORRECTO mediante métodos públicos
            System.out.println("Titulo del libro: " + libro1.getTitulo());
            System.out.println("¿Esta disponible? " + libro1.isDisponible());

            // ✅ MODIFICACIÓN CORRECTA mediante métodos públicos
            libro1.setNumeroPaginas(500);  // Usando setter con validación

            // ========== INTERACCIÓN ENTRE CLASES ==========
            System.out.println("\n=== INTERACCIONES ===");
            bibliotecario.prestarMaterial(libro1, "Juan Perez");
            bibliotecario.prestarMaterial(dvd1, "Maria Lopez");

            System.out.println("\n=== INFORMACION ===");
            bibliotecario.mostrarInformacionCompleta(libro1);
            bibliotecario.mostrarInformacionCompleta(dvd1);

            // ========== DEMOSTRACIÓN DE VALIDACIONES ==========
            System.out.println("\n=== VALIDACIONES ===");
            try {
                libro1.setNumeroPaginas(-10);  // ❌ Esto lanzará excepción
            } catch (IllegalArgumentException e) {
                System.out.println("Error correctamente capturado: " + e.getMessage());
            }

            try {
                bibliotecario.setNombre("");  // ❌ Esto lanzará excepción
            } catch (IllegalArgumentException e) {
                System.out.println("Error correctamente capturado: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("\n=== SISTEMA FUNCIONANDO CORRECTAMENTE ===");
    }
}
// AQUÍ TERMINA LA CLASE - NO DEBE HABER NADA MÁS DESPUÉS DE ESTA LÍNEA