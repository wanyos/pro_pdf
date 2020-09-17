
package com.wanyos.init;

import com.wanyos.bd.CuadrosDAO;
import com.wanyos.manager.ManagerCuadros;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wanyos
 */
public class InitCuadros extends Init {
    
    private ManagerCuadros mc;
    private boolean sin_cabecera;
    private String ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, nombre_nueva_bd;
    
    
    
    
    public InitCuadros(String ruta_pdf, String ruta_destino, boolean sin_cabecera){
        this.mc = new ManagerCuadros();
        this.ruta_pdf = ruta_pdf;
        this.ruta_destino = ruta_destino;
        this.sin_cabecera = sin_cabecera;
    }
    
    
    public InitCuadros(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino, String nombre_destino, boolean sin_cabecera){
        this.mc = new ManagerCuadros();
        this.ruta_pdf = ruta_pdf;
        this.nombre_archivo_pdf = nombre_archivo_pdf;
        this.ruta_destino = ruta_destino;
        this.nombre_destino = nombre_destino;
        this.sin_cabecera = sin_cabecera;
    }
    
    
    public InitCuadros(String ruta_pdf, String nombre_archivo_pdf, String nombre_nueva_bd){
        this.mc = new ManagerCuadros();
        this.ruta_pdf = ruta_pdf;
        this.nombre_archivo_pdf = nombre_archivo_pdf;
        this.nombre_nueva_bd = nombre_nueva_bd;
    }
    
    
    public String setArchivosCuadros() {
        mc.writeArchivosCuadros(ruta_pdf, ruta_destino, sin_cabecera);
        return(mc.getTotalDatosActualizar());
    }
    
    
    public String setArchivoCuadro(){
        mc.writeFileCuadro(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, sin_cabecera);
        return(mc.getTotalDatosActualizar());
    }
    
    
    public String setNuevaBD(){
        String msg = "";
        Map<String, List<String>> listas_cuadros;
        CuadrosDAO cuadros_dao;
        List<String> nombres_tablas = new ArrayList<>();
        
        listas_cuadros = mc.getMapCuadro(ruta_pdf, nombre_archivo_pdf);
        if(!listas_cuadros.isEmpty()){
            cuadros_dao = new CuadrosDAO(nombre_nueva_bd);
            msg = cuadros_dao.crearNuevaBD();
            for(String key: listas_cuadros.keySet()){
                nombres_tablas.add(key);
            }
            String creada_tabla = cuadros_dao.crearTablaCuadro(nombre_nueva_bd, nombres_tablas);
            msg = msg.concat(creada_tabla);
        }
        return msg;
    }
    
    
    public String actualizarBD(){
        String msg = "";
        
        
        
        return msg;
    }
    
    
   
    
    
   
        
    
    
    
}
