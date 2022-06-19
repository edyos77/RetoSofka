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
public class ConsultasNaveTripulada extends Conexion{
    private NaveTripulada miNave; 

    public boolean registrarNave(NaveTripulada unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String resgistroSql = "INSERT INTO nave_tripulada(nombre,pais,peso,velocidad,potencia,"
                + "combustible,cap_personas) VALUES (?,?,?,?,?,?,?)";

        try {
            pstm = con.prepareStatement(resgistroSql);
            
            pstm.setString(1, unaNave.getNombre());
            pstm.setString(2, unaNave.getPais());
            pstm.setDouble(3, unaNave.getPeso());
            pstm.setDouble(4, unaNave.getVelocidad());
            pstm.setDouble(5, unaNave.getPotencia());
            pstm.setString(6, unaNave.getCombustible());
            pstm.setInt(7, unaNave.getCapacidadPersonas());           
            
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

    public boolean buscarNave(NaveTripulada unaNave) {   
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();
        
        String consultaSql = "SELECT * FROM nave_tripulada  WHERE nombre=?";
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
                unaNave.setCapacidadPersonas(Integer.parseInt(rs.getString("cap_personas")));                
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

    public boolean modificarNave(NaveTripulada unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String actualizaSql = "UPDATE nave_tripulada SET pais =?,peso=?,velocidad=?,"
                + "potencia =?,combustible=?,cap_personas=? WHERE nombre = ?";

        try {
            pstm = con.prepareStatement(actualizaSql);
            pstm.setString(7, unaNave.getNombre());
            pstm.setString(1, unaNave.getPais());
            pstm.setDouble(2, unaNave.getPeso());
            pstm.setDouble(3, unaNave.getVelocidad());
            pstm.setDouble(4, unaNave.getPotencia());
            pstm.setString(5, unaNave.getCombustible());
            pstm.setInt(6, unaNave.getCapacidadPersonas());
            
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

    public boolean eliminarNave(NaveTripulada unaNave) {
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String borrarSql = "DELETE FROM nave_tripulada  WHERE nombre = ?";
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
        ArrayList<NaveTripulada> naves = new ArrayList<>();
        PreparedStatement pstm = null;
        Connection con = (Connection) getConexion();

        String consultasql = "SELECT * FROM nave_tripulada";

        try {
            pstm = con.prepareStatement(consultasql);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                miNave = new NaveTripulada();
                miNave.setNombre(res.getString("nombre"));
                miNave.setPais(res.getString("pais"));
                miNave.setPeso(res.getDouble("peso"));
                miNave.setVelocidad(res.getDouble("velocidad"));
                miNave.setPotencia(res.getDouble("potencia"));
                miNave.setCombustible(res.getString("combustible"));
                miNave.setCapacidadPersonas(res.getInt("cap_personas"));               

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
