package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.Conexion;

/**
 *
 * @author Eduar Yosme Pardo
 */
public class ConsultasNaveLanzadera extends Conexion{
    private NaveLanzadera miNave; 

    public boolean registrarNave(NaveLanzadera unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String resgistroSql = "INSERT INTO nave_lanzadera(nombre,pais,peso,velocidad,potencia,"
                + "combustible,cap_carga,altura) VALUES (?,?,?,?,?,?,?,?)";

        try {
            pstm = con.prepareStatement(resgistroSql);
            
            pstm.setString(1, unaNave.getNombre());
            pstm.setString(2, unaNave.getPais());
            pstm.setDouble(3, unaNave.getPeso());
            pstm.setDouble(4, unaNave.getVelocidad());
            pstm.setDouble(5, unaNave.getPotencia());
            pstm.setString(6, unaNave.getCombustible());
            pstm.setInt(7, unaNave.getCapacidadCarga());
            pstm.setInt(8, unaNave.getAltura());
            
            pstm.execute();            
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }

    }

    public boolean buscarNave(NaveLanzadera unaNave) {   
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();
        
        String consultaSql = "SELECT * FROM nave_lanzadera  WHERE nombre=?";
        try {
            pstm = con.prepareStatement(consultaSql);
            pstm.setString(1, unaNave.getNombre());
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                unaNave.setNombre(rs.getString("nombre"));
                unaNave.setPais(rs.getString("pais"));
                unaNave.setPeso(Double.parseDouble(rs.getString("peso")));
                unaNave.setVelocidad(Double.parseDouble(rs.getString("velocidad")));
                unaNave.setPotencia(Double.parseDouble(rs.getString("potencia")));
                unaNave.setCombustible(rs.getString("combustible"));                    
                unaNave.setCapacidadCarga(Integer.parseInt(rs.getString("cap_carga")));
                unaNave.setAltura(Integer.parseInt(rs.getString("altura")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }              
    }

    public boolean modificarNave(NaveLanzadera unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String actualizaSql = "UPDATE nave_lanzadera SET pais =?,peso=?,velocidad=?,"
                + "potencia =?,combustible=?,cap_carga=?,altura=? WHERE nombre = ?";

        try {
            pstm = con.prepareStatement(actualizaSql);
            pstm.setString(8, unaNave.getNombre());
            pstm.setString(1, unaNave.getPais());
            pstm.setDouble(2, unaNave.getPeso());
            pstm.setDouble(3, unaNave.getVelocidad());
            pstm.setDouble(4, unaNave.getPotencia());
            pstm.setString(5, unaNave.getCombustible());
            pstm.setInt(6, unaNave.getCapacidadCarga());
            pstm.setInt(7, unaNave.getAltura());
            pstm.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }

    }

    public boolean eliminarNave(NaveLanzadera unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String borrarSql = "DELETE FROM nave_lanzadera  WHERE nombre = ?";
        try {
            pstm = con.prepareStatement(borrarSql);
            
            pstm.setString(1, unaNave.getNombre());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }

    }
    
    public ArrayList listarNaves() {
        ArrayList<NaveLanzadera> naves = new ArrayList<>();
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String consultasql = "SELECT * FROM nave_lanzadera";

        try {
            pstm = con.prepareStatement(consultasql);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                miNave = new NaveLanzadera();
                miNave.setNombre(res.getString("nombre"));
                miNave.setPais(res.getString("pais"));
                miNave.setPeso(res.getDouble("peso"));
                miNave.setVelocidad(res.getDouble("velocidad"));
                miNave.setPotencia(res.getDouble("potencia"));
                miNave.setCombustible(res.getString("combustible"));
                miNave.setCapacidadCarga(res.getInt("cap_carga"));
                miNave.setAltura(res.getInt("altura"));

                naves.add(miNave);
            }
            res.close();

        } catch (SQLException e) {
            System.err.println(e);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return naves;
    }
}
