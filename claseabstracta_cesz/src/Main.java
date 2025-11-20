//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Transporte t1 = new Carro(4,4,"Gasolina",5,500,2);
        Transporte t2 = new Avion(6,3,"Gasavion",5000,"Alemania",15000);
        Transporte t3 = new Autobus(8,2,"Diesel",1500,"Durango",50);


        t1.viaje();
        t2.viaje();
        t3.viaje();
    }
}