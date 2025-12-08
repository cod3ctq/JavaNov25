package models;

public class Tarjeta {
    private int tarjetaId;
    private int cuentaId;
    private int numTarjeta;
    private String nip;
    private int cvv;
    private String expira;
    private int tipoTarjetaId;

    public Tarjeta(int tarjetaId, int cuentaId, int numTarjeta, String nip,
                   int cvv, String expira, int tipoTarjetaId) {
        this.tarjetaId = tarjetaId;
        this.cuentaId = cuentaId;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.cvv = cvv;
        this.expira = expira;
        this.tipoTarjetaId = tipoTarjetaId;
    }
}
