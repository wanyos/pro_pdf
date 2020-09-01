
package com.wanyos.manager;
import com.wanyos.tratar.TratarPdfDiasGenerados;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wanyos
 */
public class ManagerDiasGenerados extends ManagerPdf {
    
    private TratarPdfDiasGenerados lpdfd;
    private boolean datos_escritos;
    private String total_lineas = "";
    private List<String> diferencias;
    
    
    public ManagerDiasGenerados(){}

    
    //Estos métodos recogen los dtos después de escribir en el archivo
    //Estos datos están en la clase padre
    
    public String getTotalLineasEscritas() {
        return total_lineas;
    }
    
    public boolean getDatosEscritos(){
        return datos_escritos;
    }
    
    /**
     * Lista de las diferencias que hay entre el archivo antiguo y el nuevo
     * Se usa al actualizar el archivo de libres
     * @return 
     */
    public List<String> getDiferencias(){
        return this.diferencias;
    }
    
    
    /**
     * Actualiza o crea un archivo nuevo
     * Si nuevo=true hay que comprobar que el nombre del archivo destino existe
     * Si existe se modifica el nombre para duplicar el archivo
     * Si no existe se crea el nuevo archivo con el nombre que venga en el parametro
     * Si hay que actualizar se lee el archivo antiguo para comparar los datos con el nuevo
     * Se crea un pequeño String con los datos que cambien con la actualización
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_destino
     * @param nombre_archivo_destino 
     * @param archivo_nuevo si es falso se actualiza el archivo destino, si no se crea uno nuevo
     */
    public void setFileDiasGenerados(String ruta_pdf, String nombre_pdf, String ruta_destino, String nombre_archivo_destino, boolean archivo_nuevo) {
        if (archivo_nuevo) {
            setArchivoNuevo(ruta_pdf, nombre_pdf, ruta_destino, nombre_archivo_destino);
        } else {
           setArchivo(ruta_pdf, nombre_pdf, ruta_destino, nombre_archivo_destino);
        }
    }
    
    
    /**
     * Nuevo archivo dias generados
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_destino
     * @param nombre_archivo_destino 
     */
    private void setArchivoNuevo(String ruta_pdf, String nombre_pdf, String ruta_destino, String nombre_archivo_destino){
        boolean sobreescribir = false;
        String ruta_archivo = ruta_destino+"\\"+nombre_archivo_destino;
        
        if(getExisteArchivo(ruta_archivo)){
            nombre_archivo_destino = this.getNuevoNombre(ruta_destino, nombre_archivo_destino);
        }
        lpdfd = new TratarPdfDiasGenerados(ruta_pdf, nombre_pdf);
        List<String> dias_leidos = lpdfd.getDiasLeidosPdf();
       
        super.writeFile(ruta_destino, nombre_archivo_destino, dias_leidos, sobreescribir);
        datos_escritos = super.isSetDatosArchivo();
        total_lineas = super.getTotalDatosActualizar();
    }
    
    
    /**
     * Actualiza el archivo dias generados
     * @param ruta_pdf
     * @param nombre_pdf
     * @param ruta_destino
     * @param nombre_archivo_destino 
     */
    private void setArchivo(String ruta_pdf, String nombre_pdf, String ruta_destino, String nombre_archivo_destino){
         boolean sobreescribir = false;
         diferencias = new ArrayList<>();
         List<String> archivo_antiguo = this.getDatosArchivoAntiguo(ruta_destino, nombre_archivo_destino);
         lpdfd = new TratarPdfDiasGenerados(ruta_pdf, nombre_pdf);
         List<String> dias_leidos = lpdfd.getDiasLeidosPdf();
         
         //si no hay datos antiguos no se indica nada en el string
         if(!archivo_antiguo.isEmpty()){
           diferencias = getCompararDatos(archivo_antiguo, dias_leidos);  
         }
         
         super.writeFile(ruta_destino, nombre_archivo_destino, dias_leidos, sobreescribir);
         datos_escritos = super.isSetDatosArchivo();
    }
    
    
    /**
     * Comprueba los cambios que existen entre los dias generados que habia con los nuevos leidos
     * @param antiguo
     * @param nuevo
     * @return listado con los cambios
     */
    private List<String> getCompararDatos(List<String> antiguo, List<String> nuevo) {
        List<String> datos = new ArrayList<>();
        int contador_old = 0;

        for (String aux : nuevo) {
            String[] d = aux.split(";");
            if (contador_old <= antiguo.size() && getDiasIguales(aux, antiguo.get(contador_old))) {
                if (getDiaModificado(aux, antiguo.get(contador_old))) {
                  datos.add(" Dia modificado: " + d[0] + " " + d[2]);  
                }
                contador_old++;
            } else {
                datos.add(" Nuevo dia: " + d[0] + " " + d[2]);
            }
        }
        return datos;
    }
    
    
    private boolean getDiasIguales(String nuevo, String antiguo){
       String [] d_nuevo = nuevo.split(";");
       String [] d_antiguo = antiguo.split(";");
       
       //0=clave  1=condicon  2=f_generado 3=f_cobro 4=f_disfrute
       if((d_nuevo[0].equals(d_antiguo[0])) && (d_nuevo[2].equals(d_antiguo[2]))){
           return true;
       }
        return false;
    }
    
    
    private boolean getDiaModificado(String nuevo, String antiguo){
       String [] d_nuevo = nuevo.split(";");
       String [] d_antiguo = antiguo.split(";");
       
       //0=clave  1=condicon  2=f_generado 3=f_cobro 4=f_disfrute
       if(!d_nuevo[3].equals(d_antiguo[3]) || !d_nuevo[4].equals(d_antiguo[4])){
           return true;
       }
        return false;
    }
    
    
    private boolean getExisteArchivo(String ruta){
        File f = new File(ruta);
        return f.exists();
    }
    
    
    /**
     * Lee al archivo antiguo para obtener los datos que contiene
     * Se usa para actualizar el archivo dias generados y mostrar los cambios que pueda tener el nuevo archivo
     * @param ruta_destino
     * @param nombre_archivo
     * @return 
     */
    private List<String> getDatosArchivoAntiguo(String ruta_destino, String nombre_archivo) {
        List<String> datos = new ArrayList<>();
        FileReader fd = null;
        BufferedReader bf = null;
        String ruta, line;
        File f;

        try {
            ruta = ruta_destino + "\\" + nombre_archivo;
            if (getExisteArchivo(ruta)) {
                f = new File(ruta);

                fd = new FileReader(f);
                bf = new BufferedReader(fd);

                while ((line = bf.readLine()) != null) {
                    datos.add(line);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagerDiasGenerados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagerDiasGenerados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fd.close();
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerDiasGenerados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    /**
     * Crea un nuevo nombre para un archivo nuevo
     * En caso que exista aumenta el número de versión
     * @param ruta
     * @param nombre_archivo
     * @return 
     */
    private String getNuevoNombre(String ruta, String nombre_archivo) {
        String nuevo = "";
        int add = 0;
        nuevo = nombre_archivo;

        do {
            //quitar extension y posibles digitos seguidos del nombre
            int d = 0;
            if(add > 0 && add < 9){
                d = 1;
            } else if(add > 9){
                d = 2;
            }
            int l = nuevo.length();
            nuevo = nuevo.substring(0, l - (d+4));
            
            String n = String.valueOf(++add);
            nuevo = nuevo.concat(n + ".txt");
        } while (this.getExisteArchivo(ruta + "\\" + nuevo));

        return nuevo;
    }

    
}
