/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaexercicios.semana8;

/**
 *
 * @author emily
 */
public class questao2 {
    public static void main(String[] args) {
        
        int[][] img1 = new int[300][300]; // CRIANDO AS IMAGENS COM TAMANHO
        int[][] img2 = new int[300][300];
        int[][] img3 = new int[300][300];
        
        for(int i = 0; i < img1.length; i++){ // PERCORRENDO A IMAGEM
           for(int j = 0; j < img1.length; j++){
               if(j >= 100 && j <= 200 && i >= 100 && i <= 200){ // VERIFICANDO SE ESTÁ DENTRO DO MEIO DA IMAGEM
                   img1[i][j] = 128; // INSERINDO 128 PARA TODAS AS IMG
                   img2[i][j] = 128;
                   img3[i][j] = 128;
               }
               else{ // CASO CONTRARIO, INSERIR OS DEMAIS VALOES PARA OS OUTROS PIXELS DA IMG
                   img1[i][j] = 0;
                   img2[i][j] = 64;
                   img3[i][j] = 192;
               }
           }
        }
        
        ImagemDigital.plotarImagem(img1, "Imagem 1");
        ImagemDigital.plotarImagem(img2, "Imagem 2");
        ImagemDigital.plotarImagem(img3, "Imagem 3");
    }
    
}
