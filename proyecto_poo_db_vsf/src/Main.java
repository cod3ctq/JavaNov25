import DTO.ReporteMovimientosClienteDTO;
import services.impl.CajeroBasico;
import services.impl.PractiCaja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CajeroBasico b1 = new CajeroBasico("Av. Reforma", 100,
                109064);

        PractiCaja p1 = new PractiCaja("Boulevard Puerto Aereo", 200, 23492);
        //b1.buscarCuenta();
        //b1.consultarSaldo(400000000002L);
//        try {
////            Object[] resultados = b1.retirar(400000000006l, "2169", 700000);
////            System.out.println(resultados[0]);
////            System.out.println(resultados[1]);
//            models.Ticket tt = p1.despositar(400000000006l,40000);
//            System.out.println(tt);
//        }catch (Exception ex){//jerarquia de clases de excepcion en java
//            System.out.println(ex.getMessage());
//            System.out.println("Intenta otra vez");
//        }
        //Un catch puede manejar multiples excepciones, como?
        //Usar la clase generiaca, Exception
        //Separandolas con la barra vertical OR |

        //models.Ticket t = p1.despositar(400000000006L, 1000);
        //System.out.println(t);

        //

        try{
            ReporteMovimientosClienteDTO reporte = p1.generarReporte("Carlos Sánchez");
            System.out.println(reporte);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //Desarrollo en capas:
        //crear paquetes donde distribuir las clases del proyecto
        //segun las responsabilidades del codigo


        //models
        //database
        //DAO
        //DTO
        //exception
        //services

    }
}