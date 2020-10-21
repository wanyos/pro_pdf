
package com.wanyos.manager;

import com.wanyos.modelo.Turno;
import com.wanyos.tratar.TratarPdfCuadros;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Se crean archivos con los datos del pdf cuadros
 * Se lee una carpeta con todos los pdf y se convierten a archivo plano
 * Actualiza el los cuadros en la base de datos
 * Crea nuevas bases de datos con cuadros
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

                    List<String> datos_cuadro = this.getCuadroLeido(ruta_cuadros_pdf, name, sin_cabecera);

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
     * Escribe un solo archivo con los datos del cuadro pedido
     * Hay que comprobar que el listado del cuadro es solo de un cuadro o hay más
     * Si es así hay que separarlos
     * Si el nombre de archivo_destino="" se coge el nombre o los nombres del pdf leido
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_destino
     * @param nombre_archivo_destino
     * @param sin_cabecera 
     */
    public void writeFileCuadro(String ruta_pdf, String nombre_pdf, String ruta_destino, String nombre_archivo_destino, boolean sin_cabecera) {
        boolean sobreescribir = false;
        List<String> datos_cuadro = this.getCuadroLeido(ruta_pdf, nombre_pdf, sin_cabecera);
        List<String> names = this.lpdfc.getNombresCuadros();
        List<String> datos = new ArrayList<>();
        int contador = 0;
        String nombre = nombre_archivo_destino;
        
        for (String aux : datos_cuadro) {
            if (aux.equals(";")) {
                if(nombre_archivo_destino.length() <= 0){
                    nombre = names.get(contador++);
                }
                super.writeFile(ruta_destino, nombre + ".txt", datos, sobreescribir);
                datos.clear();
            } else {
                datos.add(aux);
            }
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
        Map<String, List<String>> map_cuadros = new HashMap<>();
        
        List<String> nombres = lpdfc.getNombresCuadros();
        List<String> datos_cuadros = lpdfc.getCuadroSinCabecera();
        List<String> datos = new ArrayList<>();
        int contador = 0;
        
        for(String aux: datos_cuadros){
            if(aux.equals(";")){
                map_cuadros.put(nombres.get(contador++), datos);
                datos = new ArrayList<>();
            } else {
                datos.add(aux);
            }
        }
        return map_cuadros;
    }
    
    
    public Map<String, List<Turno>> getMapTurnos(String ruta_pdf, String nombre_pdf) {
        lpdfc = new TratarPdfCuadros(ruta_pdf, nombre_pdf);
        Map<String, List<Turno>> map_turnos = new HashMap<>();
        
        List<String> nombres = lpdfc.getNombresCuadros();
        List<String> datos_cuadros = lpdfc.getCuadroSinCabecera();
        List<Turno> lista_turnos = new ArrayList<>();
        int contador = 0;
            
        for(String aux: datos_cuadros){
            if(aux.equals(";")){
                map_turnos.put(nombres.get(contador++), lista_turnos);
                lista_turnos = new ArrayList<>();
            } else {
                Turno t = convertTurno(aux);
                lista_turnos.add(t);
            }
        }
        return map_turnos;
    }
    
    
    
    private Turno convertTurno(String line) {
        String[] d = line.split(";");
        int turno = Integer.parseInt(d[0]);
        String cc = d[1];
        LocalTime init = LocalTime.parse(d[2], DateTimeFormatter.ofPattern("HH:mm"));
        String lugar_ini = d[3];
        LocalTime fin = LocalTime.parse(d[4], DateTimeFormatter.ofPattern("HH:mm"));
        String lugar_fin = d[5];
        LocalTime total_turno = LocalTime.parse(d[6], DateTimeFormatter.ofPattern("HH:mm"));
        int minutos;
        if (d[7].equals("--")) {
            minutos = 0;
        } else {
            minutos = Integer.parseInt(d[7]);
        }

        Turno t = new Turno(turno, cc, init, lugar_ini, fin, lugar_fin, total_turno, minutos);

        return t;
    }

    
    
}
