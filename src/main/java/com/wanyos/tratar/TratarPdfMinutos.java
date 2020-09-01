
package com.wanyos.tratar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author wanyos
 */
public class TratarPdfMinutos {
    
    private LeerPdf lpdf;
    private List<String> datos_leidos;
    private List<String> datos_final;
    
    
    public TratarPdfMinutos(String ruta, String nombre_archivo){
        lpdf = new LeerPdf(ruta, nombre_archivo);
        datos_leidos = lpdf.getDatosPdf();
        separarLineasPdf(datos_leidos);
    }
    
    
    public List<String> getDatosFinal(){
        if(datos_final == null){
            datos_final = new ArrayList<>();
        }
        return datos_final;
    }
    
    
    /**
     * Separa los string en lineas por el salto de linea 
     * @param datos 
     */
    private void separarLineasPdf(List<String> datos) {
        List<String> lineas = new ArrayList<>();
        if (datos != null && !datos.isEmpty()) {
            for (String aux : datos) {
                String[] l = aux.split("\n");
                for (int a = 0; a < l.length; a++) {
                    lineas.add(l[a].trim());
                }
            }
        }
        extraerLineas(lineas);
    }
    
    
    /**
     * Escoge todas las lineas que empiezan por fecha con formato dd/mm/yyyy
     * @param line 
     */
    private void extraerLineas(List<String> line){
        List<String> lineas = new ArrayList<>();
        if(!line.isEmpty()){
            for(String aux: line){
               if(isFecha(aux, 0)){
                   lineas.add(aux);
               }
            }
        }
        separarCampos(lineas);
    }
    
    
    /**
     * Separa los campos por el espacio entre palabras agregando ";"
     * @param lineas 
     */
    private void separarCampos(List<String> lineas){
        datos_final = new ArrayList<>(); 
        String f = "";
        if(!lineas.isEmpty()){
            for(String aux: lineas){
                String [] esp = aux.split("\\s");
                for(int a = 0; a < esp.length; a++){
                  f = f.concat(esp[a]+";");
                }
                //quitar el último ";"
                f = f.substring(0, f.length()-1);
                datos_final.add(f);
                f = "";
            }
        }
    }
    
    
    /**
     * Comprueba que una cadena tiene formato fecha
     * La cadena se extrae de la linea empezando en el caracter indicado y contado 
     * los caracteres que debe tener una fecha de la forma; dd/mm/yyyy
     * @param cadena
     * @param init_sub_string
     * @return 
     */
    private boolean isFecha(String linea, int init_sub_string){
        String exp = "\\d{2}/\\d{2}/\\d{4}";
        String sub_cadena = "";
        if(linea.length() >= 10){
          sub_cadena = linea.substring(init_sub_string, init_sub_string+10);  
        }
        return Pattern.matches(exp, sub_cadena);
    }
   
    
    
    
    
}
