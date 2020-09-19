
package com.wanyos.init;


import com.wanyos.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 
 * @author wanyos
 */
public class Init {

    private FrameInit fi;
    private JButton btn_ejecutar;
    private AbstractPanel pn_abs;
    private String ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, nombre_nueva_bd;
    
    
    public Init() {
        fi = new FrameInit();
        this.btn_ejecutar = fi.getBtnEjecutar();
        setListenerBtn();
    }
    
    
    /**
     * Inicia el proceso de conversion 
     */
    private void setListenerBtn(){
        this.btn_ejecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               pn_abs = fi.getPnAbs();
               //ejecutarConvert(pn_abs);
               prepare();
            }
        });
    }
    
    
    private void prepare(){
        InitAbstract inb = null;
        if(pn_abs instanceof PnCuadros){
            inb = new InitCuadros(pn_abs);
        } else if(pn_abs instanceof PnGenerados){
            inb = new InitGenerados(pn_abs);
        } else if(pn_abs instanceof PnMinutos){
            inb = new InitMinutos(pn_abs);
        }
        if(inb != null){
           this.setDatosEscritos(inb.getMensaje()); 
        }
    }
    
    
    private void setDatosEscritos(String datos_actualizados) {
        if (datos_actualizados != null && datos_actualizados.length() > 0) {
            fi.setTxtMensaje(" Fin del proceso de conversión del pdf...\n Se han escrito: " + datos_actualizados + "lineas\n");
        }
    }
    
    
    /**
     * Escoge entre opción archivo o base de datos
     * @param pn_abstract 
     */
//    private void ejecutarConvert(AbstractPanel pn_abstract){
//        if(pn_abstract.getBaseDatos()){
//            prepareBD(pn_abstract);
//        } else if(!pn_abstract.getBaseDatos()){
//          prepareArchivo(pn_abstract, pn_abstract.getName());  
//        }    
//    }
    
   
    
    
//    private void prepareBD(AbstractPanel pn_abs){
//        if(pn_abs instanceof PnCuadros){
//            if(comprobarDatosBD(pn_abs)){
//              prepareCuadroBD(pn_abs);  
//            }
//           
//        } else if(pn_abs instanceof PnGenerados){
//            if(comprobarDatosBD(pn_abs)){
//               prepareGeneradosBD(pn_abs); 
//            }
//            
//            
//        } else if(pn_abs instanceof PnMinutos){
//            
//            prepareMinutosBD(pn_abs);
//        }
//    }
    
    
//    private void prepareArchivo(AbstractPanel pn_abs, String name_pn) {
//        switch (name_pn) {
//            case "cuadros":
//                if (comprobarCuadroArchivo(pn_abs)) {
//                  prepareCuadroArchivo(pn_abs);
//                }
//                break;
//
//            case "generados":
//                if (comprobarPdf_Destino_ArchivoPdf(pn_abs)) {
//                   prepareGeneradosArchivo(pn_abs);
//                }
//                break;
//
//            case "minutos":
//                if (comprobarPdf_Destino_ArchivoPdf(pn_abs) && comprobarArchivoDestino(pn_abs)) {
//                   prepareMinutosArchivo(pn_abs);
//                }
//                break;
//        }
//    }
    
    
   
    
  
//    private boolean comprobarDatosBD(AbstractPanel pn_abstract){
//        if(!existeRutaBD(pn_abstract)){
//               JOptionPane.showMessageDialog(pn_abs, "Error en la ruta de pdf o archivo pdf... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
//               return false;
//           } else {
//               //comprobar si bd nueva
//               if(pn_abstract.getArchivoNuevo() && !existeNombreBD(pn_abstract)){
//                 JOptionPane.showMessageDialog(pn_abs, "Error nombre base de datos nueva... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
//                 return false;
//               } 
//           }
//              this.ruta_pdf = pn_abs.getFilePdf().getAbsolutePath();
//              this.nombre_archivo_pdf = pn_abs.getFileArchivoPdf().getName();
//              this.nombre_nueva_bd = pn_abs.getNombreNuevaBD();
//        return true;
//    }
    
    
//    private boolean comprobarCuadroArchivo(AbstractPanel pn_abs) {
//        if (pn_abs.isTodosArchivos()) {
//            if (!existeRutaPdf_y_Destino(pn_abs)) {
//                JOptionPane.showMessageDialog(pn_abs, "Error en la ruta de pdf o ruta destino... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//        } else {
//            return comprobarPdf_Destino_ArchivoPdf(pn_abs);
//        }
//        return true;
//    }
    
    
//    private boolean comprobarPdf_Destino_ArchivoPdf(AbstractPanel pn_abs){
//        if(!existeRutaPdf_y_Destino(pn_abs)){
//            JOptionPane.showMessageDialog(pn_abs, "Error en la ruta de pdf o ruta destino... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
//            return false;
//        } else if(!pn_abs.getFileArchivoPdf().exists()){
//            JOptionPane.showMessageDialog(pn_abs, "Error en la ruta archivo pdf... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        this.ruta_pdf = pn_abs.getFilePdf().getAbsolutePath();
//        this.nombre_archivo_pdf = pn_abs.getFileArchivoPdf().getName();
//        this.ruta_destino = pn_abs.getFileDestino().getAbsolutePath();
//        return true;
//    }
    
    
//    private boolean comprobarArchivoDestino(AbstractPanel pn_abs){
//        File f = new File(pn_abs.getFileDestino().getAbsolutePath()+ "\\" + pn_abs.getNombreDestino());
//        if (!f.exists()) {
//                JOptionPane.showMessageDialog(pn_abs, "Nombre archivo destino no existe... ", "Error Init...", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//        this.nombre_destino = pn_abs.getNombreDestino();
//        return true;
//    }
        
    
    private boolean existeRutaBD(AbstractPanel pn_abs){
        return pn_abs.getFilePdf().exists() && pn_abs.getFileArchivoPdf().exists();
    }
    
    
    private boolean existeNombreBD(AbstractPanel pn_abs){
        if(pn_abs.getNombreNuevaBD().length() <= 0){
            return false;
        }
        return true;
    }
    
    
    private boolean existeRutaPdf_y_Destino(AbstractPanel pn_abs){
        return pn_abs.getFilePdf().exists() && pn_abs.getFileDestino().exists();
    }
    
    
    
    
    
    
    
//    private void prepareCuadroBD(AbstractPanel pn_abs){
//        InitCuadros inc;
//        String mensaje = "";
//        if(pn_abs.getArchivoNuevo()){
//          inc = new InitCuadros(ruta_pdf, nombre_archivo_pdf, nombre_nueva_bd);
//          mensaje = inc.setNuevaBD();  
//        } else {
//          inc = new InitCuadros(ruta_pdf, nombre_archivo_pdf, pn_abs.getSelectBase());   
//        }
//        fi.setTxtMensaje(mensaje);
//    }
    
 
//    private void prepareCuadroArchivo(AbstractPanel pn_abs) {
//        InitCuadros inc;
//        String msg = "";
//
//        if (pn_abs.isTodosArchivos()) {
//            inc = new InitCuadros(ruta_pdf, ruta_destino, pn_abs.getSinCabecera());
//            msg = inc.setArchivosCuadros();
//        } else {
//            nombre_archivo_pdf = pn_abs.getFileArchivoPdf().getName();
//            nombre_destino = this.comprobarNombreDestino(pn_abs.getNombreDestino(), nombre_archivo_pdf);
//            inc = new InitCuadros(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, pn_abs.getSinCabecera());
//            msg = inc.setArchivoCuadro();
//        }
//        this.setDatosEscritos(msg);
//    }
    
    
    private void prepareGeneradosBD(AbstractPanel pn_abs){
        String mensaje = "";
        
        this.setDatosEscritos(mensaje);
    }
    
    
//    private void prepareGeneradosArchivo(AbstractPanel pn_abs) {
//         InitGenerados ing;
//         String msg = "";
//        boolean archivo_nuevo = pn_abs.getArchivoNuevo();
//       
//        if(archivo_nuevo){
//           nombre_destino = comprobarNombreDestino(pn_abs.getNombreDestino(), pn_abs.getFilePdf().getName());  
//        } else if(comprobarArchivoDestino(pn_abs)){
//           nombre_destino = pn_abs.getNombreDestino(); 
//        }
//          ing = new InitGenerados(ruta_pdf, nombre_archivo_pdf, ruta_destino, nombre_destino, archivo_nuevo);
//          msg = ing.setArchivoGenerados();
//          this.setDatosEscritos(msg);
//    }
    
    
    private void prepareMinutosBD(AbstractPanel pn_abs){
        String mensaje = "";
        
        this.setDatosEscritos(mensaje);
    }
    
    
//    private void prepareMinutosArchivo(AbstractPanel pn_abs){
//        InitMinutos inm;
//        String msg = "";
//        
//        if(comprobarArchivoDestino(pn_abs)){
//           nombre_destino = pn_abs.getNombreDestino();
//           inm = new InitMinutos(ruta_pdf, nombre_archivo_pdf, ruta_destino);
//           msg = inm.setActualizarArchivo(nombre_destino);
//           this.setDatosEscritos(msg);
//        }
//    }
    
    
    /**
     * Si el nombre destino no es valido se crea uno basado en el nombre del pdf leido
     * @param nombre_destino
     * @param nombre_pdf
     * @return 
     */
//    private String comprobarNombreDestino(String nombre_destino, String nombre_pdf){
//        String nombre = "";
//        if(nombre_destino == null || nombre_destino.trim().length() == 0 || !nombre_destino.contains(".txt")){
//            String sub = nombre_pdf.substring(0, nombre_pdf.length()-4);
//            nombre = nombre.concat("nuevo_").concat(sub).concat(".txt");
//            return nombre;
//        }
//        return nombre_destino;
//    }
    
    
    
    
//    private void eliminarPdfLeido(String ruta_pdf, String nombre_pdf) {
//        if (nombre_pdf == null) {
//            int op = JOptionPane.showConfirmDialog(pn_abs, "Quiere eliminar todos los pdfs leidos...?", "Delete pdfs", JOptionPane.YES_NO_OPTION);
//            if (op == 0) {
//                eliminarTodosPdf(ruta_pdf);
//            }
//        } else if (!nombre_pdf.isEmpty() && nombre_pdf.contains(".pdf")) {
//            int op = JOptionPane.showConfirmDialog(pn_abs, "Quiere eliminar pdf leido...?", "Delete pdf", JOptionPane.YES_NO_OPTION);
//            if (op == 0) {
//                eliminarPdf(ruta_pdf, nombre_pdf);
//            }
//        }
//    }
    
    
    /**
     * Elimina el archivo si es un pdf
     * @param ruta_pdf
     * @param nombre_pdf 
     */
//    private void eliminarPdf(String ruta_pdf, String nombre_pdf) {
//        File f = new File(ruta_pdf + "\\" + nombre_pdf);
//        f.delete();
//
//        if (!f.exists()) {
//            JOptionPane.showMessageDialog(pn_abs, " Eliminado el archivo: " + nombre_pdf, " Eliminar...", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(pn_abs, " El archivo " + nombre_pdf + " no ha sido eliminado...", " Eliminar...", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    
//    /**
//     * Elimina todos los pdfs si el archivo es un directorio
//     * @param files 
//     */
//    private void eliminarTodosPdf(String ruta_pdf) {
//        File f = new File(ruta_pdf);
//        int total_archivos_pdf = 0;
//        int total_eliminados = 0;
//        if (f.isDirectory()) {
//            File[] archivos = f.listFiles();
//            for (int a = 0; a < archivos.length; a++) {
//                String name = archivos[a].getName();
//                if (name.contains(".pdf")) {
//                    total_archivos_pdf++;
//                    archivos[a].delete();
//
//                    if (!archivos[a].exists()) {
//                        total_eliminados++;
//                    }
//                }
//            }
//            JOptionPane.showMessageDialog(pn_abs, " Eliminados: " + total_eliminados + " archivos de " + total_archivos_pdf + " archivos", "Eliminados...", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(pn_abs, "La ruta que quiere eliminar pdfs no es un directorio... ", "Aviso Init...", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//    
    
    
    
    
    
    
    public static void main(String[] args) {
        
           new Init();
    }

}
