package DTO;//DTO: Data Transfer Obejct
//Objeto con estructura y enfoque flexible, pensado
//para la transmision/recepcion de datos hacia y desde el servidor
//No replica la estructura de una tabla fisica

public class CuentaTarjetaDTO {

    private int cuentaId;
   private int numCuenta;
   private String descripcion;
   private int saldo;
   private int saldoMin;
   private int saldoMax;
   private long numTarjeta;
   private String nip;

    public CuentaTarjetaDTO(int cuentaId, int numCuenta, String descripcion, int saldo, int saldoMin, int saldoMax, long numTarjeta, String nip) {
        this.cuentaId = cuentaId;
        this.numCuenta = numCuenta;
        this.descripcion = descripcion;
        this.saldo = saldo;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(int saldoMin) {
        this.saldoMin = saldoMin;
    }

    public int getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(int saldoMax) {
        this.saldoMax = saldoMax;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "DTO.CuentaTarjetaDTO{" +
                "cuentaId=" + cuentaId +
                ", numCuenta=" + numCuenta +
                ", descripcion='" + descripcion + '\'' +
                ", saldo=" + saldo +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                ", numTarjeta=" + numTarjeta +
                ", nip='" + nip + '\'' +
                '}';
    }
}
