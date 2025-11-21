public class Laptop extends Computadora {

        double peso;
        int bateriaHoras;

        Laptop() {}

        Laptop(String marca, String procesador, int ram, int almacenamiento,
               double peso, int bateriaHoras) {

            super(marca, procesador, ram, almacenamiento);

            this.peso = peso;
            this.bateriaHoras = bateriaHoras;
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "marca='" + marca + '\'' +
                    ", procesador='" + procesador + '\'' +
                    ", ram=" + ram +
                    ", almacenamiento=" + almacenamiento +
                    ", peso=" + peso +
                    ", bateriaHoras=" + bateriaHoras +
                    '}';
        }
    }

