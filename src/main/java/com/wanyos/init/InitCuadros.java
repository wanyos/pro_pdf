
package com.wanyos.init;

import com.wanyos.bd.CuadrosDAO;
import com.wanyos.manager.ManagerCuadros;
import com.wanyos.vista.AbstractPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wanyos
 */
public class InitCuadros extends InitAbstract {
    
    private ManagerCuadros mc;
    
  
    public InitCuadros(AbstractPanel pn_abs){
        super(pn_abs);
        //comprueba datos comunes en todos los supuestos
        comprobarDatosCuadros();
    }
    
    
    /**
     * Comprueba los datos de los casos concretos que pueden existir
     */
    private void comprobarDatosCuadros(){
        if(super.comprobarDatos()){      //comprueba los datos esenciales tanto para base de datos como para archivos
            if(super.isActualizarBd()){
                comprobarDatosBD();
            } else {
                comprobarDatosArchivo();
            }
        }
    }
    
    
    private void comprobarDatosBD() {
        if (super.getNuevoActualizar() && existeNombreNuevaBD()) {
            //obtener los datos necesarios para crear una nueva base de datos
            this.setNuevaBD(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getNombreNuevaBD());
        } else {
            //obtener los datos para actualizar la base de datos indicada
            this.setActualizarBD(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getSelectBase());
        }
    }
    
    
    private void comprobarDatosArchivo() {
        if (super.getTodosArchivos()) {
            setArchivosCuadros(super.getRutaFilePdf(), super.getRutaFileDestino(), super.getSinCabecera());
        } else {
            if (super.existeFileArchivoPdf()) {
                setArchivoCuadro(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getRutaFileDestino(),
                                 super.getNombreArchivoDestino(), super.getSinCabecera());
            }
        }
    }

    
    /**
     * Crea archivos de todos los pdf que existan en el directorio ruta_destino
     * @param ruta_pdf
     * @param ruta_destino
     * @param sin_cabecera 
     */
    private void setArchivosCuadros(String ruta_pdf, String ruta_destino, boolean sin_cabecera) {
        mc = new ManagerCuadros();
        mc.writeArchivosCuadros(ruta_pdf, ruta_destino, sin_cabecera);
        super.setMensaje(mc.getTotalDatosActualizar());
    }
    
    
    /**
     * Crea un unico archivo con el pdf 
     * @param ruta_pdf
     * @param nombre_archivo_pdf
     * @param ruta_destino
     * @param nombre_destino
     * @param sin_cabecera 
     */
    private void setArchivoCuadro(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino, String nombre_destino, boolean sin_cabecera){
        mc = new ManagerCuadros();
        mc.writeFileCuadro(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, sin_cabecera);
        super.setMensaje(mc.getTotalDatosActualizar());
    }
    
    
    /**
     * Crea ujna nueva base de datos con la estructura de cuadros
     * @param ruta_pdf
     * @param nombre_archivo_pdf
     * @param nombre_nueva_bd 
     */
    private void setNuevaBD(String ruta_pdf, String nombre_archivo_pdf, String nombre_nueva_bd){
        mc = new ManagerCuadros();
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
        super.setMensaje(msg);
    }
    
    
    /**
     * Rellena la nueva base de datos creada con los datos del HasMap
     */
    private void setDatosNuevaBD(Map<String, List<String>> datos){
        
    }
    
    
    /**
     * Actualiza la base de datos seleccionada
     * @param ruta_pdf
     * @param archivo_pdf
     * @param nombre_bd 
     */
    private void setActualizarBD(String ruta_pdf, String archivo_pdf, String nombre_bd){
        mc = new ManagerCuadros();
        String msg = "";
        
        
        
        super.setMensaje(msg);
    }
    
    
   
    
    
   
        
    
    
    
}
