
package com.wanyos.init;

import com.wanyos.manager.ManagerDiasGenerados;
import java.util.List;

/**
 * 
 * @author wanyos
 */
public class InitGenerados  {
    
    private String ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino;
    private boolean archivo_nuevo;
    private ManagerDiasGenerados mgd;
    
    
    public InitGenerados(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino, String nombre_destino, boolean archivo_nuevo){
        this.ruta_pdf = ruta_pdf;
        this.nombre_archivo_pdf = nombre_archivo_pdf;
        this.ruta_destino = ruta_destino;
        this.nombre_destino = nombre_destino;
        this.archivo_nuevo = archivo_nuevo;
    }
    
    
    public String setArchivoGenerados(){
        mgd = new ManagerDiasGenerados();
        mgd.setFileDiasGenerados(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, archivo_nuevo);
        if(archivo_nuevo){
          return(mgd.getTotalDatosActualizar()); 
        }
          return(mgd.getTotalDatosActualizar().concat(getDatosEscritosDiferencias(mgd.isSetDatosArchivo())));
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
    
    
}
