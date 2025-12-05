package models;

import java.time.LocalDate;

public class Ticket {

    //ubicacion, pecha, numcuenta, folio, transaccion, monto
    private int idCajero;
    private int folio;
    private String ubicacion;
    private LocalDate fecha;
    private int numCuenta;
    private String tipoTransaccion;
    private int monto;


    public Ticket(int idCajero, int folio, String ubicacion, LocalDate fecha, int numCuenta, String tipoTransaccion, int monto) {
        this.idCajero = idCajero;
        this.folio = folio;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.numCuenta = numCuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "models.Ticket{" +
                "idCajero=" + idCajero +
                ", folio=" + folio +
                ", ubicacion='" + ubicacion + '\'' +
                ", fecha=" + fecha +
                ", numCuenta=" + numCuenta +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
