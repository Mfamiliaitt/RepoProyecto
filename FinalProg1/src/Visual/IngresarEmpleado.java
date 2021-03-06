package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.sun.management.jmx.Trace;

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
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPasswordField;


public class IngresarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
	private JFormattedTextField txtId;
	private JFormattedTextField txtId_1;
	private JButton btnRegistrar;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			IngresarEmpleado dialog = new IngresarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public IngresarEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IngresarEmpleado.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Registrar empleado");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelJefedeproyecto = new JPanel();
			panelJefedeproyecto.setBackground(SystemColor.textHighlightText);
			panelJefedeproyecto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jefe de Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelJefedeproyecto.setBounds(30, 338, 668, 79);
			contentPanel.add(panelJefedeproyecto);
			panelJefedeproyecto.setLayout(null);
			panelJefedeproyecto.setVisible(true);
			chckbxProjectManager = new JCheckBox("Certificacion en project manager");
			chckbxProjectManager.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			chckbxProjectManager.setBackground(SystemColor.textHighlightText);
			chckbxProjectManager.setBounds(16, 38, 247, 23);
			panelJefedeproyecto.add(chckbxProjectManager);
			
			
		}
		{
		    panelPlanificador = new JPanel();
		    panelPlanificador.setBackground(SystemColor.textHighlightText);
			panelPlanificador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planificador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPlanificador.setBounds(30, 338, 668, 79);
			contentPanel.add(panelPlanificador);
			panelPlanificador.setLayout(null);
			panelPlanificador.setVisible(false);
			JLabel lblFrecuenciaDePlanificacion = new JLabel("Frecuencia de planificacion");
			lblFrecuenciaDePlanificacion.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblFrecuenciaDePlanificacion.setBounds(10, 32, 144, 30);
			panelPlanificador.add(lblFrecuenciaDePlanificacion);
			
			spnFrecuencia = new JSpinner();
			spnFrecuencia.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnFrecuencia.setBounds(164, 37, 29, 20);
			panelPlanificador.add(spnFrecuencia);
			panelPlanificador.setVisible(false);
		}
		{
			panelProgramador = new JPanel();
			panelProgramador.setBackground(SystemColor.textHighlightText);
			panelProgramador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Programador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelProgramador.setBounds(30, 338, 668, 79);
			contentPanel.add(panelProgramador);
			panelProgramador.setLayout(null);
			panelProgramador.setVisible(false);
			{
				JLabel lblNewLabel_9 = new JLabel("Lenguaje:");
				lblNewLabel_9.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_9.setBounds(10, 38, 82, 14);
				panelProgramador.add(lblNewLabel_9);
			}
			{
				CmbLenguaje = new JComboBox();
				CmbLenguaje.setBackground(new Color(153, 204, 255));
				CmbLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "C", "C++", "C#", "Fortran", "Java", "Python", "Swift", "Assembler "}));
				CmbLenguaje.setBounds(81, 35, 127, 20);
				panelProgramador.add(CmbLenguaje);
			}
		}
		
		panelDiseniador = new JPanel();
		panelDiseniador.setBackground(SystemColor.textHighlightText);
		panelDiseniador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dise\u00F1ador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDiseniador.setBounds(30, 338, 668, 79);
		contentPanel.add(panelDiseniador);
		panelDiseniador.setLayout(null);
		panelDiseniador.setVisible(false);
		
		{
			JLabel lblNewLabel_8 = new JLabel("Tipo de dise\u00F1o:");
			lblNewLabel_8.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblNewLabel_8.setBounds(10, 29, 98, 14);
			panelDiseniador.add(lblNewLabel_8);
		}
		{
			cmbTipoDisenio = new JComboBox();
			cmbTipoDisenio.setBackground(new Color(153, 204, 255));
			cmbTipoDisenio.setModel(new DefaultComboBoxModel(new String[] {"Web", "Desktop", "Android", "iOS"}));
			cmbTipoDisenio.setBounds(112, 26, 164, 20);
			panelDiseniador.add(cmbTipoDisenio);
		}
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(IngresarEmpleado.class.getResource("/Imagenes/avatar-grande (3).png")));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(32, 59, 178, 178);
		contentPanel.add(lblImagen);
		{
			JPanel PDatos = new JPanel();
			PDatos.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
			PDatos.setBackground(Color.WHITE);
			PDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PDatos.setBounds(220, 23, 478, 260);
			contentPanel.add(PDatos);
			PDatos.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
				lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_1.setBounds(10, 23, 96, 14);
				PDatos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_2.setBounds(10, 59, 62, 14);
				PDatos.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Apellidos:");
				lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_3.setBounds(10, 95, 62, 14);
				PDatos.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
				lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_4.setBounds(10, 131, 62, 14);
				PDatos.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Sexo:");
				lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_5.setBounds(10, 193, 46, 14);
				PDatos.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Edad:");
				lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_6.setBounds(10, 229, 46, 14);
				PDatos.add(lblNewLabel_6);
			}
			
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
			rdnFemenino.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdnFemenino.setBackground(new Color(255, 255, 255));
			rdnFemenino.setSelected(true);
			buttonGroup_1.add(rdnFemenino);
			rdnFemenino.setBounds(71, 189, 103, 23);
			PDatos.add(rdnFemenino);
			
			rdnMaculino = new JRadioButton("Masculino");
			rdnMaculino.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdnMaculino.setBackground(new Color(255, 255, 255));
			buttonGroup_1.add(rdnMaculino);
			rdnMaculino.setBounds(187, 189, 144, 23);
			PDatos.add(rdnMaculino);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
			spnEdad.setBounds(71, 229, 62, 20);
			PDatos.add(spnEdad);
			
			lblSalario = new JLabel("Salario:");
			lblSalario.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblSalario.setBounds(192, 229, 46, 14);
			PDatos.add(lblSalario);
			
			txtSalario = new JTextField();
			txtSalario.setBounds(245, 226, 86, 20);
			PDatos.add(txtSalario);
			txtSalario.setColumns(10);
			
			txtId = new JFormattedTextField();
			try {
				MaskFormatter ced = new MaskFormatter("###-#######-#");
				ced.setPlaceholderCharacter('_');
				txtId_1 = new JFormattedTextField(ced);
				txtId_1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						if(Empresa.getInstance().isempleadoregistrado(txtId_1.getText())){
							btnRegistrar.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Este empleado ya existe");
						}else{btnRegistrar.setEnabled(true);}
						
					}
					
				});
			} catch (Exception e) {}
			txtId_1.setBounds(106, 20, 147, 20);
			PDatos.add(txtId_1);
			
			lblNewLabel = new JLabel("Contrase\u00F1a:");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblNewLabel.setBounds(10, 168, 96, 14);
			PDatos.add(lblNewLabel);
			
			JLabel lblNewLabel_10 = new JLabel("*Su c\u00E9dula ser\u00E1 su usuario para login");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_10.setForeground(new Color(255, 0, 51));
			lblNewLabel_10.setBounds(263, 24, 205, 14);
			PDatos.add(lblNewLabel_10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(105, 162, 144, 20);
			PDatos.add(passwordField);
		}
		{
		    pVacio = new JPanel();
		    pVacio.setBackground(Color.WHITE);
		    pVacio.setBounds(0, 0, 724, 15);
		    contentPanel.add(pVacio);
		    pVacio.setBorder(null);
			pVacio.setVisible(true);
			
		}
		{
			PCargoDelEmpleado = new JPanel();
			PCargoDelEmpleado.setBackground(Color.WHITE);
			PCargoDelEmpleado.setBorder(new TitledBorder(null, "Cargo del empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PCargoDelEmpleado.setBounds(30, 283, 668, 54);
			contentPanel.add(PCargoDelEmpleado);
			PCargoDelEmpleado.setLayout(null);
			{
				JLabel lblNewLabel_7 = new JLabel("Cargo:");
				lblNewLabel_7.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_7.setBounds(10, 26, 46, 14);
				PCargoDelEmpleado.add(lblNewLabel_7);
			}
			
			rdbJefeDeProyecto = new JRadioButton("Jefe de proyecto");
			rdbJefeDeProyecto.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdbJefeDeProyecto.setBackground(SystemColor.window);
			rdbJefeDeProyecto.setSelected(true);
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
			rdbPlanificador.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdbPlanificador.setBackground(SystemColor.window);
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
			rdbProgramador.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdbProgramador.setBackground(SystemColor.window);
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
			rdbDiseniador.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			rdbDiseniador.setBackground(SystemColor.window);
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
			buttonPane.setBackground(new Color(153, 204, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnRegistrar.setBackground(SystemColor.control);
				btnRegistrar.setIcon(new ImageIcon(IngresarEmpleado.class.getResource("/Imagenes/signo-de-comprobado.png")));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(faltaAlgo()){
							JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
						}
						else{
						String identificador=txtId_1.getText();
						String nombre=txtNombre.getText();
						String direccion=txtDireccion.getText();
						String apellidos=txtApellidos.getText();
						String sexo="Masculino";
						char arrayC[] = passwordField.getPassword(); /*Arreglo de caracteres para guardar el array de char que devuelve getPassword*/
						String pass = new String(arrayC); 
						if(rdnMaculino.isSelected()){ sexo="Masculino";}
						if(rdnFemenino.isSelected()){ sexo="Femenino";}
						int edad=(int) spnEdad.getValue();
					    Double salario=Double.parseDouble(txtSalario.getText());
					if(rdbJefeDeProyecto.isSelected()){						
						Empleado aux = new JefeProyecto(identificador, nombre, apellidos, direccion, sexo, edad, salario, "","Sobresaliente", 0, chckbxProjectManager.isSelected());						
						aux.setPassword(pass);
						Empresa.getInstance().addEmpleado(aux);
	                
					}
					else if(rdbDiseniador.isSelected()){
						Empleado aux= new Diseniador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Sobresaliente", cmbTipoDisenio.getSelectedItem().toString());				
						aux.setPassword(pass);
						Empresa.getInstance().addEmpleado(aux);	
					}
					else if(rdbPlanificador.isSelected()){
						Empleado aux=new Planificador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Sobresaliente", (int) spnFrecuencia.getValue());	
						aux.setPassword(pass);
						Empresa.getInstance().addEmpleado(aux);	
					}
					else if(rdbProgramador.isSelected()){
						Empleado aux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", "Sobresaliente", CmbLenguaje.getSelectedItem().toString());		
						aux.setPassword(pass);
						Empresa.getInstance().addEmpleado(aux);
					}
					JOptionPane.showMessageDialog(null, "Empleado registrado satisfactoriamente");
					clean();
					}
				}

					private void clean() {
					txtApellidos.setText("");
					txtDireccion.setText("");
					txtId_1.setText("");
					txtNombre.setText("");
					txtSalario.setText("");
					passwordField.setText("");
					
					}

					@SuppressWarnings("deprecation")
					private boolean faltaAlgo() {
						boolean falta=false;
						if(txtId_1.getText().isEmpty() || passwordField.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtSalario.getText().isEmpty()){
							falta=true;
						}						
						return falta;
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCancelar.setBackground(SystemColor.control);
				btnCancelar.setIcon(new ImageIcon(IngresarEmpleado.class.getResource("/Imagenes/boton-de-cerrar.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
