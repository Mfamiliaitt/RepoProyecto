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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.SystemColor;

public class CrearProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel P1;
	private JPanel P2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearProyecto dialog = new CrearProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearProyecto() {
		setTitle("Project wizard");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			P1 = new JPanel();
			P1.setBounds(0, 0, 724, 428);
			contentPanel.add(P1);
			P1.setLayout(null);
			{
				JPanel panelProyecto = new JPanel();
				panelProyecto.setBounds(0, 0, 350, 187);
				P1.add(panelProyecto);
				panelProyecto.setLayout(null);
				panelProyecto.setBorder(new TitledBorder(null, "Datos del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				{
					JLabel label = new JLabel("C\u00F3digo:");
					label.setBounds(171, 22, 46, 14);
					panelProyecto.add(label);
				}
				{
					JLabel lblTipoDeProyecto = new JLabel("Tipo de proyecto:");
					lblTipoDeProyecto.setBounds(172, 121, 150, 14);
					panelProyecto.add(lblTipoDeProyecto);
				}
				{
					textField = new JTextField();
					textField.setEnabled(false);
					textField.setColumns(10);
					textField.setBounds(171, 35, 136, 20);
					panelProyecto.add(textField);
				}
				{
					JLabel label = new JLabel("Descripcion");
					label.setBounds(10, 22, 151, 14);
					panelProyecto.add(label);
				}
				{
					JTextArea textArea = new JTextArea();
					textArea.setBounds(10, 35, 151, 128);
					panelProyecto.add(textArea);
				}
				{
					JLabel label = new JLabel("Fecha de Entrega");
					label.setBounds(171, 76, 151, 14);
					panelProyecto.add(label);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Aplicacion Web", "Video Juegos", "Aplicacion Movil", "Corporativo", "Desktop"}));
					comboBox.setBounds(171, 135, 151, 20);
					panelProyecto.add(comboBox);
				}
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerDateModel(new Date(1511582400000L), null, null, Calendar.DAY_OF_YEAR));
					spinner.setBounds(171, 90, 151, 20);
					panelProyecto.add(spinner);
				}
			}
			{
				JLabel lblImagen = new JLabel("Imagen del proyecto");
				lblImagen.setBounds(360, 11, 354, 170);
				P1.add(lblImagen);
			}
			{
				JPanel panelEmpleado = new JPanel();
				panelEmpleado.setBounds(0, 189, 714, 228);
				P1.add(panelEmpleado);
				panelEmpleado.setBorder(new TitledBorder(null, "Datos del equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelEmpleado.setLayout(null);
				{
					JLabel lblCargo = new JLabel("Cargo: ");
					lblCargo.setBounds(10, 33, 46, 14);
					panelEmpleado.add(lblCargo);
				}
				{
					JComboBox cbxCargoEmpl = new JComboBox();
					cbxCargoEmpl.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Jefe de proyecto", "Planificador", "Dise\u00F1ador", "Programador"}));
					cbxCargoEmpl.setBounds(66, 30, 121, 20);
					panelEmpleado.add(cbxCargoEmpl);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 58, 286, 159);
					panelEmpleado.add(scrollPane);
				}
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(370, 58, 324, 159);
				panelEmpleado.add(scrollPane);
				
				JButton btnAgregar = new JButton(">");
				btnAgregar.setBounds(306, 94, 54, 29);
				panelEmpleado.add(btnAgregar);
				
				JButton btnEliminar = new JButton("X");
				btnEliminar.setBounds(306, 136, 54, 29);
				panelEmpleado.add(btnEliminar);
			}
		}
		{
			P2 = new JPanel();
			P2.setBounds(0, 0, 724, 428);
			contentPanel.add(P2);
			P2.setLayout(null);
			P2.setVisible(false);
			
			;
			{
				JPanel panelBusqueda = new JPanel();
				panelBusqueda.setLayout(null);
				panelBusqueda.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Busqueda de cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelBusqueda.setBackground(SystemColor.control);
				panelBusqueda.setBounds(10, 11, 495, 94);
				P2.add(panelBusqueda);
				{
					JLabel label = new JLabel("C\u00E9dula: ");
					label.setBounds(10, 40, 55, 14);
					panelBusqueda.add(label);
				}
				{
					JFormattedTextField formattedTextField = new JFormattedTextField((AbstractFormatter) null);
					formattedTextField.setColumns(10);
					formattedTextField.setBounds(76, 37, 165, 20);
					panelBusqueda.add(formattedTextField);
				}
				{
					JButton button = new JButton("<html><font color = black>Buscar</font></html>");
					button.setBackground(new Color(100, 149, 237));
					button.setBounds(251, 36, 102, 23);
					panelBusqueda.add(button);
				}
			}
			{
				JPanel panelInfo = new JPanel();
				panelInfo.setLayout(null);
				panelInfo.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelInfo.setBackground(SystemColor.control);
				panelInfo.setBounds(10, 116, 495, 185);
				P2.add(panelInfo);
				{
					JLabel label = new JLabel("C\u00E9dula:");
					label.setBounds(10, 35, 46, 14);
					panelInfo.add(label);
				}
				{
					JFormattedTextField formattedTextField = new JFormattedTextField((AbstractFormatter) null);
					formattedTextField.setEditable(false);
					formattedTextField.setColumns(10);
					formattedTextField.setBounds(76, 32, 165, 20);
					panelInfo.add(formattedTextField);
				}
				{
					JLabel label = new JLabel("Tel\u00E9fono:");
					label.setBounds(251, 35, 63, 14);
					panelInfo.add(label);
				}
				{
					textField_1 = new JTextField();
					textField_1.setEditable(false);
					textField_1.setColumns(10);
					textField_1.setBounds(320, 32, 165, 20);
					panelInfo.add(textField_1);
				}
				{
					JLabel label = new JLabel("Nombre: ");
					label.setBounds(10, 84, 63, 14);
					panelInfo.add(label);
				}
				{
					JLabel label = new JLabel("Direcci\u00F3n: ");
					label.setBounds(10, 133, 63, 14);
					panelInfo.add(label);
				}
				{
					textField_2 = new JTextField();
					textField_2.setEditable(false);
					textField_2.setColumns(10);
					textField_2.setBounds(76, 130, 409, 20);
					panelInfo.add(textField_2);
				}
				{
					textField_3 = new JTextField();
					textField_3.setEditable(false);
					textField_3.setColumns(10);
					textField_3.setBounds(76, 81, 409, 20);
					panelInfo.add(textField_3);
				}
			}
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(P1.isVisible()){
							P1.setVisible(false);
							P2.setVisible(true);
							
						}
					}
				});
				{
					JButton btnAtras = new JButton("Atras");
					btnAtras.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(P2.isVisible()){
								P1.setVisible(true);
								P2.setVisible(false);
							}
						}
					});
					buttonPane.add(btnAtras);
				}
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
