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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMBinOp;

import logic.Cliente;
import logic.Contrato;
import logic.Diseniador;
import logic.Empleado;
import logic.Empresa;
import logic.JefeProyecto;
import logic.Planificador;
import logic.Programador;
import logic.Proyecto;

import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

public class CrearProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtDireccion;
	private JTextField txtNombre;
	private JPanel P1;
	private JPanel P2;
	private JTextField txtApellido;
	private static Object[] fila;
	private static DefaultTableModel model = new DefaultTableModel();
	private static Object[] fila1;
	private static DefaultTableModel model1 = new DefaultTableModel();
	private JTable table;
	private JTable table_1;
	private Proyecto pAux = new Proyecto();
	private JTextField txtNombreCmostrado;
	private JTextField txtCedulaMostrada;
	private JTextField txtTelMostrado;
	private JTextField txtNombreProMostrado;
	private JTextField txtFechaEntregaMostrada;
	private JTextField txtPrecioMostrado;
	private JTextField txtFechRealizacionMostrada;
	private JPanel P3 = new JPanel();

	private JButton btnAtras;
	private JFormattedTextField txtCedulacliente;
	private JFormattedTextField txtTelefonoclient;
	private JComboBox cbxCargoEmpl;
	private JComboBox cmbTipoDeProyecto;
	private JButton btnRegistrar;
	private JLabel lblNombre;
	private JTextArea txtDescripcion;
	private JSpinner spnFechaTermino;
	private JPanel panelTerminos;
	private JCheckBox chckbxAcepto;
	private JButton btnFinalizarContrato;
	private boolean Nocrear = false;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			CrearProyecto dialog = new CrearProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public CrearProyecto() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CrearProyecto.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Crear Proyecto");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			panelTerminos = new JPanel();
			panelTerminos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(153, 204, 255)));
			panelTerminos.setVisible(false);

			panelTerminos.setBackground(Color.WHITE);
			panelTerminos.setBounds(0, 0, 724, 428);
			P3.add(panelTerminos);
			panelTerminos.setLayout(null);

			chckbxAcepto = new JCheckBox("Acepto los t\u00E9rminos y condiciones");
			chckbxAcepto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (chckbxAcepto.isSelected()) {
						btnFinalizarContrato.setEnabled(true);

					} else {

						btnFinalizarContrato.setEnabled(false);
					}

				}
			});
			chckbxAcepto.setBackground(Color.WHITE);
			chckbxAcepto.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			chckbxAcepto.setBounds(59, 339, 223, 23);
			panelTerminos.add(chckbxAcepto);
			{
				btnFinalizarContrato = new JButton("Finalizar");
				btnFinalizarContrato.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.getInstance().loadTable();
						Contrato contratoAux = new Contrato(txtCodigo.getText(), txtCedulacliente.getText(), new Date(),
								(Date) spnFechaTermino.getValue(), true);
						for (Empleado empleado : pAux.getElEquipo()) {
							Empresa.getInstance().buscarEmpleadoPorCedula(empleado.getIdentificador()).setOcupado(true);
						}
						Proyecto NuevoProyecto = new Proyecto(cmbTipoDeProyecto.getSelectedItem().toString(),
								txtCodigo.getText(), true, "A tiempo", pAux.getElEquipo(), txtDescripcion.getText());
						contratoAux.setMiProyecto(NuevoProyecto);
						contratoAux.setCostoProyecto(Double.parseDouble(txtPrecioMostrado.getText()));

						Cliente nuevoCliente = new Cliente(txtCedulacliente.getText(), txtNombreCmostrado.getText(),
								txtApellido.getText(), txtTelefonoclient.getText(), txtDireccion.getText());
						Empresa.getInstance().addContrato(contratoAux);
						if (!Nocrear) {
							Empresa.getInstance().agregarClientes(nuevoCliente);
						}
						Empresa.getInstance().addProyecto(NuevoProyecto);
						
						JOptionPane.showMessageDialog(null, "Contrato creado exitosamente");
						//pAux.getElEquipo().clear();
						loadTable1();
						Nocrear = false;
						Principal.getInstance().loadTable();
					Principal.getInstance().cargarGrafica();
						
						dispose();
					}
				});
				btnFinalizarContrato.setEnabled(false);
				btnFinalizarContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnFinalizarContrato.setBackground(SystemColor.control);
				btnFinalizarContrato.setIcon(
						new ImageIcon(CrearProyecto.class.getResource("/Imagenes/accept-file-or-checklist.png")));
				btnFinalizarContrato.setBounds(59, 369, 128, 23);
				panelTerminos.add(btnFinalizarContrato);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("T\u00E9rminos y condiciones");
				lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setBounds(249, 11, 223, 23);
				panelTerminos.add(lblNewLabel_5);
			}
			{
				JTextArea txtrElPresenteContrato = new JTextArea();
				txtrElPresenteContrato.setLineWrap(true);
				txtrElPresenteContrato.setWrapStyleWord(true);
				txtrElPresenteContrato.setFont(new Font("Century Gothic", Font.PLAIN, 13));
				txtrElPresenteContrato.setText(
						"El presente Contrato regula la utilizaci\u00F3n, por parte de Ud., de los servicios de SoftMasters (los \u201CServicios\u201D), a trav\u00E9s de los cuales Ud. podr\u00E1 comprar, obtener, utilizar bajo licencia, alquilar apps (las \u201CApps\u201D) y otros servicios dentro de las apps (el \u201CContenido\u201D). Nuestro Servicio es: Creaci\u00F3n de software . Nuestros Servicios est\u00E1n disponibles para que los utilice en su Pa\u00EDs de Residencia. Para utilizar nuestros Servicios, Ud. necesitar\u00E1 hardware compatible, software (se recomienda y, en ocasiones, se exige la \u00FAltima versi\u00F3n) .El rendimiento de nuestros Servicios puede verse afectado por estos factores.\r\n\r\n-Derecho de cancelaci\u00F3n: Si elige cancelar su proyecto, puede hacerlo antes de aceptar el proyecto, de lo contrario si cancela el proyecto luego de que este ha sido aceptado, se le cobrara el costo total del proyecto.\r\n\r\nPara cancelar su pedido, deber\u00E1 informarnos de su decisi\u00F3n. \r\n\r\n-Derecho a pr\u00F3rroga: Luego de haber aceptado el proyecto, si el equipo de empleados exige alg\u00FAn cambio que requiera de prorrogar el proyecto este debe obtener la aceptaci\u00F3n de usted y por ende, de aceptar la pr\u00F3rroga, no se le cargara ning\u00FAn monto.\r\n\r\n-Derecho a terminar proyecto: Usted tiene derecho a terminar un proyecto antes de la fecha de t\u00E9rmino elegida, el costo de este seguir\u00E1 permaneciendo igual. \r\n\r\n-En caso de estado de proyecto tard\u00EDo: Si el equipo no finaliza el proyecto para la fecha determinada, se le restar\u00E1 un porcentaje al costo total del proyecto por cada d\u00EDa de tardanza.\r\n\r\nSi no tiene ning\u00FAn inconveniente con nuestros T\u00E9rminos y condiciones, Acepte.");
				txtrElPresenteContrato.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtrElPresenteContrato.setBounds(59, 49, 601, 283);

				JScrollPane lines = new JScrollPane(txtrElPresenteContrato);
				lines.setSize(534, 287);
				lines.setLocation(95, 45);
				panelTerminos.add(lines);

			}
			{
				JButton btnCancelarcontraro = new JButton("Cancelar");
				btnCancelarcontraro.setBackground(SystemColor.control);
				btnCancelarcontraro.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCancelarcontraro
						.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/boton-de-cerrar.png")));
				btnCancelarcontraro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.getInstance().loadTable();
						panelTerminos.setVisible(false);
						btnAtras.setEnabled(true);
					}
				});
				btnCancelarcontraro.setBounds(193, 369, 128, 23);
				panelTerminos.add(btnCancelarcontraro);
			}
		}

		P1 = new JPanel();
		P1.setBackground(Color.WHITE);
		P1.setBounds(0, 0, 724, 428);
		contentPanel.add(P1);
		P1.setLayout(null);

		P1.setVisible(true);

		{
			JPanel panelProyecto = new JPanel();
			panelProyecto.setBackground(Color.WHITE);
			panelProyecto.setBounds(252, 0, 462, 187);
			P1.add(panelProyecto);
			panelProyecto.setLayout(null);
			panelProyecto.setBorder(
					new TitledBorder(null, "Datos del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				JLabel label = new JLabel("C\u00F3digo:");
				label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				label.setBounds(32, 38, 46, 14);
				panelProyecto.add(label);
			}
			{
				JLabel lblTipoDeProyecto = new JLabel("Tipo de proyecto:");
				lblTipoDeProyecto.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblTipoDeProyecto.setBounds(192, 38, 150, 14);
				panelProyecto.add(lblTipoDeProyecto);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setOpaque(false);
				txtCodigo.setBackground(Color.LIGHT_GRAY);
				txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtCodigo.setEnabled(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(32, 53, 136, 20);
				panelProyecto.add(txtCodigo);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblNombre.setBounds(32, 92, 151, 14);
				panelProyecto.add(lblNombre);
			}
			{
				txtDescripcion = new JTextArea();
				txtDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtDescripcion.setBounds(32, 106, 136, 20);
				panelProyecto.add(txtDescripcion);
			}
			{
				cmbTipoDeProyecto = new JComboBox();
				cmbTipoDeProyecto.setBackground(new Color(153, 204, 255));
				cmbTipoDeProyecto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cmbTipoDeProyecto.getSelectedIndex() != 0) {
							if (cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Aplicacion Web")) {
								txtCodigo.setText("AW-" + Empresa.getInstance().getMisProyectos().size());
							} else if (cmbTipoDeProyecto.getSelectedItem().toString()
									.equalsIgnoreCase("Video Juegos")) {
								txtCodigo.setText("VJ-" + Empresa.getInstance().getMisProyectos().size());
							} else if (cmbTipoDeProyecto.getSelectedItem().toString()
									.equalsIgnoreCase("Aplicacion Movil")) {
								txtCodigo.setText("AM-" + Empresa.getInstance().getMisProyectos().size());
							} else if (cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Corporativo")) {
								txtCodigo.setText("CO-" + Empresa.getInstance().getMisProyectos().size());
							} else if (cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Desktop")) {
								txtCodigo.setText("DT-" + Empresa.getInstance().getMisProyectos().size());
							}

						}

					}
				});
				cmbTipoDeProyecto.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Aplicacion Web",
						"Video Juegos", "Aplicacion Movil", "Corporativo", "Desktop" }));
				cmbTipoDeProyecto.setBounds(191, 53, 151, 20);
				panelProyecto.add(cmbTipoDeProyecto);
			}
			{
				JLabel lblFechaDe = new JLabel("Fecha de termino");
				lblFechaDe.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
				lblFechaDe.setBounds(192, 92, 150, 14);
				panelProyecto.add(lblFechaDe);
			}

			spnFechaTermino = new JSpinner();
			Date a=new Date();
			Date b=new Date();
			spnFechaTermino.setModel(new SpinnerDateModel(b, null, null, Calendar.MILLISECOND));
			spnFechaTermino.setBounds(189, 108, 153, 20);
			panelProyecto.add(spnFechaTermino);
		}
		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBackground(Color.WHITE);
		panelEmpleado.setBounds(10, 189, 704, 251);
		P1.add(panelEmpleado);
		panelEmpleado.setBorder(
				new TitledBorder(null, "Datos del equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleado.setLayout(null);
		{
			JLabel lblCargo = new JLabel("Cargo: ");
			lblCargo.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblCargo.setBounds(10, 33, 46, 14);
			panelEmpleado.add(lblCargo);
		}
		{
			cbxCargoEmpl = new JComboBox();
			cbxCargoEmpl.setBackground(new Color(153, 204, 255));
			cbxCargoEmpl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadTable();
				}
			});
			cbxCargoEmpl.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Jefe de proyecto",
					"Planificador", "Dise\u00F1ador", "Programador" }));
			cbxCargoEmpl.setBounds(66, 30, 121, 20);
			panelEmpleado.add(cbxCargoEmpl);
		}

		JButton btnAgregar = new JButton("");
		btnAgregar.setBackground(SystemColor.control);
		btnAgregar.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/flecha-de-siguiente.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (pAux.contadorDeEmpleados() < 5) {
						Empleado aux = Empresa.getInstance().buscarEmpleadoPorCedula(table.getValueAt(table.getSelectedRow(), 0).toString());
						if (aux instanceof JefeProyecto) {
							if (!pAux.agregarJefeProyecto(aux)) {
								JOptionPane.showMessageDialog(null, "Error");
							}
						}
						if (aux instanceof Diseniador) {
							if (!pAux.agregarDiseniador(aux)) {
								JOptionPane.showMessageDialog(null, "Error");
							}
						}
						if (aux instanceof Planificador) {
							if (!pAux.agregarPlanificador(aux)) {
								JOptionPane.showMessageDialog(null, "Error");
							}
						}
						if (aux instanceof Programador) {
							if (!pAux.agregarProgramador(aux)) {
								JOptionPane.showMessageDialog(null, "Error");
							}
						}
						loadTable1();
						loadTable();
					} else {
						JOptionPane.showMessageDialog(null, "no se puede agregar mas de 5 empleados al equipo");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		});
		btnAgregar.setBounds(328, 94, 54, 29);
		panelEmpleado.add(btnAgregar);

		JButton btnEliminar = new JButton("");
		btnEliminar.setBackground(SystemColor.control);
		btnEliminar.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/boton-de-cerrar.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// Empleado aux =
					// Empresa.getInstance().getMisEmpleados().get(table_1.getSelectedRow());
					pAux.getElEquipo().remove(table_1.getSelectedRow());
					
					loadTable1();

				} catch (Exception e2) {

				}
			}
		});
		btnEliminar.setBounds(328, 136, 54, 29);
		panelEmpleado.add(btnEliminar);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 58, 293, 159);
		panelEmpleado.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(401, 58, 293, 159);
		panelEmpleado.add(panel_1_1);
		panel_1_1.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane1 = new JScrollPane();
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			/*
			 * @Override public void mouseClicked(java.awt.event.MouseEvent e) {
			 * }
			 */
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(model1);
		scrollPane1.setViewportView(table_1);
		panel_1_1.add(scrollPane1, BorderLayout.CENTER);

		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/compartiendo (3).png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(23, 11, 219, 167);
			P1.add(label);
		}

		{

			P3.setBackground(Color.WHITE);
			P3.setBounds(0, 0, 724, 428);
			contentPanel.add(P3);
			P3.setLayout(null);
			P3.setVisible(false);

			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(
						new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del Cliente:",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBackground(Color.WHITE);
				panel.setBounds(10, 11, 704, 108);
				P3.add(panel);
				{
					JLabel label = new JLabel("Nombre:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(10, 70, 57, 14);
					panel.add(label);
				}
				{
					txtNombreCmostrado = new JTextField();
					txtNombreCmostrado.setEditable(false);
					txtNombreCmostrado.setColumns(10);
					txtNombreCmostrado.setBounds(77, 67, 408, 21);
					panel.add(txtNombreCmostrado);
				}
				{
					JLabel label = new JLabel("C\u00E9dula:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(10, 29, 57, 14);
					panel.add(label);
				}
				{
					txtCedulaMostrada = new JTextField();
					txtCedulaMostrada.setEditable(false);
					txtCedulaMostrada.setColumns(10);
					txtCedulaMostrada.setBounds(77, 24, 117, 21);
					panel.add(txtCedulaMostrada);
				}
				{
					JLabel label = new JLabel("Tel\u00E9fono:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(204, 29, 57, 14);
					panel.add(label);
				}
				{
					txtTelMostrado = new JTextField();
					txtTelMostrado.setEditable(false);
					txtTelMostrado.setColumns(10);
					txtTelMostrado.setBounds(268, 24, 217, 21);
					panel.add(txtTelMostrado);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2
							.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/avatar-grande (1).png")));
					lblNewLabel_2.setBounds(544, 29, 90, 55);
					panel.add(lblNewLabel_2);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(
						new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n Del Proyecto:",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBackground(Color.WHITE);
				panel.setBounds(10, 130, 704, 108);
				P3.add(panel);
				{
					JLabel label = new JLabel("Nombre:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(10, 25, 55, 14);
					panel.add(label);
				}
				{
					txtNombreProMostrado = new JTextField();
					txtNombreProMostrado.setEditable(false);
					txtNombreProMostrado.setColumns(10);
					txtNombreProMostrado.setBounds(140, 19, 476, 20);
					panel.add(txtNombreProMostrado);
				}
				{
					JLabel label = new JLabel("Fecha de entrega:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(328, 50, 110, 14);
					panel.add(label);
				}
				{
					txtFechaEntregaMostrada = new JTextField();
					txtFechaEntregaMostrada.setText((String) null);
					txtFechaEntregaMostrada.setEditable(false);
					txtFechaEntregaMostrada.setColumns(10);
					txtFechaEntregaMostrada.setBounds(438, 47, 178, 20);
					panel.add(txtFechaEntregaMostrada);
				}
				{
					JLabel label = new JLabel("Total a pagar:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(10, 81, 85, 14);
					panel.add(label);
				}
				{
					txtPrecioMostrado = new JTextField();
					txtPrecioMostrado.setEditable(false);
					txtPrecioMostrado.setColumns(10);
					txtPrecioMostrado.setBounds(140, 78, 178, 20);
					panel.add(txtPrecioMostrado);
				}
				{
					JLabel label = new JLabel("Fecha de Realizaci\u00F3n:");
					label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
					label.setBounds(10, 53, 131, 14);
					panel.add(label);
				}
				{
					txtFechRealizacionMostrada = new JTextField();
					txtFechRealizacionMostrada.setText((String) null);
					txtFechRealizacionMostrada.setEditable(false);
					txtFechRealizacionMostrada.setColumns(10);
					txtFechRealizacionMostrada.setBounds(140, 50, 178, 20);
					panel.add(txtFechRealizacionMostrada);
				}
			}

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Equipo de Trabajo",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 246, 704, 171);
			P3.add(panel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 22, 438, 138);
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				/*
				 * @Override public void mouseClicked(java.awt.event.MouseEvent
				 * e) { }
				 */
			});
			table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_1.setModel(model1);
			scrollPane.setViewportView(table_1);
			/**/ panel.add(scrollPane, BorderLayout.CENTER);
			{
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setIcon(
						new ImageIcon(CrearProyecto.class.getResource("/Imagenes/solicitud-de-amistad (2).png")));
				lblNewLabel_3.setBounds(491, 48, 142, 97);
				panel.add(lblNewLabel_3);
			}
		}
		P2 = new JPanel();
		P2.setBackground(Color.WHITE);
		P2.setBounds(0, 0, 724, 440);
		contentPanel.add(P2);
		P2.setLayout(null);
		P2.setVisible(false);
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setBounds(255, 11, 413, 239);
		P2.add(panelInfo);
		{
			JLabel label = new JLabel("C\u00E9dula:");
			label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			label.setBounds(10, 35, 46, 14);
			panelInfo.add(label);
		}
		{
			JLabel label = new JLabel("Tel\u00E9fono:");
			label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			label.setBounds(10, 196, 63, 14);
			panelInfo.add(label);
		}
		{
			JLabel label = new JLabel("Nombre: ");
			label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			label.setBounds(10, 84, 63, 14);
			panelInfo.add(label);
		}
		{
			JLabel label = new JLabel("Direcci\u00F3n: ");
			label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			label.setBounds(10, 157, 63, 14);
			panelInfo.add(label);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(96, 151, 292, 20);
			panelInfo.add(txtDireccion);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(96, 78, 292, 20);
			panelInfo.add(txtNombre);
		}
		{
			JLabel lblNewLabel = new JLabel("Apellido:");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 11));
			lblNewLabel.setBounds(10, 121, 76, 14);
			panelInfo.add(lblNewLabel);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(96, 115, 292, 20);
			panelInfo.add(txtApellido);
		}

		try {
			MaskFormatter ced = new MaskFormatter("###-#######-#");
			ced.setPlaceholderCharacter('_');
			txtCedulacliente = new JFormattedTextField(ced);
		} catch (Exception e) {
		}

		txtCedulacliente.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Cliente c = Empresa.getInstance().buscarClientePorCedula(txtCedulacliente.getText());

				if (c != null) {
					txtCedulacliente.setText(c.getId());
					txtNombre.setText(c.getNombre());
					txtApellido.setText(c.getApellido());
					txtDireccion.setText(c.getDireccion());
					txtTelefonoclient.setText(c.getTelefono());

					txtCedulacliente.setEnabled(false);
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefonoclient.setEnabled(false);
					Nocrear = true;

				} else {

					txtCedulacliente.setText(" ");
					txtNombre.setText(" ");
					txtApellido.setText(" ");
					txtDireccion.setText(" ");
					txtTelefonoclient.setText(" ");

					txtCedulacliente.setEnabled(true);
					txtNombre.setEnabled(true);
					txtApellido.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefonoclient.setEnabled(true);

				}

			}
		});
		txtCedulacliente.setBounds(76, 32, 128, 20);
		panelInfo.add(txtCedulacliente);

		try {
			MaskFormatter tel = new MaskFormatter("###-###-####");
			tel.setPlaceholderCharacter('_');
			txtTelefonoclient = new JFormattedTextField(tel);
		} catch (Exception e) {
		}

		txtTelefonoclient.setBounds(96, 190, 128, 20);
		panelInfo.add(txtTelefonoclient);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/avatar-grande (3).png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(26, 31, 217, 173);
			P2.add(lblNewLabel_1);
		}

		{
			{
			}
		}
		{

			{
			}
		}
		{
			String[] columnNames = { "Cedula", "Nombre", "Apellido", "Salario", "Estado" };
			// model=new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);

		}
		loadTable();
		{
			String[] columnNames = { "Cedula", "Nombre", "Apellido", "Salario", "Estado" };
			// model1=new DefaultTableModel();
			model1.setColumnIdentifiers(columnNames);
		}

		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 204, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Siguiente");
				okButton.setBackground(SystemColor.control);
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/flecha-de-siguiente.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAtras.setEnabled(true);
						int k = 0;
						if (P1.isVisible()) {
							if (pAux.contadorDeEmpleados() != 5) {
								JOptionPane.showMessageDialog(null, "La cantidad de empleados por proyecto debe ser 5");
							} else if (txtCodigo.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
							} else {
								k = 1;
								P1.setVisible(false);
								P3.setVisible(false);
								P2.setVisible(true);
							}

						} else if (P2.isVisible()) {
							if (faltaAlgo()) {
								JOptionPane.showMessageDialog(null, "Debe introducir un cliente");
							} else {
								txtCedulaMostrada.setText(txtCedulacliente.getText());
								txtNombreCmostrado.setText(txtNombre.getText() + " " + txtApellido.getText());
								txtTelMostrado.setText(txtTelefonoclient.getText());
								txtNombreProMostrado.setText(txtDescripcion.getText());
								SimpleDateFormat fecha1 = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat fecha2 = new SimpleDateFormat("dd/MM/yyyy");
								txtFechaEntregaMostrada.setText(fecha1.format(spnFechaTermino.getValue()));
								txtFechRealizacionMostrada.setText(fecha2.format(new Date()));
								Date dateHoy = new Date();
								Contrato contrato = new Contrato(txtCodigo.getText(), txtCedulaMostrada.getText(),dateHoy, (Date) spnFechaTermino.getValue(), false);
								Proyecto proyecto = pAux;
								proyecto.setCodigoProyecto(txtCodigo.getText());
								proyecto.setDescripcionDeProyecto(txtNombreProMostrado.getText());
								contrato.setMiProyecto(proyecto);
								txtPrecioMostrado.setText(Double.toString(Math.round(contrato.costoDeProyectoAtiempo())));
								btnRegistrar.setEnabled(true);
								P1.setVisible(false);
								P2.setVisible(false);
								P3.setVisible(true);
								okButton.setEnabled(false);
							}
						}
					}

					private boolean faltaAlgo() {
						boolean falta = false;
						if (txtCedulacliente.getText().isEmpty() || txtApellido.getText().isEmpty()
								|| txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty()
								|| txtTelefonoclient.getText().isEmpty()) {
							falta = true;
						}
						return falta;

					}
				});
				{
					btnAtras = new JButton("Atras");
					btnAtras.setBackground(SystemColor.control);
					btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnAtras.setIcon(new ImageIcon(
							CrearProyecto.class.getResource("/Imagenes/flecha-blanca-hacia-la-izquierda-.png")));
					btnAtras.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (P1.isVisible()) {
								btnAtras.setEnabled(false);
							}
							if (P2.isVisible()) {
								btnAtras.setEnabled(false);
								P1.setVisible(true);
								P2.setVisible(false);
								P3.setVisible(false);
								btnRegistrar.setEnabled(false);
							} else if (P3.isVisible()) {
								btnAtras.setEnabled(true);
								okButton.setEnabled(true);
								btnRegistrar.setEnabled(false);
								P1.setVisible(false);
								P2.setVisible(true);
								P3.setVisible(false);

							}
						}
					});
					btnRegistrar = new JButton("Registrar");
					btnRegistrar.setBackground(SystemColor.control);
					btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnRegistrar.setIcon(
							new ImageIcon(CrearProyecto.class.getResource("/Imagenes/signo-de-comprobado.png")));
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Principal.getInstance().loadTable();
							/* Guardar los datos */
							panelTerminos.setVisible(true);
							btnAtras.setEnabled(false);

						}
					});
					buttonPane.add(btnRegistrar);
					buttonPane.add(btnAtras);
					btnRegistrar.setEnabled(false);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(SystemColor.control);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Imagenes/boton-de-cerrar.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pAux.getElEquipo().clear();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	// Tabla para cargar contratos de cliente
	/*
	 * private void loadTable2(String id) { // TODO Auto-generated method stub
	 * model.setRowCount(0); fila = new Object[model.getColumnCount()]; for
	 * (Contrato contrato :
	 * Empresa.getInstance().buscarClientePorCedula(id).getMiContrato()) {
	 * 
	 * fila[0] = contrato.getCodigoProyecto(); fila[1] =
	 * contrato.getFechaInicio(); fila[2] = contrato.getFechaTermino();
	 * 
	 * model.addRow(fila);
	 * 
	 * } }
	 */

	private void loadTable1() {
		model1.setRowCount(0);
		fila1 = new Object[model1.getColumnCount()];
		for (Empleado empleado : pAux.getElEquipo()) {
			fila1[0] = empleado.getIdentificador();
			fila1[1] = empleado.getNombre();
			fila1[2] = empleado.getApellidos();
			fila1[3] = empleado.getSalario();
			if (empleado.isOcupado()) {
				fila1[4] = "Ocupado";
			} else {
				fila1[4] = "Disponible";
			}

			model1.addRow(fila1);
		}

	}

	private void loadTable() {
		// TODO Auto-generated method stub

		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empleado empleado : Empresa.getInstance().getMisEmpleados()) {
			if (pAux.buscarEmpleadoPorCedula(empleado.getIdentificador()) == null && !empleado.isOcupado()) {

				if (cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
				}

				/****** Filtrado de los empleados ******/

				else if (cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Jefe de proyecto")) {
					if (empleado instanceof JefeProyecto) {
						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						fila[3] = empleado.getSalario();
						if (empleado.isOcupado()) {
							fila[4] = "Ocupado";
						} else {
							fila[4] = "Disponible";
						}

						model.addRow(fila);

					}
				} else if (cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Planificador")) {
					if (empleado instanceof Planificador) {

						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						fila[3] = empleado.getSalario();
						if (empleado.isOcupado()) {
							fila[4] = "Ocupado";
						} else {
							fila[4] = "Disponible";
						}

						model.addRow(fila);

					}
				} else if (cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Dise\u00F1ador")) {
					if (empleado instanceof Diseniador) {

						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						fila[3] = empleado.getSalario();
						if (empleado.isOcupado()) {
							fila[4] = "Ocupado";
						} else {
							fila[4] = "Disponible";
						}

						model.addRow(fila);

					}
				} else if (cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Programador")) {
					if (empleado instanceof Programador) {

						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						fila[3] = empleado.getSalario();
						if (empleado.isOcupado()) {
							fila[4] = "Ocupado";
						} else {
							fila[4] = "Disponible";
						}

						model.addRow(fila);

					}
				}

				/*
				 * fila[0] = empleado.getIdentificador(); fila[1] =
				 * empleado.getNombre(); fila[2] = empleado.getApellidos();
				 * fila[3] = empleado.getSalario(); if (empleado.isOcupado()){
				 * fila[4] = "Ocupado"; } else{ fila[4] = "Disponible"; }
				 * 
				 * model.addRow(fila);
				 */

			}
		}

	}
	}