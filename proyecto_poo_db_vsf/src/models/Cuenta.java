package models;

public class Cuenta {
    private int cuentaId;
    private int clienteId;
    private int numCuenta;
    private int tipoCuenta;
    private int saldo;

    public Cuenta(int cuentaId, int clienteId, int numCuenta, int tipoCuenta, int saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
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

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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
                ", clienteId=" + clienteId +
                ", numCuenta=" + numCuenta +
                ", tipoCuenta=" + tipoCuenta +
                ", saldo=" + saldo +
                '}';
    }
}
