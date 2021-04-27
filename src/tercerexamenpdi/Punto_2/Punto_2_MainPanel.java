package tercerexamenpdi.Punto_2;

import MetodosGenerales.MetodosGenerales;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Punto_2_MainPanel extends javax.swing.JPanel {
    protected BufferedImage GlobalImage = null;
    MetodosGenerales MG = new MetodosGenerales();


    public Punto_2_MainPanel() {
        initComponents();
        /* Titulo */
        TitledBorder Title = BorderFactory.createTitledBorder("Punto 2 - Escalado con Interpolacion Lineal");
        Title.setTitleJustification(TitledBorder.CENTER);
        this.setBorder(Title);
        
        /* Borde del lienzo */
        Border LienzoBorder = BorderFactory.createLineBorder(Color.black);
        Lienzo.setBorder(LienzoBorder);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lienzo = new javax.swing.JPanel();
        LienzoImage = new javax.swing.JLabel();
        loadImage = new javax.swing.JButton();
        Escalado2 = new javax.swing.JButton();
        Escalado3 = new javax.swing.JButton();
        Escalado4 = new javax.swing.JButton();
        Escalado5 = new javax.swing.JButton();
        ResolutionOrign = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ResolutionResult = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout LienzoLayout = new javax.swing.GroupLayout(Lienzo);
        Lienzo.setLayout(LienzoLayout);
        LienzoLayout.setHorizontalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LienzoLayout.setVerticalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        loadImage.setText("Cargar Imagen");
        loadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageActionPerformed(evt);
            }
        });

        Escalado2.setText("x2");
        Escalado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Escalado2ActionPerformed(evt);
            }
        });

        Escalado3.setText("x3");
        Escalado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Escalado3ActionPerformed(evt);
            }
        });

        Escalado4.setText("x4");
        Escalado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Escalado4ActionPerformed(evt);
            }
        });

        Escalado5.setText("x5");
        Escalado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Escalado5ActionPerformed(evt);
            }
        });

        ResolutionOrign.setText("0");

        jLabel2.setText("Resolucion Original");

        ResolutionResult.setText("0");

        jLabel3.setText("Resolucion Resultante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Escalado2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Escalado3))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ResolutionResult)
                            .addComponent(ResolutionOrign)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Escalado4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Escalado5)))
                        .addGap(271, 271, 271))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadImage)
                    .addComponent(Escalado2)
                    .addComponent(Escalado3)
                    .addComponent(Escalado4)
                    .addComponent(Escalado5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResolutionOrign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResolutionResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(181, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageActionPerformed
         try { 
        JFileChooser FC = new JFileChooser();
        FC.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        /* Solo permitimos archivos de tipo PNG y JPG*/
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        FC.setFileFilter(imgFilter);
        
        int result = FC.showOpenDialog(this);
        if(result != JFileChooser.CANCEL_OPTION || result != JFileChooser.ABORT){
            File image = FC.getSelectedFile();
            
            if(image == null || image.getName().equals("")){
                JOptionPane.showMessageDialog(null, "Favor de cargar una imagen valida");
            }else{
                BufferedImage img = ImageIO.read(image);
                GlobalImage = MG.CopyImage(img);
                setOriginalImage(img);
                ResolutionOrign.setText(GlobalImage.getWidth() + " x " + GlobalImage.getHeight());
            }
        }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResolutionResult.setText("");
    }//GEN-LAST:event_loadImageActionPerformed

    private void Escalado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Escalado2ActionPerformed
        Metodos MT = new Metodos();
        BufferedImage Copia = MG.CopyImage(GlobalImage);
        BufferedImage Resultante = MT.EscaladoInterpolacionLineal(GlobalImage, Copia, 2);
        MG.ImagenResultado(Resultante.getWidth(), Resultante.getHeight(), Resultante );
        ResolutionResult.setText(Resultante.getWidth() + " x " + Resultante.getHeight());
    }//GEN-LAST:event_Escalado2ActionPerformed

    private void Escalado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Escalado3ActionPerformed
        Metodos MT = new Metodos();
        BufferedImage Copia = MG.CopyImage(GlobalImage);
        BufferedImage Resultante = MT.EscaladoInterpolacionLineal(GlobalImage, Copia, 3);
        MG.ImagenResultado(Resultante.getWidth(), Resultante.getHeight(), Resultante );
        ResolutionResult.setText(Resultante.getWidth() + " x " + Resultante.getHeight());
    }//GEN-LAST:event_Escalado3ActionPerformed

    private void Escalado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Escalado4ActionPerformed
        Metodos MT = new Metodos();
        BufferedImage Copia = MG.CopyImage(GlobalImage);
        BufferedImage Resultante = MT.EscaladoInterpolacionLineal(GlobalImage, Copia, 4);
        MG.ImagenResultado(Resultante.getWidth(), Resultante.getHeight(), Resultante );
        ResolutionResult.setText(Resultante.getWidth() + " x " + Resultante.getHeight());
    }//GEN-LAST:event_Escalado4ActionPerformed

    private void Escalado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Escalado5ActionPerformed
        Metodos MT = new Metodos();
        BufferedImage Copia = MG.CopyImage(GlobalImage);
        BufferedImage Resultante = MT.EscaladoInterpolacionLineal(GlobalImage, Copia, 5);
        MG.ImagenResultado(Resultante.getWidth(), Resultante.getHeight(), Resultante );
        ResolutionResult.setText(Resultante.getWidth() + " x " + Resultante.getHeight());
    }//GEN-LAST:event_Escalado5ActionPerformed

    
    protected void setOriginalImage(BufferedImage img){
        Image scaledImage = img.getScaledInstance(LienzoImage.getWidth(), LienzoImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledImage);
        LienzoImage.setIcon(Icon);      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Escalado2;
    private javax.swing.JButton Escalado3;
    private javax.swing.JButton Escalado4;
    private javax.swing.JButton Escalado5;
    private javax.swing.JPanel Lienzo;
    private javax.swing.JLabel LienzoImage;
    private javax.swing.JTextField ResolutionOrign;
    private javax.swing.JTextField ResolutionResult;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loadImage;
    // End of variables declaration//GEN-END:variables
}
