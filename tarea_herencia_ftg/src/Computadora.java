public class Computadora {
        String marca;
        String procesador;
        int ram;
        int almacenamiento;

        Computadora() {}

        Computadora(String marca, String procesador, int ram, int almacenamiento) {
            this.marca = marca;
            this.procesador = procesador;
            this.ram = ram;
            this.almacenamiento = almacenamiento;
        }

        @Override
        public String toString() {
            return "Computadora{" +
                    "marca='" + marca + '\'' +
                    ", procesador='" + procesador + '\'' +
                    ", ram=" + ram +
                    ", almacenamiento=" + almacenamiento +
                    '}';
        }
    }


