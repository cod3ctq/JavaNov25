package DAO;

import database.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReciboDAO {

    Connection con = null;// abrir la conexion
    PreparedStatement ps = null;//interprete para mandar las instrucciones a la base
    ResultSet rs = null;//Salida de resultados

    public void pagarRecibo(String referencia){
        String query = "UPDATE RECIBOS SET STATUS = 1 WHERE REFERENCIA = '"+referencia+"'";
        try{
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query);//se usa para el update, delete
            int x = ps.executeUpdate();
            if(x>0) System.out.println("Servicio pagado correctamente");
            else System.out.println("Error al pagar el servicio");
        }catch(Exception ex){

        }
    }
}
