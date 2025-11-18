import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {

        //Lectura:
        String ruta="C:\\Users\\pacoa\\Desktop\\prueba y error.txt";
        String rutaescritura = "C:\\Users\\pacoa\\Desktop\\escritura.txt";
        File file2 = new File(rutaescritura);
        File file = new File(ruta); //representacion del archivo en memoria
        String linea;

        try {
//            FileReader fr = new FileReader(file); //lector
//            BufferedReader br = new BufferedReader(fr); //cache
//            while ((linea = br.readLine())!=null){
//                System.out.println(linea);
//            }

            FileWriter fw=new FileWriter(file2);
           fw.write("Este es un mesaje que debera estar dentro del archivo de texto");
           fw.close();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}