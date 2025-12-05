package DAO;

import DTO.DetalleMovimientoDTO;
import DTO.ReporteMovimientosClienteDTO;
import database.conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void registrarMovimiento(Movimiento mov) {
        String query = "INSER INTO MOVIMIENTOS( CUENTA_ID,FECHA,TIPO_OPERACION;MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            ps.setInt(1, mov.getCuentaId());
            ps.setDate(2, Date.valueOf(mov.getFecha()));
            ps.setString(3, mov.getTipoOperacion());
            ps.setInt(4, mov.getMonto());

            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Insercion ok");
            } else {
                System.out.println("Error al registrar movimientos");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ReporteMovimientosClienteDTO generearReportePorCliente(String cliente){
        ReporteMovimientosClienteDTO reporte = null;
        String nombre = "";
        int numcuenta =0;
        List<DetalleMovimientoDTO> detalles = new ArrayList<DetalleMovimientoDTO>();
        DetalleMovimientoDTO dto = null;
        int retiros=0;
        int depositos=0;
        int transf = 0;
        String query="SELECT * FROM MOVIMIENTOS_POR_CLIENTE WHERE NOMBRE='"+cliente+"'";
        try{
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                 dto= new DetalleMovimientoDTO(rs.getString("TIPO_OPERACION"),
                         rs.getDate("FECHA").toLocalDate(),rs.getInt("MONTO"));
                 detalles.add(dto);

                 switch(rs.getString("TIPO_OPERACION")){
                     case "RETIRO":
                         retiros = retiros + rs.getInt("MONTO");
                         break;
                     case "DEPOSITO":
                         depositos = depositos + rs.getInt("MONTO");
                         break;
                     case "TRANFERENCIAS":
                         transf = transf + rs.getInt("MONTO");
                         break;
                 }
                 nombre = rs.getString("NOMBRE");
                 numcuenta = rs.getInt("NUM_CUENTA");

             }

             reporte = new ReporteMovimientosClienteDTO(nombre,numcuenta,detalles,retiros,depositos,transf);

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return null;

    }
}