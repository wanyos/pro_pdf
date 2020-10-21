
package com.wanyos.init;

import com.wanyos.manager.ManagerDiasGenerados;
import java.io.File;
import java.util.List;

/**
 * 
 * @author wanyos
 */
public class InitGenerados extends InitAbstract {
    
   
    private ManagerDiasGenerados mgd;
    private String ruta_pdf, ruta_archivo_pdf, ruta_destino, nombre_archivo_destino;
    private boolean nuevo_archivo;
    
    
    public InitGenerados(File file_pdf, File archivo_pdf){
        this.ruta_pdf = file_pdf.getAbsolutePath();
        this.ruta_archivo_pdf = archivo_pdf.getAbsolutePath();
        setActualizarBD();
    }
    
    
    public InitGenerados(File file_pdf, File archivo_pdf, File file_destino, String nombre_archivo_destino, boolean nuevo_archivo){
        this.ruta_pdf = file_pdf.getAbsolutePath();
        this.ruta_archivo_pdf = archivo_pdf.getAbsolutePath();
        this.ruta_destino = file_destino.getAbsolutePath();
        this.nombre_archivo_destino = nombre_archivo_destino;
        this.nuevo_archivo = nuevo_archivo;
        setArchivoGenerados();
    }

       
    private void setArchivoGenerados() {
        String msg = "";
        mgd = new ManagerDiasGenerados();
        mgd.setFileDiasGenerados(ruta_pdf, ruta_archivo_pdf, ruta_destino, nombre_archivo_destino, nuevo_archivo);
        if (nuevo_archivo) {
            msg = mgd.getTotalDatosActualizar();
        } else {
            msg = mgd.getTotalDatosActualizar().concat(getDatosEscritosDiferencias(mgd.isSetDatosArchivo()));
        }
        super.setMensaje(msg);
    }
    
    
    private String getDatosEscritosDiferencias(boolean escrito) {
        String diferencias = "";
        if (escrito) {
            List<String> datos = mgd.getDiferencias();
            if (!datos.isEmpty()) {
                for (String aux : datos) {
                    diferencias = diferencias.concat(aux+"\n");
                }
            }
        }
        return diferencias;
    }
    
    
    private void setActualizarBD(){
         mgd = new ManagerDiasGenerados();
         String msg = "";
        
        
        
        super.setMensaje(msg);
    }
    
    
    
    
}
