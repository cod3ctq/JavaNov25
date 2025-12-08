package DAO;

import DTO.DetalleMovimientoDTO;
import DTO.ReporteMovimientosClienteDTO;
import database.Conexion;
import models.Movimiento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void registrarMovimiento(Movimiento mov) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, FECHA, TIPO_OPERACION, MONTO) VALUES(?,?,?,?)";
        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD
            );
            ps = con.prepareStatement(query);
            ps.setInt(1, mov.getCuentaId());
            ps.setDate(2, Date.valueOf(mov.getFecha()));
            ps.setString(3, mov.getTipoOperacion());
            ps.setInt(4, mov.getMonto());

            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("insercion ok");
            } else {
                System.out.println("error al registrar movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ReporteMovimientosClienteDTO generarReporteCliente(String cliente) {
        ReporteMovimientosClienteDTO reporte = null;
        List<DetalleMovimientoDTO> detalles = new ArrayList<>();

        String nombre = "";
        int numCuenta = 0;

        int totalRetiros = 0;
        int totalDepositos = 0;
        int totalPagos = 0;
        int totalTransferencias = 0;

        String query =
                "SELECT C.NOMBRE AS NOMBRE_CLIENTE, CU.NUM_CUENTA, " +
                        "M.FECHA, M.TIPO_OPERACION, M.MONTO " +
                        "FROM CLIENTES C " +
                        "INNER JOIN CUENTAS CU ON C.CLIENTE_ID = CU.CLIENTE_ID " +
                        "INNER JOIN MOVIMIENTOS M ON CU.CUENTA_ID = M.CUENTA_ID " +
                        "WHERE C.NOMBRE = ? " +
                        "ORDER BY M.FECHA";

        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD
            );
            ps = con.prepareStatement(query);
            ps.setString(1, cliente);
            rs = ps.executeQuery();

            while (rs.next()) {

                if (nombre.isEmpty()) {
                    nombre = rs.getString("NOMBRE_CLIENTE");
                    numCuenta = rs.getInt("NUM_CUENTA");
                }

                DetalleMovimientoDTO dto = new DetalleMovimientoDTO();
                dto.setTipoOperacion(rs.getString("TIPO_OPERACION"));
                dto.setFecha(rs.getDate("FECHA").toLocalDate());
                dto.setMonto(rs.getInt("MONTO"));

                detalles.add(dto);

                String tipo = dto.getTipoOperacion();
                int monto = dto.getMonto();

                switch (tipo) {
                    case "RETIRO":
                        totalRetiros += monto;
                        break;
                    case "DEPOSITO":
                        totalDepositos += monto;
                        break;
                    case "PAGO DE SERVICIOS":
                        totalPagos += monto;
                        break;
                    case "TRANSFERENCIA":
                        totalTransferencias += monto;
                        break;
                }
            }

            if (!detalles.isEmpty()) {
                reporte = new ReporteMovimientosClienteDTO(
                        nombre,
                        numCuenta,
                        detalles,
                        totalRetiros,
                        totalDepositos,
                        totalPagos,
                        totalTransferencias
                );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return reporte;
    }
}
