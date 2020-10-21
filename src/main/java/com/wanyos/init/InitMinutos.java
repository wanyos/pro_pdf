
package com.wanyos.init;

import com.wanyos.manager.ManagerMinutos;
import java.io.File;

/**
 *
 * @author wanyos
 */
public class InitMinutos extends InitAbstract {
    
    private ManagerMinutos mm;
    private String ruta_pdf, ruta_archivo_pdf, ruta_destino, nombre_destino;
    
    
    
    public InitMinutos(File file_pdf, File archivo_pdf){
        this.ruta_pdf = file_pdf.getAbsolutePath();
        this.ruta_archivo_pdf = archivo_pdf.getAbsolutePath();
        setActualizarBD();
    }
    
    
    public InitMinutos(File file_pdf, File archivo_pdf, File file_destino, String nombre_destino){
        this.ruta_pdf = file_pdf.getAbsolutePath();
        this.ruta_archivo_pdf = archivo_pdf.getAbsolutePath();
        this.ruta_destino = file_destino.getAbsolutePath();
        this.nombre_destino = nombre_destino;
        setActualizarArchivo();
    }
    
    
    private void setActualizarArchivo() {
        mm = new ManagerMinutos();
        mm.actualizarArchivo(ruta_pdf, ruta_archivo_pdf, ruta_destino, nombre_destino);
        super.setMensaje(mm.getTotalDatosActualizar());
    }

    
    private void setActualizarBD(){
        
    }
    
}
