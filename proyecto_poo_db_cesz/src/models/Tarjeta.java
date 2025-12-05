package models;

public class Tarjeta {

    private int tarjetaId;
    private int cuentaId;
    private int numTarjeta;
    private String nip;
    private int cvv;
    private String expira;
    private int tipoTarjetaId;

    public Tarjeta(){}

    public Tarjeta(int tarjetaId, int cuentaId, int numTarjeta, String nip, int cvv, String expira, int tipoTarjetaId) {
        this.tarjetaId = tarjetaId;
        this.cuentaId = cuentaId;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.cvv = cvv;
        this.expira = expira;
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpira() {
        return expira;
    }

    public void setExpira(String expira) {
        this.expira = expira;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "models.Tarjeta{" +
                "tarjetaId=" + tarjetaId +
                ", cuentaId=" + cuentaId +
                ", numTarjeta=" + numTarjeta +
                ", nip='" + nip + '\'' +
                ", cvv=" + cvv +
                ", expira='" + expira + '\'' +
                ", tipoTarjetaId=" + tipoTarjetaId +
                '}';
    }
}
