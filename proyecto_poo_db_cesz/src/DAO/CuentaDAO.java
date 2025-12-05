package DAO;

import DTO.CuentaTarjetaDTO;
import database.Conexion;
import models.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {
    //DAO => data acces object => encapsular la logica de las consultas
    Connection con = null;// abrir la conexion
    PreparedStatement ps = null;//interprete para mandar las instrucciones a la base
    ResultSet rs = null;//Salida de resultados

    public List<Cuenta> cargarCuentas(){
        List<Cuenta> datos = new ArrayList<Cuenta>();
        Cuenta cuenta = null;
        String query = "SELECT * FROM CUENTAS";
        try{
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD);
            ps = con.prepareStatement(query);//traduce a sql nativo
            rs = ps.executeQuery();//ejecutar query

            while(rs.next()){
                cuenta = new Cuenta(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID"),
                        rs.getInt("NUM_CUENTA"),rs.getInt("TIPO_CUENTA_ID"),rs.getInt("SALDO"));
                datos.add(cuenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }


    public CuentaTarjetaDTO buscarCuenta(long numTarjeta){
        CuentaTarjetaDTO dto = null;
        String query = "SELECT CU.CUENTA_ID, CU.NUM_CUENTA, TC.DESCRIPCION, CU.SALDO, TC.SALDO_MIN, TC.SALDO_MAX,T.NUM_TARJETA, T.NIP " +
                "FROM TIPO_CUENTA TC INNER JOIN CUENTAS CU " +
                "ON TC.TIPO_ID = CU.TIPO_CUENTA_ID " +
                "INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID WHERE T.NUM_TARJETA = "+numTarjeta;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");//cargar el driver o conector
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD);
            ps = con.prepareStatement(query);//traduce a sql nativo
            rs = ps.executeQuery();//ejecutar query de lectura
            while(rs.next()){
                dto = new CuentaTarjetaDTO(rs.getInt("CUENTA_ID"),rs.getInt("NUM_CUENTA"),rs.getString("DESCRIPCION"),
                        rs.getInt("SALDO"), rs.getInt("SALDO_MIN"),rs.getInt("SALDO_MAX"),
                        rs.getLong("NUM_TARJETA"),rs.getString("NIP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public void actualizarSaldo(int numCuenta, int nuevoSaldo){

        String query = "UPDATE CUENTAS SET SALDO = "+nuevoSaldo+" WHERE NUM_CUENTA = "+numCuenta;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD);
            ps = con.prepareStatement(query);//se usa para el update, delete
            int x = ps.executeUpdate();
            if(x>0) System.out.println("Actualizacion OK");
            else System.out.println("Error al actualizar");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
