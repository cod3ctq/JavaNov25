package DAO;

import DTO.ServicioDTO;
import database.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicioDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ServicioDTO buscarServicio(String convenio, String referencia) {

        ServicioDTO dto = null;

        String query =
                "SELECT S.CONVENIO, R.REFERENCIA, R.PERIODO, R.MONTO, R.STATUS " +
                        "FROM SERVICIOS S INNER JOIN RECIBOS R " +
                        "ON S.SERVICIO_ID = R.SERVICIO_ID " +
                        "WHERE S.CONVENIO = '" + convenio + "' " +
                        "AND R.REFERENCIA = '" + referencia + "' " +
                        "AND R.STATUS = 0";

        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD
            );
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ServicioDTO(
                        rs.getString("CONVENIO"),
                        rs.getString("REFERENCIA"),
                        rs.getString("PERIODO"),
                        rs.getDouble("MONTO"),
                        rs.getInt("STATUS")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
}
