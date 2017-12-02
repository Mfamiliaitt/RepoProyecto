package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Diseniador;
import logic.Empleado;
import logic.Empresa;
import logic.JefeProyecto;
import logic.Planificador;
import logic.Programador;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EvaluacionAnual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JComboBox cbmEstado;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public EvaluacionAnual() {
		Empresa.getInstance().evaluaciondelempleado();
		setIconImage(Toolkit.getDefaultToolkit().getImage(EvaluacionAnual.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Evaluacion Anual");
		setBounds(100, 100, 557, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleados registrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 76, 389, 232);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Cédula","Nombre","Apellido","Cargo","Evaluación"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
				
					scrollPane.setViewportView(table);
				}
			}
		} 
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(409, 78, 46, 14);
		contentPanel.add(lblEstado);
		
		cbmEstado = new JComboBox();
		cbmEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});
		cbmEstado.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Muy bueno", "Bueno", "Malo"}));
		cbmEstado.setBounds(409, 95, 107, 20);
		contentPanel.add(cbmEstado);
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Empleado empleado : Empresa.getInstance().getMisEmpleados()) {			
			//Filtrado de estado de empleados
			if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Muy bueno")){
				if(empleado.getEvaluacionAnual().equalsIgnoreCase("Muy bueno")){				
						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						if(empleado instanceof JefeProyecto){
							fila[3] = "Jefe de proyecto";	
						}else if(empleado instanceof Planificador){
							fila[3] = "Planficador";	
						}else if(empleado instanceof Programador){
							fila[3] = "Programador";
						}else if(empleado instanceof Diseniador){
							fila[3] = "Diseñador";	
						}				
							fila[4]=empleado.getEvaluacionAnual();
							model.addRow(fila);	
						}
										
				}
				else if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Bueno")){
					if(empleado.getEvaluacionAnual().equalsIgnoreCase("Bueno")){			
							fila[0] = empleado.getIdentificador();
							fila[1] = empleado.getNombre();
							fila[2] = empleado.getApellidos();
							if(empleado instanceof JefeProyecto){
								fila[3] = "Jefe de proyecto";	
							}else if(empleado instanceof Planificador){
								fila[3] = "Planficador";	
							}else if(empleado instanceof Programador){
								fila[3] = "Programador";
							}else if(empleado instanceof Diseniador){
								fila[3] = "Diseñador";	
							}
							
								fila[4]=empleado.getEvaluacionAnual();
								model.addRow(fila);								
							}
							
						
						
				}		
				else if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Malo")){
					if(empleado.getEvaluacionAnual().equalsIgnoreCase("Malo")){		
							fila[0] = empleado.getIdentificador();
							fila[1] = empleado.getNombre();
							fila[2] = empleado.getApellidos();
							if(empleado instanceof JefeProyecto){
								fila[3] = "Jefe de proyecto";	
							}else if(empleado instanceof Planificador){
								fila[3] = "Planficador";	
							}else if(empleado instanceof Programador){
								fila[3] = "Programador";
							}else if(empleado instanceof Diseniador){
								fila[3] = "Diseñador";	
							}						
								fila[4]=empleado.getEvaluacionAnual();
								model.addRow(fila);
								
							}
							
							
					
				}
				
				
			
			
	}
	}
}
