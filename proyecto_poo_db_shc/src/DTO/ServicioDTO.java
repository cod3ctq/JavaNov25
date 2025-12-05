package DTO;

public class ServicioDTO {
    private String convenio;
    private String referencia;
    private String perido;
    private double monto;
    private int status;

    public ServicioDTO(String convenio, String referencia, String perido, double monto, int status) {
        this.convenio = convenio;
        this.referencia = referencia;
        this.perido = perido;
        this.monto = monto;
        this.status = status;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DTO.ServicioDTO{" +
                "convenio='" + convenio + '\'' +
                ", referencia='" + referencia + '\'' +
                ", perido='" + perido + '\'' +
                ", monto=" + monto +
                ", status=" + status +
                '}';
    }
}
