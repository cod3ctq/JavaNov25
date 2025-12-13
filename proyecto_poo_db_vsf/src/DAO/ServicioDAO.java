package DAO;

import DTO.ServicioDTO;
import database.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicioDAO {

    ServicioDTO dto = null;
    Connection con = null;//abrir la conexion a la BD
    PreparedStatement ps = null;//mandar las sentencias hacia la BD
    ResultSet rs = null;//salida de resultados

    public ServicioDTO buscarServicio(String convenio, String referencia){
        String query = "SELECT S.CONVENIO, R.REFERENCIA, R.PERIODO, R.MONTO, R.STATUS " +
                "FROM SERVICIOS S INNER JOIN RECIBOS R " +
                "ON S.SERVICIO_ID = R.SERVICIO_ID WHERE S.CONVENIO = '"+convenio+"' AND REFERENCIA = '"+referencia+"' AND R.STATUS = 0";


        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            rs = ps.executeQuery(); //Ejecuta la sentencia
            while(rs.next()){
                dto = new ServicioDTO(rs.getString("CONVENIO"),
                        rs.getString("REFERENCIA"),
                        rs.getString("PERIODO"),
                        rs.getDouble("MONTO"),
                        rs.getInt("STATUS"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return dto;
    }
}
