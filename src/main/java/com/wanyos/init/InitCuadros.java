
package com.wanyos.init;

import com.wanyos.bd.CuadrosDAO;
import com.wanyos.manager.ManagerCuadros;
import com.wanyos.modelo.Turno;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wanyos
 */
public class InitCuadros extends InitAbstract {
    
    
    private ManagerCuadros mc;
    private CuadrosDAO cuadros_dao;
    private String ruta_pdf, archivo_pdf, ruta_destino, nombre_destino;
    private String select_base, nombre_nueva_base;
    private boolean sin_cabecera;
    
    /**
     * Inicia el paso de todos los archivos a destino
     * @param file_pdf
     * @param file_destino
     * @param sin_cabecera 
     */
    public InitCuadros(File file_pdf, File file_destino, boolean sin_cabecera){
       this.ruta_pdf = file_pdf.getAbsolutePath();
       this.ruta_destino = file_destino.getAbsolutePath();
       this.sin_cabecera = sin_cabecera;
       this.setArchivosCuadros();
    }
    
    /**
     * Solo un archivo
     * @param file_pdf
     * @param archivo_pdf
     * @param file_destino
     * @param nombre_destino
     * @param sin_cabecera 
     */
    public InitCuadros(File file_pdf, File archivo_pdf, File file_destino, String nombre_destino, boolean sin_cabecera){
       this.ruta_pdf = file_pdf.getAbsolutePath();
       this.archivo_pdf = archivo_pdf.getName();
       this.ruta_destino = file_destino.getAbsolutePath();
       this.nombre_destino = nombre_destino;
       this.sin_cabecera = sin_cabecera;
       this.setArchivoCuadro();
    }
    
    /**
     * Actuolizar o nueva base de datos
     * @param file_pdf
     * @param archivo_pdf 
     * @param select_base
     * @param nombre_nueva_base 
     */
    public InitCuadros(File file_pdf, File archivo_pdf, String select_base, String nombre_nueva_base){
        this.ruta_pdf = file_pdf.getAbsolutePath();
        this.archivo_pdf = archivo_pdf.getName();
        this.select_base = select_base;
        this.nombre_nueva_base = nombre_nueva_base;
        this.setBaseDatos();
    }
    
    
    /**
     * Crea archivos de todos los pdf que existan en el directorio ruta_destino
     */
    private void setArchivosCuadros() {
        mc = new ManagerCuadros();
        mc.writeArchivosCuadros(ruta_pdf, ruta_destino, sin_cabecera);
        super.setMensaje(mc.getTotalDatosActualizar());
    }
    
    
    /**
     * Crea un unico archivo con el pdf 
     * @param ruta_pdf
     * @param nombre_archivo_pdf
     * @param ruta_destino
     * @param nombre_destino
     * @param sin_cabecera 
     */
    private void setArchivoCuadro(){
        mc = new ManagerCuadros();
        mc.writeFileCuadro(ruta_pdf, archivo_pdf, ruta_destino, nombre_destino, sin_cabecera);
        super.setMensaje(mc.getTotalDatosActualizar());
    }
    
    
    private void setBaseDatos(){
        if(nombre_nueva_base.length() > 0){
            setNuevaBD();
        } else {
            setActualizarBD();
        }
    }
    
    
    /**
     * Crea una nueva base de datos
     * @param ruta_pdf
     * @param nombre_archivo_pdf
     * @param nombre_nueva_bd 
     */
    private void setNuevaBD() {
        mc = new ManagerCuadros();
        cuadros_dao = new CuadrosDAO();
        String msg = "";
        
        //crear la base de datos
        String crear_bd = this.crearBD(cuadros_dao, nombre_nueva_base);
        msg = msg.concat(crear_bd);
        
        //crear tablas con estructura
        Map<String, List<Turno>> map_cuadros = mc.getMapTurnos(ruta_pdf, archivo_pdf);
        
        String crear_tablas = this.crearTablasCuadros(cuadros_dao, map_cuadros, nombre_nueva_base);
        msg = msg.concat(crear_tablas);
        
        //rellenar tablas con datos
        for (Map.Entry<String, List<Turno>> map_aux : map_cuadros.entrySet()) {
            String nombre_tabla = map_aux.getKey();
            List<Turno> lista_turnos = map_aux.getValue();
            String set_datos = setDatosTablas(cuadros_dao, nombre_tabla, lista_turnos, nombre_nueva_base);
            msg = msg.concat(set_datos);
        }
        
        super.setMensaje(msg);
    }
    
    
    private String crearBD(CuadrosDAO cuadros_dao, String nombre_nueva_bd){
        String msg = "";
        msg = cuadros_dao.crearNuevaBD(nombre_nueva_bd);
        return msg;
    }
    
    
    private String crearTablasCuadros(CuadrosDAO cuadros_dao, Map<String, List<Turno>> map_cuadros, String nombre_nueva_bd) {
        String msg = "";
        List<String> nombres_tablas = new ArrayList<>();

        if (!map_cuadros.isEmpty()) {
            for (String key : map_cuadros.keySet()) {
                nombres_tablas.add(key);
            }
            String creada_tabla = cuadros_dao.crearTablaCuadro(nombre_nueva_bd, nombres_tablas);
            msg = msg.concat(creada_tabla);
        }
        return msg;
    }
    
    
    private String setDatosTablas(CuadrosDAO cuadros_dao, String nombre_tabla, List<Turno> lista_turnos, String nombre_nueva_bd){
        String msg = "";
        String mensaje = cuadros_dao.setDatosTabla(nombre_nueva_bd, nombre_tabla, lista_turnos);
        msg = msg.concat(mensaje);
        return msg;
    }
    
            
    /**
     * Actualiza la base de datos seleccionada
     * @param ruta_pdf
     * @param archivo_pdf
     * @param nombre_bd 
     */
    private void setActualizarBD(){
        mc = new ManagerCuadros();
        String msg = "";
        
        
        
        super.setMensaje(msg);
    }
    
    

    
   
    
    
//    private void initHilo(){
//        Hilo hilo = new Hilo();
//        hilo.start();;
//    }
//    
//    
//    class Hilo implements Runnable {
//       
//        @Override
//        public void run() {
//            while(progreso){
//                try {
//                    sleep(1000);
//                    System.out.println("Dentro del bucle");
//                    FrameInit.setValueBarra(FrameInit.getValueBarra() + 1);
//                    if(FrameInit.getValueBarra() > 100){
//                        progreso = false;
//                    }
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(FrameInit.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            FrameInit.setValueBarra(FrameInit.getValueBarra() + (100 - FrameInit.getValueBarra()));
//        }
//    }
    
   
        
    
    
    
}
