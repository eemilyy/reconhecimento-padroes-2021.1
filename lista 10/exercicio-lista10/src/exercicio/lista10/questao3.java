/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao3 {
    
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
    
    public static double log(double base, double valor) {
        return Math.log(valor) / Math.log(base);
    }
    
    public static void main(String[] args) {
        
        // FALTA FAZEEEEEEEEEEEEEERRRRRRRRRRRR
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0308(a)(fractured_spine).png");
        int[][] newImg = new int[img.length][img[0].length];
        int[][] newImg2 = new int[img.length][img[0].length];
        int[][] newImg3 = new int[img.length][img[0].length];

        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j] = (int) ((double)((255 - 1) / log(0.6, 255) * Math.log(1 + img[i][j]))); // c*log(1+r)
                newImg2[i][j] = (int) ((255 - 1) / log(255, 0.5) * Math.log(1 + img[i][j]));
                newImg3[i][j] = (int) ((255 - 1) / log(255, 0.4) * Math.log(1 + img[i][j]));
                //newImg3[i][j] = (int) ((255 - 1 / log(img[i][j], 0.4) * Math.log(1 + img[i][j])));
            }
        }
        
        corrigirImagem(newImg);
        corrigirImagem(newImg2);
        corrigirImagem(newImg3);
        ImagemDigital.plotarImagem(newImg, "Imagem Gama 0.6");
        //ImagemDigital.plotarImagem(newImg2, "Imagem Gama 0.5");
        //ImagemDigital.plotarImagem(newImg3, "Imagem Gama 0.4");
    }
    
}
