
package tercerexamenpdi.Punto_2;

import MetodosGenerales.RGB;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Metodos {
    protected BufferedImage EscaladoInterpolacionLineal(BufferedImage Original, BufferedImage Copia, int factor){
        int width = factor * Original.getWidth(); 
        int height = factor * Original.getHeight();
        BufferedImage Lienzo = resizeImage(Copia, width, height);
        Lienzo = CleanImagen(Lienzo);
        BufferedImage Resultante = null;
        
        switch(factor){
            case 2:
                Resultante = CalculoEscalado2Larange(Original, Lienzo, factor);
            break;
            
            case 3:
                Resultante = CalculoEscaladoLarange(Original, Lienzo, factor);
            break;
            
            case 4:
                Resultante = CalculoEscaladoLarange(Original, Lienzo, factor);
            break;
            
            case 5:
                Resultante = CalculoEscaladoLarange(Original, Lienzo, factor);
            break;
        }
        return Resultante;
    }
    
    protected BufferedImage CalculoEscalado2(BufferedImage Original, BufferedImage Lienzo, int factor){
        int valA;
        int valB;
        
        int subi = 0;
        int subj = 0;
        
        /* Escalamos la imagen, pero sin los pixeles intermedios */
        
        /* Recorremos por filas y columnas */
        for(int i = 0; i < Original.getWidth() - 2; i++){
            for(int j = 0; j < Original.getHeight() - 2; j++){
               /* Aplicamos Larange */
               valA = Lienzo.getRGB(j, i);
               valB = Lienzo.getRGB(j+2, i);
               int norte = (int)CalculoLagrange(0, 2, valA, valB, 1);
               Lienzo.setRGB(subj+1, subi, norte);
               
               /* Oeste */
               valA = Lienzo.getRGB(j, i);
               valB = Lienzo.getRGB(j, i+2);
               int oeste = (int)CalculoLagrange(0, 2, valA, valB, 1);
               
               /* Este */
               valA = Lienzo.getRGB(j+2, i);
               valB = Lienzo.getRGB(j+2, i+2);
               int este = (int)CalculoLagrange(0, 2, valA, valB, 1);
               Lienzo.setRGB(subj+2, subi+1, este);
               
               /* Sur */
               valA = Lienzo.getRGB(j, i+2);
               valB = Lienzo.getRGB(j+2, i+2);
               int sur = (int)CalculoLagrange(0, 2, valA, valB, 1);
               Lienzo.setRGB(subj+1, subi+2, sur);
               
               /* Calculo pixel central */
               /*Diagonal izquierda superior a derecha inferior*/
               valA = Lienzo.getRGB(j, i);
               valB = Lienzo.getRGB(j+2, i+2);
               int tempA = (int)CalculoLagrange(0, 2, valA, valB, 1);
               
               /*Diagonal izquierda inferior a derecha superior*/
               valA = Lienzo.getRGB(j, i+2);
               valB = Lienzo.getRGB(j+2, i);
               int tempB = (int)CalculoLagrange(0, 2, valA, valB, 1);
               
               int prom = (tempA + tempB)/2;
               
               subi+= factor;
            }
            subi = 0;
            subj += factor;

        }
        return Lienzo;
    }
    
    protected BufferedImage CalculoEscalado2Larange(BufferedImage Original, BufferedImage Lienzo, int factor){
        Lienzo = CleanImagen(Lienzo);
        BufferedImage LienzoFinal = setPivotPoints(Original, Lienzo, factor);
        int valA;
        int valB;
        Color color;
        
        for(int i = 0; i < LienzoFinal.getWidth()-2; i += 2){
            for(int j = 0; j < LienzoFinal.getHeight()-2; j += 2){
                
                /* Norte */
                valA = LienzoFinal.getRGB(i, j);
                valB = LienzoFinal.getRGB(i+2, j);
                int norte = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorNorte = setPixelColor(norte);
                LienzoFinal.setRGB(i+1, j, colorNorte.getRGB());
                
                /* Oeste */
                valA = LienzoFinal.getRGB(i, j);
                valB = LienzoFinal.getRGB(i, j+2);
                int oeste = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorOeste = setPixelColor(oeste);
                LienzoFinal.setRGB(i, j+1, colorOeste.getRGB());
                
                /* Este */
                valA = LienzoFinal.getRGB(i+2, j);
                valB = LienzoFinal.getRGB(i+2, j+2);
                int este = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorEste = setPixelColor(este);
                LienzoFinal.setRGB(i+2, j+1, colorEste.getRGB());
                
                /* Sur */
                valA = LienzoFinal.getRGB(i, j+2);
                valB = LienzoFinal.getRGB(i+2, j+2);
                int sur = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorSur = setPixelColor(sur);
                LienzoFinal.setRGB(i+1, j+2, colorSur.getRGB());
                
                /* Central */
                /*Diagonal izq sup a der inf*/
                valA = LienzoFinal.getRGB(i, j);
                valB = LienzoFinal.getRGB(i+2, j+2);
                int tempA = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorTempA = setPixelColor(tempA);
                
                /*Diagonal izq inf a der sep*/
                valA = LienzoFinal.getRGB(i, j+2);
                valB = LienzoFinal.getRGB(i+2, j);
                int tempB = CalculoLagrange(0, 2, valA, valB, 1);
                Color colorTempB = setPixelColor(tempB);
                
                Color colorCentro = ColorPromedio(colorTempA, colorTempB);
                LienzoFinal.setRGB(i+1, j+1, colorCentro.getRGB());                
            }
        }
        return LienzoFinal;
    }
    
    protected BufferedImage CalculoEscaladoLarange(BufferedImage Original, BufferedImage Lienzo, int factor){
        Lienzo = CleanImagen(Lienzo);
        BufferedImage LienzoFinal = setPivotPoints(Original, Lienzo, factor);
        Color color;
        System.out.println("Operacion de cuantos pixeles sobras");
        System.out.println("Ancho: " + LienzoFinal.getWidth()%factor);
        System.out.println("Alto: " + LienzoFinal.getHeight()%factor);
        
        
        for(int i = 0; i < LienzoFinal.getWidth() - factor; i+= factor){
            for(int j = 0; j < LienzoFinal.getHeight() - factor ; j += factor){
                
                /* Tomamos los pivotes */
                int PivotA = LienzoFinal.getRGB(i, j);
                int PivotB = LienzoFinal.getRGB(i+factor, j);
                int PivotC = LienzoFinal.getRGB(i, j+factor);
                int PivotD = LienzoFinal.getRGB(i+factor, j+factor);
                
                /* Rellanamos nuestra matriz auxiliar */
                int[][] MatAux = new int[factor+1][factor+1];
                int mati = 0; 
                int matj = 0;
                
                /* Rellenamos la matriz auxiliar */
                for(int subi = i; subi < i + (MatAux.length -1); subi++){
                    for(int subj = j; subj < j + (MatAux.length - 1); subj++){
                        MatAux[mati][matj] = LienzoFinal.getRGB(subi, subj);
                        matj++;
                    }
                    matj = 0;
                    mati++;
                }
                
                mati = 0;
                matj = 0;
                /* Calculamos los colores para los pixeles de la matriz */
                MatAux = CalculoPartes(MatAux, PivotA, PivotB, PivotC, PivotD, factor);
                
                /* Recorremos la matriz para asginar los valores de nuestra matriz */
                for(int subi = i; subi < i + (MatAux.length - 1); subi++){
                    for(int subj = j; subj < j + (MatAux.length - 1); subj++){
                        color = setPixelColor(MatAux[mati][matj]);
                        LienzoFinal.setRGB(subi, subj, color.getRGB());
                        matj++;
                    }
                    matj = 0;
                    mati++;
                }
                
            }
        }
        return LienzoFinal;
    }
    
    protected Color ColorPromedio(Color A1, Color A2){
        int promRed = (A1.getRed() + A2.getRed())/2;
        int promGreen = (A1.getGreen() + A2.getGreen())/2;
        int promBlue = (A1.getBlue() + A2.getBlue())/2;
        
        Color Prom = new Color(promRed, promGreen, promBlue);     
        return Prom;       
    }
    
    protected int[][] CalculoPartes(int[][] Mat, int PivotA, int PivotB, int PivotC, int PivotD, int factor){
        int valA;
        int valB;
        int tam = Mat.length - 1;
        Color color;
        Color Aux = new Color(0, 0, 255);
        Color Aux2 = new Color(255, 0, 0);
        
        /* Parte Norte */
        for(int i = 1; i < Mat.length - 1; i++){
            valA = PivotA;
            valB = PivotB;
            int norte = CalculoLagrange(0, Mat.length, valA, valB, i);
            color = setPixelColor(norte);
            /* Guardamos el valor entero del pixel */
            Mat[i][0] = color.getRGB();
        }
        
        /* Parte Oeste */
        for(int i = 0; i < 1; i++){
            for(int j = 1; j < tam; j++){
                valA = PivotA; 
                valB = PivotC; 
                int oeste = CalculoLagrange(0, Mat.length, valA, valB, j);
                color = setPixelColor(oeste);
                /* Guadamos el color */
                Mat[i][j] = color.getRGB();
            }
        }
        
        /* Parte Este */
        for(int i = tam; i < tam + 1; i++){
            for(int j = 1; j < tam; j++){
                valA = PivotB;
                valB = PivotD;
                int este = CalculoLagrange(0, Mat.length, valA, valB, j);
                color = setPixelColor(este);
                Mat[i][j] = color.getRGB();
            }
        }
        
        /* Parte Sur */
        for(int i = 1; i < tam; i++){
            valA = PivotC;
            valB = PivotD;
            int sur = CalculoLagrange(0, Mat.length, valA, valB, i);
            color = setPixelColor(sur);
            Mat[i][Mat.length - 1] = color.getRGB();
        }
        
        
        /* Parte Central */
        /* Calculo del tamano 3*/
        if(factor == 3){
            /* Diagonal izq sup a der inf  */
            valA = PivotA; 
            valB = PivotD; 
            int central_1 = CalculoLagrange(0, Mat.length, valA, valB, 1);
            color = setPixelColor(central_1);
            Mat[1][1] = color.getRGB();
            
            int central_2 = CalculoLagrange(0, Mat.length, valA, valB, 2);
            color = setPixelColor(central_2);
            Mat[2][2] = color.getRGB();
            
            /* Diagonal izq inf a der sup  */
            valA = PivotC; 
            valB = PivotB; 
            int central_3 = CalculoLagrange(0, Mat.length, valA, valB, 1);
            color = setPixelColor(central_3);
            Mat[1][2] = color.getRGB();
            
            int central_4 = CalculoLagrange(0, Mat.length, valA, valB, 2);
            color = setPixelColor(central_4);
            Mat[2][1] = color.getRGB();  
        }
        
        /* Centro para el tamano 4*/
        if(factor == 4){
            int subi = 1;
            int subj = 1;
            
            /* Diagonal de izq supr a der inf*/
            valA = PivotA;
            valB = PivotD;
            
            for(int i = 1; i < 4; i++){
                int central = CalculoLagrange(0, Mat.length, valA, valB, i);
                color = setPixelColor(central);
                Mat[subi][subj] = color.getRGB();
                subi++;
                subj++;
            }
            
            valA = PivotC;
            valB = PivotB;
            subi = 1;
            subj = 3;
            /* Diagonal de izq inf a der sup*/
            for(int i = 1; i < 4; i++){
                int central = CalculoLagrange(0, Mat.length, valA, valB, i);
                color = setPixelColor(central);
                Mat[subi][subj] = color.getRGB();
                subi++;
                subj--;
            }
            
            /* Pixeles remanente */
            /* Remanente Oeste */
            valA = Mat[1][1];
            valB = Mat[1][3];
            int RemanenteOeste = CalculoLagrange(0, 2, valA, valB, 1);
            color = setPixelColor(RemanenteOeste);
            Mat[1][2] = color.getRGB();
            
            /* Remanente este */
            valA = Mat[3][1];
            valB = Mat[3][3];
            int RemanenteEste = CalculoLagrange(0, 2, valA, valB, 1);
            color = setPixelColor(RemanenteEste);
            Mat[3][2] = color.getRGB();
            
            /* Remanente Norte */
            valA = Mat[1][1];
            valB = Mat[3][1];
            int RemanenteNorte = CalculoLagrange(0, 2, valA, valB, 1);
            color = setPixelColor(RemanenteNorte);
            Mat[2][1] = color.getRGB();
            
            /* Remanente Sur */
            valA = Mat[1][3];
            valB = Mat[3][3];
            int RemanenteSur = CalculoLagrange(0, 2, valA, valB, 1);
            color = setPixelColor(RemanenteSur);
            Mat[2][3] = color.getRGB();
        }
        
        /* Centro el tamano 5*/
        if(factor == 5){
            /* factores  */
            int subi = 1;
            int subj = 1;
            
            
            /*Calcula para la diagonal de izq sup a derecha inf */
            valA = PivotA;
            valB = PivotD;
            
            for(int i = 1; i < 5; i++){
                int central = CalculoLagrange(0, Mat.length, valA, valB, i);
                color = setPixelColor(central);
                Mat[subi][subj] = color.getRGB();
                subi++;
                subj++;
            }
            
            
            /*Calcula para la diagonal de izq inf a derecha sup */
            valA = PivotC;
            valB = PivotB;
            
            subi = 1;
            subj = 4;
            
            for(int i = 1; i < 5; i++){
                int central = CalculoLagrange(0, Mat.length, valA, valB, i);
                color = setPixelColor(central);
                Mat[subi][subj] = color.getRGB();
                subi++;
                subj--;
            }
            

            /* Calculo para los pixeles remanentes */
            /* Remanentes Oeste*/
            valA = Mat[1][1];
            valB = Mat[1][4];
            subi = 1; 
            subj = 2; 
            for(int i = 1; i < 3; i++){
                int Oeste = CalculoLagrange(0, 3, valA, valB, i);
                color = setPixelColor(Oeste);
                Mat[subi][subj] = color.getRGB();
                subj++;
            }
            
            /* Remanentes Este*/
            valA = Mat[4][1];
            valB = Mat[4][4];
            subi = 4;
            subj = 2; 
            for(int i = 1; i < 3; i++){
                int Este = CalculoLagrange(0, 3, valA, valB, i);
                color = setPixelColor(Este);
                Mat[subi][subj] = color.getRGB();
                subj++;
            }
            
            /* Remanentes Norte */
            valA = Mat[1 ][1];
            valB = Mat[4][1];
            subi = 2;
            subj = 1; 
            for(int i = 1; i < 3; i++){
                int Norte = CalculoLagrange(0, 3, valA, valB, i);
                color = setPixelColor(Norte);
                Mat[subi][subj] = color.getRGB();
                subi++;
            }
            
            /* Remanentes Sur */
            valA = Mat[1][4];
            valB = Mat[4][4];
            subi = 2;
            subj = 4;
            for(int i = 1; i < 3; i++){
                int Norte = CalculoLagrange(0, 3, valA, valB, i);
                color = setPixelColor(Norte);
                Mat[subi][subj] = color.getRGB();
                subi++;                
            }
            
        }
        
        return Mat;
        
    }
    
    protected int CalculoLagrange(int x0, int x1, int F0, int F1, int x){
        double L0 = ((double)x - (double)x1)/((double)x0 - (double)x1);
        double L1 = ((double)x - (double)x0)/((double)x1 - (double)x0);
        
        /*Creamos los colores */
        Color F0_c = setPixelColor(F0);
        Color F1_c = setPixelColor(F1);
 
        /* Aplicamos la formula para cada canal */
        double Red  = Math.round((F0_c.getRed() * L0 ) + ( F1_c.getRed() * L1 ));
        double Green = Math.round((F0_c.getGreen()*L0 ) + ( F1_c.getGreen() * L1 ));
        double Blue = Math.round((F0_c.getBlue()*L0 ) + ( F1_c.getBlue() * L1 ));
        
        /* Cortamos los valores en caso se sobrepadas el limite de 0 < x < 255 */
        Red = Red < 0 ? 0 : Red > 255 ? 255 : Red; 
        Green = Green < 0 ? 0 : Green > 255 ? 255 : Green; 
        Blue = Blue < 0 ? 0 : Blue > 255 ? 255 : Blue; 

        /* Color */
        Color newPixel = new Color((int)Red, (int)Green, (int)Blue);
        return newPixel.getRGB();
    }
    
    protected BufferedImage setPivotPoints(BufferedImage Original, BufferedImage Copia, int factor){
        int subimgi = 0;
        int subimgj = 0;
        
        for(int i = 0; i < Original.getWidth(); i++){
            for(int j = 0; j < Original.getHeight(); j++){
                /* Pintamos los pixeles segun la separacion del factor */
                int pixel = Original.getRGB(i, j);
                for(int subi = subimgi; subi < factor + subimgi; subi++ ){
                    for(int subj = subimgj; subj < factor + subimgj; subj++){
                        if(subi == subimgi && subj == subimgj){
                            /* El pivote se pinta de su color original */
                            Color colorPixel = setPixelColor(pixel);
                            Copia.setRGB(subi, subj, colorPixel.getRGB());  
                        }else{
                            /* Los espacios entre los pixeles pivote se pinta de blanco puro*/
                            Color color = new Color(0, 255, 0);
                            Copia.setRGB(subi, subj, color.getRGB());
                        }
                    }
                }
                subimgj += factor;
            }
            subimgj = 0;
            subimgi += factor;
        }
        return Copia;
    }
 
    protected Color setPixelColor(int Pixel){
        int red =   (Pixel & 0x00ff0000) >> 16;
        int green = (Pixel & 0x0000ff00) >> 8;
        int blue =   Pixel & 0x000000ff;
        Color color = new Color(red, green, blue);
        return color;
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
}

