package Models;

public class Tarjeta {
    private int tarjetaId;
    private int cuentaId;
    private int numTarjeta;
    private int cvv;
    private String expira;
    private int tipoTarjeta;
    private String nip;

    public Tarjeta(int tarjetaId, int cuentaId, int numTarjeta, int cvv, String expira, int tipoTarjeta, String nip) {
        this.tarjetaId = tarjetaId;
        this.cuentaId = cuentaId;
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.expira = expira;
        this.tipoTarjeta = tipoTarjeta;
        this.nip = nip;
    }


    public int getTarjetaId() {
        return tarjetaId;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public int getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Models.Tarjeta{" +
                "tarjetaId=" + tarjetaId +
                ", cuentaId=" + cuentaId +
                ", numTarjeta=" + numTarjeta +
                ", cvv=" + cvv +
                ", expira='" + expira + '\'' +
                ", tipoTarjeta=" + tipoTarjeta +
                ", nip='" + nip + '\'' +
                '}';
    }
}
