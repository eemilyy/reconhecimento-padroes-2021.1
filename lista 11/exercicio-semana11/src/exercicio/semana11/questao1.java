/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio.semana11;

/**
 *
 * @author emily
 */
public class questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0308(a)(fractured_spine).png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
        
        int vetorHistograma[] = new int[256];
        int vetorAcumulado[] = new int[256];
        int vetorCores[] = new int[256];

         for(int i = 0; i < img.length; i++){
             for(int j = 0; j < img[0].length; j++){
                 vetorHistograma[img[i][j]] += 1;
             }
         }
         vetorAcumulado[0] = vetorHistograma[0];
         for(int i = 1; i < 256; i++){
             vetorAcumulado[i] = vetorHistograma[i] + vetorAcumulado[i-1];
         }

         int pixels = img.length * img[0].length;
         for(int i = 0; i < 256; i++){
             vetorCores[i] = (int) Math.round(((vetorAcumulado[i] - 1.0) / (pixels - 1.0)) * 255);
         }

         for(int i = 0; i < img.length; i++){
             for(int j = 0; j < img[0].length; j++){
                 newImg[i][j] = vetorCores[img[i][j]];
             }
         }
         
         ImagemDigital.plotarImagem(newImg, "Imagem Nova");
         
         PlotarGrafico p1 = new PlotarGrafico(vetorHistograma);
         PlotarGrafico p2 = new PlotarGrafico(vetorCores);      
         
    }
    
}
