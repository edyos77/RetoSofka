
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Eduar Yosme Pardo
 */
public class Conexion {   
     
    public final String BD = "navesespacialesbd";   
    public final String USER = "root";   
    public final String PASSWORD = "";   
    public final String URL = "jdbc:mysql://localhost:3306/" + BD;   
    public Connection con = null;   
    
    public Connection getConexion() {      
        try {        
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
        }
        catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
