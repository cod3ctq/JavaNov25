package services;

import DTO.ReporteMovimientosClienteDTO;
import models.Ticket;

public interface OpAvanzadas {

    Ticket despositar(long numTarjeta, int monto);
    //Pagar Servicios: Luz, internet, agua, SAT
    Ticket pagarServicio(long numTarjeta, String convenio, String referencia);
    ReporteMovimientosClienteDTO generarReporte(String cliente);


    //Generar un reporte de los mov asociados de una tarjeta
    //Genera un reporte de los abonos asociadios al prestamo de un clente


}
