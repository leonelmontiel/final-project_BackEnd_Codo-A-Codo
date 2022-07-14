package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.Camisetas;

public class CamisetasDAO {
    private static final String SQL_CREATE="INSERT INTO camiseta(equipo, numero, jugador, talle, precio, stock) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM camiseta";
    private static final String SQL_READ_BY_ID= "SELECT * FROM camiseta WHERE idcamiseta= ?";
    private static final String SQL_UPDATE_PRECIO="UPDATE camiseta SET precio = ? WHERE idcamiseta = ?";
    private static final String SQL_UPDATE_STOCK="UPDATE camiseta SET stock = ? WHERE idcamiseta = ?";
    private static final String SQL_DELETE="DELETE FROM camiseta WHERE idcamiseta = ?";
    
    
    public List<Camisetas> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Camisetas camiseta ;
        List<Camisetas> camisetas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int idcamiseta = rs.getInt(1);
                String equipo = rs.getString(2);
                int numero = rs.getInt(3);
                String jugador = rs.getString(4);                
                String talle = rs.getString(5);
                double precio = rs.getDouble(6);
                int stock = rs.getInt(7);

                camiseta = new Camisetas(idcamiseta, equipo, numero, jugador, talle, precio, stock);

                camisetas.add(camiseta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return camisetas;
    }
    
    public Camisetas findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Camisetas camiseta = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            rs = stmt.executeQuery();
            
            while (rs.absolute(1)) {
                
                int idcamiseta = rs.getInt(1);
                String equipo = rs.getString(2);
                int numero = rs.getInt(3);
                String jugador = rs.getString(4);                
                String talle = rs.getString(5);
                double precio = rs.getDouble(6);
                int stock = rs.getInt(7);

                camiseta = new Camisetas(idcamiseta, equipo, numero, jugador, talle, precio, stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return camiseta;
    }
    
    
    
    public int insert(Camisetas camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, camiseta.getEquipo());
            stmt.setInt(2, camiseta.getNumero());
            stmt.setString(3, camiseta.getJugador());
            stmt.setString(4, camiseta.getTalle());
            stmt.setDouble(5, camiseta.getPrecio());
            stmt.setInt(6, camiseta.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updatePrecio(Camisetas camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, camiseta.getPrecio());
            stmt.setInt(2, camiseta.getIdcamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateStock(Camisetas camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_STOCK);
            stmt.setInt(1, camiseta.getStock());
            stmt.setInt(2, camiseta.getIdcamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int deleteLibro(Camisetas camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, camiseta.getIdcamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
