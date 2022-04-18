/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaexercicios.semana8;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author emily
 */
public class questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       int[][] img = ImagemDigital.carregarImagem("./Fig0207(a)(gray-level-band).png");
       //ImagemDigital.plotarImagem(img, "Testando");
        
        
       ArrayList<Integer> listaTons = new ArrayList<Integer>(); // VETOR QUE IRÁ ARMAZENAR TONS DISTINTOS
       
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(!listaTons.contains(img[i][j])){ // VERIFICA SE A IMG[I][J] NÃO ESTÁ CONTIDA NO ARRAYLIST
                    listaTons.add(img[i][j]); // SE NÃO ESTÁ CONTIDA, INSERE NO ARRAYLIST
                }
            }
        }
        System.out.println(listaTons); // EXIBIR OS VALORES QUE FORAM INSERIDOS
    }
    
}
