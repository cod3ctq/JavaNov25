package DataBase;

import java.sql.PreparedStatement;

public class Conexion {

    public static String DRIVER = "oracle.jdbc.OracleDriver";
    public static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String USER = "db1";
    public static String PASSWORD = "admin";


    public PreparedStatement prepareStatement(String query) {
        return null;
    }
}
