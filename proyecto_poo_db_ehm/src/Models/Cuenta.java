package Models;

public class Cuenta {

    private int cuentaId;
    private int clienteId;
    private int numCuenta;
    private int tipoCuentaId;
    private int saldo;

    public Cuenta(int cuentaId, int clienteId, int numCuenta, int tipoCuentaId, int saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
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
        return "Models.Cuenta{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", numCuenta=" + numCuenta +
                ", tipoCuentaId=" + tipoCuentaId +
                ", saldo=" + saldo +
                '}';
    }
}
