
package com.wanyos.vista;

import com.wanyos.bd.Conexion;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author wanyos
 */
public class ModeloComBoBox extends DefaultComboBoxModel<String> {

    private Conexion bd;
    private List<String> nombres_bd;
    
    public ModeloComBoBox(){
       //se inicia el servicio en caso que no estuviera activo 
       Conexion.initServer();
    }
    
    
   /**
    * Añade al modelo la lista de nombres bases de datos 
    */
    public void update() {
        removeAllElements();
        bd = new Conexion();
        nombres_bd = bd.getNombresBd();
        if (nombres_bd.isEmpty()) {
            addElement("No existen datos");
        } else {
            addElement("--Nombres BD--");
            for (String aux : nombres_bd) {
                addElement(aux);
            }
        }
    }
    
    
    
    
    
    
    
    
}
