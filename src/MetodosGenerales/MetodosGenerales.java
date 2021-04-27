
package MetodosGenerales;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tercerexamenpdi.ImagenResultante.ImagenResultantePanel;


public class MetodosGenerales {
    /*Funcion que pinta el nuevo panel con la imagen resultante*/
    public void ImagenResultado(int ancho, int alto, BufferedImage img){
        /* Instancia del JFrame independiente*/
        ImagenResultantePanel IRP = new ImagenResultantePanel();
        /* Seteamos la imagen al JFrame*/
        Dimension DM = new Dimension(ancho, alto);
        IRP.getContainer().setPreferredSize(DM);
        IRP.getScrollPane().setViewportView(IRP.getContainer());
        
        /* Label que contendra la imagen de resultado */
        JLabel ImagenResultado = new JLabel();
        
        /*Calculo de sus posiciones y tam*/
        ImagenResultado.setLocation(10, 10);
        ImagenResultado.setSize(ancho, alto);
        
        /* Cargamos la imagen al label*/
        ImagenResultado = setResultadoImage(img, ImagenResultado);
        
        /*Cargamos la el JLabel con la imagen */
        IRP.getContainer().add(ImagenResultado);
        IRP.setVisible(true);
    }
   
    /* Set la imagen de resultado */
    public JLabel setResultadoImage(BufferedImage img, JLabel Label){
        Image scaledImage = img.getScaledInstance(Label.getWidth(), Label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledImage);
        Label.setIcon(Icon);  
        return Label;
    }
    
    /* Copiar imagen */
    public BufferedImage CopyImage(BufferedImage original){
        BufferedImage clone = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics2D g2d = clone.createGraphics();
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();
        return clone;
    }
    
    
    /*Tranforma el color de pixel a escala de grises */
    public int getGrayScale(int rgb) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = (rgb) & 0xff;
        int gray = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);
        /* Retornamos el color en escala de grises */
        return gray;
    }
}
