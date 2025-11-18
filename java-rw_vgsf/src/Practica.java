import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Practica {
    public static void main(String[] args) {

        String rutaArchivo = "C:\\Users\\GabrielSF\\Desktop\\escritura.txt";
        try {
            Path path = Paths.get(rutaArchivo);//Lee el contenido completo del archivo como una cadena
            String contenidoOriginal = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

            // 3. Aplica la transformación.
            String contenidoTransformado = transformarTexto(contenidoOriginal);

            // 4. Escribe el contenido transformado de vuelta al archivo, sobrescribiendo el original.
            Files.write(path, contenidoTransformado.getBytes(StandardCharsets.UTF_8));
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


     //Convierte el texto a minúsculas y luego reemplaza cada letra por la siguiente en el alfabeto.

    private static String transformarTexto(String texto) {
        int contadorPalabras = 0 ;
        String textoMinusculas = texto.toLowerCase();

        StringBuilder resultado = new StringBuilder();

        for (char caracter : textoMinusculas.toCharArray()) {
            if (caracter >= 'a' && caracter <= 'z') {// Si el caracter es una letra minúscula de 'a' a 'y', la desplaza a la siguiente.
                if (caracter != 'z') {
                    resultado.append((char) (caracter + 1));
                } else {
                    // Si es 'z', se cicla a 'a'.
                    resultado.append('a');
                }
            } else {
                // Mantiene cualquier otro caracter (números, espacios, signos de puntuación, etc.) sin cambios.
                resultado.append(caracter);
                contadorPalabras++;
                //System.out.println(contadorPalabras);
            }
        }
        System.out.println(contadorPalabras);
        return resultado.toString();

    }
}
