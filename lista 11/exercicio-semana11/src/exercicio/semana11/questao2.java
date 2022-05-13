/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.semana11;

import java.util.ArrayList;

/**
 *
 * @author emily
 */
public class questao2 {
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig1038(a)(noisy_fingerprint).png");
        int[][] newImg = new int[img.length][img[0].length];
        int g1 = 0, g2 = 0;
        int contG1 = 0, contG2 = 0;
        
        int t = 170;
        int tNovo = t;
        int delta = 6;
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        do{
            for(int i = 0; i < img.length; i++){
                for(int j = 0; j < img[0].length; j++){
                    if(img[i][j] > t){
                        g1 += img[i][j];
                        contG1 += 1;
                    }
                    else{
                        g2 += img[i][j];
                        contG2 += 1;
                    }
                }
            }

            int m1 = g1 / contG1;
            int m2 = g2 / contG2;
            t = tNovo;
            tNovo = (m1 + m2) / 2;

        } while((t - tNovo) > delta);
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(img[i][j] < tNovo){
                    newImg[i][j] = 0;
                }
                else{
                    newImg[i][j] = 255;
                }
            }
        }
        
        ImagemDigital.plotarImagem(newImg, "Imagem Nova");
        
    }
}
