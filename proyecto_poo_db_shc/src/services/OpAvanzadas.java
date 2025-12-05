package services;

import DTO.ReporteMovimientosClienteDTO;
import models.Ticket;

public interface OpAvanzadas {

    Ticket depositar (long numTarjeta, int monto);
    //PAGAR SERVICIOS : LUZ, INTERNET, AGUA

    Ticket pagarServicios(long numTarjeta, String convenio, String referencia);
    ReporteMovimientosClienteDTO generarReporte(String cliente);



    // Generar reporte de los movimientos asociados a la cuenta de una tarjeta
    // Generar reporte de los abonos asociados al prestamo de un cliente


}
