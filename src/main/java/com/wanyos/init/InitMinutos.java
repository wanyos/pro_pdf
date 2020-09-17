
package com.wanyos.init;

import com.wanyos.manager.ManagerMinutos;

/**
 *
 * @author wanyos
 */
public class InitMinutos  {
    
    ManagerMinutos mm;
    String ruta_pdf, nombre_archivo_pdf, ruta_destino;
    
    public InitMinutos(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino){
        mm = new ManagerMinutos();
        this.ruta_pdf = ruta_pdf;
        this.nombre_archivo_pdf = nombre_archivo_pdf;
        this.ruta_destino = ruta_destino;
    }
    
   
    public String setActualizarArchivo(String nombre_destino){
        mm.actualizarArchivo(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino);
        return(mm.getTotalDatosActualizar());            
     }

    
}
