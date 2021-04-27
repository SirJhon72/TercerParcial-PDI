package tercerexamenpdi.Punto_3;

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


public class Punto_3_MainPanel extends javax.swing.JPanel {
    protected BufferedImage GlobalImage = null;
    MetodosGenerales MG = new MetodosGenerales();

    
    public Punto_3_MainPanel() {
        initComponents();
        /* Titulo */
        TitledBorder Title = BorderFactory.createTitledBorder("Punto 3 - Rotacion");
        Title.setTitleJustification(TitledBorder.CENTER);
        this.setBorder(Title);
        
        /* Borde del lienzo */
        Border LienzoBorder = BorderFactory.createLineBorder(Color.black);
        LienzoImage.setBorder(LienzoBorder);
        
        /* Borde del lienzo */
        LienzoRotacionPanel.setBorder(LienzoBorder);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lienzo = new javax.swing.JPanel();
        LienzoImage = new javax.swing.JLabel();
        loadImage = new javax.swing.JButton();
        LienzoRotacionPanel = new javax.swing.JPanel();
        LienzoRotado = new javax.swing.JLabel();
        Rotar = new javax.swing.JButton();
        Grados = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout LienzoLayout = new javax.swing.GroupLayout(Lienzo);
        Lienzo.setLayout(LienzoLayout);
        LienzoLayout.setHorizontalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LienzoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        LienzoLayout.setVerticalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LienzoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        loadImage.setText("Cargar Imagen");
        loadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LienzoRotacionPanelLayout = new javax.swing.GroupLayout(LienzoRotacionPanel);
        LienzoRotacionPanel.setLayout(LienzoRotacionPanelLayout);
        LienzoRotacionPanelLayout.setHorizontalGroup(
            LienzoRotacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoRotacionPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LienzoRotado, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        LienzoRotacionPanelLayout.setVerticalGroup(
            LienzoRotacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoRotacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzoRotado, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Rotar.setText("Rotar");
        Rotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RotarActionPerformed(evt);
            }
        });

        jLabel1.setText("Grados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loadImage)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Grados, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rotar)
                        .addGap(29, 29, 29)))
                .addComponent(LienzoRotacionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LienzoRotacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rotar)
                            .addComponent(Grados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(loadImage))))
                .addContainerGap(74, Short.MAX_VALUE))
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
            }
        }    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loadImageActionPerformed

    private void RotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotarActionPerformed
        Metodos MT = new Metodos();
        BufferedImage Copia = MG.CopyImage(GlobalImage);
        int grados = Integer.parseInt(Grados.getText().trim());
        BufferedImage Resultante = MT.RotacionImagen(grados, GlobalImage, Copia);
        setRotatedImage(Resultante);
//        MG.ImagenResultado(Resultante.getWidth(), Resultante.getHeight(), Resultante );
       
    }//GEN-LAST:event_RotarActionPerformed

    protected void setOriginalImage(BufferedImage img){
        Image scaledImage = img.getScaledInstance(LienzoImage.getWidth(), LienzoImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledImage);
        LienzoImage.setIcon(Icon);      
    }
    
    protected void setRotatedImage(BufferedImage img){
        Image scaledImage = img.getScaledInstance(LienzoRotado.getWidth(), LienzoRotado.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledImage);
        LienzoRotado.setIcon(Icon);      
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Grados;
    private javax.swing.JPanel Lienzo;
    private javax.swing.JLabel LienzoImage;
    private javax.swing.JPanel LienzoRotacionPanel;
    private javax.swing.JLabel LienzoRotado;
    private javax.swing.JButton Rotar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadImage;
    // End of variables declaration//GEN-END:variables
}
