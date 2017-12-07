package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

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
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

public class ListadoEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JButton btnbuscarempl;
	private JFormattedTextField txtbuscar;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListadoEmpleados dialog = new ListadoEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListadoEmpleados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoEmpleados.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Listado de empleados");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 204, 255));
			buttonPane.setBounds(0, 428, 724, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/Imagenes/boton-de-cerrar.png")));
				cancelButton.setBackground(SystemColor.control);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.getInstance().loadTable();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleados registrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(29, 68, 665, 338);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Cédula","Nombre","Apellido","Dirección", "Sexo", "Cargo","Salario","Evaluación","Estado"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 204, 255));
			panel.setBounds(29, 11, 665, 46);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Buscar por cedula:");
				lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel.setBounds(23, 11, 159, 14);
				panel.add(lblNewLabel);
			}
			{
				try {
					MaskFormatter t = new MaskFormatter("###-#######-#");
					t.setPlaceholderCharacter('_');
					txtbuscar = new JFormattedTextField(t);
				} catch (Exception e) {}
				txtbuscar.setBounds(136, 9, 159, 20);
				
				panel.add(txtbuscar);
			}
			{
				btnbuscarempl = new JButton("Buscar");
				btnbuscarempl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Empleado emple=Empresa.getInstance().buscarEmpleadoPorCedula(txtbuscar.getText());
						if (emple!=null){
								loadTable2(txtbuscar.getText());		
							}else{
								JOptionPane.showMessageDialog(null, "El empleado no existe");
								txtbuscar.setText("");
								loadTable();	
							}
						
						
					}
				});
				btnbuscarempl.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/Imagenes/magnifier.png")));
				btnbuscarempl.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnbuscarempl.setBounds(315, 7, 115, 23);
				panel.add(btnbuscarempl);
			}
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Empleado empleado : Empresa.getInstance().getMisEmpleados()) {
			fila[0] = empleado.getIdentificador();
			fila[1] = empleado.getNombre();
			fila[2] = empleado.getApellidos();
			fila[3] = empleado.getDireccion();
			fila[4] = empleado.getSexo();
			if(empleado instanceof JefeProyecto){
				fila[5] = "Jefe de proyecto";	
			}else if(empleado instanceof Planificador){
				fila[5] = "Planficador";	
			}else if(empleado instanceof Programador){
				fila[5] = "Programador";
			}else if(empleado instanceof Diseniador){
				fila[5] = "Diseñador";	
			}
			fila[6] = empleado.getSalario();
			fila[7] = empleado.getEvaluacionAnual();
			if (empleado.isOcupado()){
			    fila[8] = "Ocupado";
			}
			else{
				fila[8] = "Disponible";
			}
			
			model.addRow(fila);
				}
	
	}
	private void loadTable2(String cedula){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		Empleado emple=Empresa.getInstance().buscarEmpleadoPorCedula(cedula);									
				fila[0] = emple.getIdentificador();
				fila[1] = emple.getNombre();
				fila[2] = emple.getApellidos();
				fila[3] = emple.getDireccion();
				fila[4] = emple.getSexo();
				if(emple instanceof JefeProyecto){
					fila[5] = "Jefe de proyecto";	
				}else if(emple instanceof Planificador){
					fila[5] = "Planficador";	
				}else if(emple instanceof Programador){
					fila[5] = "Programador";
				}else if(emple instanceof Diseniador){
					fila[5] = "Diseñador";	
				}
				fila[6] = emple.getSalario();
				fila[7] = emple.getEvaluacionAnual();
				if (emple.isOcupado()){
				    fila[8] = "Ocupado";
				}
				else{
					fila[8] = "Disponible";
				}
				model.addRow(fila);		
				}
			
}
