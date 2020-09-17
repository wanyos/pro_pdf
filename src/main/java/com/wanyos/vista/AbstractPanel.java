
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
public abstract class AbstractPanel extends JPanel {
    
    private File pdf, archivo_pdf, destino;
    private String nombre_destino, nombre_nueva_bd;
    private boolean sin_cabecera, todos_archivos, nuevo, bd;


    
    // -------------------------------------------------------------------------------------------------------------------------
    //  Métodos de acceso a los componentes del PnDatosPdf que usaran el resto de paneles
    
    protected void setFilePdf(File f) {
        pdf = f;
    }

    protected void setFileArchivoPdf(File f) {
        archivo_pdf = f;
    }

    protected void setFileDestino(File f) {
        destino = f;
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
    
    protected void setNombreNuevaBD(String nombre_bd){
        this.nombre_nueva_bd = nombre_bd;
    }
    
    
    public abstract String getSelectBase();
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos que usa el PnGenerados
    
    protected void setNuevoActualizar(boolean nuevo){
       this.nuevo = nuevo;    
    }
    
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos getters and setters

    public File getFilePdf() {
        if(pdf == null){
           pdf = new File(""); 
        }
        return pdf;
    }

    public File getFileArchivoPdf() {
        if(archivo_pdf == null){
            archivo_pdf = new File("");
        }
        return archivo_pdf;
    }

    public File getFileDestino() {
        if(destino == null){
            destino = new File("");
        }
        return destino;
    }

    public String getNombreDestino() {
        if(nombre_destino == null){
            nombre_destino = "";
        }
        return this.nombre_destino;
    }
    
    public String getNombreNuevaBD(){
        if(nombre_nueva_bd == null){
            nombre_nueva_bd = "";
        }
        return this.nombre_nueva_bd;
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
