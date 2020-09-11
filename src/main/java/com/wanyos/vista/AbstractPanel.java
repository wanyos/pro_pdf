
package com.wanyos.vista;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author wanyos
 */
public class AbstractPanel extends JPanel {
    
    private File ruta_pdf, ruta_archivo_pdf, ruta_destino;
    private String nombre_destino, nombre_bd;
    private boolean sin_cabecera, todos_archivos, nuevo, bd;


    
    // -------------------------------------------------------------------------------------------------------------------------
    //  Métodos de acceso a los componentes del PnDatosPdf que usaran el resto de paneles
    
    protected void setFileRutaPdf(File f) {
        ruta_pdf = f;
    }

    protected void setFileRutaArchivoPdf(File f) {
        ruta_archivo_pdf = f;
    }

    protected void setFileRutaDestino(File f) {
        ruta_destino = f;
    }

    protected void setNombreDestino(String n) {
        nombre_destino = n;
    }
    
    protected void setBaseDatos(boolean b){
        bd = b;
    }
    
    /**
     * Crea una lista con todos los paneles que contiene este panel
     * @return 
     */
    protected List<JPanel> getPns(){
        List<JPanel> pns = new ArrayList<>();
        Component [] c = this.getComponents();
        for(int a = 0; a< c.length; a++){
            if(c[a] instanceof JPanel){
                pns.add((JPanel) c[a]);
            }
        }
        return pns;
    }
    
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos que usa el PnCuadrosPdf
    
    protected void setSinCabecera(boolean b){
        sin_cabecera = b;
    }
    
    protected void setTodosArchivos(boolean todos_archivos) {
        this.todos_archivos = todos_archivos;
    }
    
    protected void setNuevaBD(String nombre_bd){
        this.nombre_bd = nombre_bd;
    }
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos que usa el PnGenerados
    
    protected void setNuevoActualizar(boolean nuevo){
       this.nuevo = nuevo;    
    }
    
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos getters and setters

    public File getRutaPdf() {
        if(ruta_pdf == null){
           ruta_pdf = new File(""); 
        }
        return ruta_pdf;
    }

    public File getRutaArchivoPdf() {
        if(ruta_archivo_pdf == null){
            ruta_archivo_pdf = new File("");
        }
        return ruta_archivo_pdf;
    }

    public File getRutaDestino() {
        if(ruta_destino == null){
            ruta_destino = new File("");
        }
        return ruta_destino;
    }

    public String getNombreDestino() {
        if(nombre_destino == null){
            nombre_destino = "";
        }
        return this.nombre_destino;
    }
    
    public String getNombreBD(){
        if(nombre_bd == null){
            nombre_bd = "";
        }
        return this.nombre_bd;
    }
    
    public boolean getSinCabecera(){
        return this.sin_cabecera;
    }

    public boolean isTodosArchivos() {
        return todos_archivos;
    }
    
    public boolean getArchivoNuevo(){
        return nuevo;
    }

    public boolean getBaseDatos(){
        return bd;
    }
    
    
    
    
    

       
    
}
