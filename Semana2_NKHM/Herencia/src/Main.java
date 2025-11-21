public class Main {
    public static void main(String[] args) {

        // Crear un personaje con constructor vacío
        Personaje pj1 = new Personaje();
        System.out.println(pj1);

        // Modificar atributos con setters
        pj1.setFuerza(10);
        pj1.setDestreza(8);
        pj1.setInteligencia(12);
        pj1.setFe(6);
        pj1.setSalud(100);
        pj1.setMana(50);

        System.out.println(pj1);

        // Crear un personaje con constructor lleno
        Personaje pj2 = new Personaje(15, 9, 14, 10, 120, 80);
        System.out.println(pj2);

        // Probar métodos
        pj2.entrenar();
        pj2.meditar();
        pj2.estudiar();
        pj2.rezar();
        pj2.comer();
        pj2.beber();
    }
}
