package DAO;

import DataBase.Conexion;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReciboDAO {


    Conexion con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public void pagarRecibo(String referencia){
        String query= "UPDATE SET STATUS = 1 WHERE REFERENCIA= '"+referencia+"'";
        try{
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = (Conexion) DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //precomplila o interpreta para que la base la entienda, traduce a SQL nativo
            int x= ps.executeUpdate();
            if (x>0){
                System.out.println("Servicio pagado correctamente");
            }else{
                System.out.println("Error al pagar el servicio");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
