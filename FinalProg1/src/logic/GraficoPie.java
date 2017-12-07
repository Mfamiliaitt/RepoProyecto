package logic;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoPie {

	 JPanel panel;
	  /*  public Ventana(){
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }*/
	public GraficoPie(){
		
	}
	    public JPanel init() {
	        panel = new JPanel();
	        panel.setLayout(new BorderLayout(0, 0));
	      // panel.setLayout(GridBagLayout);
	       // getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultPieDataset data = new DefaultPieDataset();
	        
	        data.setValue("Aplicacion Web", Empresa.getInstance().cantidadDeProyectosPorTipo("Aplicacion Web")*100/(Empresa.getInstance().getMisProyectos().size()+1));
	        data.setValue("Video Juegos",Empresa.getInstance().cantidadDeProyectosPorTipo("Video Juegos")*100/(Empresa.getInstance().getMisProyectos().size()+1));
	        data.setValue("Aplicacion Movil",Empresa.getInstance().cantidadDeProyectosPorTipo("Aplicacion Movil")*100/(Empresa.getInstance().getMisProyectos().size()+1));
	        data.setValue("Corporativo", Empresa.getInstance().cantidadDeProyectosPorTipo("Corporativo")*100/(Empresa.getInstance().getMisProyectos().size()+1));
	        data.setValue("Desktop",Empresa.getInstance().cantidadDeProyectosPorTipo("Desktop")*100/(Empresa.getInstance().getMisProyectos().size()+1));
	 
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart(
	         "Porcentaje de Tipos de Proyectos creados", 
	         data, 
	         true, 
	         true, 
	         false);
	         
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        
	        panel.add(chartPanel);
	        return panel;
	    }

}
