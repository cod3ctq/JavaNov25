package models;

public class Cuenta {

    private int cuentaID;
    private int clienteId;
    private int numCuenta;
    private int tipoCuentaId;
    private int saldo;

    public Cuenta(int cuentaID, int clienteId, int numCuenta, int tipoCuentaId, int saldo) {
        this.cuentaID = cuentaID;
        this.clienteId = clienteId;
        this.numCuenta = numCuenta;
        this.tipoCuentaId = tipoCuentaId;
        this.saldo = saldo;
    }

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "models.Cuenta{" +
                "cuentaID=" + cuentaID +
                ", clienteId=" + clienteId +
                ", numCuenta=" + numCuenta +
                ", tipoCuentaId=" + tipoCuentaId +
                ", saldo=" + saldo +
                '}';
    }
}
//POJO(Plain Old Java Object)
//SI replica la estructura de una tabla de una base de datos => ENTIDAD