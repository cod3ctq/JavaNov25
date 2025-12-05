package DTO;

import java.time.LocalDate;

public class DetalleMovimientoDTO {

    private String  tipoOperacion;
    private LocalDate fecha;
    private int monto;

    public DetalleMovimientoDTO(String tipoOperacion, LocalDate fecha, int monto) {
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "DTO.DetalleMovimientoDTO{" +
                "tipoOperacion='" + tipoOperacion + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
