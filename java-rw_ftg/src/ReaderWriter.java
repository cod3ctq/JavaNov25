import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriter {
    public static void main(String[] args) {

        //Lectura:
        String ruta="C:\\Users\\pacoa\\Desktop\\transformador de texto entrada.txt";
        String rutaescritura ="C:\\Users\\pacoa\\Desktop\\transformador de texto salida.txt";
        File file2 = new File(rutaescritura);
        File file = new File(ruta); //representacion del archivo en memoria
        String linea;

        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String textoCompleto = "";
            while ((linea = br.readLine()) != null) {
                textoCompleto = textoCompleto + linea + " ";
            }

            String minusculas = textoCompleto.toLowerCase();

            String recorrido = "";
            for (int i = 0; i < minusculas.length(); i++) {
                char c = minusculas.charAt(i);

                if (c >= 'a' && c <= 'z') {
                    if (c == 'z') {
                        c = 'a';
                    } else {
                        c = (char)(c + 1);
                    }
                }

                recorrido = recorrido + c;
            }

            int palabras = 0;
            boolean dentro = false;

            for (int i = 0; i < minusculas.length(); i++) {
                char c = minusculas.charAt(i);

                if (c != ' ' && dentro == false) {
                    dentro = true;
                    palabras++;
                }

                if (c == ' ') {
                    dentro = false;
                }
            }

            FileWriter fw = new FileWriter(file2);
            fw.write(recorrido + "\n");
            fw.write(palabras + "\n");
            fw.close();


        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}