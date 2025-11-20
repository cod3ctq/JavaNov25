import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Lectura
        String ruta = "C:\\Users\\edgar\\Desktop\\texto.txt";
        String rutaescritura = "C:\\Users\\edgar\\Desktop\\escritura.txt";
        File file2 = new File(rutaescritura);
        File file = new File(ruta);
        String linea;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            FileWriter fw = new FileWriter(file2);
            fw.write("Generar huuyrsuru");
           fw.close();
            }
            } catch(Exception ex){
                System.out.println(ex.getMessage());

            }
        }
    }
