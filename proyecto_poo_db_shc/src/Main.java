import DTO.ReporteMovimientosClienteDTO;
import services.impl.CajeroBasico;
import services.impl.Practicaja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // isntancia de una clase hija
        CajeroBasico b1 = new CajeroBasico("Av.Reforma", 100, 109064);
        Practicaja p1 = new Practicaja("Boulevar Avila Camacho", 200, 2349);
        // b1.mostarCuentas();

//        // b1.consultarSaldo(400000000006L);
//        try {
////            Object [] resultados = b1.retirar(400000000006L,"2169",100);
////            System.out.println(resultados[0]);
////            System.out.println(resultados[1]);
////            models.Ticket tt = p1.depositar(40000000006L, 40000);
////            System.out.println(tt);
////
//        } catch (exceptions.AccountNotExitException | exceptions.WrongNipException | exceptions.InsufficientBalanceException |
//                 exceptions.UnderMinimunException ex) {
//        System.out.println(ex.getMessage());
//        System.out.println("Intenta otra Vez");
//
//            // b1.retirar(400000000006L,"2169",500);
//
//            //models.Ticket t = p1.depositar(400000000006L, 50000);
//            // System.out.println("t");

//        }
//     try {          models.Ticket t = p1.pagarServicios(40000000006L, "TP0330", "TPL003");
//            System.out.println("Servicio Pagado)");
//
//        } catch {

        try {
           ReporteMovimientosClienteDTO reporte=  p1.generarReporte("Carlos Sánchez");
            System.out.println(reporte);


        }catch(Exception ex){

        }

        }
    }
// DESARROLLO EN CAPAS:
//CREA PAQUETES DONDE DISTRIBUIR LAS CLASES DEL PROYECTO SEGUN LAS RESPONSABILIDADES DEL CODIGO
//paquetes
//Models : claeese que solo modelan objetos
// 1.- database
// 2.- DAO
// 3.- DTO
// 4.- exceptions
// 5.- services
// 6.- implem

// CREAR UNA NUEVA RAMA
// proyecto_poo_shc
//subir el proyecto completo
