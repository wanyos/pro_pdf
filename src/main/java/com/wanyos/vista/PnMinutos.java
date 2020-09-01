
package com.wanyos.vista;

/**
 * @author wanyos
 */
public class PnMinutos extends PnDatosPdf {

    
    public PnMinutos() {
        initComponents();
        this.updateUI();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_minutos = new javax.swing.JPanel();

        pn_minutos.setBackground(new java.awt.Color(153, 153, 153));
        pn_minutos.setMaximumSize(new java.awt.Dimension(500, 45));
        pn_minutos.setMinimumSize(new java.awt.Dimension(500, 45));
        pn_minutos.setName("pn_minutos"); // NOI18N

        javax.swing.GroupLayout pn_minutosLayout = new javax.swing.GroupLayout(pn_minutos);
        pn_minutos.setLayout(pn_minutosLayout);
        pn_minutosLayout.setHorizontalGroup(
            pn_minutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        pn_minutosLayout.setVerticalGroup(
            pn_minutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        add(pn_minutos);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pn_minutos;
    // End of variables declaration//GEN-END:variables
}
