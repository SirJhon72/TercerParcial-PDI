package tercerexamenpdi.Punto_3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

public class Metodos {
    double[] posX = new double[4];
    double[] posY = new double[4];
    double MinX = 0; 
    double MinY = 0;

    protected BufferedImage RotacionImagen(int grados, BufferedImage Original, BufferedImage Copia){
        /* Calculo de la matriz */
        int Ty = Original.getWidth()/2;
        int Tx = Original.getHeight()/2;
        double[][] MatOpc = CalculoDeMatriz(grados, Tx, Ty);
        int count = 0;
        Color colorAux = new Color(0, 0, 255);

        
        /* Calculo de tamano de la nueva imagen */
        BufferedImage Lienzo = CalculoTamanoImagen(Copia, grados);
        Lienzo = CleanImagen(Lienzo);

        double[][] Point = new double[1][3];
        int posX = 0;
        int posY = 0;
        
        /* Realizamos las operaciones */
        for(int j = 0; j < Original.getHeight(); j++){
            for(int i = 0; i < Original.getWidth(); i++){
                posX = 0;
                posY = 0;
                Point[0][0] = j;
                Point[0][1] = i; 
                Point[0][2] = 1;
                double[][] tempPoint = CalculoPosicion(Point, MatOpc);
                
                /* Sumanos los valores minimos */
                posX = (int)(tempPoint[0][0] + Math.abs(MinX));
                posY = (int)(tempPoint[0][1] + Math.abs(MinY));
                
                int Pixel = Original.getRGB(i, j);
                Color color = setPixelColor(Pixel);
                
                try {
                    Lienzo.setRGB(posY, posX, color.getRGB());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }

        return Lienzo;
    }
    
    protected double[][] CalculoPosicion(double[][] Point, double[][] MatOpc){
        double[][] finalPoint = new double[1][3];
        int temp = 0;
        /* Multiplicacion de matrices */
        for(int j = 0; j < MatOpc.length; j++){
            for(int i = 0; i < MatOpc.length; i++){
                temp += (int)(MatOpc[i][j] * Point[0][i]);
            }
            finalPoint[0][j] = temp; 
            temp = 0;
                
        }
        
        return finalPoint;
    }
    
    protected BufferedImage CalculoTamanoImagen(BufferedImage Copia, int grados){
        /* Cargamos los puntos extremos  */
        Point[] Points = new Point[4];
        Points[0] = new Point(0, 0);
        Points[1] = new Point(Copia.getHeight()-1, 0);
        Points[2] = new Point(0, Copia.getWidth()-1);
        Points[3] = new Point(Copia.getHeight()-1, Copia.getWidth() - 1);
        Color color = new Color(255, 0, 0);
        
        /*Calculo de nuestros grados */
        double seno = Math.sin(Math.toRadians(grados));
        double cos = Math.cos(Math.toRadians(grados));
        
        double newseno = (double)Math.round(seno * 100000d) / 100000d;
        double newcos = (double)Math.round(cos * 100000d) / 100000d;     
        
        /* Punto central */
        int Tx = (Copia.getHeight() / 2); /* M/2 */
        int Ty = (Copia.getWidth() / 2); /* N/2 */
        
        /* Actualizamos los puntos externos */
        for(int i = 0; i < Points.length; i++){
            double A = Points[i].getX() - Tx;
            double B = Points[i].getY() - Ty;
            double AR = A*newcos - B*newseno;
            double BR = A*newseno + B*newcos;
            Points[i].x = (int)Math.round(AR + Tx);
            Points[i].y = (int)Math.round(BR + Ty);
        } 
        
        /* Puntos minimos */
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        
        for(int i = 0; i < Points.length; i++){
            /* X maxima */
            if(maxX < Points[i].getX()){
                maxX = (int)Points[i].getX();
            }
            
            /* X minima */
            if(minX > Points[i].getX()){
                minX = (int)Points[i].getX();
            }
            
            /* Y maxima */
            if(maxY < Points[i].getY()){
                maxY = (int)Points[i].getY();
            }
            
            /* Y minima */
            if(minY > Points[i].getY()){
                minY = (int)Points[i].getY();
            }
            
        }
        
        MinX = minX; 
        MinY = minY;
        /* Calculo del tamano */
        int width = (maxY - minY) + 1;
        int height = (maxX - minX) + 1;

        Copia = resizeImage(Copia, width, height);   
        return Copia;
    }
    
    protected double[][] CalculoDeMatriz(int grados, int Tx, int Ty){
        double[][] MatOp = new double[3][3];
        /*Calculo de nuestros grados */
        double seno = Math.sin(Math.toRadians(grados));
        double cos = Math.cos(Math.toRadians(grados));
        
        double newseno = (double)Math.round(seno * 100000d) / 100000d;
        double newcos = (double)Math.round(cos * 100000d) / 100000d;  
        
        
        /* Primera Fila */
        MatOp[0][0] = newcos;
        MatOp[1][0] = (-1)*newseno;
        MatOp[2][0] = (-1) * (Tx*newcos) + Ty*newseno + Tx;
        
        /* Segunda fila */
        MatOp[0][1] = newseno;
        MatOp[1][1] = newcos;
        MatOp[2][1] = (-1)*(Tx*newseno) + (-1)*(Ty*newcos) + Ty;
        
        /* Tercera fila */
        MatOp[0][2] = 0;
        MatOp[1][2] = 0;
        MatOp[2][2] = 1;
        
        return MatOp;
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
    
    protected double findMax(double[] array){
        double max = array[0];
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
    
    protected double findMin(double[] array){
        double min = array[0];
        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
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
    
    protected Color setPixelColor(int Pixel){
        int red =   (Pixel & 0x00ff0000) >> 16;
        int green = (Pixel & 0x0000ff00) >> 8;
        int blue =   Pixel & 0x000000ff;
        Color color = new Color(red, green, blue);
        return color;
    }
    
}
