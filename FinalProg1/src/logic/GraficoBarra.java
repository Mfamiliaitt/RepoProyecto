package logic;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra {
	 JPanel panel;
	 
	    /*public Ventana2(){
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }*/
		 public GraficoBarra() {
			
		}
			
	  public JPanel init() {
	        panel = new JPanel();
	        panel.setLayout(new BorderLayout(0, 0));
	       // getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(Empresa.getInstance().dameGanancia(), "Perdidas", "Lunes");
	        dataset.setValue(Empresa.getInstance().dameGanancia(), "Ganancias", "Lunes");
	       
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Ganancias y pérdidas","Ganancia y perdidas", "Monto", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.gray);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.red); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	        return panel;
	    }
	

}
