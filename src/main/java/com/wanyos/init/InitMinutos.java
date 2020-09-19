
package com.wanyos.init;

import com.wanyos.manager.ManagerMinutos;
import com.wanyos.vista.AbstractPanel;

/**
 *
 * @author wanyos
 */
public class InitMinutos extends InitAbstract {
    
    ManagerMinutos mm;
    String ruta_pdf, nombre_archivo_pdf, ruta_destino;
    
    
    public InitMinutos(AbstractPanel pn_abs){
        super(pn_abs);
        comprobarDatosMinutos();
    }
    
    
    private void comprobarDatosMinutos(){
        if(super.comprobarDatos()){
            if(super.isActualizarBd()){
                setActualizarBD(super.getRutaFilePdf(), super.getNombreArchivoPdf());
            } else {
                comprobarArchivo();
            }
        }
    }
    
    
    private void comprobarArchivo(){
      if(super.existeFileArchivoPdf() && super.existeFileArchivoDestino()){
          setActualizarArchivo(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getRutaFileDestino(), super.getNombreArchivoDestino());
      }    
    }
    
    
    private void setActualizarArchivo(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino, String nombre_destino) {
        mm = new ManagerMinutos();
        mm.actualizarArchivo(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino);
        super.setMensaje(mm.getTotalDatosActualizar());
    }

    
    private void setActualizarBD(String ruta_pdf, String nombre_archivo_pdf){
        
    }
    
}
