/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaexercicios.semana8;

/**
 *
 * @author emily
 */
public class questao3 {
    public static void main(String[] args) {
       int[][][] img = ImagemDigital.carregarImagemCor("./imagem_rosto.jpg");
       //ImagemDigital.plotarImagemCor(img, "Rosto Colorido");
       
       // QUESTÃO A)
       
       int[][][] imgMenor = new int[200][200][3];
       
       for(int i = 0; i < 200; i++){
           for(int j = 0; j < 200; j++){
                   imgMenor[i][j][0] = img[i + 225][j + 35][0];
                   imgMenor[i][j][1] = img[i + 225][j + 35][1];
                   imgMenor[i][j][2] = img[i + 225][j + 35][2];
           }    
       }
       
       ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor");
       
       // QUESTÃO B)
       
       /**final int constante = 200;
       
       for(int i = 0; i < imgMenor.length; i++){
           for(int j = 0; j < imgMenor[0].length; j++){
                   imgMenor[i][j][2] = Math.min(255, imgMenor[i][j][2] + constante);
           }    
       }
       
       ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor AZUL");**/
       
       // QUESTÃO C)
       
       /**final int constante = 80;
       
       for(int i = 0; i < imgMenor.length; i++){
           for(int j = 0; j < imgMenor[0].length; j++){
                   imgMenor[i][j][0] = Math.min(255, imgMenor[i][j][0] + constante);
                   imgMenor[i][j][1] = Math.min(255, imgMenor[i][j][1] + constante);
                   imgMenor[i][j][2] = Math.min(255, imgMenor[i][j][2] + constante);
           }    
       }
       
       ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor CONSTANTES");**/
       
       // QUESTÃO D)
       
       /**final int constante = -90;
       
       for(int i = 0; i < imgMenor.length; i++){
           for(int j = 0; j < imgMenor[0].length; j++){
                   imgMenor[i][j][0] = Math.max(0, imgMenor[i][j][0] + constante);
                   imgMenor[i][j][1] = Math.max(0, imgMenor[i][j][1] + constante);
                   imgMenor[i][j][2] = Math.max(0, imgMenor[i][j][2] + constante);
           }    
       }
       
       ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor CONSTANTES NEG");**/
       
       // QUESTÃO E)
       
       /**final float constante = (float) 1.9;
       
       for(int i = 0; i < imgMenor.length; i++){
           for(int j = 0; j < imgMenor[0].length; j++){
                   imgMenor[i][j][0] = Math.min(255, (int)(constante * (imgMenor[i][j][0])));
                   imgMenor[i][j][1] = Math.min(255, (int)(constante * (imgMenor[i][j][1])));
                   imgMenor[i][j][2] = Math.min(255, (int)(constante * (imgMenor[i][j][2])));
              
           }    
       }
       
       //ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor com Constante");**/
       
       // QUESTÃO F)
       
       final float constanteMenor = (float) 0.3;
       
       for(int i = 0; i < imgMenor.length; i++){
           for(int j = 0; j < imgMenor[0].length; j++){
                   imgMenor[i][j][0] = Math.max(0, (int)(constanteMenor * (imgMenor[i][j][0])));
                   imgMenor[i][j][1] = Math.max(0, (int)(constanteMenor * (imgMenor[i][j][1])));
                   imgMenor[i][j][2] = Math.max(0, (int)(constanteMenor * (imgMenor[i][j][2])));
              
           }    
       }
       
       ImagemDigital.plotarImagemCor(imgMenor, "Rosto Colorido Menor com Constante Menor");
       
       
    }
}
