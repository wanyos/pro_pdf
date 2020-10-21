
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
    private String nombre_destino;


    
    // -------------------------------------------------------------------------------------------------------------------------
    //  Métodos implementados en las clases: 
    
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
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos que implementa PnCuadrosPdf
    public abstract boolean getSelectBaseDatos();

    public abstract boolean getSinCabecera();

    public abstract boolean isTodosArchivos();

    public abstract String getNombreNuevaBD();

    public abstract String getSelectBase();
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos que usa el PnGenerados
    
    public abstract boolean getNuevoActualizar();
    
    
    
    // -------------------------------------------------------------------------------------------------------------------------
    // Métodos getters 

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

       
    
}
