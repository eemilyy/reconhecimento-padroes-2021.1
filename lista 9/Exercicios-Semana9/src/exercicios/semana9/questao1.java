/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios.semana9;


/**
 *
 * @author emily
 */
public class questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/lena_gray_512.png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/mandril_gray.png");
        int[][] newImg25 = new int[512][512];
        int[][] newImg50 = new int[512][512];
        int[][] newImg75 = new int[512][512];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        ImagemDigital.plotarImagem(img2, "Imagem 2");
        
        for(int i = 0; i < 512; i++){
           for(int j = 0; j < 512; j++){
                   newImg25[i][j] = (int) ((0.25 * img[i][j]) + ((1 - 0.25) * img2[i][j]));
                   newImg50[i][j] = (int) ((0.50 * img[i][j]) + ((1 - 0.50) * img2[i][j]));
                   newImg75[i][j] = (int) ((0.75 * img[i][j]) + ((1 - 0.75) * img2[i][j]));
           }    
       }
        
        ImagemDigital.plotarImagem(newImg25, "INTERPOLAÇÃO 1 0.25");
        ImagemDigital.plotarImagem(newImg50, "INTERPOLAÇÃO 1 0.50");
        ImagemDigital.plotarImagem(newImg75, "INTERPOLAÇÃO 1 0.75");
        
    }
    
}
