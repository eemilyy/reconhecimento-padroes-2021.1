/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao1 {

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
     
     //-------------------------------------------------------------------
    
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0304(a)(breast_digital_Xray).png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
                
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j] = (255 - 1) - img[i][j];
            }
        }
        corrigirImagem(newImg);
        ImagemDigital.plotarImagem(newImg, "Nova imagem");
    }
    
}
