public class Vehiculo {
    String Marca;
    String Submarca;
    int Modelo;
    String Serie;

    public Vehiculo(String marca, String submarca, int modelo, String serie) {
        Marca = marca;
        Submarca = submarca;
        Modelo = modelo;
        Serie = serie;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getSubmarca() {
        return Submarca;
    }

    public void setSubmarca(String submarca) {
        Submarca = submarca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    @Override
    public String toString() {
        return "Vehiculo:" +
                "\nMarca='" + Marca +
                "\nSubmarca='" + Submarca +
                "\nModelo=" + Modelo +
                "\nSerie='" + Serie;
    }
}
