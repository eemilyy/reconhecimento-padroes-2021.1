/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0309(a)(washed_out_aerial_image).png");
        int[][] newImg = new int[img.length][img[0].length];
        int[][] newImg2 = new int[img.length][img[0].length];
        int[][] newImg3 = new int[img.length][img[0].length];
        
               
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j] = (int) (Math.pow(254, 1 - 3) * (Math.pow(img[i][j], 3)));
                newImg2[i][j] = (int) (Math.pow(254, 1 - 4) * (Math.pow(img[i][j], 4)));
                newImg3[i][j] = (int) (Math.pow(254, 1 - 5) * (Math.pow(img[i][j], 5)));
            }
        }
        
        corrigirImagem(newImg);
        corrigirImagem(newImg2);
        corrigirImagem(newImg3);
        ImagemDigital.plotarImagem(newImg, "Imagem Gama 3");
        ImagemDigital.plotarImagem(newImg2, "Imagem Gama 4");
        ImagemDigital.plotarImagem(newImg3, "Imagem Gama 5");
    }
}
