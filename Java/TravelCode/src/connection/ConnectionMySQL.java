package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/travelcode";
    private static final String USER = "root";
    private static final String PASSWORD = "310512";

    public static Connection createConnectionMySQL() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main (String [] args) throws Exception { 
        Connection conn = createConnectionMySQL();

        if (conn != null) {
            System.out.println(conn + "\n\n *** Conexão obtida com sucesso! ****");
            conn.close();
        }
    }
}
