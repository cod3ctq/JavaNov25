package DTO;// UN DTO: DATA TRANSFERIR OBJETC
// es un objeto con estructura y enfoque flexible, pensando para la transmicion/ recepcion
// de datos hacia y desde el servidor
// su caracterista: no replica la estructura de una tabla fisica

public class cuentaTarjetaDTO {
    private  int cuentaId;
    private  int numCuenta;
    private String descripcion;
    private int saldo;
    private int saldoMin;
    private int saldoMax;
    private long numTrajeta;
    private String nip;

    public cuentaTarjetaDTO(int cuentaId, int numCuenta, String descripcion, int saldo, int saldoMin, int saldoMax, long numTrajeta, String nip) {
        this.cuentaId = cuentaId;
        this.numCuenta = numCuenta;
        this.descripcion = descripcion;
        this.saldo = saldo;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
        this.numTrajeta = numTrajeta;
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

    public long getNumTrajeta() {
        return numTrajeta;
    }

    public void setNumTrajeta(long numTrajeta) {
        this.numTrajeta = numTrajeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "DTO.cuentaTarjetaDTO{" +
                "cuentaId=" + cuentaId +
                ", numCuenta=" + numCuenta +
                ", descripcion='" + descripcion + '\'' +
                ", saldo=" + saldo +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                ", numTrajeta=" + numTrajeta +
                ", nip='" + nip + '\'' +
                '}';
    }
}
