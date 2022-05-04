/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.lista10;

/**
 *
 * @author emily
 */
public class questao7 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0312(a)(kidney).png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                
                if(img[i][j] >= 100 && img[i][j] <= 150){
                    newImg[i][j] = 153;
                }
                else{
                     newImg[i][j] = 25;
                }
                
                /**if(img[i][j] >= 120 && img[i][j] <= 135){
                    newImg[i][j] = 204;
                }
                else{
                    newImg[i][j] = img[i][j];
                }**/
            }
        }
        
        ImagemDigital.plotarImagem(newImg, "Imagem Nova");
    }
}
