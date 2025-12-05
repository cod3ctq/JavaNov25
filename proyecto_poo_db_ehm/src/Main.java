import Services.impl.CajeroBasico;
import Services.impl.Practicaja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Instancia de una clase hija
        CajeroBasico b1 = new CajeroBasico("Av. Reforma",
                100,109064);

        Practicaja p1 = new Practicaja("Boulevar Xalapa-Banderilla",
                200,23492);
       // b1.mostrarCuentas();
       // b1.consultarSaldo(40000000006L);
       // try{
           // Object[] resultados = b1.retirar(400000000006L, "2169",54000);
            //System.out.println(resultados[0]);
            //System.out.println(resultados[1]);
            //Models.Ticket tt= p1.depositar(400000000006L,4000);
            //System.out.println(tt);

       // }catch(Exception.InsufficientBalanceException.AccountNoExistException|Exception.WrongNipException|Exception.InsufficientBalanceException|Exception.UnderMinimunException  ex){//jerarquia de clases de exception en java
           // System.out.println(ex.getMessage());
          //  System.out.println("Intenta otra vez");
       // }

        //try{
            //Models.Ticket tt= p1.pagarServicio(400000000006L, "TP0330","TPL005");
            //System.out.println(tt);
        //}catch (Exception.InsufficientBalanceException.AccountNoExistException|Exception.WrongNipException|Exception.InsufficientBalanceException|Exception.UnderMinimunException  ex){
           // System.out.println(ex.getMessage());
            //System.out.println("Intenta otra vez");
        }

        //un catch puede manejar multipls excepciones, como?
        //Usando la clase generica, Exception
        //O anotando individualmente cada clase de excepcion especifica, separandolas con la barra vertical |

        //Models.Ticket t=p1.depositar(400000000006L,50000);
        //System.out.println(t);

        //Probar el pagar servicio
//    try{
//       DTO.ReporteMovimientosClienteDTO reporte= p1.generarReporte("Carlos Sanches");
//        System.out.println(reporte);
//    }catch(Exception ex){

    //Deasrrollo en capas:
    //Crear paquetes donde distribuir las clases del proyecto
    //Segun las responsabilidades del codigo

    //models: clases que solo modelan objetos de negocio sin logica
    //database
    //DAO
    //DTO
    //exception
    //services\
    //

    }
