package DTO;

public class ServicioDTO {

    private String convenio;
    private String referencia;
    private String periodo;
    private double monto;
    private int status;

    public ServicioDTO(String convenio, String referencia, String periodo, double monto, int status) {
        this.convenio = convenio;
        this.referencia = referencia;
        this.periodo = periodo;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        return "ServicioDTO{" +
                "convenio='" + convenio + '\'' +
                ", referencia='" + referencia + '\'' +
                ", periodo='" + periodo + '\'' +
                ", monto=" + monto +
                ", status=" + status +
                '}';
    }
}
