import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Lectura
        String ruta = "C:\\Users\\52231\\OneDrive\\Escritorio\\Lectura.txt\\";
        String rutaescritura= "C:\\Users\\52231\\OneDrive\\Escritorio\\escritura.txt";
        File file = new File(ruta);
        File file2 = new File(rutaescritura);
        String linea;
        String abc="abcdefghijklmnñopqrstuvwxyz";
        String lienaCifrada;
        char caracter;
        int contadorPalabras=0;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine())!= null){
                linea=  linea.toLowerCase();
                contadorPalabras = contadorPalabras + linea.split(" ").length;

                //Iterar cada linea del archivo, tal cual esta en mayusculas
                for(int i =0; i<linea.length(); i++){
                    caracter =linea.charAt(i);
                    if(caracter== ' '|| caracter==','|| caracter=='"' ||
                            caracter==':'|| caracter=='('|| caracter==')'||
                            caracter=='{'||caracter=='}'||caracter=='.'||caracter==';'||){
                        lienaCifrada= lienaCifrada + "#";
                    }else if (caracter== 'z') {
                        lienaCifrada=lienaCifrada+"a";
                    }
                    else {
                        lienaCifrada = lineacifrada + abc.charAt(abc.indexOf(caracter) + 1);
                    }
                System.out.println(lienaCifrada);
            }
            fw.write(lienaCifrada);
                lienaCifrada="";
                System.out.println("palabras:" + contadorPalabras);
            fw.close();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        // Normalizar todas las minusculas
        // Ecribir cuantas palabras tiene el texto

        // But i must explain to you
        // cuj j nvtu fyqmbjm up z





        }

    }

}