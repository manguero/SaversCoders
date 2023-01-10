package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private static Connection con;
    
    private static EntityManager em;
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/saverscoders";
    private static final String USER = "root";
    private static final String PASS = "";
    
    static{
        try{
            Class.forName(DRIVER);         
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER:" +e);
       }
    }
    public static Connection conexion(){   
        if(con==null){
            try{
                //Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
               // JOptionPane.showMessageDialog(null, "Conectado");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION"+e);
                //e.printStackTrace();
            }
        }
        return con;
    }

    void getConnection() {
    }
    
    public static EntityManager getEntityManager(){
        if(em==null){
            EntityManagerFactory sf=Persistence.createEntityManagerFactory("saverscoders");
            em=sf.createEntityManager();
        }
        return em;
    }
    
}
