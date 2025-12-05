package DTO;

import java.util.List;

public class ReporteMovimientosClienteDTO {

    private String cliente;
    private int numCuenta;
    private List<DetalleMovimientoDTO> detalles;
    private int totalRetiros;
    private int totalDepositos;
    private int totalTransferencias;


    public ReporteMovimientosClienteDTO(String cliente, int numCuenta, List<DetalleMovimientoDTO> detalles, int totalRetiros, int totalDepositos, int totalTransferencias) {
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.detalles = detalles;
        this.totalRetiros = totalRetiros;
        this.totalDepositos = totalDepositos;
        this.totalTransferencias = totalTransferencias;
    }

    public int getTotalRetiros() {
        return totalRetiros;
    }

    public void setTotalRetiros(int totalRetiros) {
        this.totalRetiros = totalRetiros;
    }

    public int getTotalDepositos() {
        return totalDepositos;
    }

    public void setTotalDepositos(int totalDepositos) {
        this.totalDepositos = totalDepositos;
    }

    public int getTotalTransferencias() {
        return totalTransferencias;
    }

    public void setTotalTransferencias(int totalTransferencias) {
        this.totalTransferencias = totalTransferencias;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public List<DetalleMovimientoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleMovimientoDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "DTO.ReporteMovimientosClienteDTO{" +
                "cliente='" + cliente + '\'' +
                ", numCuenta=" + numCuenta +
                ", detalles=" + detalles +
                ", totalRetiros=" + totalRetiros +
                ", totalDepositos=" + totalDepositos +
                ", totalTransferencias=" + totalTransferencias +
                '}';
    }
}
