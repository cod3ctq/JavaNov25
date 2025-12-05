package DAO;

import DTO.ServicioDTO;
import database.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServiciosDAO {
    Connection con = null; // abrir la database.conexion
    PreparedStatement ps = null; // Interprete para mandar las instrucciones a la base
    ResultSet rs = null; // salida de resultado (cachar la informacion)

    public ServicioDTO buscarServicio(String convenio, String referencia) {

        ServicioDTO dto = null;
        String query = "SELECT S.CONVENIO,R.REFERENCIA, R.PERIODO, R.MONTO, R.STATUS" +
                "FROM SERVICIOS S INNER JOIN RECIBOS R " +
                "ON S.SERVICIO_ID = R.SERVICIO_ID WHERE S. CONVENIO = ' " + convenio+"' AND R.REFERENCIA ='"+referencia+"' AND R.STATUS = 0";
        try {
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new ServicioDTO(rs.getString("CONVENI0"),
                        rs.getString("REFERENCIA"),
                        rs.getString("PERIODO"),
                        rs.getDouble("MONTO"),
                        rs.getInt("STATUS")
                );

             }
        }catch(Exception ex){
            ex.printStackTrace();
        }

            return dto;

    }
}

