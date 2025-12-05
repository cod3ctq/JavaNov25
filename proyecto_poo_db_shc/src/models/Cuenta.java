package models;

public class Cuenta {
    private int cuentaId;
    private int cliente;
    private int numCuenta;
    private int tipoCuentaId;
    private int saldo;

    public Cuenta(int cuentaId, int cliente, int numCuenta, int tipoCuentaId, int saldo) {
        this.cuentaId = cuentaId;
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.tipoCuentaId = tipoCuentaId;
        this.saldo = saldo;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
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
                "cuentaId=" + cuentaId +
                ", cliente=" + cliente +
                ", numCuenta=" + numCuenta +
                ", tipoCuentaId=" + tipoCuentaId +
                ", saldo=" + saldo +
                '}';
    }
}
