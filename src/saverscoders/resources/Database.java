package saverscoders.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	
	private static final String base = "saverscoders.store";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/" + base;
    private static Connection con = null;

    public static Connection conexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch(SQLException e) {
            System.err.println(e);
        }
        return con;
    }
    
}