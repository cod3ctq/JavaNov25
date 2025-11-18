import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        String ruta = "/ceteq-week1/java-rw/para-leer.txt";
        String rutaEscritura = "/ceteq-week1/java-rw/para-escribir.txt";
        File file = new File(ruta);
        File file2 = new File(rutaEscritura);
        String linea;
        int conteoPalabras = 0;
        int conteoLineas = 0;

        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file2);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                StringBuilder result = new StringBuilder();
                String lineaMinusculas = linea.toLowerCase();
                for (char c : lineaMinusculas.toCharArray()){
                    if (Character.isLetter(c)) {
                        if (c == 'z') {
                            result.append('a');
                        } else {
                            result.append((char)(c + 1));
                        }
                    } else {
                        result.append(c);
                    }
                }
                conteoPalabras += result.toString().split(" ").length;
                fw.write(result.toString());
                conteoLineas++;
                fw.write("\n");
            }
            fw.write(String.format("\nConteo de palabras: %d", conteoPalabras));
            fw.write(String.format("\nConteo de líneas: %d", conteoLineas));
            fw.close();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
