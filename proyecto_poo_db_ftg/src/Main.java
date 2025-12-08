import DTO.ReporteMovimientosClienteDTO;
import exceptions.AccountNotExistException;
import exceptions.BusinessException;
import exceptions.InsufficientBalanceException;
import exceptions.UnderMinimunException;
import exceptions.WrongNipException;
import models.Ticket;
import services.impl.CajeroBasico;
import services.impl.PractiCaja;

public class Main {
    public static void main(String[] args) {

        CajeroBasico b1 = new CajeroBasico("Av Reforma", 100, 109063);
        PractiCaja p1 = new PractiCaja("Av Reforma", 200, 23492);

        try {
            Ticket t = p1.depositar(400000000006L, 40000);
            System.out.println(t);

            // Ejemplo pago servicio:
            // Ticket t2 = p1.pagarServicio(400000000006L, "CFE0110", "CFE001");
            // System.out.println(t2);

            // Ejemplo reporte:
            // ReporteMovimientosClienteDTO reporte = p1.generarReporte("Carlos Sánchez");
            // System.out.println(reporte.getCliente());
            // for (var det : reporte.getMovimientos()) {
            //     System.out.println(det.getFecha() + " " + det.getTipoOperacion() + " " + det.getMonto());
            // }

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.out.println("intenta otra vez :)");
        }
    }
}




































/*
import DTO.ReporteMovimientosClienteDTO;
import exceptions.*;
import models.Ticket;
import services.impl.CajeroBasico;
import services.impl.PractiCaja;
public class Main {
    public static void main(String[] args) {

//        services.impl.CajeroBasico b1 = new services.impl.CajeroBasico("Av Reforma", 100, 109063);
//        services.impl.PractiCaja p1 = new services.impl.PractiCaja("Av Reforma", 200, 23492);
//        try {
        //Object[] resultados = b1.retirar(400000000006L, "2169", 500);
        //System.out.println(resultados[0]); // monto
        //System.out.println(resultados[1]); // ticket

        //models.Ticket tt = p1.depositar("400000000006L", 100001);
        // System.out.println(tt);

//             models.Ticket t = p1.depositar(400000000006L, 40000);
//             System.out.println(t);
//
//        } catch (exceptions.AccountNotExistException |
//                 exceptions.WrongNipException |
//                 exceptions.InsufficientBalanceException |
//                 exceptions.UnderMinimunException ex) {

//            System.out.println(ex.getMessage());
//            System.out.println("intenta otra vez :)");
        try{
            ReporteMovimientosClienteDTO reporte = p1.generarReporte("Carlos Sánchez");
            System.out.println(reporte);


        }catch(BusinessException e){


        }
        //desarrollo en capas:
        //crear paquetes donde distribuir las clases del proyecto
        //segun las responsabilidades del codigo

        //models : clases que solo modelan objetos de negocio sin logica
        //database
        //dao
        //dto
        //exceptions
        //services
        //implem



    }
}



 */