package DTO;

import java.util.List;

public class ReporteMovimientosClienteDTO {

    private String cliente;
    private int numCuenta;
    private List<DetalleMovimientoDTO> movimientos;
    private int totalRetiros;
    private int totalDepositos;
    private int totalPagos;
    private int totalTransferencias;

    public ReporteMovimientosClienteDTO(String cliente,
                                        int numCuenta,
                                        List<DetalleMovimientoDTO> movimientos,
                                        int totalRetiros,
                                        int totalDepositos,
                                        int totalPagos,
                                        int totalTransferencias) {
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.movimientos = movimientos;
        this.totalRetiros = totalRetiros;
        this.totalDepositos = totalDepositos;
        this.totalPagos = totalPagos;
        this.totalTransferencias = totalTransferencias;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public List<DetalleMovimientoDTO> getMovimientos() {
        return movimientos;
    }

    public int getTotalRetiros() {
        return totalRetiros;
    }

    public int getTotalDepositos() {
        return totalDepositos;
    }

    public int getTotalPagos() {
        return totalPagos;
    }

    public int getTotalTransferencias() {
        return totalTransferencias;
    }
}
