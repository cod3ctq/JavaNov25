package Models;

import java.time.LocalDate;

public class Movimiento {

    private int movimientoId;
    private int cuentaId;
    private LocalDate fecha;
    private String tipoOperacion;
    private int monto;

    public Movimiento(int movimientoId, int cuentaId, LocalDate fecha, String tipoOperacion, int monto) {
        this.movimientoId = movimientoId;
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }
    public Movimiento( int cuentaId, LocalDate fecha, String tipoOperacion, int monto) {
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Models.Movimiento{" +
                "movimientoId=" + movimientoId +
                ", cuentaId=" + cuentaId +
                ", fecha=" + fecha +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
