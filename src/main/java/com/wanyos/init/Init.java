
package com.wanyos.init;


import com.wanyos.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Validar vl;
    private InitAbstract inb;
   
    
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
        if(pn_abs instanceof PnCuadros){
            //inb = new InitCuadros(pn_abs);
            if(pn_abs.getSelectBaseDatos()){
                validarCuadrosBD();
            } else {
                validarCuadrosArchivo();
            }
            
        } else if(pn_abs instanceof PnGenerados){
            //inb = new InitGenerados(pn_abs);
            if(pn_abs.getSelectBaseDatos()){
                validarGeneradosBaseDatos();
            } else {
                validarGeneradosArchivo();
            }
            
        } else if (pn_abs instanceof PnMinutos) {
            //inb = new InitMinutos(pn_abs);
            if (pn_abs.getSelectBaseDatos()) {
                validarMinutosBaseDatos();
            } else {
                validarMinutosArchivo();
            }
        }

        if (inb != null){
           this.setDatosEscritos(inb.getMensaje()); 
        }
    }
    
    
    //--------------------------------------------------------   validar cuadros  -----------------------------------------------------------//
    
    private void validarCuadrosArchivo() {
        vl = new Validar(pn_abs);

        if (pn_abs.isTodosArchivos() && vl.validarTodosArchivosCuadro()) {
            //crear objeto todos archivos
           inb = new InitCuadros(pn_abs.getFilePdf(), pn_abs.getFileDestino(), pn_abs.getSinCabecera());

        } else if(vl.validarArchivoCuadro()){
           //crear objeto para un solo archivo
           inb = new InitCuadros(pn_abs.getFilePdf(), pn_abs.getFileArchivoPdf(), pn_abs.getFileDestino(), pn_abs.getNombreDestino(), pn_abs.getSinCabecera());
        } else {
            JOptionPane.showMessageDialog(pn_abs, "No se puede crear archivo cuadros, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void validarCuadrosBD(){
        vl = new Validar(pn_abs);
        //falta validar si es un nombre valido cuando seleccionamos una base existente
        if(vl.validarBDCuadro()){
            inb = new InitCuadros(pn_abs.getFilePdf(), pn_abs.getFileDestino(), pn_abs.getSelectBase(), pn_abs.getNombreNuevaBD()); 
        } else {
            JOptionPane.showMessageDialog(pn_abs, "No se puede crear BD cuadros, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
   //--------------------------------------------------------   validar generados  -----------------------------------------------------------//
    
    
    private void validarGeneradosArchivo(){
         vl = new Validar(pn_abs);
         
         if(vl.validarArchivoGenerados()){
             inb = new InitGenerados(pn_abs.getFilePdf(), pn_abs.getFileArchivoPdf(), pn_abs.getFileDestino(), pn_abs.getNombreDestino(), pn_abs.getNuevoActualizar());
         } else {
             JOptionPane.showMessageDialog(pn_abs, "No se puede actualizar archivo generados, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
         }
    }
    
    private void validarGeneradosBaseDatos(){
      vl = new Validar(pn_abs);
      
      if(vl.validarFilePdfArchivoPdf()){
          inb = new InitGenerados(pn_abs.getFilePdf(), pn_abs.getFileArchivoPdf());
      } else {
          JOptionPane.showMessageDialog(pn_abs, "No se puede actualizar BD generados, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
      }
    }
    
    
   //--------------------------------------------------------   validar generados  -----------------------------------------------------------//
    
    
    private void validarMinutosArchivo(){
        vl = new Validar(pn_abs);
        if(vl.validarArchvivoMinutos()){
            inb = new InitMinutos(pn_abs.getFilePdf(), pn_abs.getFileArchivoPdf(), pn_abs.getFileDestino(), pn_abs.getNombreDestino());
        } else {
          JOptionPane.showMessageDialog(pn_abs, "No se puede actualizar archivo minutos, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);  
        } 
    }
    
    
    private void validarMinutosBaseDatos(){
        vl = new Validar(pn_abs);
        if(vl.validarFilePdfArchivoPdf()){
            inb = new InitMinutos(pn_abs.getFilePdf(), pn_abs.getFileArchivoPdf());
        } else {
            JOptionPane.showMessageDialog(pn_abs, "No se puede actualizar BD minutos, faltan datos... ", "!!!Error...", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    private void setDatosEscritos(String datos){
        if(pn_abs.getSelectBaseDatos()){
            setDatosEscritosBD(datos);
        } else {
            setDatosEscritosArchivo(datos);
        }
    }
    
    private void setDatosEscritosArchivo(String datos_actualizados) {
        if (datos_actualizados != null && datos_actualizados.length() > 0) {
            fi.setTxtMensaje(" Fin del proceso de conversión del pdf...\n Se han escrito: " + datos_actualizados + "lineas\n");
        }
    }
    
    private void setDatosEscritosBD(String datos_escritos){
        if (datos_escritos != null && datos_escritos.length() > 0) {
            fi.setTxtMensaje(datos_escritos);
        }
    }
    
    
    
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
