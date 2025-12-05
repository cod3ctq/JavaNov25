package DAO;

import DTO.DetalleMovimientoDTO;
import DTO.ReporteMovimientosClienteDTO;
import DataBase.Conexion;
import Models.Movimiento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {
    Connection con = null; //Abrir la conexion
    PreparedStatement ps = null; //Interprete para mandar las instrucciones a la base
    ResultSet rs = null;
    public void registrarMovimiento(Movimiento mov){
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, FECHA, TIPO_OPERACION,MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName(Conexion.DRIVER);//cargar el driver, conector
            con= (Connection) DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD );
            ps= con.prepareStatement(query);
            //Acomoda los valores en los marcadores de posicion
            ps.setInt(1,mov.getCuentaId());
            ps.setDate(2, Date.valueOf(mov.getFecha()));
            ps.setString(3,mov.getTipoOperacion());
            ps.setInt(4,mov.getMonto());

            int x= ps.executeUpdate();
            if(x>0){
                System.out.println("Insercion OK");
            }else{
                System.out.println("Error al registrar movimiento");
            }
        } catch(Exception ex){
            ex.printStackTrace();

        }
    }


    public ReporteMovimientosClienteDTO generarReportePorCliente(String cliente){
            ReporteMovimientosClienteDTO reporte = null;
            String nombre="";
            int numCuenta=0;
            List<DetalleMovimientoDTO> detalles= new ArrayList<DetalleMovimientoDTO>();
            DetalleMovimientoDTO dto=null;
            int retiros=0;
            int depositos=0;
            int transf=0;
            String query="SELECT * FROM MOVIMIENTOS_POR_CLIENTE WHERE NOMBRE='"+cliente+"'";

            try{
                Class.forName(Conexion.DRIVER); //cargar el driver, conector
                con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
                ps = con.prepareStatement(query);
                rs=ps.executeQuery();

                while(rs.next()){
                    dto=new DetalleMovimientoDTO(rs.getString("TIPO_OPERACION"),
                            rs.getDate("FECHA").toLocalDate(),
                            rs.getInt("MONTO"));
                detalles.add(dto);

                switch (rs.getString("TIPO_OPERACION")){
                    case "RETIRO":
                        retiros=retiros+rs.getInt("MONTO");
                        break;

                    case "DEPOSITO":
                        depositos=depositos+rs.getInt("MONTO");
                        break;

                    case "TRANSFERENCIA":
                        transf=transf+rs.getInt("MONTO");
                        break;
                }
                    nombre=rs.getString("NOMBRE");
                    numCuenta=rs.getInt("NUM_CUENTA");
                }

                reporte = new ReporteMovimientosClienteDTO(nombre,numCuenta,detalles,retiros,depositos,transf);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return reporte;
    }
}
