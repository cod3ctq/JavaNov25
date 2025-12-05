package Services;

import DTO.ReporteMovimientosClienteDTO;
import Models.Ticket;

public interface OpAvanzadas {

    Ticket depositar(long numTarjeta, int monto);

    //Pagar servicios: luz, internet, agua
    Ticket pagarServicio(long numTarjeta, String convenio,String referencia);
     ReporteMovimientosClienteDTO generarReporte(String cliente);

    //nombre del cliente num cuenta, fecha monto y tipo de movimiento

    //Generar un reporte de los movimientos asociados a la cuenta de una tarjeta
    //Generar un reporte de los abonos asociados al prestamo de un cliente



}
