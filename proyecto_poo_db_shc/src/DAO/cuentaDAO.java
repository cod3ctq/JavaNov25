package DAO;

import DTO.cuentaTarjetaDTO;
import database.conexion;
import models.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// DATA ACCESS OBJECT: ENCAPSULAR AL LOGICA DE CONSULTAS
public class cuentaDAO {

    Connection con = null; // abrir la database.conexion
    PreparedStatement ps = null; // Interprete para mandar las instrucciones a la base
    ResultSet rs = null; // salida de resultado (cachar la informacion)

    public List<Cuenta> cargarCuentas() {
        // database.conexion a db con JDBC
        List<Cuenta> datos = new ArrayList<Cuenta>();
        Cuenta cuenta = null;
        String query = "SELECT * FROM CUENTAS";


        try {
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // captura los datos de la fila actual en el objeto auxiliar
                cuenta = new Cuenta(rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"), rs.getInt("NUM_CUENTA"),
                        rs.getInt("TIPO_CUENTA_ID"), rs.getInt("SALDO"));

                // añade el objeto lleno a la lista
                datos.add(cuenta);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public cuentaTarjetaDTO buscarCuenta(long numTarjeta) {

        cuentaTarjetaDTO dto = null;
        String query = "SELECT CU.CUENTA_ID, CU.NUM_CUENTA, TC.DESCRIPCION, CU.SALDO, TC. SALDO_MIN, TC. SALDO_MAX, T.NUM_TARJETA, T.NIP " +
                "FROM TIPO_CUENTA TC INNER JOIN CUENTAS CU " +
                "ON TC.TIPO_ID = CU.TIPO_CUENTA_ID " +
                "INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID WHERE T.NUM_TARJETA =" + numTarjeta;


        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // captura los datos de la fila actual en el objeto auxiliar
                dto = new cuentaTarjetaDTO(rs.getInt("Cuenta_ID"),rs.getInt("NUm_CUENTA"), rs.getString("DESCRIPCION"), rs.getInt("SALDO"), rs.getInt("SALDO_MIN"),
                        rs.getInt("SALDO_MAX"), rs.getLong("NUM_TARJETA"), rs.getString("NIP"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    public void actualizarSaldo(int numCuenta, int nuevoSaldo) {
        String query = "UPDATE CUENTAS SET SALDO =" + nuevoSaldo + " WHERE NUM_CUENTA =" + numCuenta;
        try {
            Class.forName(conexion.DRIVE);
            con = DriverManager.getConnection(conexion.URL, conexion.USER, conexion.PASSWORD);
            ps = con.prepareStatement(query);
            int x = ps.executeUpdate();// deveuelve el numero de filas afectadas por la sentencia
            if (x > 0) {
                System.out.println("Actualizacion ok");
            } else {
                System.out.println("error al actualizar");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


        }


