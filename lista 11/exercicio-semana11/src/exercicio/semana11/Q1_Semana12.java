/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.semana11;

/**
 *
 * @author emily
 */
public class Q1_Semana12 {
    
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
        
       int[][] img = ImagemDigital.carregarImagem("./imagens/LUA.png");
       int[][] novaImg1 = new int[img.length][img[0].length];
       int[][] novaImg2 = new int[img.length][img[0].length];
      
       int[][] m1 = {{0,-1, 0}, {-1, 4, -1}, {0, -1, 0}};
       int[][] m2 = {{-1,-1, -1}, {-1, 8, -1}, {-1, -1, -1}};
       
       
       ImagemDigital.plotarImagem(img, "Imagem Lua");
       
       for(int i = 1; i < (img.length - 1); i++){
           for(int j = 1; j < (img[0].length - 1); j++){
                int t = 0;
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        t += img[i + x][j + y] * m1[x + 1][y + 1];
                    }
                }
            novaImg1[i][j] = img[i][j] + t;
           }    
       }
       
       for(int i = 1; i < (img.length - 1); i++){
           for(int j = 1; j < (img[0].length - 1); j++){
                int t = 0;
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        t += img[i + x][j + y] * m2[x + 1][y + 1];
                    }
                }
            novaImg2[i][j] = img[i][j] + t;
           }    
       }
       
        corrigirImagem(novaImg1);
        corrigirImagem(novaImg2);
        ImagemDigital.plotarImagem(novaImg1, "Primeira Mascara");
        ImagemDigital.plotarImagem(novaImg2, "Segunda Mascara");
    }
}
