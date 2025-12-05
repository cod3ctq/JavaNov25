package DAO;

import DTO.CuentaTarjetaDTO;
import database.Conexion;
import models.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//data access object : encapsular la logica de consultas
public class CuentaDAO {

    Connection con = null;//abrir la conexion a la BD
    PreparedStatement ps = null;//mandar las sentencias hacia la BD
    ResultSet rs = null;//salida de resultados

    public List<Cuenta> cargarCuentas(){
        List<Cuenta> datos = new ArrayList<Cuenta>();
        Cuenta cuenta=null;
        String query = "SELECT * FROM CUENTAS";
        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            rs = ps.executeQuery(); //Ejecuta la sentencia
            while(rs.next()){
                //captura los datos de la fila actual en el objeto auxiliar
                cuenta = new Cuenta(rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"), rs.getInt("NUM_CUENTA"),
                        rs.getInt("TIPO_CUENTA_ID"),rs.getInt("SALDO"));
                //añade el objeto lleno a la lista
                datos.add(cuenta);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return datos;
    }

    public CuentaTarjetaDTO buscarCuenta(long numTarjeta){

        CuentaTarjetaDTO dto = null;
        String query = "SELECT CU.CUENTA_ID, CU.NUM_CUENTA, TC.DESCRIPCION, CU.SALDO, TC.SALDO_MIN, TC.SALDO_MAX, T.NUM_TARJETA, T.NIP " +
                "FROM TIPO_CUENTA TC INNER JOIN CUENTAS CU " +
                "ON TC.TIPO_ID = CU.TIPO_CUENTA_ID " +
                "INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID WHERE T.NUM_TARJETA ="+numTarjeta;
        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            rs = ps.executeQuery();
            while(rs.next()){
                //captura los datos de la fila actual en el objeto auxiliar
                dto = new CuentaTarjetaDTO(rs.getInt("CUENTA_ID"),rs.getInt("NUM_CUENTA"), rs.getString("DESCRIPCION"),
                        rs.getInt("SALDO"), rs.getInt("SALDO_MIN"), rs.getInt("SALDO_MAX"),
                        rs.getLong("NUM_TARJETA"),rs.getString("NIP"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            //System.out.println(ex.getMessage());
        }
        return dto;
    }

    public void actualizarSaldo(int numCuenta, int nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO ="+nuevoSaldo+" WHERE NUM_CUENTA = "+numCuenta;

        try {
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            rs = ps.executeQuery();
            int x = ps.executeUpdate();//devuelkve el numero de filas afectadas por la sentencia

            if (x>0){
                System.out.println("Actualizacion ok");
            }else{
                System.out.println("Error al actualizar");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
