package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import logic.Diseniador;
import logic.Empleado;
import logic.Empresa;
import logic.JefeProyecto;
import logic.Planificador;
import logic.Programador;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;


public class IngresarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JPanel PCargoDelEmpleado;
	private JPanel panelDiseniador;
	private JPanel pVacio;
	private JPanel panelProgramador;
	private JPanel panelPlanificador;
	private JPanel panelJefedeproyecto;
	private JRadioButton rdnFemenino;
	private JRadioButton rdnMaculino;
	private JSpinner spnEdad;
	private JButton btnCargar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbDiseniador;
	private JRadioButton rdbProgramador;
	private JRadioButton rdbJefeDeProyecto;
	private JRadioButton rdbPlanificador;
	private JComboBox cmbTipoDisenio;
	private JComboBox CmbLenguaje;
	private JLabel lblSalario;
	private JTextField txtSalario;
	private JCheckBox chckbxProjectManager;
	private JSpinner spnFrecuencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IngresarEmpleado dialog = new IngresarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IngresarEmpleado() {
		setTitle("Agregar empleado");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelJefedeproyecto = new JPanel();
			panelJefedeproyecto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jefe de Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelJefedeproyecto.setBounds(30, 327, 668, 90);
			contentPanel.add(panelJefedeproyecto);
			panelJefedeproyecto.setLayout(null);
			
			chckbxProjectManager = new JCheckBox("Certificacion en project manager");
			chckbxProjectManager.setBounds(16, 38, 247, 23);
			panelJefedeproyecto.add(chckbxProjectManager);
			panelJefedeproyecto.setVisible(false);
			
		}
		{
		    panelPlanificador = new JPanel();
			panelPlanificador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planificador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPlanificador.setBounds(30, 327, 668, 90);
			contentPanel.add(panelPlanificador);
			panelPlanificador.setLayout(null);
			
			JLabel lblFrecuenciaDePlanificacion = new JLabel("Frecuencia de planificacion");
			lblFrecuenciaDePlanificacion.setBounds(10, 32, 144, 30);
			panelPlanificador.add(lblFrecuenciaDePlanificacion);
			
			spnFrecuencia = new JSpinner();
			spnFrecuencia.setBounds(164, 37, 29, 20);
			panelPlanificador.add(spnFrecuencia);
			panelPlanificador.setVisible(true);
		}
		{
			panelProgramador = new JPanel();
			panelProgramador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Programador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelProgramador.setBounds(30, 327, 668, 90);
			contentPanel.add(panelProgramador);
			panelProgramador.setLayout(null);
			panelProgramador.setVisible(false);
			{
				JLabel lblNewLabel_9 = new JLabel("Lenguaje:");
				lblNewLabel_9.setBounds(10, 38, 82, 14);
				panelProgramador.add(lblNewLabel_9);
			}
			{
				CmbLenguaje = new JComboBox();
				CmbLenguaje.setModel(new DefaultComboBoxModel(new String[] {"C", "C++", "C#", "Fortran", "Java", "Python", "Swift", "Assembler "}));
				CmbLenguaje.setBounds(81, 35, 127, 20);
				panelProgramador.add(CmbLenguaje);
			}
		}
		
		panelDiseniador = new JPanel();
		panelDiseniador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dise\u00F1ador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDiseniador.setBounds(30, 327, 668, 90);
		contentPanel.add(panelDiseniador);
		panelDiseniador.setLayout(null);
		panelDiseniador.setVisible(false);
		
		{
			JLabel lblNewLabel_8 = new JLabel("Tipo de dise\u00F1o:");
			lblNewLabel_8.setBounds(10, 29, 98, 14);
			panelDiseniador.add(lblNewLabel_8);
		}
		{
			cmbTipoDisenio = new JComboBox();
			cmbTipoDisenio.setModel(new DefaultComboBoxModel(new String[] {"Web", "Desktop", "Android", "iOS"}));
			cmbTipoDisenio.setBounds(112, 26, 164, 20);
			panelDiseniador.add(cmbTipoDisenio);
		}
		
		JLabel lblImagen = new JLabel("La imagen del empleado");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(30, 39, 178, 178);
		contentPanel.add(lblImagen);
		
	    btnCargar = new JButton("Cargar");
		btnCargar.setBounds(77, 228, 89, 23);
		contentPanel.add(btnCargar);
		{
			JPanel PDatos = new JPanel();
			PDatos.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PDatos.setBounds(243, 23, 455, 240);
			contentPanel.add(PDatos);
			PDatos.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
				lblNewLabel_1.setBounds(10, 23, 96, 14);
				PDatos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setBounds(10, 59, 62, 14);
				PDatos.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Apellidos:");
				lblNewLabel_3.setBounds(10, 95, 62, 14);
				PDatos.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
				lblNewLabel_4.setBounds(10, 131, 62, 14);
				PDatos.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Sexo:");
				lblNewLabel_5.setBounds(10, 167, 46, 14);
				PDatos.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Edad:");
				lblNewLabel_6.setBounds(10, 203, 46, 14);
				PDatos.add(lblNewLabel_6);
			}
			
			txtId = new JTextField();
			txtId.setBounds(105, 20, 129, 20);
			PDatos.add(txtId);
			txtId.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(105, 53, 307, 20);
			PDatos.add(txtNombre);
			
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(105, 89, 307, 20);
			PDatos.add(txtApellidos);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(105, 125, 307, 20);
			PDatos.add(txtDireccion);
			
			rdnFemenino = new JRadioButton("Femenino");
			buttonGroup_1.add(rdnFemenino);
			rdnFemenino.setBounds(71, 163, 77, 23);
			PDatos.add(rdnFemenino);
			
			rdnMaculino = new JRadioButton("Masculino");
			buttonGroup_1.add(rdnMaculino);
			rdnMaculino.setBounds(161, 163, 77, 23);
			PDatos.add(rdnMaculino);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
			spnEdad.setBounds(71, 203, 62, 20);
			PDatos.add(spnEdad);
			
			lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(192, 203, 46, 14);
			PDatos.add(lblSalario);
			
			txtSalario = new JTextField();
			txtSalario.setBounds(245, 200, 86, 20);
			PDatos.add(txtSalario);
			txtSalario.setColumns(10);
		}
		{
		    pVacio = new JPanel();
		    pVacio.setBounds(0, 0, 724, 15);
		    contentPanel.add(pVacio);
		    pVacio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pVacio.setVisible(true);
			
		}
		{
			PCargoDelEmpleado = new JPanel();
			PCargoDelEmpleado.setBorder(new TitledBorder(null, "Cargo del empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PCargoDelEmpleado.setBounds(30, 262, 668, 54);
			contentPanel.add(PCargoDelEmpleado);
			PCargoDelEmpleado.setLayout(null);
			{
				JLabel lblNewLabel_7 = new JLabel("Cargo:");
				lblNewLabel_7.setBounds(10, 26, 46, 14);
				PCargoDelEmpleado.add(lblNewLabel_7);
			}
			
			rdbJefeDeProyecto = new JRadioButton("Jefe de proyecto");
			rdbJefeDeProyecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbJefeDeProyecto.isSelected()){
						pVacio.setVisible(false);
						panelJefedeproyecto.setVisible(true);
						panelPlanificador.setVisible(false);
						panelProgramador.setVisible(false);
						panelDiseniador.setVisible(false);
						
					}
				}
			});
			buttonGroup.add(rdbJefeDeProyecto);
			rdbJefeDeProyecto.setBounds(92, 22, 121, 23);
			PCargoDelEmpleado.add(rdbJefeDeProyecto);
			
			rdbPlanificador = new JRadioButton("Planificador");
			rdbPlanificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbPlanificador.isSelected()){
						pVacio.setVisible(false);
						panelJefedeproyecto.setVisible(false);
						panelPlanificador.setVisible(true);
						panelProgramador.setVisible(false);
						panelDiseniador.setVisible(false);
						
					}
				}
			});
			buttonGroup.add(rdbPlanificador);
			rdbPlanificador.setBounds(226, 22, 109, 23);
			PCargoDelEmpleado.add(rdbPlanificador);
			
			rdbProgramador = new JRadioButton("Programador");
			rdbProgramador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbProgramador.isSelected()){
						pVacio.setVisible(false);
						panelJefedeproyecto.setVisible(false);
						panelPlanificador.setVisible(false);
						panelProgramador.setVisible(true);
						panelDiseniador.setVisible(false);
						
					}
				}
			});
			buttonGroup.add(rdbProgramador);
			rdbProgramador.setBounds(352, 22, 109, 23);
			PCargoDelEmpleado.add(rdbProgramador);
			
			rdbDiseniador = new JRadioButton("Dise\u00F1ador");
			rdbDiseniador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbDiseniador.isSelected()){
						pVacio.setVisible(false);
						panelJefedeproyecto.setVisible(false);
						panelPlanificador.setVisible(false);
						panelProgramador.setVisible(false);
						panelDiseniador.setVisible(true);
						
					}
				}
			});
			buttonGroup.add(rdbDiseniador);
			rdbDiseniador.setBounds(475, 22, 109, 23);
			PCargoDelEmpleado.add(rdbDiseniador);
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String identificador=txtId.getText();
						String nombre=txtNombre.getText();
						String direccion=txtDireccion.getText();
						String apellidos=txtApellidos.getText();
						String sexo="Masculino";
						if(rdnMaculino.isSelected()){ sexo="Masculino";}
						if(rdnFemenino.isSelected()){ sexo="Femenino";}
						int edad=(int) spnEdad.getValue();
					    Double salario=Double.parseDouble(txtSalario.getText());
					if(rdbJefeDeProyecto.isSelected()){
						
	Empleado aux = new JefeProyecto(identificador, nombre, apellidos, direccion, sexo, edad, salario, "","Bueno", 0, chckbxProjectManager.isSelected());
						
	                Empresa.getInstance().addEmpleado(aux);
					}
					if(rdbDiseniador.isSelected()){
	Empleado aux= new Diseniador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Bueno", cmbTipoDisenio.getSelectedItem().toString());				
	                Empresa.getInstance().addEmpleado(aux);	
					}
					if(rdbPlanificador.isSelected()){
	Empleado aux=new Planificador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Bueno", (int) spnFrecuencia.getValue());					
	Empresa.getInstance().addEmpleado(aux);	
					}
					if(rdbProgramador.isSelected()){}
				Empleado aux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Bueno", CmbLenguaje.getSelectedItem().toString());		
					Empresa.getInstance().addEmpleado(aux);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
