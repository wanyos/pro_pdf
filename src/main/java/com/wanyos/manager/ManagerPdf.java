
package com.wanyos.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wanyos
 */
public abstract class ManagerPdf {
    
   
    private boolean set_datos_archivo;
    private String total_datos_actualizar = "";

    
    /**
     * true si el archivo aumento de tamaño
     * @return 
     */
    protected boolean isSetDatosArchivo() {
        return set_datos_archivo;
    }
    
    /**
     * Total de lineas escritas
     * @return 
     */
    protected String getTotalDatosActualizar(){
        return total_datos_actualizar;
    }
    
    
    
    /**
     * Escribe un archivo con los datos del parámetro
     * @param ruta_destino
     * @param nombre_archivo
     * @param datos
     * @param sobreescribir true=continua false=sobreescribe 
     */
    protected void writeFile(String ruta_destino, String nombre_archivo, List<String> datos, boolean sobreescribir) {
        FileWriter fw = null;
        BufferedWriter bf = null;
        File f = null;
        long size_before = 0, size_after = 0;
        int lines_before = 0, lines_after = 0;

        if (!datos.isEmpty()) {
            try {
                String ruta = ruta_destino + "\\" + nombre_archivo;
                f = new File(ruta);
               
                size_before = f.length();
                lines_before = this.getLines(f);
                fw = new FileWriter(f, sobreescribir);
                bf = new BufferedWriter(fw);
                for (String aux : datos) {
                    bf.write(aux + "\n");
                }
                total_datos_actualizar = total_datos_actualizar.concat(String.valueOf(datos.size())+", ");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error en archivo...\n" + ex.getMessage(), "Error ManagerPdf...", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    bf.close();
                    fw.close();
                    size_after = f.length();
                    lines_after = this.getLines(f);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error cierre de recursos...\n" + ex.getMessage(), "Error ManagerPdf...", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
          setCambioTamano(size_before, size_after, lines_before, lines_after);
    }
    
    
    /**
     * Comprueba si el archivo ha cambiado de tamaño
     * @param size_before
     * @param size_after 
     */
    private void setCambioTamano(long size_before, long size_after, int lines_before, int lines_after){
        if((size_after > size_before) || (lines_after > lines_before)){
            this.set_datos_archivo = true;
        }
    }
    
    
    /**
     * Lee un archivo y devuelve el número total de lineas que tiene
     * @param f
     * @return 
     */
    private int getLines(File f) {
        int lines = 0;
        FileReader fr = null;
        BufferedReader bf = null;
        String l;
        if (f.exists()) {
            try {
                fr = new FileReader(f);
                bf = new BufferedReader(fr);
                while ((l = bf.readLine()) != null) {
                    lines++;
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManagerPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManagerPdf.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManagerPdf.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lines;
    }
    
    
    
    
    
    


    
}
