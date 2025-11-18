import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String ruta ="C:\\Users\\zamar\\Desktop\\Comandos git.txt";
    String rutaescritura ="C:\\Users\\zamar\\Desktop\\escritura.txt";
    //String ruta ="C:\\Users\\zamar\\Desktop\\Git\\JavaNov25\\nombrecompleto.txt";
    File file = new File(ruta);
    File file2 = new File(rutaescritura);
    String linea;
    try{
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        while((linea = br.readLine()) != null){
//            System.out.println(linea);
//        }
        FileWriter fw = new FileWriter(file2);
        fw.write("ESTE ES UN MENSAJE QUE DEBERA ESTAR DENTRO DEL ARCHIVO DE TEXTO");
        fw.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
}