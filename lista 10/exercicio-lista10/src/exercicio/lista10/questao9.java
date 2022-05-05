/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao9 {
    
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
        int[][] imgSig = new int[img.length][img[0].length];
        
        String binario = "";
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                binario = String.format("%8s", Integer.toBinaryString(img[i][j])).replace(' ', '0');
                imgSig[i][j] = (int)((Math.pow(2,7) *  Character.getNumericValue(binario.charAt(0))) + (Math.pow(2,6) *  Character.getNumericValue(binario.charAt(1))));
            }
        }        
        questao1.corrigirImagem(imgSig);
        
        ImagemDigital.plotarImagem(imgSig,"Imagem Plano Significativo 1");
    }
}
