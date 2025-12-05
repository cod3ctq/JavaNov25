package models;

public class Tarjeta {
    private int tarjeta;
    private int cuentaId;
    private int numTarjeta;
    private String nip;
    private int cvv;
    private String expira;
    private int tipoTarjeraId;

    public Tarjeta(int tarjeta, int cuentaId, int numTarjeta, String nip, int cvv, String expira, int tipoTarjeraId) {
        this.tarjeta = tarjeta;
        this.cuentaId = cuentaId;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.cvv = cvv;
        this.expira = expira;
        this.tipoTarjeraId = tipoTarjeraId;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public int getTipoTarjeraId() {
        return tipoTarjeraId;
    }

    public void setTipoTarjeraId(int tipoTarjeraId) {
        this.tipoTarjeraId = tipoTarjeraId;
    }

    @Override
    public String toString() {
        return "models.Tarjeta{" +
                "tarjeta=" + tarjeta +
                ", cuentaId=" + cuentaId +
                ", numTarjeta=" + numTarjeta +
                ", nip='" + nip + '\'' +
                ", cvv=" + cvv +
                ", expira='" + expira + '\'' +
                ", tipoTarjeraId=" + tipoTarjeraId +
                '}';
    }
}
