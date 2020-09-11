
package com.wanyos.vista;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;



/**
 * @author wanyos
 */
public class PnCuadros extends PnDatosPdf {

    
    public PnCuadros() {
      initComponents();
      this.setColorCombo();
      this.setGroup();
      this.setVisibleBD(false);
      this.listenerBD();
      this.updateUI();
    }
    
    
    private void setColorCombo() {
     ((JTextField) cbo_bases.getEditor().getEditorComponent()).setBackground(new Color(153,153,153));
     ((JTextField) cbo_bases.getEditor().getEditorComponent()).setForeground(new Color(255,255,255));
    }    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        pn_cuadros = new javax.swing.JPanel();
        ch_sin_cabecera = new javax.swing.JCheckBox();
        ch_todos = new javax.swing.JCheckBox();
        pn_cuadros1 = new javax.swing.JPanel();
        rd_actualizar_bd = new javax.swing.JRadioButton();
        cbo_bases = new javax.swing.JComboBox<>();
        separator2 = new javax.swing.JSeparator();
        rd_nueva_bd = new javax.swing.JRadioButton();
        txt_nombre_bd = new org.edisoncor.gui.textField.TextField();

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

        setMaximumSize(new java.awt.Dimension(700, 300));
        setMinimumSize(new java.awt.Dimension(550, 300));
        setPreferredSize(new java.awt.Dimension(700, 300));

        pn_cuadros.setBackground(new java.awt.Color(153, 153, 153));
        pn_cuadros.setMaximumSize(new java.awt.Dimension(550, 45));
        pn_cuadros.setMinimumSize(new java.awt.Dimension(550, 45));
        pn_cuadros.setName("pn_cuadros"); // NOI18N
        pn_cuadros.setPreferredSize(new java.awt.Dimension(550, 45));
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

        pn_cuadros1.setBackground(new java.awt.Color(153, 153, 153));
        pn_cuadros1.setMaximumSize(new java.awt.Dimension(700, 45));
        pn_cuadros1.setMinimumSize(new java.awt.Dimension(500, 45));
        pn_cuadros1.setName("pn_cuadros1"); // NOI18N
        pn_cuadros1.setPreferredSize(new java.awt.Dimension(7000, 45));
        pn_cuadros1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        rd_actualizar_bd.setBackground(new java.awt.Color(153, 153, 153));
        rd_actualizar_bd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rd_actualizar_bd.setForeground(new java.awt.Color(255, 255, 255));
        rd_actualizar_bd.setText("Actualizar BD");
        rd_actualizar_bd.setName("rd_actualizar_bd"); // NOI18N
        rd_actualizar_bd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rd_actualizar_bdItemStateChanged(evt);
            }
        });
        pn_cuadros1.add(rd_actualizar_bd);

        cbo_bases.setBackground(new java.awt.Color(153, 153, 153));
        cbo_bases.setEditable(true);
        cbo_bases.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbo_bases.setForeground(new java.awt.Color(255, 255, 255));
        cbo_bases.setMinimumSize(new java.awt.Dimension(100, 22));
        cbo_bases.setOpaque(false);
        cbo_bases.setPreferredSize(new java.awt.Dimension(180, 22));
        pn_cuadros1.add(cbo_bases);

        separator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        separator2.setPreferredSize(new java.awt.Dimension(50, 5));
        pn_cuadros1.add(separator2);

        rd_nueva_bd.setBackground(new java.awt.Color(153, 153, 153));
        rd_nueva_bd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rd_nueva_bd.setForeground(new java.awt.Color(255, 255, 255));
        rd_nueva_bd.setText("Nueva BD");
        rd_nueva_bd.setName("rd_nueva_bd"); // NOI18N
        rd_nueva_bd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rd_nueva_bdItemStateChanged(evt);
            }
        });
        pn_cuadros1.add(rd_nueva_bd);

        txt_nombre_bd.setColumns(15);
        txt_nombre_bd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombre_bd.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txt_nombre_bd.setMaximumSize(new java.awt.Dimension(150, 25));
        txt_nombre_bd.setMinimumSize(new java.awt.Dimension(150, 25));
        txt_nombre_bd.setPreferredSize(new java.awt.Dimension(150, 22));
        txt_nombre_bd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nombre_bdFocusLost(evt);
            }
        });
        pn_cuadros1.add(txt_nombre_bd);

        add(pn_cuadros1);
    }// </editor-fold>//GEN-END:initComponents

    
    private void setGroup(){
        ButtonGroup gr = new ButtonGroup();
        gr.add(this.rd_actualizar_bd);
        gr.add(this.rd_nueva_bd);
        this.rd_actualizar_bd.setSelected(true);
    }
    
    
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
        if (ch_sin_cabecera.isSelected()) {
            super.setSinCabecera(true);            
        } else {
            super.setSinCabecera(false);
        }        
    }//GEN-LAST:event_ch_sin_cabeceraItemStateChanged

    private void rd_actualizar_bdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rd_actualizar_bdItemStateChanged
        if (rd_actualizar_bd.isSelected()) {
            txt_nombre_bd.setEnabled(false);
            cbo_bases.setEnabled(true);
            super.setNuevoActualizar(false);
            ModeloComBoBox modelo = new ModeloComBoBox();
            modelo.update();
            cbo_bases.setModel(modelo);
        }
    }//GEN-LAST:event_rd_actualizar_bdItemStateChanged

    private void rd_nueva_bdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rd_nueva_bdItemStateChanged
        if (rd_nueva_bd.isSelected()) {
            txt_nombre_bd.setEnabled(true);
            cbo_bases.setEnabled(false);
            super.setNuevoActualizar(true);
        }
    }//GEN-LAST:event_rd_nueva_bdItemStateChanged

    private void txt_nombre_bdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombre_bdFocusLost
        super.setNuevaBD(txt_nombre_bd.getText());
    }//GEN-LAST:event_txt_nombre_bdFocusLost


    protected void listenerBD(){
        ch_bd.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (ch_bd.isSelected()) {
                    setVisibleBD(true);
                    txt_nombre_bd.setEnabled(false);
                } else {
                   setVisibleBD(false);
                }
            }
        });
    }
    
    
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
    
    
    private void setVisibleBD(boolean b) {
        this.rd_actualizar_bd.setVisible(b);
        this.cbo_bases.setVisible(b);
        this.rd_nueva_bd.setVisible(b);
        this.separator2.setVisible(b);
        this.txt_nombre_bd.setVisible(b);
        this.updateUI();
    }
    
    
    
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_bases;
    private javax.swing.JCheckBox ch_sin_cabecera;
    private javax.swing.JCheckBox ch_todos;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel pn_cuadros;
    private javax.swing.JPanel pn_cuadros1;
    private javax.swing.JRadioButton rd_actualizar_bd;
    private javax.swing.JRadioButton rd_nueva_bd;
    private javax.swing.JSeparator separator2;
    protected org.edisoncor.gui.textField.TextField txt_nombre_bd;
    // End of variables declaration//GEN-END:variables

}
