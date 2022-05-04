/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao5 {
    
    static void corrigirImagem(int[][][] img){
        int max = 0;
        int min = 255;        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                max = Math.max(max, img[i][j][0]);
                min = Math.min(min, img[i][j][1]);
                min = Math.min(min, img[i][j][2]);
            }
        }
        
        System.out.println(max);
        System.out.println(min);
        
        // Correção de escala
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j][0] = (255 * (img[i][j][0] -  min))/(max-min);
                img[i][j][1] = (255 * (img[i][j][1] -  min))/(max-min);
                img[i][j][2] = (255 * (img[i][j][2] -  min))/(max-min);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][][] img = ImagemDigital.carregarImagemCor("./imagens/a4d88a27b6e6f33558a8e675b742-1458995.jpg");
        int[][][] newImg = new int[img.length][img[0].length][3];
        
        ImagemDigital.plotarImagemCor(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j][0] = (int) (Math.pow(254, 1 - 3) * (Math.pow(img[i][j][0], 3)));
                newImg[i][j][1] = (int) (Math.pow(254, 1 - 3) * (Math.pow(img[i][j][1], 3)));
                newImg[i][j][2] = (int) (Math.pow(254, 1 - 3) * (Math.pow(img[i][j][2], 3)));
            }
        }
        corrigirImagem(newImg);
        ImagemDigital.plotarImagemCor(newImg, "Nova Imagem");
    }
}
