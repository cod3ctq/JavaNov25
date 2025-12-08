package DAO;

import DTO.CuentaTarjetaDTO;
import database.Conexion;
import models.Cuenta;
import models.Movimiento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Cuenta> cargarCuentas() {
        List<Cuenta> datos = new ArrayList<>();
        Cuenta cuenta;

        String query = "SELECT * FROM CUENTAS";

        try {
            Class.forName(Conexion.DRIVER);
            con = DriverManager.getConnection(
                    Conexion.URL,
                    Conexion.USER,
                    Conexion.PASSWORD
            );
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                cuenta = new Cuenta(
                        rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getInt("NUM_CUENTA"),
                        rs.getInt("TIPO_CUENTA_ID"),
                        rs.getInt("SALDO")
                );
                datos.add(cuenta);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return datos;
    }

    public CuentaTarjetaDTO buscarCuenta(long numTarjeta) {

        CuentaTarjetaDTO dto = null;

        String query =
                "SELECT CU.CUENTA_ID, CU.NUM_CUENTA, TC.DESCRIPCION, CU.SALDO, " +
                        "       TC.SALDO_MIN, TC.SALDO_MAX, T.NUM_TARJETA, T.NIP " +
                        "FROM TIPO_CUENTA TC INNER JOIN CUENTAS CU " +
                        "ON TC.TIPO_ID = CU.TIPO_CUENTA_ID " +
                        "INNER JOIN TARJETAS T " +
                        "ON CU.CUENTA_ID = T.CUENTA_ID " +
                        "WHERE T.NUM_TARJETA = " + numTarjeta;

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
                dto = new CuentaTarjetaDTO(
                        rs.getInt("CUENTA_ID"),
                        rs.getInt("NUM_CUENTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getInt("SALDO"),
                        rs.getInt("SALDO_MIN"),
                        rs.getInt("SALDO_MAX"),
                        rs.getLong("NUM_TARJETA"),
                        rs.getString("NIP")
                );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dto;
    }

    public void actualizarSaldo(int numCuenta, int nuevoSaldo) {

        String query = "UPDATE CUENTAS SET SALDO = " + nuevoSaldo +
                " WHERE NUM_CUENTA = " + numCuenta;

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
                System.out.println("actualizacion ok");
            } else {
                System.out.println("error al actualizar");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registrarMovimiento(Movimiento mov) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID,FECHA,TIPO_OPERACION,MONTO) VALUES(?,?,?,?)";
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
}
