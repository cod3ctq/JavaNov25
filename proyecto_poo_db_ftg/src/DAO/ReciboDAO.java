package DAO;

import database.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReciboDAO {

    Connection con = null;
    PreparedStatement ps = null;

    public void pagarRecibo(String referencia) {
        String query = "UPDATE RECIBOS SET STATUS = 1 WHERE REFERENCIA = '" + referencia + "'";
        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD
            );
            ps = con.prepareStatement(query);
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Servicio pagado correctamente");
            } else {
                System.out.println("error al pagar el servicio");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
