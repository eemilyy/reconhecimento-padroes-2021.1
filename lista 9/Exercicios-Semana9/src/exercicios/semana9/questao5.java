/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.semana9;

/**
 *
 * @author emily
 */
public class questao5 {
    
    static void corrigirImagem(int[][] img){
        int max = 0;
        int min = 255;        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                max = Math.max(max, img[i][j]);
                min = Math.min(min, img[i][j]);
            }
        }
        
        System.out.println(max);
        System.out.println(min);
        
        // Correção de escala
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j] = (255 * (img[i][j] -  min))/(max-min);
            }
        }
    } 
    
    public static void main(String[] args) {
        
        int[][] img = ImagemDigital.carregarImagem("./ruido/lena1.png");
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 2; i <= 100; i++){
            int[][] img2 = ImagemDigital.carregarImagem("./ruido/lena" + i + ".png");            
            
            for(int k = 0; k < img.length; k++){
                for(int j = 0; j < img[0].length; j++){
                    img[k][j] = img[k][j] + img2[k][j];
                }
            }
        }
        
        /**for(int i = 2; i <= 10; i++){
            int[][] img2 = ImagemDigital.carregarImagem("./ruido/lena" + i + ".png");            
            
            for(int k = 0; k < img.length; k++){
                for(int j = 0; j < img[0].length; j++){
                    img[k][j] = img[k][j] + img2[k][j];
                }
            }
        }**/
        
        corrigirImagem(img);
        ImagemDigital.plotarImagem(img, "Media 100");
        //int[][] img = ImagemDigital.carregarImagem("./imagens/lena_gray_512.png");
    }
}
