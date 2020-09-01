
package com.wanyos.bd;

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wanyos
 */
public class Conexion {
    
    private Connection cx;
    
    
    public Connection getConexionBd(String nombre_bd){
        try {
            cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombre_bd, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.cx;
    }
    
    
    public Connection getConexionMysql() {
        String drive = "jdbc:mysql://localhost:3306/";
        Connection cnx = null;
        try {
            cnx = (Connection) DriverManager.getConnection(drive, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
    
    
    public String createBd(String nombre_bd) {
        String base_creada;
        Connection cnx = null;
        PreparedStatement ps = null;
        try {

            cnx = this.getConexionMysql();
            ps = cnx.prepareStatement("CREATE DATABASE " + nombre_bd);
            ps.executeUpdate();
            base_creada = " Base datos: " + nombre_bd + " se ha creado...";

        } catch (SQLException ex) {
            base_creada = "Error base datos: " + nombre_bd + " no se ha creado... ";
        } finally {
            try {
                cnx.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return base_creada;
    }
    
    
    public String deleteeBd(String nombre_bd) {
        String base_creada;
        Connection cnx = null;
        PreparedStatement ps = null;
        try {

            cnx = this.getConexionMysql();
            ps = cnx.prepareStatement("DROP DATABASE " + nombre_bd);
            ps.executeUpdate();
            base_creada = " Base datos: " + nombre_bd + " se ha eliminado...";

        } catch (SQLException ex) {
            base_creada = "Error base datos: " + nombre_bd + " no se ha eliminado... ";
        } finally {
            try {
                cnx.close();
                ps.close();
            } catch (SQLException ex) {
                base_creada = "Error base datos: " + nombre_bd + " no se ha eliminado... ";
            }
        }
        return base_creada;
    }
    
    
    public String createTable(String nombre_bd, String nombre_table, String campos) {
        String tabla_creada;
        Connection cnx = null;
        PreparedStatement ps = null;
        try {
            
            cnx = this.getConexionBd(nombre_bd);
            ps = cnx.prepareStatement("CREATE TABLE " + nombre_table + "(" + campos + ")");
            ps.execute();
            tabla_creada = "La tabla "+nombre_table+ " se ha creado en "+nombre_bd+"...";
            
        } catch (SQLException ex) {
            tabla_creada = "Error la tabla "+nombre_table+ " no se ha creado en "+nombre_bd+"..."+ex.getMessage();
        } finally {
            try {
                cnx.close();
                ps.close();
            } catch (SQLException ex) {
                tabla_creada = "Error la tabla "+nombre_table+ " no se ha creado en "+nombre_bd+"..."+ex.getMessage();
            }
        }
        return tabla_creada;
    }
    
    
    public String deleteTable(String nombre_bd, String nombre_table) {
        String tabla_eliminada;
        Connection cnx = null;
        PreparedStatement ps = null;
        try {

            cnx = this.getConexionBd(nombre_bd);
            ps = cnx.prepareStatement("DROP TABLE " + nombre_table);
            ps.execute();
            tabla_eliminada = "La tabla " + nombre_table + " se ha eliminado de " + nombre_bd + "...";

        } catch (SQLException ex) {
            tabla_eliminada = "La tabla " + nombre_table + " no se ha eliminado de " + nombre_bd + "..." + ex.getMessage();
        } finally {
            try {
                cnx.close();
                ps.close();
            } catch (SQLException ex) {
                tabla_eliminada = "Error la tabla " + nombre_table + " no se ha eliminado de " + nombre_bd + "..." + ex.getMessage();
            }
        }
        return tabla_eliminada;
    }
    
    /**
     * Se encesita algún dato que diferencie el nombre de la tabla
     * Si solo se pone "%" devuelve más de 200 tablas
     * @param cx_bd
     * @return 
     */
    public List<String> getNombresTablas(Connection cx_bd) {
        List<String> nombres = new ArrayList<>();
        try {
            DatabaseMetaData md = cx_bd.getMetaData();
            ResultSet rs = md.getTables(null, null, "emt_%", null);
            while(rs.next()){
              nombres.add(rs.getString(3));
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return nombres;
    }
    
    public void getNombres(){
        try {
            Connection c = this.getConexionBd("cuadros_marzo2019");
            PreparedStatement ps = null;
            Resultset rs = null;
            
            ps = c.prepareStatement("SHOW TABLES LIKE 'emt_%'");
            rs = (Resultset) ps.executeQuery();
            while(rs != null){
                System.out.println(rs.toString());
                System.out.println();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void initServer(){
        try {
            Runtime.getRuntime().exec("C:\\xampp\\mysql_start.bat", new String[]{ "argumento" });
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void stopServer() {
        try {
            Process p = new ProcessBuilder("C:\\xampp\\mysql_stop.bat", "argumento").start();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String [] args){
        Conexion c = new Conexion();
        c.getNombres();
        //List<String> t = c.getNombresTablas(c.getConexionBd("cuadros_marzo2019"));
//        String nombre_bd = "Nueva_base_datos";
//        String nombre_tabla = "Nombres";
//        String campos = "nombre varchar(45), apellidos varchar(45)";
       // System.out.println(c.createBd(nombre_bd));
       // System.out.println(c.createTable(nombre_bd, nombre_tabla, campos));
        //System.out.println(c.deleteeBd(nombre_bd));
        //System.out.println(c.deleteTable(nombre_bd, nombre_tabla));
        System.out.println();
    }
    
    
    
    
}
