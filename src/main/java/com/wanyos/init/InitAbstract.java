
package com.wanyos.init;

import com.wanyos.vista.AbstractPanel;
import java.io.File;
import javax.swing.JOptionPane;


/**
 *
 * @author wanyos
 */
public abstract class InitAbstract {
    
    
    private AbstractPanel pn_abs;
    private boolean actualizar_bd;
    private String mensaje;

    
    public InitAbstract(AbstractPanel pn_abs){
        this.pn_abs = pn_abs;
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    
    protected void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    /**
     * Comprobar los datos esenciales para todos
     * Comprueba tanto para base de datos como para archivo
     * @return 
     */
    protected boolean comprobarDatos() {
        if (pn_abs.getSelectBaseDatos() && comprobarDatosBD()) {
            actualizar_bd = true;
            return true;
        } else {
            return comprobarDatosArchivo();
        }
    }
    
    
    /**
     * Comun para los tres paneles
     */
    private boolean comprobarDatosBD() {
        if (!!pn_abs.getFilePdf().exists() || !pn_abs.getFileArchivoPdf().exists()) {
            JOptionPane.showMessageDialog(pn_abs, "Error en la ruta de pdf o archivo pdf... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    /**
     * Común a los tres paneles
     * @return 
     */
    private boolean comprobarDatosArchivo(){
        if(!pn_abs.getFilePdf().exists() || !pn_abs.getFileDestino().exists()){
            JOptionPane.showMessageDialog(pn_abs, "Error en la ruta de pdf o ruta destino... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    /**
     * Comprueba que el nombre para crear una nueva base de datos
     * @return 
     */
    protected boolean existeNombreNuevaBD(){
        if(pn_abs.getNombreNuevaBD().length() <= 0){
            JOptionPane.showMessageDialog(pn_abs, "Error el nombre nueva base de datos no es correcto... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    

    protected boolean existeFileArchivoDestino() {
        File f = new File(pn_abs.getFileDestino().getAbsolutePath() + "\\" + pn_abs.getNombreDestino());
        if (pn_abs.getNombreDestino().length() <= 0 || !f.exists()) {
            JOptionPane.showMessageDialog(pn_abs, "Error el archivo destino actualizar no existe... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    protected boolean existeFileArchivoPdf(){
        if(!pn_abs.getFileArchivoPdf().exists()){
            JOptionPane.showMessageDialog(pn_abs, "Error el archivo pdf no existe... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    protected boolean isActualizarBd() {
        return actualizar_bd;
    }
    
    //si true=nuevo, false=actualizar
    protected boolean getNuevoActualizar(){
        return pn_abs.getNuevoActualizar();
    }
    
    
    protected String getRutaFilePdf(){
        return pn_abs.getFilePdf().getAbsolutePath();
    }
    
    protected String getNombreArchivoPdf(){
        return pn_abs.getFileArchivoPdf().getName();
    }
    
    protected String getRutaFileDestino(){
        return pn_abs.getFileDestino().getAbsolutePath();
    }
    
    protected String getNombreArchivoDestino(){
        return pn_abs.getNombreDestino();
    }
    
    protected String getNombreNuevaBD(){
        return pn_abs.getNombreNuevaBD();
    }
    
    protected String getSelectBase(){
        return pn_abs.getSelectBase();
    }
    
    protected boolean getSinCabecera(){
        return pn_abs.getSinCabecera();
    }
    
    protected boolean getTodosArchivos(){
        return pn_abs.isTodosArchivos();
    }
    
    
    /**
     * Si el nombre destino no es valido se crea uno basado en el nombre del pdf leido
     * @param nombre_destino
     * @param nombre_pdf
     * @return 
     */
    protected String comprobarNombreDestino(String nombre_destino, String nombre_pdf){
        String nombre = "";
        if(nombre_destino == null || nombre_destino.trim().length() == 0 || !nombre_destino.contains(".txt")){
            String sub = nombre_pdf.substring(0, nombre_pdf.length()-4);
            nombre = nombre.concat("nuevo_").concat(sub).concat(".txt");
            return nombre;
        }
        return nombre_destino;
    }
    
    
    

}
