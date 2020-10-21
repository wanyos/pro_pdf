
package com.wanyos.init;

import com.wanyos.vista.AbstractPanel;


/**
 *
 * @author wanyos
 */
public abstract class InitAbstract {
    
    
//    private AbstractPanel pn_abs;
//    private boolean actualizar_bd;
    private String mensaje;

    
    
    public String getMensaje() {
        return mensaje;
    }
    
    protected void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
//    
//    protected boolean isActualizarBd() {
//        return actualizar_bd;
//    }
//    
//    //si true=nuevo, false=actualizar
//    protected boolean getNuevoActualizar(){
//        return pn_abs.getNuevoActualizar();
//    }
//    
//    
//    protected String getRutaFilePdf(){
//        return pn_abs.getFilePdf().getAbsolutePath();
//    }
//    
//    protected String getNombreArchivoPdf(){
//        return pn_abs.getFileArchivoPdf().getName();
//    }
//    
//    protected String getRutaFileDestino(){
//        return pn_abs.getFileDestino().getAbsolutePath();
//    }
    
//    protected String getNombreArchivoDestino(){
//        return pn_abs.getNombreDestino();
//    }
//    
//    protected String getNombreNuevaBD(){
//        return pn_abs.getNombreNuevaBD();
//    }
//    
//    protected String getSelectBase(){
//        return pn_abs.getSelectBase();
//    }
//    
//    protected boolean getSinCabecera(){
//        return pn_abs.getSinCabecera();
//    }
//    
//    protected boolean getTodosArchivos(){
//        return pn_abs.isTodosArchivos();
//    }
//    
    
    /**
     * Si el nombre destino no es valido se crea uno basado en el nombre del pdf leido
     * @param nombre_destino
     * @param nombre_pdf
     * @return 
     */
//    protected String comprobarNombreDestino(String nombre_destino, String nombre_pdf){
//        String nombre = "";
//        if(nombre_destino == null || nombre_destino.trim().length() == 0 || !nombre_destino.contains(".txt")){
//            String sub = nombre_pdf.substring(0, nombre_pdf.length()-4);
//            nombre = nombre.concat("nuevo_").concat(sub).concat(".txt");
//            return nombre;
//        }
//        return nombre_destino;
//    }
    
    
    

}
