import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lectura_escritura {

    public static void main(String[] args) {

        String rutalectura ="C:\\Users\\zamar\\Desktop\\archivolectura.txt";
        String rutaescritura ="C:\\Users\\zamar\\Desktop\\archivoescritura.txt";

        StringBuilder contenido = new StringBuilder();
        int contador = 0;

        try {
            FileReader fr = new FileReader(rutalectura);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");

                if (!linea.trim().isEmpty()) {
                    contador += linea.trim().split(" ").length;
                }
            }
            br.close();

            String textoMinusculas = contenido.toString().toLowerCase();

            String textoModificado = cambiarLetras(textoMinusculas);

            FileWriter fw = new FileWriter(rutaescritura);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(textoModificado);

            bw.write("\n");
            bw.write("TOTAL DE PALABRAS: "+contador);
            bw.close();

            System.out.println("Número total de palabras: " + contador);

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String cambiarLetras(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') resultado.append('a');
                else resultado.append((char) (c + 1));
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
}
