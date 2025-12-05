package DAO;

import DTO.CuentaTarjetaDTO;
import DataBase.Conexion;
import Models.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//Data Access Object :Encapsular la logica de consulta
public class CuentaDAO {

    Connection con = null; //Abrir la conexion
    PreparedStatement ps = null; //Interprete para mandar las instrucciones a la base
    ResultSet rs = null; // //Salida de resultados

    public List<Cuenta> cargarCuentas (){
        //DataBase.Conexion a base de datos con JDBC

        List<Cuenta> datos= new ArrayList<Cuenta>();
        Cuenta cuenta=null;
        String query = "SELECT * FROM CUENTAS";
//investigar el driver y la url para una conexion jdbc a oracle
        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //precomplila o interpreta para que la base la entienda, traduce a SQL nativo
            rs = ps.executeQuery(); //Ejecuta la secuencia

            while(rs.next()){
                cuenta= new Cuenta(rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getInt("NUM_CUENTA"),
                        rs.getInt("TIPO_CUENTA_ID"),
                        rs.getInt("SALDO"));
                //Anade el objeto lleno a la lista
                datos.add(cuenta);


            }
        }catch (Exception ex){
            ex.printStackTrace();

        }

        return datos;
    }
    public CuentaTarjetaDTO buscarCuenta(long numTarjeta){
        CuentaTarjetaDTO dto=null;
        String query = "SELECT CU.CUENTA_ID, CU.NUM_CUENTA, TC.DESCRIPCION, CU.SALDO, TC.SALDO_MIN, TC.SALDO_MAX, T.NUM_TARJETA, T.NIP\n" +
                "FROM TIPO_CUENTA TC INNER JOIN CUENTAS CU " +
                "ON TC.TIPO_ID=CU.TIPO_CUENTA_ID " +
                "INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID=T.CUENTA_ID WHERE T.NUM_TARJETA="+numTarjeta;
         //investigar el driver y la url para una conexion jdbc a oracle
        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //precomplila o interpreta para que la base la entienda, traduce a SQL nativo
            rs = ps.executeQuery(); //Ejecuta la secuencia

            while(rs.next()){
                dto= new CuentaTarjetaDTO(rs.getInt("CUENTA_ID"),rs.getInt("NUM_CUENTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getInt("SALDO"),
                        rs.getInt("SALDO_MIN"),
                        rs.getInt("SALDO_MAX"),
                        rs.getLong("NUM_TARJETA"),
                        rs.getString("NIP"));
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return dto;
    }

    public void actualizarSaldo(int numCuenta, int nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO ="+ nuevoSaldo+ " WHERE NUM_CUENTA ="+numCuenta;

        try {
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query);
            int x = ps.executeUpdate(); //Devuelve el numero de filas afectadas por la sentencia

            if (x>0){
                System.out.println("Actualizacion OK");
            } else {
                System.out.println("Error al actualizar");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
