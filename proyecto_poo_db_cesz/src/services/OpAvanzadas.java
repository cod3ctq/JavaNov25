package services;

import DTO.ReporteMovimientosClienteDTO;
import models.Ticket;

public interface OpAvanzadas {
    Ticket depositar(long numTarjeta, int monto);

    //pago de servicios: Luz, internet, agua
    Ticket pagarServicio(long numTarjeta, String convenio, String referencia);

    ReporteMovimientosClienteDTO generarReporte(String client);
    //GENERAR UN REPORTE DE LOS MOVIMIENTOS ASOCIADOS A LA CUENTA DE UNA TARJETA
    //GENERAR UN REPORTE DE LOS ABONOS ASOCIADOS AL PRESTAMO DE UN CLIENTE


}
