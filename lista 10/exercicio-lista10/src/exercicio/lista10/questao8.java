/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao8 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0314(a)(100-dollars).png");
        int[][] plano0 = new int[img.length][img[0].length];
        int[][] plano1 = new int[img.length][img[0].length];
        int[][] plano2 = new int[img.length][img[0].length];
        int[][] plano3 = new int[img.length][img[0].length];
        int[][] plano4 = new int[img.length][img[0].length];
        int[][] plano5 = new int[img.length][img[0].length];
        int[][] plano6 = new int[img.length][img[0].length];
        int[][] plano7 = new int[img.length][img[0].length];
        String binario = "";
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                binario = String.format("%8s", Integer.toBinaryString(img[i][j])).replace(' ', '0');
                
                plano0[i][j] = (int)(Math.pow(2,7) *  Character.getNumericValue(binario.charAt(0)));
                plano1[i][j] = (int)(Math.pow(2,6) *  Character.getNumericValue(binario.charAt(1)));
                plano2[i][j] = (int)(Math.pow(2,5) *  Character.getNumericValue(binario.charAt(2)));
                plano3[i][j] = (int)(Math.pow(2,4) *  Character.getNumericValue(binario.charAt(3)));
                plano4[i][j] = (int)(Math.pow(2,3) *  Character.getNumericValue(binario.charAt(4)));
                plano5[i][j] = (int)(Math.pow(2,2) *  Character.getNumericValue(binario.charAt(5)));
                plano6[i][j] = (int)(Math.pow(2,1) *  Character.getNumericValue(binario.charAt(6)));
                plano7[i][j] = (int)(Math.pow(2,0) *  Character.getNumericValue(binario.charAt(7)));

            }
        }
        
        questao1.corrigirImagem(plano0);
        questao1.corrigirImagem(plano1);
        questao1.corrigirImagem(plano2);
        questao1.corrigirImagem(plano3);
        questao1.corrigirImagem(plano4);
        questao1.corrigirImagem(plano5);
        questao1.corrigirImagem(plano6);
        questao1.corrigirImagem(plano7);
        
        ImagemDigital.plotarImagem(plano0,"Imagem Plano 1");
        ImagemDigital.plotarImagem(plano1,"Imagem Plano 2");
        ImagemDigital.plotarImagem(plano2,"Imagem Plano 3");
        ImagemDigital.plotarImagem(plano3,"Imagem Plano 4");
        ImagemDigital.plotarImagem(plano4,"Imagem Plano 5");
        ImagemDigital.plotarImagem(plano5,"Imagem Plano 6");
        ImagemDigital.plotarImagem(plano6,"Imagem Plano 7");
        ImagemDigital.plotarImagem(plano7,"Imagem Plano 8");
        
    }
   
}
