/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.semana9;

/**
 *
 * @author emily
 */
public class questao2 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0228(a)(angiography_mask_image).png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/Fig0228(b)(angiography_live_ image).png");
        int[][] newImg = new int[420][420];
        int[][] newImg2 = new int[420][420];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        ImagemDigital.plotarImagem(img2, "Imagem 2");  
        
        // SUBTRAINDO PRIMEIRA IMAGEM PELA SEGUNDA       
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j] = (img[i][j] - img2[i][j]);
            }
        }
        
        // SUBTRAINDO SEGUNDA IMAGEM PELA PRIMEIRA
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg2[i][j] = (img2[i][j] - img[i][j]);
            }
        }
       
        corrigirImagem(newImg);
        corrigirImagem(newImg2);
        ImagemDigital.plotarImagem(newImg, "1 SUBTRAÇÃO");
        ImagemDigital.plotarImagem(newImg2, "2 SUBTRAÇÃO");
        
    }
}
