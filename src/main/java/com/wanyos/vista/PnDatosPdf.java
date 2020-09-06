
package com.wanyos.vista;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.edisoncor.gui.button.ButtonRect;
import org.edisoncor.gui.label.LabelMetric;
import org.edisoncor.gui.textField.TextField;

/**
 * @author wanyos
 * Panel recoge datos de las rutas de los archivos
 * Asigna a las variales Files los archivos seleccionados en el JDialog
 */
public class PnDatosPdf extends AbstractPanel {

    
    public PnDatosPdf() {
        initComponents();
        listenerBd();
    }

    protected ButtonRect getBtn_destino() {
        return btn_destino;
    }

    protected ButtonRect getBtn_nombre_pdf() {
        return btn_nombre_pdf;
    }

    protected ButtonRect getBtn_ruta_pdf() {
        return btn_ruta_pdf;
    }

    protected TextField getTxt_destino() {
        return txt_ruta_destino;
    }

    protected TextField getTxt_nombre_destino() {
        return txt_nombre_destino;
    }

    protected TextField getTxt_nombre_pdf() {
        return txt_nombre_pdf;
    }

    protected TextField getTxt_ruta_pdf() {
        return txt_ruta_pdf;
    }

    protected LabelMetric getLbl_destino() {
        return lbl_destino;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_base_datos = new javax.swing.JPanel();
        ch_bd = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        pn_datos = new javax.swing.JPanel();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        btn_ruta_pdf = new org.edisoncor.gui.button.ButtonRect();
        txt_ruta_pdf = new org.edisoncor.gui.textField.TextField();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        btn_nombre_pdf = new org.edisoncor.gui.button.ButtonRect();
        txt_nombre_pdf = new org.edisoncor.gui.textField.TextField();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        btn_destino = new org.edisoncor.gui.button.ButtonRect();
        txt_ruta_destino = new org.edisoncor.gui.textField.TextField();
        lbl_destino = new org.edisoncor.gui.label.LabelMetric();
        txt_nombre_destino = new org.edisoncor.gui.textField.TextField();

        setBackground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(550, 250));
        setMinimumSize(new java.awt.Dimension(550, 250));
        setPreferredSize(new java.awt.Dimension(550, 250));
        setRequestFocusEnabled(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pn_base_datos.setBackground(new java.awt.Color(153, 153, 153));
        pn_base_datos.setMaximumSize(new java.awt.Dimension(550, 40));
        pn_base_datos.setMinimumSize(new java.awt.Dimension(550, 40));
        pn_base_datos.setName("pn_base_datos"); // NOI18N
        pn_base_datos.setPreferredSize(new java.awt.Dimension(550, 40));
        pn_base_datos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ch_bd.setBackground(new java.awt.Color(153, 153, 153));
        ch_bd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ch_bd.setForeground(new java.awt.Color(255, 255, 255));
        ch_bd.setText("Actualizar BD");
        ch_bd.setContentAreaFilled(false);
        pn_base_datos.add(ch_bd);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setPreferredSize(new java.awt.Dimension(110, 5));
        pn_base_datos.add(jSeparator1);

        add(pn_base_datos);

        pn_datos.setBackground(new java.awt.Color(153, 153, 153));
        pn_datos.setMaximumSize(new java.awt.Dimension(550, 130));
        pn_datos.setMinimumSize(new java.awt.Dimension(550, 130));
        pn_datos.setName("pn_datos"); // NOI18N
        pn_datos.setPreferredSize(new java.awt.Dimension(550, 130));
        pn_datos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelMetric1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric1.setText("Ruta pdf");
        labelMetric1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelMetric1.setPreferredSize(new java.awt.Dimension(110, 16));
        pn_datos.add(labelMetric1);

        btn_ruta_pdf.setText("...");
        btn_ruta_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ruta_pdfMouseEntered(evt);
            }
        });
        btn_ruta_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ruta_pdfActionPerformed(evt);
            }
        });
        pn_datos.add(btn_ruta_pdf);

        txt_ruta_pdf.setEditable(false);
        txt_ruta_pdf.setColumns(30);
        txt_ruta_pdf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_ruta_pdf.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txt_ruta_pdf.setMaximumSize(new java.awt.Dimension(366, 25));
        txt_ruta_pdf.setMinimumSize(new java.awt.Dimension(366, 25));
        pn_datos.add(txt_ruta_pdf);

        labelMetric2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric2.setText("Nombre pdf");
        labelMetric2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelMetric2.setPreferredSize(new java.awt.Dimension(110, 16));
        pn_datos.add(labelMetric2);

        btn_nombre_pdf.setText("...");
        btn_nombre_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nombre_pdfMouseEntered(evt);
            }
        });
        btn_nombre_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nombre_pdfActionPerformed(evt);
            }
        });
        pn_datos.add(btn_nombre_pdf);

        txt_nombre_pdf.setEditable(false);
        txt_nombre_pdf.setColumns(30);
        txt_nombre_pdf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombre_pdf.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txt_nombre_pdf.setMaximumSize(new java.awt.Dimension(366, 25));
        txt_nombre_pdf.setMinimumSize(new java.awt.Dimension(366, 25));
        pn_datos.add(txt_nombre_pdf);

        labelMetric3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric3.setText("Ruta destino");
        labelMetric3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelMetric3.setPreferredSize(new java.awt.Dimension(110, 16));
        pn_datos.add(labelMetric3);

        btn_destino.setText("...");
        btn_destino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_destinoMouseEntered(evt);
            }
        });
        btn_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_destinoActionPerformed(evt);
            }
        });
        pn_datos.add(btn_destino);

        txt_ruta_destino.setEditable(false);
        txt_ruta_destino.setColumns(30);
        txt_ruta_destino.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_ruta_destino.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txt_ruta_destino.setMaximumSize(new java.awt.Dimension(366, 25));
        txt_ruta_destino.setMinimumSize(new java.awt.Dimension(366, 25));
        pn_datos.add(txt_ruta_destino);

        lbl_destino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_destino.setText("Nombre destino");
        lbl_destino.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_destino.setPreferredSize(new java.awt.Dimension(110, 16));
        pn_datos.add(lbl_destino);

        txt_nombre_destino.setColumns(15);
        txt_nombre_destino.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombre_destino.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txt_nombre_destino.setMaximumSize(new java.awt.Dimension(150, 25));
        txt_nombre_destino.setMinimumSize(new java.awt.Dimension(150, 25));
        txt_nombre_destino.setPreferredSize(new java.awt.Dimension(150, 22));
        txt_nombre_destino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nombre_destinoFocusLost(evt);
            }
        });
        pn_datos.add(txt_nombre_destino);

        add(pn_datos);
    }// </editor-fold>//GEN-END:initComponents

    // Sube a la clase padre la ruta escogida en el chooser del directorio donde esta el pdf
    private void btn_ruta_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ruta_pdfActionPerformed
        File select_file = this.getFileDialog(true);
        if(select_file != null){
            super.setFileRutaPdf(select_file);
            this.txt_ruta_pdf.setText(select_file.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_ruta_pdfActionPerformed

    // Sube a la clase padre el nombre del pdf escogido en el chooser
    private void btn_nombre_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nombre_pdfActionPerformed
        File select_file = this.getFileDialog(false);
        if(select_file != null){
           super.setFileRutaArchivoPdf(select_file);
           this.txt_nombre_pdf.setText(select_file.getName()); 
        }
    }//GEN-LAST:event_btn_nombre_pdfActionPerformed

    // Sube a la clase padre la ruta destino del directorio escogido en el chooser
    private void btn_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_destinoActionPerformed
       File select_file = this.getFileDialog(true);
        if(select_file != null){
            super.setFileRutaDestino(select_file);
            this.txt_ruta_destino.setText(select_file.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_destinoActionPerformed

    
    /**
     * Si está seleccionado se guardan los datos en base datos 
     */
    protected void listenerBd() {
        ch_bd.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (ch_bd.isSelected()) {
                    setEnabledNombresBd(false);
                    getPnsAbstract(false);
                    setBaseDatos(true);
                } else {
                    setEnabledNombresBd(true);
                    getPnsAbstract(true);
                    setBaseDatos(true);
                }
            }
        });
    }
    
    
    private void setEnabledNombresBd(boolean b){
      if(!b){
       this.btn_ruta_pdf.setEnabled(true);
       this.btn_nombre_pdf.setEnabled(true);   
      }
      this.btn_destino.setEnabled(b);
      this.txt_ruta_destino.setEnabled(b);
      this.txt_ruta_destino.setText("");
      this.txt_nombre_destino.setEnabled(b);
      this.txt_nombre_destino.setText("");
    }
    
    
    /**
     * Obtiene todos los paneles para actuar sobre los componentes y hacerlos visible o no
     * Se hacen excepciones de paneles para que actuen de otra forma sobreescribiendo el listener de ch_bd
     * Los recoge de AbstractPanel 
     * @param b 
     */
    private void getPnsAbstract(boolean b) {
        List<JPanel> pns = super.getPns();
        if (!pns.isEmpty()) {
            for (JPanel p : pns) {
                if (!p.getName().equalsIgnoreCase("pn_datos") && !p.getName().equalsIgnoreCase("pn_cuadros1") &&
                        !p.getName().equalsIgnoreCase("pn_base_datos")) {
                    setVisiblePn(p, b);
                }
            }
        }
    }
    
    
    /**
     * Deshabilita/Habilita todos los componenetes del panel
     * @param pn
     * @param b 
     */
    private void setVisiblePn(JPanel pn, boolean b){
      Component [] c = pn.getComponents();
      for(int a = 0; a < c.length; a++){
         if(c[a] instanceof JCheckBox){
           JCheckBox j = (JCheckBox) c[a];
           j.setSelected(false);
         } 
         c[a].setVisible(b);
      }
    }
    
    
    /**
     * Devuelve el archivo o el directorio seleccionado
     * @return 
     */
    private File getFileDialog(boolean directory) {
        File select_file = null;
        try {
            JDialog jd = new JDialog();
            Container cp = jd.getContentPane();
            JFileChooser fc = new JFileChooser();

            if (directory) {
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            }
            fc.showOpenDialog(cp);
            select_file = fc.getSelectedFile();
            jd.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
            jd.setVisible(true);
        } catch (IllegalArgumentException e) {

        }
        return select_file;
    }
    
    
    
    // Eventos de ratón, muestra una mano cuando el cursor pasa por encima de los botones
    private void btn_ruta_pdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ruta_pdfMouseEntered
        btn_ruta_pdf.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_ruta_pdfMouseEntered

    private void btn_nombre_pdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nombre_pdfMouseEntered
        btn_nombre_pdf.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_nombre_pdfMouseEntered

    private void btn_destinoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_destinoMouseEntered
        btn_destino.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_destinoMouseEntered

    private void txt_nombre_destinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombre_destinoFocusLost
       super.setNombreDestino(this.txt_nombre_destino.getText());
    }//GEN-LAST:event_txt_nombre_destinoFocusLost

    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected org.edisoncor.gui.button.ButtonRect btn_destino;
    private org.edisoncor.gui.button.ButtonRect btn_nombre_pdf;
    private org.edisoncor.gui.button.ButtonRect btn_ruta_pdf;
    protected javax.swing.JCheckBox ch_bd;
    private javax.swing.JSeparator jSeparator1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric lbl_destino;
    private javax.swing.JPanel pn_base_datos;
    private javax.swing.JPanel pn_datos;
    protected org.edisoncor.gui.textField.TextField txt_nombre_destino;
    private org.edisoncor.gui.textField.TextField txt_nombre_pdf;
    protected org.edisoncor.gui.textField.TextField txt_ruta_destino;
    private org.edisoncor.gui.textField.TextField txt_ruta_pdf;
    // End of variables declaration//GEN-END:variables


  

}
