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
import javax.swing.SwingConstants;

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
		setTitle("Evaluaci\u00F3n Anual");
		setBounds(100, 100, 589, 487);
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
			panel.setBounds(10, 151, 324, 255);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"C�dula","Nombre","Apellido","Cargo","Evaluaci�n"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
				
					scrollPane.setViewportView(table);
				}
			}
		} 
		
		JLabel lblEstado = new JLabel("Evaluaci\u00F3n:");
		lblEstado.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
		lblEstado.setBounds(344, 161, 79, 14);
		contentPanel.add(lblEstado);
		
		cbmEstado = new JComboBox();
		cbmEstado.setBackground(new Color(153, 204, 255));
		cbmEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});
		cbmEstado.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Sobresaliente", "Suficiente", "Deficiente"}));
		cbmEstado.setBounds(433, 155, 107, 20);
		contentPanel.add(cbmEstado);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 204, 255));
			panel.setBounds(0, 415, 573, 33);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnSalir.setIcon(new ImageIcon(EvaluacionAnual.class.getResource("/Imagenes/boton-de-cerrar.png")));
				btnSalir.setBounds(474, 5, 89, 23);
				panel.add(btnSalir);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(EvaluacionAnual.class.getResource("/Imagenes/boton-de-una-estrella (3).png")));
			lblNewLabel.setBounds(196, 11, 181, 139);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(EvaluacionAnual.class.getResource("/Imagenes/boton-de-una-estrella (2).png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(164, 93, 65, 47);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(EvaluacionAnual.class.getResource("/Imagenes/boton-de-una-estrella (2).png")));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(346, 93, 58, 47);
			contentPanel.add(lblNewLabel_2);
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Empleado empleado : Empresa.getInstance().getMisEmpleados()) {			
			//Filtrado de estado de empleados
			if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Sobresaliente")){
				if(empleado.getEvaluacionAnual().equalsIgnoreCase("Sobresaliente")){				
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
							fila[3] = "Dise�ador";	
						}				
							fila[4]=empleado.getEvaluacionAnual();
							model.addRow(fila);	
						}
										
				}
				else if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Suficiente")){
					if(empleado.getEvaluacionAnual().equalsIgnoreCase("Suficiente")){			
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
								fila[3] = "Dise�ador";	
							}
							
								fila[4]=empleado.getEvaluacionAnual();
								model.addRow(fila);								
							}
							
						
						
				}		
				else if(cbmEstado.getSelectedItem().toString().equalsIgnoreCase("Deficiente")){
					if(empleado.getEvaluacionAnual().equalsIgnoreCase("Deficiente")){		
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
								fila[3] = "Dise�ador";	
							}						
								fila[4]=empleado.getEvaluacionAnual();
								model.addRow(fila);
								
							}
							
							
					
				}
				
				
			
			
	}
	}
}
