
package com.wanyos.manager;

import com.wanyos.tratar.TratarPdfCuadros;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Se crean archivos con los datos del pdf cuadros
 * Se lee una carpeta con todos los pdf y se convierten a archivo plano
 * Actualiza el los cuadros en la base de datos
 * @author wanyos
 */
public class ManagerCuadros extends ManagerPdf {
    
    private TratarPdfCuadros lpdfc;
    
    
    public ManagerCuadros(){}

    
    @Override
    public String getTotalDatosActualizar() {
        return super.getTotalDatosActualizar();
    }
    
           
    @Override
    public boolean isSetDatosArchivo(){
        return super.isSetDatosArchivo();
    }
    
    
    /**
     * Devuelve una lista del cuadro leido
     * @param ruta_pdf
     * @param nombre_pdf
     * @param sin_cabecera
     * @return 
     */
    public List<String> getCuadroLeido(String ruta_pdf, String nombre_pdf, boolean sin_cabecera){
        lpdfc = new TratarPdfCuadros(ruta_pdf, nombre_pdf);
        if(sin_cabecera){
          return lpdfc.getCuadroSinCabecera();    
        } 
        return lpdfc.getCuadrosLeidosPdf();
    }
    
    
    /**
     * Escribe en archivos todos los cuadros pdf de la ruta del parámetro
     * Hay que ver si en datos leidos viene un solo cuadro o varios
     * @param ruta_cuadros_pdf 
     * @param ruta_destino_archivos 
     * @param sin_cabecera 
     */
    public void writeArchivosCuadros(String ruta_cuadros_pdf, String ruta_destino_archivos, boolean sin_cabecera) {
        boolean sobreescribir = false;
        File ruta = new File(ruta_cuadros_pdf);
        if (ruta.isDirectory()) {
            File[] files = ruta.listFiles();
            for (int a = 0; a < files.length; a++) {
                String name = files[a].getName();
                if (name.contains(".pdf")) {

                    List<String> datos_cuadro;
                    lpdfc = new TratarPdfCuadros(ruta_cuadros_pdf, name);
                    if (sin_cabecera) {
                        datos_cuadro = lpdfc.getCuadroSinCabecera();
                    } else {
                        datos_cuadro = lpdfc.getCuadrosLeidosPdf();
                    }

                    int contador = 0;
                    List<String> names = lpdfc.getNombresCuadros();
                    List<String> datos = new ArrayList<>();
                    for (String aux : datos_cuadro) {
                        if (aux.equals(";")) {
                            super.writeFile(ruta_destino_archivos, names.get(contador++) + ".txt", datos, sobreescribir);
                            datos.clear();
                        } else {
                            datos.add(aux);
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La ruta no es un directorio... ", "ManagerCuadros...\n", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * Devuelve un map de cuadros con su nombre y turnos, sin cabecera
     * @param ruta_pdf
     * @param nombre_pdf
     * @return mapa con clave nombre de la tabla y valor un listado con todos los turnos
     */
    public Map<String, List<String>> getMapCuadro(String ruta_pdf, String nombre_pdf){
        lpdfc = new TratarPdfCuadros(ruta_pdf, nombre_pdf);
        Map<String, List<String>> listas_cuadros = new HashMap<>();
        
        List<String> nombres = lpdfc.getNombresCuadros();
        List<String> datos_cuadros = lpdfc.getCuadroSinCabecera();
        List<String> datos = new ArrayList<>();
        int contador = 0;
        
        for(String aux: datos_cuadros){
            if(aux.equals(";")){
                listas_cuadros.put(nombres.get(contador++), datos);
            } else {
                datos.add(aux);
            }
        }
        return listas_cuadros;
    }
    
    
    /**
     * Escribe un solo archivo con los datos del cuadro pedido
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_destino
     * @param nombre_archivo_destino
     * @param sin_cabecera 
     */
    public void writeFileCuadro(String ruta_pdf, String nombre_pdf, String ruta_destino, String nombre_archivo_destino, boolean sin_cabecera) {
        boolean sobreescribir = false;
        List<String> datos_cuadro = this.getCuadroLeido(ruta_pdf, nombre_pdf, sin_cabecera);
        super.writeFile(ruta_destino, nombre_archivo_destino, datos_cuadro, sobreescribir);
    }

    
}
