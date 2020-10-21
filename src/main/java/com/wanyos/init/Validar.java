
package com.wanyos.init;

import com.wanyos.vista.AbstractPanel;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author wanyos
 */
public class Validar {
    
    //validar cuadros
    //archivo --> 1 archivo --> 4 parametros
    //archivo --> todos archivos --> ruta_pdf, ruta_destino
    //bd --> actualizar --> ruta_pdf, archivo_pdf, nombre_bd_lista
    //bd --> nueva --> ruta_pdf, archivo_pdf, nuevo_nombre
    
    //validar generados
    //archivo --> ruta_pdf, archivo_pdf 
    //archivo nuevo --> nombre_nuevo_archivo
    //archivo actualziar --> nombre_archivo_actualizar
    
    //validar minutos
    //archivo --> ruta_pdf, archivo_pdf
    //bd --> ruta_pdf, archivo_pdf, ruta_destino, nombre_destino
    
    private AbstractPanel pn_abs;
    
    public Validar(AbstractPanel pn){
        this.pn_abs = pn;
    }
    
    
    public boolean validarFilePdfArchivoPdf(){
         if(pn_abs.getFilePdf().exists() && pn_abs.getFileArchivoPdf().exists()){
             return true;
         }
         return false;
     }
    
    
     //    -------------------   Validar Cuadros   -------------------------------------------------------------------------------
    
    public boolean validarTodosArchivosCuadro(){
        if(pn_abs.getFilePdf().exists() && pn_abs.getFileDestino().exists()){
            return true;
        }
        return false;
    }
    
    
    public boolean validarArchivoCuadro(){
        if(validarFilePdfArchivoPdf() && pn_abs.getFileDestino().exists()){
          return true;
        }
        return false;
    }
    
    public boolean validarBDCuadro(){
        if(pn_abs.getFilePdf().exists() && pn_abs.getFileArchivoPdf().exists()){
            return true;
        }
        return false;
    }
    
    
         
         //    -------------------   Validar Generados   -------------------------------------------------------------------------------
     
     
     public boolean validarArchivoGenerados(){
         if(validarFilePdfArchivoPdf() && pn_abs.getFileDestino().exists()){
             return true;
         } 
         return false;
     }
     
     
     
     
     
         //    -------------------   Validar Minutos   -------------------------------------------------------------------------------
    
     
     public boolean validarArchvivoMinutos(){
         if(validarFilePdfArchivoPdf() && pn_abs.getFileDestino().exists()){  // && existeFileArchivoDestino()){
             return true;
         }
         return false;
     }
     
//      private boolean existeFileArchivoDestino() {
//         //puede existir la ruta destino y el nombre no existir, en ese caso le podemos dar un nombre al destino para 
//         //continuar el proceso
//        File f = new File(pn_abs.getFileDestino().getAbsolutePath() + "\\" + pn_abs.getNombreDestino());
//        if (pn_abs.getNombreDestino().length() <= 0 || !f.exists()) {
//            return false;
//        }
//        return true;
//    }
     
     
}
