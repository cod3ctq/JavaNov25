import java.io.BufferedReader;

import java.io.File; //
import java.io.FileReader; //
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\GabrielSF\\Desktop\\lectura.txt";
        String rutaescritura = "C:\\Users\\GabrielSF\\Desktop\\escritura.txt";
        File file = new File(ruta);//representacion del archivo en memoiria
        File file2 = new File(rutaescritura);
        String linea;
        try{
//            FileReader fr = new FileReader(file);//lector
//            BufferedReader br = new BufferedReader(fr);//cache
//            while ((linea = br.readLine())!=null){
//                System.out.println(linea);
//            }
        FileWriter fw = new FileWriter(file2);
        fw.write("ESTE ES UN MENSAJE QUE DEBERA ESTAR DENTRO DEL ARCHIVO DE TEXTO");
        fw.close();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            //normalizar a minusculas
            //que cada letra de cada palabra se cambie por la siguiente en el abecedario

        }
    }
}