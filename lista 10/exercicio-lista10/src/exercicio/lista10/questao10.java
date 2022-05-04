/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao10 {
    
    static void corrigirImagem(int[][][] img){
        int max0 = 0, max1 = 0, max2 = 0;
        int min0 = 255, min1 = 255, min2 = 255;        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                max0 = Math.max(max0, img[i][j][0]);
                max1 = Math.max(max1, img[i][j][1]);
                max2 = Math.max(max2, img[i][j][2]);
                min0 = Math.min(min0, img[i][j][0]);
                min1 = Math.min(min1, img[i][j][1]);
                min2 = Math.min(min2, img[i][j][2]);
            }
        }
        
        // Correção de escala
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j][0] = (255 * (img[i][j][0] -  min0))/(max0-min0);
                img[i][j][1] = (255 * (img[i][j][1] -  min1))/(max1-min1);
                img[i][j][2] = (255 * (img[i][j][2] -  min2))/(max2-min2);
            }
        }
    }
    
    public static void main(String[] args) {
        //questão (a)
        /*int[][][] img = ImagemDigital.carregarImagemCor("./imagens/Floresta.png");
        int[][][] newImg = new int[img.length][img[0].length][3];
        
        double gama = 0.6;
        
        ImagemDigital.plotarImagemCor(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j][0] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][0], gama)));
                newImg[i][j][1] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][1], gama)));
                newImg[i][j][2] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][2], gama)));
            }
        }
        corrigirImagem(newImg);
        ImagemDigital.plotarImagemCor(newImg, "Nova Imagem");*/
        
        //questão (b) PODERIA SER COM FATIAMENTO DE BITS
        /*int[][] img = ImagemDigital.carregarImagem("./imagens/Celula.png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(img[i][j] < 110){
                    newImg[i][j] = 0;
                }
                else{
                    newImg[i][j] = 255;
                }
            }
        }
        
        ImagemDigital.plotarImagem(newImg, "Nova Imagem");*/
        
        
        //questão (c)
        /*int[][][] img = ImagemDigital.carregarImagemCor("./imagens/GorisRaioni.jpg");
        int[][][] newImg = new int[img.length][img[0].length][3];
        
        double gama = 3.0;
        
        ImagemDigital.plotarImagemCor(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg[i][j][0] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][0], gama)));
                newImg[i][j][1] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][1], gama)));
                newImg[i][j][2] = (int) (Math.pow(254, 1 - gama) * (Math.pow(img[i][j][2], gama)));
            }
        }
        corrigirImagem(newImg);
        ImagemDigital.plotarImagemCor(newImg, "Nova Imagem");*/
        
        //questão (d)
        int[][] img = ImagemDigital.carregarImagem("./imagens/Cérebro.png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(img[i][j] < 170){
                    newImg[i][j] = 0;
                }
                else{
                    newImg[i][j] = 255;
                }
            }
        }
        
        ImagemDigital.plotarImagem(newImg, "Nova Imagem");
    }
}
