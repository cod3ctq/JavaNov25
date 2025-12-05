package DAO;

import DTO.ServicioDTO;
import database.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReciboDAO {
    ServicioDTO dto = null;
    Connection con = null;//abrir la conexion a la BD
    PreparedStatement ps = null;//mandar las sentencias hacia la BD
    ResultSet rs = null;//salida de resultados


    public void pagarRcibo(String referencia){
        String query ="UPDATE RECIBOS SET STATUS = 1 WHERE REFERENCIA = '"+referencia+"'";
        try {
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            int x = ps.executeUpdate();
            if (x>0){
                System.out.println("Servicio pagado correctamente");
            }else{
                System.out.println("error al pagar servicio");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
