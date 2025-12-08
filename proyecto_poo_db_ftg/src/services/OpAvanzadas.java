package services;

import DTO.ReporteMovimientosClienteDTO;
import exceptions.AccountNotExistException;
import exceptions.BusinessException;
import models.Ticket;

public interface OpAvanzadas {

    Ticket depositar(long numTarjeta, int monto) throws BusinessException;

    Ticket pagarServicio(long numTarjeta, String convenio, String referencia)
            throws AccountNotExistException, BusinessException;

    ReporteMovimientosClienteDTO generarReporte(String cliente)
            throws BusinessException;
}
