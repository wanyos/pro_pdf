
package com.wanyos.init;

import com.wanyos.manager.ManagerCuadros;
import com.wanyos.vista.AbstractPanel;

/**
 * 
 * @author wanyos
 */
public class InitCuadros {
    
    private ManagerCuadros mc;
    private boolean sin_cabecera;
    private AbstractPanel pn_abstract;
    private String ruta_pdf, ruta_destino, nombre_archivo_pdf, nombre_destino;
    
    
    
    public InitCuadros(AbstractPanel pn_abstract, String nombre_archivo_pdf, String nombre_destino){
        this.mc = new ManagerCuadros();
        this.pn_abstract = pn_abstract;
        this.nombre_archivo_pdf = nombre_archivo_pdf;
        this.nombre_destino = nombre_destino;
    }
    
    public InitCuadros(AbstractPanel pn_abstract){
        this.mc = new ManagerCuadros();
        this.pn_abstract = pn_abstract;
    }
    
    
    public String setArchivosCuadros() {
        ruta_pdf = pn_abstract.getRutaPdf().getAbsolutePath();
        ruta_destino = pn_abstract.getRutaDestino().getAbsolutePath();
        sin_cabecera = pn_abstract.getSinCabecera();
        mc.writeArchivosCuadros(ruta_pdf, ruta_destino, sin_cabecera);
        return getMensajeArchivo(mc.getDatosEscritos());
    }
    
    
    public String setArchivoCuadro(){
        ruta_pdf = pn_abstract.getRutaPdf().getAbsolutePath();
        ruta_destino = pn_abstract.getRutaDestino().getAbsolutePath();
        sin_cabecera = pn_abstract.getSinCabecera();
        mc.writeFileCuadro(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, sin_cabecera);
        return getMensajeArchivo(mc.getDatosEscritos());
    }
    
    
    private String getMensajeArchivo(boolean escrito) {
        if (escrito) {
            return " Fin del proceso de conversión cuadros...\n Se han escrito: " + mc.getTotalDatosActualizar() + "lineas\n";
        }
        return " Fin del proceso de conversión cuadros...\n No se han escrito datos...\n";
    }
    
    
   
        
    
    
    
}
