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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;


public class IngresarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JPanel PCargoDelEmpleado;
	private JPanel panelDiseniador;
	private JPanel panelVacio;
	private JPanel panelProgramador;
	private JPanel panelPlanificador;
	private JPanel panelJefedeproyecto;
	private JRadioButton rdnFemenino;
	private JRadioButton rdnMaculino;
	private JSpinner spnEdad;
	private JComboBox cbxCargo;
	private JButton btnCargar;

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
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		    panelVacio = new JPanel();
		    panelVacio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelVacio.setBounds(30, 327, 365, 90);
			contentPanel.add(panelVacio);
			panelVacio.setVisible(true);
			
		}
		{
			panelProgramador = new JPanel();
			panelProgramador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Programador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelProgramador.setBounds(30, 327, 365, 90);
			contentPanel.add(panelProgramador);
			panelProgramador.setLayout(null);
			panelProgramador.setVisible(false);
			{
				JLabel lblNewLabel_9 = new JLabel("Lenguaje:");
				lblNewLabel_9.setBounds(10, 38, 82, 14);
				panelProgramador.add(lblNewLabel_9);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(81, 35, 127, 20);
				panelProgramador.add(comboBox);
			}
		}
		{
		    panelPlanificador = new JPanel();
			panelPlanificador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planificador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPlanificador.setBounds(30, 327, 365, 90);
			contentPanel.add(panelPlanificador);
			panelPlanificador.setVisible(true);
		}
		{
			panelJefedeproyecto = new JPanel();
			panelJefedeproyecto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jefe de Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelJefedeproyecto.setBounds(30, 327, 365, 90);
			contentPanel.add(panelJefedeproyecto);
			panelJefedeproyecto.setVisible(false);
			
		}
		
		panelDiseniador = new JPanel();
		panelDiseniador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dise\u00F1ador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDiseniador.setBounds(30, 327, 365, 90);
		contentPanel.add(panelDiseniador);
		panelDiseniador.setLayout(null);
		panelDiseniador.setVisible(false);
		
		{
			JLabel lblNewLabel_8 = new JLabel("Tipo de dise\u00F1o:");
			lblNewLabel_8.setBounds(10, 29, 98, 14);
			panelDiseniador.add(lblNewLabel_8);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(112, 26, 164, 20);
			panelDiseniador.add(comboBox);
		}
		
		JLabel lblNewLabel = new JLabel("La imagen del empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 39, 178, 178);
		contentPanel.add(lblNewLabel);
		
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
				JLabel lblNewLabel_1 = new JLabel("Identificador:");
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
			txtId.setBounds(116, 20, 129, 20);
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
			rdnFemenino.setBounds(71, 163, 77, 23);
			PDatos.add(rdnFemenino);
			
			rdnMaculino = new JRadioButton("Masculino");
			rdnMaculino.setBounds(161, 163, 77, 23);
			PDatos.add(rdnMaculino);
			
			spnEdad = new JSpinner();
			spnEdad.setBounds(71, 203, 62, 20);
			PDatos.add(spnEdad);
		}
		{
			PCargoDelEmpleado = new JPanel();
			PCargoDelEmpleado.setBorder(new TitledBorder(null, "Cargo del empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PCargoDelEmpleado.setBounds(30, 262, 365, 54);
			contentPanel.add(PCargoDelEmpleado);
			PCargoDelEmpleado.setLayout(null);
			{
				JLabel lblNewLabel_7 = new JLabel("Cargo:");
				lblNewLabel_7.setBounds(10, 26, 46, 14);
				PCargoDelEmpleado.add(lblNewLabel_7);
			}
			{
				cbxCargo = new JComboBox();
				cbxCargo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cargo=cbxCargo.getSelectedItem().toString();
						if(cargo=="Jefe de proyecto"){
							//Si selecciono al jefe de proyecto
							
							panelJefedeproyecto.setVisible(true);
							
							panelDiseniador.setVisible(false);
							panelPlanificador.setVisible(false);
							panelProgramador.setVisible(false);
							panelVacio.setVisible(false);
							
						}
						else if(cargo=="Diseñador"){
							//Si selecciono al diseñador
                            panelDiseniador.setVisible(true);
                            
                            panelJefedeproyecto.setVisible(false);
							panelPlanificador.setVisible(false);
							panelProgramador.setVisible(false);
							panelVacio.setVisible(false);
						}
						else if(cargo=="Planificador"){
							//Si selecciona al planificador 
							panelPlanificador.setVisible(true); 
							
							panelDiseniador.setVisible(false);    
	                        panelJefedeproyecto.setVisible(false);
							panelProgramador.setVisible(false);
					        panelVacio.setVisible(false);	
						}
						else if(cargo=="Programador"){
							//Si selecciona al programador
                            panelProgramador.setVisible(true);
                            
                            panelPlanificador.setVisible(false); 
							panelDiseniador.setVisible(false);    
	                        panelJefedeproyecto.setVisible(false);
					        panelVacio.setVisible(false);
						}
						else{
							panelVacio.setVisible(true);
							
                            panelProgramador.setVisible(false);
                            panelPlanificador.setVisible(false); 
							panelDiseniador.setVisible(false);    
	                        panelJefedeproyecto.setVisible(false);	
						}
						
						
						
					}
				});
				cbxCargo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Jefe de proyecto", "Dise\u00F1ador", "Planificador", "Programador"}));
				cbxCargo.setBounds(112, 23, 167, 20);
				PCargoDelEmpleado.add(cbxCargo);
			}
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
