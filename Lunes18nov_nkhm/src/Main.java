import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        // Variables
        char[] abecedario = {
                'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };

        String cache = "";
        int contador=1;

        //Ubicaciones
        String ruta="C:\\Users\\nelde\\OneDrive\\Escritorio\\Documento prueba.txt";
        String rutaescritura = "C:\\Users\\nelde\\OneDrive\\Escritorio\\Escritura.txt";

        File file = new File(ruta);
        File file2 = new File(rutaescritura);
        String linea;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

                //Ciclo lee la letra que hay en el texto

                for (int i = 0; i < linea.length(); i++) {
                    char letra = Character.toLowerCase(linea.charAt(i));


                    // filtro para evitar mas espacios de los necesarios
                    if (letra == ' ') {
                        cache += " ";
                        contador = contador +1;
                        continue;
                    }

                    // comparador de letras
                    for (int n = 0; n < abecedario.length; n++) {

                        if (abecedario[n] == letra) {

                            // filtro, para Z = A
                            if (n == abecedario.length - 1) {
                                cache += abecedario[0];
                            } else {
                                cache += abecedario[n + 1];
                            }

                            break;
                        }
                    }
                }
            }


            FileWriter fw = new FileWriter(file2);
            fw.write(cache);
            fw.close();

            System.out.println("Se escribira:");
            System.out.println(cache + "\nel numero total de palabras son " + contador);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}