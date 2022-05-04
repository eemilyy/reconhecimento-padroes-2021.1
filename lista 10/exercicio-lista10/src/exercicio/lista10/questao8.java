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
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0314(a)(100-dollars).png");
        int[][] newImg = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem 1");
    }
   
}
