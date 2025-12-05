package DAO;

import DTO.DetalleMovimientoDTO;
import DTO.ReporteMovimientosClienteDTO;
import DTO.ServicioDTO;
import database.Conexion;
import models.Movimiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {
    ServicioDTO dto = null;
    Connection con = null;//abrir la conexion a la BD
    PreparedStatement ps = null;//mandar las sentencias hacia la BD
    ResultSet rs = null;//salida de resultados

    public void registrarMovimineto(Movimiento mov){
        String query="INSERT INTO MOVIMIENTOS(CUENTA_ID,FECHA,TIPO_OPERACION,MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName(Conexion.DRIVER); //cargar el driver, conector
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
            ps = con.prepareStatement(query); //traduce a SQL nativo
            ps.setInt(1,mov.getCuentaId());
            ps.setDate(2, Date.valueOf(mov.getFecha()));
            ps.setString(3, mov.getTipoOperacion());
            ps.setInt(4,mov.getMonto());

            int x=ps.executeUpdate();
            if (x>0){
                System.out.println("Insercion OK");
            }else{
                System.out.println("Error al registrar movimiento");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ReporteMovimientosClienteDTO generarReportePorCliente(String cliente){

        ReporteMovimientosClienteDTO reporte = null;
        String nombre = "";
        int numCuenta = 0;

        List<DetalleMovimientoDTO> detalles = new ArrayList<>();
        DetalleMovimientoDTO dto = null;

        int retiros = 0;
        int depositos = 0;
        int transf = 0;

        String query = "SELECT * FROM MOVIMIENTOS_POR_CLIENTE WHERE NOMBRE = ?";

        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);

            ps = con.prepareStatement(query);
            ps.setString(1, cliente);
            rs = ps.executeQuery();

            while (rs.next()) {

                // Detalle del movimiento
                dto = new DetalleMovimientoDTO(
                        rs.getString("TIPO_OPERACION"),
                        rs.getDate("FECHA").toLocalDate(),
                        rs.getInt("MONTO")
                );
                detalles.add(dto);

                // Acumulados por tipo de operación
                String tipo = rs.getString("TIPO_OPERACION");
                int monto = rs.getInt("MONTO");

                switch (tipo) {
                    case "RETIRO":
                        retiros += monto;
                        break;
                    case "DEPOSITO":
                        depositos += monto;
                        break;
                    case "TRANSFERENCIA":
                        transf += monto;
                        break;
                }

                nombre = rs.getString("NOMBRE");
                numCuenta = rs.getInt("NUM_CUENTA");
            }

            reporte = new ReporteMovimientosClienteDTO(
                    nombre, numCuenta, detalles, retiros, depositos, transf
            );

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return reporte;
    }
}
