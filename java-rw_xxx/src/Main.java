import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Lectura:
        String ruta="C:\\Users\\Cesar\\Desktop\\widget posibly.txt";
        String rutaescritura = "C:\\Users\\Cesar\\Desktop\\escritura.txt";
        File file = new File(ruta); //Representacion del archivo en memoria
        File file2 = new File(rutaescritura);
        String linea;
        String abc = "abcdefghijklmñopqrstuvwxyz";
        String lineaCifrada="";
        char caracter;
        int contadorPalabras=0;
        try{
            FileReader fr = new FileReader(file); //Lector
            BufferedReader br = new BufferedReader(fr); //Cache
            FileWriter fw = new FileWriter(file2);
            while((linea = br.readLine())!=null){
                System.out.println("Linea:"+linea);
                linea = linea.toLowerCase();
                contadorPalabras = contadorPalabras + linea.split(" ").length;
                //Iterar cada linea del archivo, tal cual esta en minusculas
                for(int i=0; i<linea.length(); i++){
                    caracter = linea.charAt(i);
                    if(caracter==' '||caracter=='.'||caracter==','||caracter==';'||
                            caracter=='('||caracter==')'||caracter=='{'||caracter=='}'||
                            caracter==':'||caracter=='"'){
                        lineaCifrada = lineaCifrada+"#";
                    }else if(caracter=='z') {
                        lineaCifrada = lineaCifrada+"a";
                    }else{
                        lineaCifrada = lineaCifrada + abc.charAt(abc.indexOf(caracter)+1);
                    }
                }
                fw.write(lineaCifrada);
                lineaCifrada ="";
                System.out.println("Palabras: "+contadorPalabras);
            }
            fw.close(); //cierra y guarda cambios en el archivo
        }catch(Exception ex){ //manejar la excepcion
           ex.printStackTrace();
        }
        //Normalizar todas a minusculas
        //Escribir cuantas palabras tiene el texto

        //But i must explain to you how all this mistaken ...
        //cvu j nvtu fyqmbjm up z

    }
}