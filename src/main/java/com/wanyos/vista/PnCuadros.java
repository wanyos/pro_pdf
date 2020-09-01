
package com.wanyos.vista;



/**
 * @author wanyos
 */
public class PnCuadros extends PnDatosPdf {

    
    public PnCuadros() {
      initComponents();
      this.updateUI();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        pn_cuadros = new javax.swing.JPanel();
        ch_sin_cabecera = new javax.swing.JCheckBox();
        ch_todos = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pn_cuadros.setBackground(new java.awt.Color(153, 153, 153));
        pn_cuadros.setMaximumSize(new java.awt.Dimension(500, 45));
        pn_cuadros.setMinimumSize(new java.awt.Dimension(500, 45));
        pn_cuadros.setName("pn_cuadros"); // NOI18N
        pn_cuadros.setPreferredSize(new java.awt.Dimension(500, 45));
        pn_cuadros.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        ch_sin_cabecera.setBackground(new java.awt.Color(153, 153, 153));
        ch_sin_cabecera.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ch_sin_cabecera.setForeground(new java.awt.Color(255, 255, 255));
        ch_sin_cabecera.setText("Sin cabecera");
        ch_sin_cabecera.setContentAreaFilled(false);
        ch_sin_cabecera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_sin_cabeceraItemStateChanged(evt);
            }
        });
        pn_cuadros.add(ch_sin_cabecera);

        ch_todos.setBackground(new java.awt.Color(153, 153, 153));
        ch_todos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ch_todos.setForeground(new java.awt.Color(255, 255, 255));
        ch_todos.setText("Todos los archivos");
        ch_todos.setContentAreaFilled(false);
        ch_todos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_todosItemStateChanged(evt);
            }
        });
        pn_cuadros.add(ch_todos);

        add(pn_cuadros);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Recoge evento si cambia el check todos_archivos
     * @param evt 
     */
    private void ch_todosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_todosItemStateChanged
        if(ch_todos.isSelected()){
            setEnabledNombres(false);
            super.setTodosArchivos(true);
        } else {
            setEnabledNombres(true);
            super.setTodosArchivos(false);
        }
    }//GEN-LAST:event_ch_todosItemStateChanged

    
    /**
     * Evento si cambia de estado el check sin cabecera
     * @param evt 
     */
    private void ch_sin_cabeceraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_sin_cabeceraItemStateChanged
        if(ch_sin_cabecera.isSelected()){
           super.setSinCabecera(true); 
        } else {
            super.setSinCabecera(false);
        }       
    }//GEN-LAST:event_ch_sin_cabeceraItemStateChanged
    
    
    /**
     * Bloquea las casillas que no son necesarias para la opcion todos los archivos
     * @param b 
     */
    private void setEnabledNombres(boolean b) {
        super.getBtn_nombre_pdf().setEnabled(b);
        super.getTxt_nombre_pdf().setEnabled(b);
        super.getTxt_nombre_pdf().setText("");
        super.getTxt_nombre_destino().setEnabled(b);
        super.getTxt_nombre_destino().setText("");
    }

    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch_sin_cabecera;
    private javax.swing.JCheckBox ch_todos;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel pn_cuadros;
    // End of variables declaration//GEN-END:variables

}
