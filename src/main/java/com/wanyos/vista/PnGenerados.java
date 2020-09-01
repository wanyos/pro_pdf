
package com.wanyos.vista;

import javax.swing.ButtonGroup;

/**
 * @author wanyos
 */
public class PnGenerados extends PnDatosPdf {

    
    public PnGenerados() {
        initComponents();
        setGroup();
        this.updateUI();
    }
    
    
    private void setGroup() {
        ButtonGroup gb = new ButtonGroup();
        gb.add(this.rd_actualizar);
        gb.add(this.rd_nuevo);
        this.rd_actualizar.setSelected(true);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_generados = new javax.swing.JPanel();
        rd_nuevo = new javax.swing.JRadioButton();
        rd_actualizar = new javax.swing.JRadioButton();

        pn_generados.setBackground(new java.awt.Color(153, 153, 153));
        pn_generados.setMaximumSize(new java.awt.Dimension(500, 45));
        pn_generados.setMinimumSize(new java.awt.Dimension(500, 45));
        pn_generados.setName("pn_generados"); // NOI18N
        pn_generados.setPreferredSize(new java.awt.Dimension(500, 45));
        pn_generados.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        rd_nuevo.setBackground(new java.awt.Color(153, 153, 153));
        rd_nuevo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rd_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        rd_nuevo.setText("Nuevo archivo");
        rd_nuevo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rd_nuevoItemStateChanged(evt);
            }
        });
        pn_generados.add(rd_nuevo);

        rd_actualizar.setBackground(new java.awt.Color(153, 153, 153));
        rd_actualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rd_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        rd_actualizar.setText("Actualizar archivo");
        pn_generados.add(rd_actualizar);

        add(pn_generados);
    }// </editor-fold>//GEN-END:initComponents

    private void rd_nuevoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rd_nuevoItemStateChanged
       super.setNuevoActualizar(this.rd_nuevo.isSelected());
    }//GEN-LAST:event_rd_nuevoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pn_generados;
    private javax.swing.JRadioButton rd_actualizar;
    private javax.swing.JRadioButton rd_nuevo;
    // End of variables declaration//GEN-END:variables
}
