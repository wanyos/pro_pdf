
package com.wanyos.manager;

import com.wanyos.tratar.TratarPdfMinutos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author wanyos
 */
public class ManagerMinutos extends ManagerPdf {
    
    
    private TratarPdfMinutos lpdfm;
    
    
    public ManagerMinutos(){}

    
    @Override
    public String getTotalDatosActualizar() {
        return super.getTotalDatosActualizar();
    }
    
    
    public boolean getDatosEscritos(){
        return super.isSetDatosArchivo();
    }

    
    
    /**
     * Actualiza el archivo minutos
     * Lee la última fecha del archivo minutos para continuar a partir de esa fecha 
     * En el pdf pueden venir dias ya escritos en el archivo
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_archivo
     * @param nombre_archivo 
     */
    public void actualizarArchivo(String ruta_pdf, String nombre_pdf, String ruta_archivo, String nombre_archivo) {
        boolean sobreescribir = true;
        lpdfm = new TratarPdfMinutos(ruta_pdf, nombre_pdf);
        
        String last_line = getLastDateArchivo(ruta_archivo+"\\"+nombre_archivo);
        String date = last_line.substring(0,10);
        List<String> datos_pdf = lpdfm.getDatosFinal();
        
        List<String> datos_actualizar = getListaDatos(date, datos_pdf);
        super.writeFile(ruta_archivo, nombre_archivo, datos_actualizar, sobreescribir);
    }
    
    
    /**
     * Recorre todo el archivo y devuelve la última linea
     * @param ruta_archivo
     * @return 
     */
    private String getLastDateArchivo(String ruta_archivo) {
        String last_line = "";
        String aux;
        FileReader fd = null;
        BufferedReader bf = null;
        try {

            File f = new File(ruta_archivo);
            fd = new FileReader(f);
            bf = new BufferedReader(fd);

            while ((aux = bf.readLine()) != null) {
                if(comprobarFecha(aux)){
                  last_line = aux.trim();  
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado...\n" + ex.getMessage(), "Error ManagerMinutos...", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error archivo...\n" + ex.getMessage(), "Error ManagerMinutos...", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                fd.close();
                bf.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error cierre de recursos...\n" + ex.getMessage(), "Error ManagerMinutos...", JOptionPane.ERROR_MESSAGE);
            }
        }
        return last_line;
    }
    
    
    /**
     * Determina desde que fecha hay que actualizar la lista de minutos
     * para ello se toma como referencia la última fecha que tenia el archivo
     * @param date
     * @param datos
     * @return 
     */
    private List<String> getListaDatos(String date, List<String> datos){
        List<String> datos_actualizar = new ArrayList<>();
        LocalDate last_date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       
        for(String aux: datos){
            String date_aux = aux.substring(0, 10);
            LocalDate last_aux = LocalDate.parse(date_aux, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if(last_date.isBefore(last_aux)){
                datos_actualizar.add(aux);
            }
        }
        return datos_actualizar;
    }
    
    
    /**
     * Comprueba que el String comienza por una fecha
     * @param s
     * @return 
     */
    private boolean comprobarFecha(String s){
        if(s != null && !s.isEmpty() && s.length() >= 10){
            String fecha = s.substring(0, 10);
            return evaluarFecha(fecha);
        }
        return false;
    }
    
    
    /**
     * Evalua expresion regular "dd/mm/yyyy"
     * @param fecha
     * @return 
     */
    private boolean evaluarFecha(String fecha) {
        String regex = "\\d{1,2}/\\d{1,2}/\\d{4}";
        if(fecha != null && !fecha.isEmpty()){
            return Pattern.matches(regex, fecha);
        }
        return false;
    }
    
   
    

}
