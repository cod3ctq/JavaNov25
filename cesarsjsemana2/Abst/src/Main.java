public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA HOSPITALARIO SIMPLIFICADO ===\n");

        // ========== CREAR PERSONAL MÉDICO ==========
        //
        Cirujano cirujano = new Cirujano(
                "Carlos Mendoza",
                "Lunes a Viernes 7:00-15:00",
                15,  //
                3,   //
                "Cardiovascular"
        );

        Enfermero enfermero = new Enfermero(
                "Ana López",
                "Lunes a Viernes 19:00-7:00",
                8,   //
                "Dr. Carlos Mendoza"
        );

        MedicoGeneral medicoGeneral = new MedicoGeneral(
                "Sofia Ramirez",
                "Lunes a Viernes 8:00-16:00",
                12,   //
                10, //
                25    //
        );

        // Información
        System.out.println("--- Cirujano ---");
        cirujano.mostrarInformacionCompleta();
        cirujano.realizarTareas();

        System.out.println("\n--- Enfermeria ---");
        enfermero.mostrarInformacionCompleta();
        enfermero.realizarTareas();

        System.out.println("\n--- Medico General ---");
        medicoGeneral.mostrarInformacionCompleta();
        medicoGeneral.realizarTareas();

        // tipo de empleado
        System.out.println("\n=== PersonalL ===");
        PersonalMedico[] personal = {cirujano, enfermero, medicoGeneral};

        for (PersonalMedico empleado : personal) {
            System.out.println("\n--- " + empleado.getNombreCompleto() + " ---");
            empleado.mostrarInformacionBasica();
            empleado.realizarTareas();
        }

        System.out.println("\n=== Personal total ===");
        System.out.println("Total de personal registrado: " + personal.length);
    }
}