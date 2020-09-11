
package com.wanyos.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.edisoncor.gui.button.ButtonAction;

/**
 *
 * @author wanyos
 */
public class FrameInit extends JFrame {

    
    private int x;
    private int y;
    private AbstractPanel pn_abs;
    
    
    public FrameInit() {
        initComponents();
        this.pack();
        this.repaint();
        this.setLocation(200, 200);
        this.btn_ejecutar.setEnabled(false);
        
        this.setVisible(true);
    }

    
    public AbstractPanel getPnAbs() {
        return pn_abs;
    }

    public ButtonAction getBtnEjecutar() {
        return btn_ejecutar;
    }
    
    public void setTxtMensaje(String m) {
        this.txt_mensaje.append(m);
    }
    
    

    private void setPanel(JPanel pn) {
        pn_ctr.removeAll();
        pn_ctr.add(pn);
        this.pack();
        this.repaint();
        pn_ctr.updateUI();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_sup = new javax.swing.JPanel();
        btn_cuadros = new org.edisoncor.gui.button.ButtonAction();
        btn_generados = new org.edisoncor.gui.button.ButtonAction();
        btn_minutos = new org.edisoncor.gui.button.ButtonAction();
        btn_salir = new javax.swing.JButton();
        pn_sep = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        pn_sub_sup = new javax.swing.JPanel();
        lbl_ventana = new org.edisoncor.gui.label.LabelMetric();
        pn_ctr = new javax.swing.JPanel();
        pn_inf = new javax.swing.JPanel();
        pn_inf_izq = new javax.swing.JPanel();
        btn_ejecutar = new org.edisoncor.gui.button.ButtonAction();
        pn_inf_der = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mensaje = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 500));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        pn_sup.setBackground(new java.awt.Color(153, 153, 153));
        pn_sup.setMaximumSize(new java.awt.Dimension(900, 50));
        pn_sup.setMinimumSize(new java.awt.Dimension(438, 50));
        pn_sup.setPreferredSize(new java.awt.Dimension(900, 50));
        pn_sup.setRequestFocusEnabled(false);

        btn_cuadros.setText("Cuadros");
        btn_cuadros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cuadrosMouseEntered(evt);
            }
        });
        btn_cuadros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuadrosActionPerformed(evt);
            }
        });
        pn_sup.add(btn_cuadros);

        btn_generados.setText("Generados");
        btn_generados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_generadosMouseEntered(evt);
            }
        });
        btn_generados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generadosActionPerformed(evt);
            }
        });
        pn_sup.add(btn_generados);

        btn_minutos.setText("Minutos");
        btn_minutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_minutosMouseEntered(evt);
            }
        });
        btn_minutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minutosActionPerformed(evt);
            }
        });
        pn_sup.add(btn_minutos);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Close.png"))); // NOI18N
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salirMouseEntered(evt);
            }
        });
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        pn_sup.add(btn_salir);

        getContentPane().add(pn_sup);

        pn_sep.setBackground(new java.awt.Color(153, 153, 153));
        pn_sep.setMaximumSize(new java.awt.Dimension(900, 20));
        pn_sep.setPreferredSize(new java.awt.Dimension(900, 20));
        pn_sep.setRequestFocusEnabled(false);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setPreferredSize(new java.awt.Dimension(500, 10));
        jSeparator1.setRequestFocusEnabled(false);
        pn_sep.add(jSeparator1);

        getContentPane().add(pn_sep);

        pn_sub_sup.setBackground(new java.awt.Color(153, 153, 153));
        pn_sub_sup.setMaximumSize(new java.awt.Dimension(900, 30));
        pn_sub_sup.setPreferredSize(new java.awt.Dimension(900, 30));
        pn_sub_sup.setRequestFocusEnabled(false);
        pn_sub_sup.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        lbl_ventana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ventana.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_ventana.setPreferredSize(new java.awt.Dimension(110, 16));
        pn_sub_sup.add(lbl_ventana);

        getContentPane().add(pn_sub_sup);

        pn_ctr.setBackground(new java.awt.Color(153, 153, 153));
        pn_ctr.setPreferredSize(new java.awt.Dimension(900, 200));
        getContentPane().add(pn_ctr);

        pn_inf.setBackground(new java.awt.Color(153, 153, 153));
        pn_inf.setPreferredSize(new java.awt.Dimension(900, 80));
        pn_inf.setLayout(new javax.swing.BoxLayout(pn_inf, javax.swing.BoxLayout.X_AXIS));

        pn_inf_izq.setBackground(new java.awt.Color(153, 153, 153));
        pn_inf_izq.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 5));

        btn_ejecutar.setText("Ejecutar");
        btn_ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ejecutarMouseEntered(evt);
            }
        });
        pn_inf_izq.add(btn_ejecutar);

        pn_inf.add(pn_inf_izq);

        pn_inf_der.setBackground(new java.awt.Color(153, 153, 153));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txt_mensaje.setEditable(false);
        txt_mensaje.setBackground(new java.awt.Color(153, 153, 153));
        txt_mensaje.setColumns(55);
        txt_mensaje.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        txt_mensaje.setForeground(new java.awt.Color(255, 255, 255));
        txt_mensaje.setRows(6);
        txt_mensaje.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_mensaje.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_mensaje.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_mensaje.setEnabled(false);
        txt_mensaje.setFocusable(false);
        txt_mensaje.setSelectedTextColor(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(txt_mensaje);

        pn_inf_der.add(jScrollPane1);

        pn_inf.add(pn_inf_der);

        getContentPane().add(pn_inf);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       Point ubicacion = MouseInfo.getPointerInfo().getLocation();
        setLocation(ubicacion.x - x, ubicacion.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void btn_cuadrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cuadrosMouseEntered
         btn_cuadros.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_cuadrosMouseEntered

    private void btn_generadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generadosMouseEntered
         btn_generados.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_generadosMouseEntered

    private void btn_minutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minutosMouseEntered
         btn_minutos.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_minutosMouseEntered

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
         btn_salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_ejecutarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ejecutarMouseEntered
        btn_ejecutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_ejecutarMouseEntered

    
    private void btn_cuadrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuadrosActionPerformed
        this.lbl_ventana.setText("Cuadros");
        pn_abs = new PnCuadros();
        pn_abs.setName("cuadros");
        this.setPanel(pn_abs);
        this.btn_ejecutar.setEnabled(true);
        this.txt_mensaje.setText("");
    }//GEN-LAST:event_btn_cuadrosActionPerformed

    
    private void btn_generadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generadosActionPerformed
        this.lbl_ventana.setText("Dias Generados");
        pn_abs = new PnGenerados();
        pn_abs.setName("generados");
        this.setPanel(pn_abs);
        this.btn_ejecutar.setEnabled(true);
        this.txt_mensaje.setText("");
    }//GEN-LAST:event_btn_generadosActionPerformed

    
    private void btn_minutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minutosActionPerformed
        this.lbl_ventana.setText("Minutos");
        pn_abs = new PnMinutos();
        pn_abs.setName("minutos");
        this.setPanel(pn_abs);
        this.btn_ejecutar.setEnabled(true);
        this.txt_mensaje.setText("");
    }//GEN-LAST:event_btn_minutosActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btn_cuadros;
    private org.edisoncor.gui.button.ButtonAction btn_ejecutar;
    private org.edisoncor.gui.button.ButtonAction btn_generados;
    private org.edisoncor.gui.button.ButtonAction btn_minutos;
    private javax.swing.JButton btn_salir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.edisoncor.gui.label.LabelMetric lbl_ventana;
    private javax.swing.JPanel pn_ctr;
    private javax.swing.JPanel pn_inf;
    private javax.swing.JPanel pn_inf_der;
    private javax.swing.JPanel pn_inf_izq;
    private javax.swing.JPanel pn_sep;
    private javax.swing.JPanel pn_sub_sup;
    private javax.swing.JPanel pn_sup;
    private javax.swing.JTextArea txt_mensaje;
    // End of variables declaration//GEN-END:variables


 }
