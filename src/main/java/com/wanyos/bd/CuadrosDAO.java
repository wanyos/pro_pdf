
package com.wanyos.bd;

import com.wanyos.modelo.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wanyos
 */
public class CuadrosDAO {
    
    
    Conexion cx;

    public CuadrosDAO() {}

    
    public String crearNuevaBD(String nombre_nueva_bd) {
        cx = new Conexion();
        return cx.createBd(nombre_nueva_bd);
    }
    
    
    public String crearTablaCuadro(String nombre_bd, List<String> nombres_tablas) {
        String msg = "";
        cx = new Conexion();
        if (!nombres_tablas.isEmpty()) {
            for (String aux : nombres_tablas) {
               msg = msg.concat(cx.createTable(nombre_bd, aux, getEstructuraTabla()));
            }
        }
        return msg;
    }
    
    
    private String getEstructuraTabla(){
        return "turno int(3), cc varchar(3), init time(4), lugar_init varchar(45), fin time(4), lugar_fin varchar(45), total_turno time(4), minutos int(3)";
    }


    public String setDatosTabla(String nombre_bd, String nombre_tabla, List<Turno> turnos) {
        String msg = "";
        Connection cx_bd = null;
        cx = new Conexion();
        PreparedStatement ps = null;
        int rs = 0;
        String sql;
        try {
            cx_bd = cx.getConexionBd(nombre_bd);
            sql = "insert into "+nombre_tabla+" (turno, cc, init, lugar_init, fin, lugar_fin, total_turno, minutos) values (?,?,?,?,?,?,?,?)";
            ps = cx_bd.prepareStatement(sql);
     
            for (Turno aux : turnos) {

                ps.setInt(1, aux.getTurno());
                ps.setString(2, aux.getCc());
                ps.setTime(3, Time.valueOf(aux.getInit()));
                ps.setString(4, aux.getLugar_init());
                ps.setTime(5, Time.valueOf(aux.getFin()));
                ps.setString(6, aux.getLugar_fin());
                ps.setTime(7, Time.valueOf(aux.getTotal_turno()));
                ps.setInt(8, aux.getMinutos());

                rs += ps.executeUpdate();
            }
                msg = msg.concat(" tabla: "+nombre_tabla+" datos: "+rs+"\n");
        } catch (SQLException ex) {
            Logger.getLogger(CuadrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                cx_bd.close();;
            } catch (SQLException ex) {
                Logger.getLogger(CuadrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }
    
    
   
    
    
}
