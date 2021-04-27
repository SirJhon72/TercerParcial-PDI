
package tercerexamenpdi.Punto_1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Metodos {
    protected BufferedImage GlobalCopy = null;
    
    protected BufferedImage EscaladoSimple(int factor, BufferedImage Original, BufferedImage Copia){
        /* Calculo del tamano de la nuevas imagen escala */
        int width = Original.getWidth() * factor;
        int height = Original.getHeight() * factor;
        
        /* Matriz que almacenara temporalmente la imagen */
        int[][] PseudoImagen = new int[width][height];
        
        /* Nueva imagen escalda */
        BufferedImage ImagenResultante = resizeImage(Copia, width, height);
        BufferedImage ImagenLimpia = CleanImagen(ImagenResultante);

        /* Iteradores para la imagen escalada */
        int subimgi = 0; 
        int subimgj = 0;
        
        /* Recorrimiento de la imagen, de monento solo guardamos los valores del pixel */
        for(int i = 0; i < Original.getWidth(); i++){
            for(int j = 0; j < Original.getHeight(); j++){
                int pixel = Original.getRGB(i, j);
                
                /*Iteraciones para la escala de la imagen*/
                for(int subi = subimgi; subi < subimgi + factor; subi++ ){
                    for(int subj = subimgj; subj < subimgj + factor; subj++){
                        PseudoImagen[subi][subj] = Original.getRGB(i, j);
                    }
                }
                /* Actualizamos el iterador j de la imagen escalada */
                subimgj+=factor;
            }
            
            /*Actaulizamos el iterador i de la imagen escalda, y reiniciamos j */
            subimgi+=factor;
            subimgj=0;
        }
        
        
        /* Pintamos la nueva imagen */
        for(int i = 0; i < ImagenLimpia.getWidth(); i++){
            for(int j = 0; j < ImagenLimpia.getHeight(); j++){
                int red =   (PseudoImagen[i][j] & 0x00ff0000) >> 16;
                int green = (PseudoImagen[i][j] & 0x0000ff00) >> 8;
                int blue =   PseudoImagen[i][j] & 0x000000ff;
                Color color = new Color(red, green, blue);
                ImagenResultante.setRGB(i, j, color.getRGB());
            }
        }
        
        return ImagenLimpia;         
    }
    
    protected BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
   
    protected BufferedImage CleanImagen(BufferedImage img){
        for(int i = 0; i < img.getWidth(); i++){
            for(int j = 0; j < img.getHeight(); j++){
                Color color = new Color(255, 255 , 255);
                img.setRGB(i, j, color.getRGB());
            }
        }
        return img;
    }

    protected int setPixelColor(int Pixel){
        Pixel = 0xff000000 | (Pixel << 16) | (Pixel << 8) | Pixel;
        return Pixel;
    }
}
