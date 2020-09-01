
package com.wanyos.tratar;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Lee el pdf de la ruta y lo devuelve en forma de texto
 * @author wanyos
 */
public class LeerPdf {
    
     private List<String> datos_pdf;

     
    public LeerPdf(String ruta, String nombre_archivo) {
        comprobarArchivo(ruta, nombre_archivo);
    }
    
    
    /**
     * Comprueba la existencia del archivo
     * @param ruta
     */
    private void comprobarArchivo(String ruta, String nombre_archivo) {
        File archivo = new File(ruta + "\\" + nombre_archivo);
        if (archivo.exists()) {
            //leer pdf
            this.lecturaPdf(archivo.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe... ", "Error LeerPdf...", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * Lee un String por página del pdf
     */
    private void lecturaPdf(String ruta) {
        datos_pdf = new ArrayList<>();
        String contenido;
        PdfReader lector = null;
        try {
            lector = new PdfReader(ruta);
            int totalPaginas = lector.getNumberOfPages();
            // por cada pagina, leeremos su contenido
            for (int iPagina = 1; iPagina <= totalPaginas; iPagina++) {
                contenido = PdfTextExtractor.getTextFromPage(lector, iPagina).trim();
                datos_pdf.add(contenido);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en el archivo... \n" + ex.getMessage(), "Error LeerPdf...", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (lector != null) {
                lector.close();
            }
        }
    }
    
    
    public List<String> getDatosPdf(){
        return this.datos_pdf;
    }
    
    
    
}
