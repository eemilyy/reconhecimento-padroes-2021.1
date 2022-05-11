/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio.semana11;

import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author emily
 */
public class PlotarGrafico extends JFrame{
    public PlotarGrafico(int[] vet){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("PlotarGrafico");
        setSize(400,400);
        setLocationRelativeTo(null);
        plotarHistograma(vet);
        setVisible(true);
    }
    
    public void plotarHistograma(int[] dataArray){

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(int i = 0; i < dataArray.length; i++){
            dataSet.addValue(dataArray[i], "", (Integer) i);         
        }        
         
        JFreeChart chart = ChartFactory.createBarChart("Histograma da imagem", "",
            "", dataSet, PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.WHITE);
        
        ChartPanel painel =  new ChartPanel(chart);
        add(painel);
    }
}
