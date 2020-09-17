
package com.wanyos.bd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wanyos
 */
public class CuadrosDAO {
    
    
    private String nombre_nueva_bd;
    Conexion cx;

    public CuadrosDAO(String nombre_nueva_bd) {
        this.nombre_nueva_bd = nombre_nueva_bd;
    }

    public String crearNuevaBD() {
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


}
