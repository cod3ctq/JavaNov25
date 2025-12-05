import DTO.ReporteMovimientosClienteDTO;
import services.impl.CajeroBasico;
import services.impl.Practicaja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //instancia de una clase hija
        CajeroBasico b1 = new CajeroBasico("Av. Reforma",100,109064);
        Practicaja p1 = new Practicaja("Av. Avila Camacho",200,23492);
        //b1.mostrarCuentas();
        //b1.consultarSaldo(400000000006L);

        //Object[] resultados = b1.retirar(480000000006L, "2169",500);//2169
//        System.out.println(resultados[0]);
//        System.out.println(resultados[1]);
        //models.Ticket t = p1.depositar(400000000006L,100001);
        //System.out.println(t);

//        try{
//            //Object[] resultados = b1.retirar(400000000006L, "2169",9000);//2169
//            models.Ticket tt = p1.depositar(400000000006L, 9000);
//        //}catch (Exception ex){
//        }catch (exceptions.AccountNotExistException|exceptions.WrongNipException|exceptions.InsufficientBalanceException|exceptions.UnderMinimumException ex){
//            System.out.println(ex.getMessage());
//            System.out.println("intenta otra vez :)");
//        }

        try{
            ReporteMovimientosClienteDTO reporte = p1.generarReporte("Carlos Sánchez");
            System.out.println(reporte);
        } catch (Exception ex) {

        }
        // un catch puede manejar multiples excepciones
        //usando la clase generica Exception
        //anotando individualmente cada clase de exception especifica separandolos con una barra bertical |


        //desarrollo en capasdonde distribuir las clases del proyecto
        //segun las responsabilidades del codigo

        //paketes para los models, database
        //models:
    }
}

//crear una nueva rama: proyecto_poo_xxx
//subir el proyecto completo