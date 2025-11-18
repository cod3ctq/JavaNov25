import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.lang.classfile.instruction.ExceptionCatch;
import java.nio.channels.ScatteringByteChannel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Lectura
        String ruta="C:\\Users\\ulise\\OneDrive\\Escritorio\\test.txt";
        String rutaescritura="C:\\Users\\ulise\\OneDrive\\Escritorio\\escritura.txt";
        File file = new File(ruta);
        File file2 = new File(rutaescritura);
        String linea;
        String abc = "abcdefghijklmnñopqrstuvwxyz";
        String lineaCifrada="";
        char caracter;
        int contadorPalabras=0;

        try {
            FileReader fr = new FileReader(file); //Lector
            BufferedReader br = new BufferedReader(fr); //Cache
            while((linea = br.readLine())!=null){
                linea = linea.toLowerCase();
                contadorPalabras=contadorPalabras + linea.split(" ").length;

                //Iterar cada linea del archivo, tal cual esta en miniusculas
                for(int i=0; i<linea.length(); i++){
                    caracter = linea.charAt(i);


                    if(caracter==' ' || caracter == '.' || caracter == ',' || caracter == ';' || caracter == '('
                            || caracter == ')' || caracter == '{' || caracter == '}' || caracter == ':' || caracter == '"');
                    lineaCifrada = lineaCifrada + "#";
                }else{
                    lineaCifrada = lineaCifrada + abc.charAt(abc.indexOf(caracter)+1);
                }
                System.out.println(linea);
            }

        }

                System.out.println(linea);
            }
//            FileWriter fw = new FileWriter(file2);
//            fw.write("ESTE ES UN MENSAJE QUE DEBERIA ESTAR DENTRO DEL TEXTO");
//            fw.close();
//
        } catch(ExceptionCatch){
            System.out.println(ex.getMessage());



        }
    } catch(Exception e){






