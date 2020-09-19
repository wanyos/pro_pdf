
package com.wanyos.init;

import com.wanyos.manager.ManagerDiasGenerados;
import com.wanyos.vista.AbstractPanel;
import java.util.List;

/**
 * 
 * @author wanyos
 */
public class InitGenerados extends InitAbstract {
    
   
    private ManagerDiasGenerados mgd;
    
    
    public InitGenerados(AbstractPanel pn_abs){
         super(pn_abs);
        //comprueba datos comunes en todos los supuestos
        comprobarDatosGenerados();
    }
   
    
    /**
     * Comprueba los datos de los casos concretos que pueden existir
     * los archivos esenciales son la ruta pdf y el archivo pdf
     * los dos son necesarios tanto para base de datos como para archivo
     */
    private void comprobarDatosGenerados(){
        if(super.comprobarDatos()){           
            if(super.isActualizarBd()){
                setActualizarBD(super.getRutaFilePdf(), super.getNombreArchivoPdf());
            } else {
                comprobarDatosArchivo();
            }
        }
    }
    
    
    /**
     * Es necesario comprobar si se quiere un archivo nuevo o no
     * En caso de uno nuevo se le usa la función comprobarNombre que le dara un nombre al archivo en caso de error
     * Si el caso es actualizar el archivo debe existir
     */
    private void comprobarDatosArchivo() {
        if (super.existeFileArchivoPdf()) {

            if (super.getNuevoActualizar()) {
                String nombre_destino = super.comprobarNombreDestino(super.getNombreArchivoDestino(), super.getNombreArchivoPdf());
                setArchivoGenerados(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getRutaFileDestino(), nombre_destino, super.getNuevoActualizar());

            } else if (!super.getNuevoActualizar() && super.existeFileArchivoDestino()) {
                setArchivoGenerados(super.getRutaFilePdf(), super.getNombreArchivoPdf(), super.getRutaFileDestino(), super.getNombreArchivoDestino(), super.getNuevoActualizar());
            }

        }
    }

    
        
    private void setArchivoGenerados(String ruta_pdf, String nombre_archivo_pdf, String ruta_destino, String nombre_destino, boolean archivo_nuevo) {
        String msg = "";
        mgd = new ManagerDiasGenerados();
        mgd.setFileDiasGenerados(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, archivo_nuevo);
        if (archivo_nuevo) {
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
    
    
    private void setActualizarBD(String ruta_pdf, String nombre_archivo_pdf){
         mgd = new ManagerDiasGenerados();
         String msg = "";
        
        
        
        super.setMensaje(msg);
    }
    
    
    
    
}
