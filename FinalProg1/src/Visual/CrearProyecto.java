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

public class CrearProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtDireccion;
	private JTextField txtNombre;
	private JPanel P1;
	private JPanel P2;
	private JTextField txtApellido;
	private static Object[] fila;
	private static DefaultTableModel model=new DefaultTableModel();
	private static Object[] fila1;
	private static DefaultTableModel model1=new DefaultTableModel();
	private JTable table;
	private JTable table_1;
	private Proyecto pAux=new Proyecto();
	private JTextField txtNom;
	private JTextField txtCedula;
	private JTextField txttell;
	private JTextField txtProNom;
	private JTextField txtFechaEntre;
	private JTextField txtEntrega;
	private JTextField txtFechReali;
	private JPanel P3;
	

	private JButton btnAtras;
	private JFormattedTextField txtCedulacliente;
	private JFormattedTextField txtTelefonoclient;
	private JComboBox cbxCargoEmpl;
	private JComboBox cmbTipoDeProyecto;
	private JButton btnRegistrar;
		

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
		
		P1 = new JPanel();
		P1.setBounds(0, 0, 724, 440);
		contentPanel.add(P1);
		P1.setLayout(null);
		
		P1.setVisible(true);
		
				{
					JPanel panelProyecto = new JPanel();
					panelProyecto.setBounds(252, 0, 462, 187);
					P1.add(panelProyecto);
					panelProyecto.setLayout(null);
					panelProyecto.setBorder(new TitledBorder(null, "Datos del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					{
						JLabel label = new JLabel("C\u00F3digo:");
						label.setBounds(32, 38, 46, 14);
						panelProyecto.add(label);
					}
					{
						JLabel lblTipoDeProyecto = new JLabel("Tipo de proyecto:");
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
						JLabel label = new JLabel("Descripcion");
						label.setBounds(32, 92, 151, 14);
						panelProyecto.add(label);
					}
					{
						JTextArea txtDescripcion = new JTextArea();
						txtDescripcion.setBounds(32, 106, 416, 55);
						panelProyecto.add(txtDescripcion);
					}
					{
						cmbTipoDeProyecto = new JComboBox();
						cmbTipoDeProyecto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(cmbTipoDeProyecto.getSelectedIndex()!=0){
									if(cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Aplicacion Web")){
										txtCodigo.setText("AW-"+Empresa.getInstance().getMisProyectos().size());
									}else if(cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Video Juegos")){
										txtCodigo.setText("VJ-"+Empresa.getInstance().getMisProyectos().size());
									}else if(cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Aplicacion Movil")){
										txtCodigo.setText("AM-"+Empresa.getInstance().getMisProyectos().size());
									}else if(cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Corporativo")){
										txtCodigo.setText("CO-"+Empresa.getInstance().getMisProyectos().size());
									}else if(cmbTipoDeProyecto.getSelectedItem().toString().equalsIgnoreCase("Desktop")){
										txtCodigo.setText("DT-"+Empresa.getInstance().getMisProyectos().size());
									}
										
								}
								
							}
						});
						cmbTipoDeProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Aplicacion Web", "Video Juegos", "Aplicacion Movil", "Corporativo", "Desktop"}));
						cmbTipoDeProyecto.setBounds(191, 53, 151, 20);
						panelProyecto.add(cmbTipoDeProyecto);
					}
				}
				JPanel panelEmpleado = new JPanel();
				panelEmpleado.setBounds(10, 189, 704, 251);
				P1.add(panelEmpleado);
				panelEmpleado.setBorder(new TitledBorder(null, "Datos del equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelEmpleado.setLayout(null);
				{
					JLabel lblCargo = new JLabel("Cargo: ");
					lblCargo.setBounds(10, 33, 46, 14);
					panelEmpleado.add(lblCargo);
				}
				{
					cbxCargoEmpl = new JComboBox();
					cbxCargoEmpl.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							loadTable();
						}
					});
					cbxCargoEmpl.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Jefe de proyecto", "Planificador", "Dise\u00F1ador", "Programador"}));
					cbxCargoEmpl.setBounds(66, 30, 121, 20);
					panelEmpleado.add(cbxCargoEmpl);
				}
				
				JButton btnAgregar = new JButton(">");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(pAux.contadorDeEmpleados()<5){	
								   Empleado aux =Empresa.getInstance().buscarEmpleadoPorCedula(table.getValueAt(table.getSelectedRow(),0).toString());
								   if(aux instanceof JefeProyecto){if(!pAux.agregarJefeProyecto(aux)){
									   JOptionPane.showMessageDialog(null, "Error"); }}
								   if(aux instanceof Diseniador ){if(!pAux.agregarDiseniador(aux)){
									   JOptionPane.showMessageDialog(null, "Error");}}
								   if(aux instanceof Planificador){if(!pAux.agregarPlanificador(aux)){
									   JOptionPane.showMessageDialog(null, "Error");}}
								   if(aux instanceof Programador){if(!pAux.agregarProgramador(aux)){
									   JOptionPane.showMessageDialog(null, "Error");}}
								   loadTable1();
									}else{JOptionPane.showMessageDialog(null, "no se puede agregar mas de 5 empleados al equipo");}
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				});
				btnAgregar.setBounds(328, 94, 54, 29);
				panelEmpleado.add(btnAgregar);
				
				JButton btnEliminar = new JButton("X");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					try {
						
						//Empleado aux = Empresa.getInstance().getMisEmpleados().get(table_1.getSelectedRow());
						pAux.getElEquipo().remove(table_1.getSelectedRow());
						pAux.getElEquipo().trimToSize();
						loadTable1();
						
					} catch (Exception e2) {
						
					}	
					}
				});
				btnEliminar.setBounds(328, 136, 54, 29);
				panelEmpleado.add(btnEliminar);
				
				JPanel panel_2 = new JPanel();
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
					panel_1_1.setBounds(401, 58, 293, 159);
					panelEmpleado.add(panel_1_1);
					panel_1_1.setLayout(new BorderLayout(0, 0));
					JScrollPane scrollPane1 = new JScrollPane();
					table_1 = new JTable();
					table_1.addMouseListener(new MouseAdapter() {
					/*	@Override
						public void mouseClicked(java.awt.event.MouseEvent e) {
						}*/
					});
					table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table_1.setModel(model1);
					scrollPane1.setViewportView(table_1);
					panel_1_1.add(scrollPane1, BorderLayout.CENTER);
					
							{
								JLabel label = new JLabel("Imagen del proyecto");
								label.setHorizontalAlignment(SwingConstants.CENTER);
								label.setBounds(23, 11, 219, 167);
								P1.add(label);
							}
		P2 = new JPanel();
		P2.setBounds(0, 0, 724, 440);
		contentPanel.add(P2);
		P2.setLayout(null);
		P2.setVisible(false);
			JPanel panelInfo = new JPanel();
			panelInfo.setLayout(null);
			panelInfo.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInfo.setBackground(SystemColor.control);
			panelInfo.setBounds(10, 26, 387, 239);
			P2.add(panelInfo);
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(10, 35, 46, 14);
				panelInfo.add(label);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(10, 196, 63, 14);
				panelInfo.add(label);
			}
			{
				JLabel label = new JLabel("Nombre: ");
				label.setBounds(10, 84, 63, 14);
				panelInfo.add(label);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n: ");
				label.setBounds(10, 157, 63, 14);
				panelInfo.add(label);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(76, 154, 292, 20);
				panelInfo.add(txtDireccion);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(76, 81, 292, 20);
				panelInfo.add(txtNombre);
			}
			{
				JLabel lblNewLabel = new JLabel("Apellido:");
				lblNewLabel.setBounds(10, 121, 46, 14);
				panelInfo.add(lblNewLabel);
			}
			{
				txtApellido = new JTextField();
				txtApellido.setColumns(10);
				txtApellido.setBounds(76, 118, 292, 20);
				panelInfo.add(txtApellido);
			}
			
			try {
				MaskFormatter ced = new MaskFormatter("###-#######-#");
				ced.setPlaceholderCharacter('_');
				txtCedulacliente = new JFormattedTextField(ced);				
				txtCedulacliente.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {									
						Cliente c=Empresa.getInstance().buscarClientePorCedula(txtCedulacliente.getText());
						
						if (c!=null){
							txtCedulacliente.setText((" ")+c.getId());
							txtNombre.setText((" ")+c.getNombre());
							txtApellido.setText((" ")+c.getApellido());
							txtDireccion.setText((" ")+c.getDireccion());
							txtTelefonoclient.setText((" ")+c.getTelefono());
							
							txtCedulacliente.setEnabled(false);
							txtNombre.setEnabled(false);
							txtApellido.setEnabled(false);
							txtDireccion.setEnabled(false);
							txtTelefonoclient.setEnabled(false);
							
						}
						else{
						
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
			} catch (Exception e) {}
			txtCedulacliente.setBounds(76, 32, 128, 20);
			panelInfo.add(txtCedulacliente);		
						

						try {
							MaskFormatter tel = new MaskFormatter("###-###-####");
							tel.setPlaceholderCharacter('_');
							txtTelefonoclient = new JFormattedTextField(tel);
						} catch (Exception e) {}
						
						txtTelefonoclient.setBounds(76, 193, 128, 20);
						panelInfo.add(txtTelefonoclient);
						{
							JLabel lblNewLabel_1 = new JLabel("Imagen que se quiera poner");
							lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_1.setBounds(458, 26, 217, 104);
							P2.add(lblNewLabel_1);
						}{}	
		{
			P3 = new JPanel();
			P3.setBounds(0, 0, 724, 428);
			contentPanel.add(P3);
			P3.setLayout(null);
			P3.setVisible(false);
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBackground(SystemColor.control);
				panel.setBounds(10, 11, 704, 108);
				P3.add(panel);
				{
					JLabel label = new JLabel("Nombre:");
					label.setBounds(10, 70, 57, 14);
					panel.add(label);
				}
				{
					txtNom = new JTextField();
					txtNom.setEditable(false);
					txtNom.setColumns(10);
					txtNom.setBounds(77, 67, 408, 21);
					panel.add(txtNom);
				}
				{
					JLabel label = new JLabel("C\u00E9dula:");
					label.setBounds(10, 29, 57, 14);
					panel.add(label);
				}
				{
					txtCedula = new JTextField();
					txtCedula.setEditable(false);
					txtCedula.setColumns(10);
					txtCedula.setBounds(77, 24, 117, 21);
					panel.add(txtCedula);
				}
				{
					JLabel label = new JLabel("Tel\u00E9fono:");
					label.setBounds(204, 29, 57, 14);
					panel.add(label);
				}
				{
					txttell = new JTextField();
					txttell.setEditable(false);
					txttell.setColumns(10);
					txttell.setBounds(268, 24, 217, 21);
					panel.add(txttell);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n Del Proyecto:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBackground(SystemColor.control);
				panel.setBounds(10, 130, 704, 108);
				P3.add(panel);
				{
					JLabel label = new JLabel("Nombre:");
					label.setBounds(10, 18, 55, 14);
					panel.add(label);
				}
				{
					txtProNom = new JTextField();
					txtProNom.setEditable(false);
					txtProNom.setColumns(10);
					txtProNom.setBounds(140, 15, 476, 20);
					panel.add(txtProNom);
				}
				{
					JLabel label = new JLabel("Fecha de entrega:");
					label.setBounds(328, 50, 110, 14);
					panel.add(label);
				}
				{
					txtFechaEntre = new JTextField();
					txtFechaEntre.setText((String) null);
					txtFechaEntre.setEditable(false);
					txtFechaEntre.setColumns(10);
					txtFechaEntre.setBounds(438, 47, 178, 20);
					panel.add(txtFechaEntre);
				}
				{
					JLabel label = new JLabel("Total a pagar:");
					label.setBounds(10, 81, 85, 14);
					panel.add(label);
				}
				{
					txtEntrega = new JTextField();
					txtEntrega.setEditable(false);
					txtEntrega.setColumns(10);
					txtEntrega.setBounds(140, 78, 178, 20);
					panel.add(txtEntrega);
				}
				{
					JLabel label = new JLabel("Fecha de Realizaci\u00F3n:");
					label.setBounds(10, 53, 131, 14);
					panel.add(label);
				}
				{
					txtFechReali = new JTextField();
					txtFechReali.setText((String) null);
					txtFechReali.setEditable(false);
					txtFechReali.setColumns(10);
					txtFechReali.setBounds(140, 50, 178, 20);
					panel.add(txtFechReali);
				}
			}
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Equipo de Trabajo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(SystemColor.menu);
			panel.setBounds(10, 235, 704, 170);
			P3.add(panel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 22, 684, 137);
			panel.add(scrollPane);
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
			String[] columnNames = {"Cedula","Nombre","Apellido","Salario","Estado"};
			//model=new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			
		}loadTable();
		{
			String[] columnNames = {"Cedula","Nombre","Apellido","Salario","Estado"};
			//model1=new DefaultTableModel();
			model1.setColumnIdentifiers(columnNames);
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
						if(P1.isVisible() && pAux.contadorDeEmpleados()!=5){
							JOptionPane.showMessageDialog(null, "La cantidad de empleados por proyecto debe ser 5");
						}else{
							btnAtras.setEnabled(true);
							P1.setVisible(false);
							P3.setVisible(false);
							P2.setVisible(true);
						}
						if(P2.isVisible() && faltaAlgo()){
							JOptionPane.showMessageDialog(null, "Debe introducir un cliente");
						}else if(Empresa.getInstance().isclienteregistrado(txtCedulacliente.getText())){
							JOptionPane.showMessageDialog(null, "El cliente con cedula "+Empresa.getInstance().buscarClientePorCedula(txtCedulacliente.getText()).getId()+" ya existe, por favor buscarlo.");
						}else{
							btnAtras.setEnabled(true);
							P1.setVisible(false);
							P2.setVisible(false);
							P3.setVisible(true);
						}
							if(P3.isVisible()){
								btnRegistrar.setEnabled(true);								
							}
					}
					private boolean faltaAlgo() {
						boolean falta=false;
						if(txtCedulacliente.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() ){
							falta=true;
						}						
						return falta;
						
					}
				});
				{
					btnAtras = new JButton("Atras");
					btnAtras.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(P1.isVisible()){
								btnAtras.setEnabled(false);
							}
							if(P2.isVisible()){
								P1.setVisible(true);
								P2.setVisible(false);
							}
							else if(P3.isVisible()){
								P1.setVisible(false);
								P2.setVisible(true);
								P3.setVisible(false);
							}
						}
					});					
					btnRegistrar = new JButton("Registrar");
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							/*Guardar los datos*/
						//	txtNombre.
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
				JButton cancelButton = new JButton("Cancelar");
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
	//Tabla para cargar contratos de cliente
   /*  private void loadTable2(String id) {
		// TODO Auto-generated method stub
    	 model.setRowCount(0);
 		fila = new Object[model.getColumnCount()];
 		for (Contrato contrato : Empresa.getInstance().buscarClientePorCedula(id).getMiContrato()) {
 			
 			fila[0] = contrato.getCodigoProyecto();
 			fila[1] = contrato.getFechaInicio();
 			fila[2] =  contrato.getFechaTermino();
 			
 			model.addRow(fila);
		
	}
     }*/

	private void loadTable1() {
		model1.setRowCount(0);
		fila1 = new Object[model1.getColumnCount()];
		for(Empleado empleado: pAux.getElEquipo()){
			fila1[0] = empleado.getIdentificador();
			fila1[1] = empleado.getNombre();
			fila1[2] = empleado.getApellidos();
			fila1[3] = empleado.getSalario();
			if (empleado.isOcupado()){
			    fila1[4] = "Ocupado";
			}
			else{
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
				if(cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")){}
				else if(cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Jefe de proyecto")){
				 if (empleado instanceof JefeProyecto) {						
						fila[0] = empleado.getIdentificador();
						fila[1] = empleado.getNombre();
						fila[2] = empleado.getApellidos();
						fila[3] = empleado.getSalario();
						if (empleado.isOcupado()){
						    fila[4] = "Ocupado";
						}
						else{
							fila[4] = "Disponible";
						}
						
						model.addRow(fila);
						
					}
				}
				else if(cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Planificador")){
					 if (empleado instanceof Planificador) {
							
							fila[0] = empleado.getIdentificador();
							fila[1] = empleado.getNombre();
							fila[2] = empleado.getApellidos();
							fila[3] = empleado.getSalario();
							if (empleado.isOcupado()){
							    fila[4] = "Ocupado";
							}
							else{
								fila[4] = "Disponible";
							}
							
							model.addRow(fila);
							
						}
				}
				else if(cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Dise\u00F1ador")){
					 if (empleado instanceof Diseniador) {
							
							fila[0] = empleado.getIdentificador();
							fila[1] = empleado.getNombre();
							fila[2] = empleado.getApellidos();
							fila[3] = empleado.getSalario();
							if (empleado.isOcupado()){
							    fila[4] = "Ocupado";
							}
							else{
								fila[4] = "Disponible";
							}
							
							model.addRow(fila);
							
						}
				}
				else if(cbxCargoEmpl.getSelectedItem().toString().equalsIgnoreCase("Programador")){
					 if (empleado instanceof Programador) {
							
							fila[0] = empleado.getIdentificador();
							fila[1] = empleado.getNombre();
							fila[2] = empleado.getApellidos();
							fila[3] = empleado.getSalario();
							if (empleado.isOcupado()){
							    fila[4] = "Ocupado";
							}
							else{
								fila[4] = "Disponible";
							}
							
							model.addRow(fila);
							
						}
				}
				
				
				/*fila[0] = empleado.getIdentificador();
				fila[1] = empleado.getNombre();
				fila[2] = empleado.getApellidos();
				fila[3] = empleado.getSalario();
				if (empleado.isOcupado()){
				    fila[4] = "Ocupado";
				}
				else{
					fila[4] = "Disponible";
				}
				
				model.addRow(fila);*/
			
		
		}
		
	}	
}