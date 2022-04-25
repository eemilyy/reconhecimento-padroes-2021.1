/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.semana9;

/**
 *
 * @author emily
 */
public class questao4 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0230(a)(dental_xray).png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/Fig0230(b)(dental_xray_mask).png");        
        int[][] img3 = ImagemDigital.carregarImagem("./imagens/newMask.png"); // NOVA MASCARA    
        int [][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        ImagemDigital.plotarImagem(img2, "Imagem 2");
        
        // REALIZANDO O PRODUTO DAS IMAGENS        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j] = (img[i][j]) * (img3[i][j]);
            }
        }
        
        corrigirImagem(newImg);
        ImagemDigital.plotarImagem(newImg, "Produto das imagens");
    }
}
