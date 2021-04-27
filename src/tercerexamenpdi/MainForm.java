package tercerexamenpdi;

import javax.swing.JDesktopPane;
import java.io.IOException;
import tercerexamenpdi.Punto_1.Punto_1_MainPanel;
import tercerexamenpdi.Punto_2.Punto_2_MainPanel;
import tercerexamenpdi.Punto_3.Punto_3_MainPanel;
import tercerexamenpdi.Punto_4.Punto_4_MainPanel;
import tercerexamenpdi.Punto_5.Punto_5_MainPanel;
import tercerexamenpdi.Punto_6.Punto_6_MainPanel;
import tercerexamenpdi.Punto_7.Punto_7_MainPanel;
import tercerexamenpdi.Main2Form;

public class MainForm extends javax.swing.JFrame {

    Main2Form forma = new Main2Form();
    
    public MainForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InnerPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Punto1 = new javax.swing.JMenuItem();
        Punto2 = new javax.swing.JMenuItem();
        Punto3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout InnerPanelLayout = new javax.swing.GroupLayout(InnerPanel);
        InnerPanel.setLayout(InnerPanelLayout);
        InnerPanelLayout.setHorizontalGroup(
            InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1172, Short.MAX_VALUE)
        );
        InnerPanelLayout.setVerticalGroup(
            InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        jMenu1.setText("Opciones");

        Punto1.setText("Punto 1 - Escalado Simple");
        Punto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Punto1ActionPerformed(evt);
            }
        });
        jMenu1.add(Punto1);

        Punto2.setText("Punto 2 - Escalado Interpolacion Lineal");
        Punto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Punto2ActionPerformed(evt);
            }
        });
        jMenu1.add(Punto2);

        Punto3.setText("Punto 3 - Rotacion ");
        Punto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Punto3ActionPerformed(evt);
            }
        });
        jMenu1.add(Punto3);

        jMenuItem1.setText("Punto 4 - Combinación Lineal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Punto 5 - Resta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Punto 6 - Multiplicación");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Punto 7 - Montaje");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(InnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Punto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Punto1ActionPerformed
        resetInnerPanel();
        Punto_1_MainPanel PP = new Punto_1_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        InnerPanel.add(PP);        
    }//GEN-LAST:event_Punto1ActionPerformed

    private void Punto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Punto2ActionPerformed
        resetInnerPanel();
        Punto_2_MainPanel PP = new Punto_2_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        InnerPanel.add(PP); 
    }//GEN-LAST:event_Punto2ActionPerformed

    private void Punto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Punto3ActionPerformed
        resetInnerPanel();
        Punto_3_MainPanel PP = new Punto_3_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        InnerPanel.add(PP); 
    }//GEN-LAST:event_Punto3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        resetInnerPanel();
        Punto_4_MainPanel PP = new Punto_4_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        PP.Todo();
        InnerPanel.add(PP); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        resetInnerPanel();
        Punto_5_MainPanel PP = new Punto_5_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        PP.Todo();
        InnerPanel.add(PP); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        resetInnerPanel();
        Punto_6_MainPanel PP = new Punto_6_MainPanel();
        PP.setSize(InnerPanel.getWidth(), InnerPanel.getHeight());
        PP.setLocation(0, 0);
        PP.setVisible(true);
        PP.Todo();
        InnerPanel.add(PP); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        resetInnerPanel();
        Punto_7_MainPanel PP = new Punto_7_MainPanel();
        PP.setSize(1150,666);
        PP.setLocation(0, 0);
        PP.setVisible(true);
        PP.Todo();
        InnerPanel.add(PP); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane InnerPanel;
    private javax.swing.JMenuItem Punto1;
    private javax.swing.JMenuItem Punto2;
    private javax.swing.JMenuItem Punto3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getInnerPanel() {
        return InnerPanel;
    }

    public void setInnerPanel(JDesktopPane InnerPanel) {
        this.InnerPanel = InnerPanel;
    }

    protected void resetInnerPanel(){
        InnerPanel.removeAll();
    }
    
}
