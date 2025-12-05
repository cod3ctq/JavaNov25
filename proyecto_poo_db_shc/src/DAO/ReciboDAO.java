package DAO;

import database.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReciboDAO {
    Connection con = null; // abrir la database.conexion
    PreparedStatement ps = null; // Interprete para mandar las instrucciones a la base
    ResultSet rs = null; // salida de resultado (cachar la informacion)

    public void pagarRecibo(String referencia) {
        String query = "UPDATE RECIBOS SET STATUS = 1 WHERE REFERENCIA = '" + referencia + "'";
        try {
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("Servicio  pagado correctamente");
            } else {
                System.out.println("Error al pagar el servicio");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}





