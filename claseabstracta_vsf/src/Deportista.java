//esta clase se convierte en abstact por que tiene alk menos un metodo abstract
//es una base conceptual para otras clases

public abstract class Deportista {

    //puede teber atributos, constructores, getter y setter
    //ademas de metodos NO abstractos

    String disciplina;
    int horasEntrenamiento;

    public Deportista(){}

    public Deportista(String disciplina, int horasEntrenamiento) {
        this.disciplina = disciplina;
        this.horasEntrenamiento = horasEntrenamiento;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getHorasEntrenamiento() {
        return horasEntrenamiento;
    }

    public void setHorasEntrenamiento(int horasEntrenamiento) {
        this.horasEntrenamiento = horasEntrenamiento;
    }

    @Override
    public String toString() {
        return "Deportista{" +
                "disciplina='" + disciplina + '\'' +
                ", horasEntrenamiento=" + horasEntrenamiento +
                '}';
    }

    //metodo abstracto: un metodo sin cuerpo o logica (hay un QUE hacer sin un COMO hacerlo)

    public abstract void entrenar();


}
