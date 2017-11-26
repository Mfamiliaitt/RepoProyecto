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
	private JFormattedTextField txtCedulabuscar;
	private JFormattedTextField txtCedulacliente;
	private JFormattedTextField txtTelefonoclient;
		

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
			P3 = new JPanel();
			P3.setBounds(0, 0, 724, 428);
			contentPanel.add(P3);
			P3.setLayout(null);
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
				panel.setBounds(10, 130, 704, 287);
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
				{
					JPanel panel_1 = new JPanel();
					panel_1.setLayout(null);
					panel_1.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Equipo de Trabajo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					panel_1.setBackground(SystemColor.control);
					panel_1.setBounds(10, 106, 684, 170);
					panel.add(panel_1);
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 22, 664, 137);
						panel_1.add(scrollPane);
					}
				}
			}
		}
		
		P1 = new JPanel();
		P1.setBounds(0, 0, 724, 428);
		contentPanel.add(P1);
		P1.setLayout(null);
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
				JComboBox cmbTipoDeProyecto = new JComboBox();
				cmbTipoDeProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Aplicacion Web", "Video Juegos", "Aplicacion Movil", "Corporativo", "Desktop"}));
				cmbTipoDeProyecto.setBounds(191, 53, 151, 20);
				panelProyecto.add(cmbTipoDeProyecto);
			}
		}
		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBounds(10, 189, 704, 228);
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
		
		JButton btnAgregar = new JButton(">");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(pAux.contadorDeEmpleados()<5){	
		   Empleado aux = Empresa.getInstance().getMisEmpleados().get(table.getSelectedRow());	
		  
		   if(aux instanceof JefeProyecto){if(!pAux.agregarJefeProyecto(aux)){
			   JOptionPane.showMessageDialog(null, "Error"); }}
		   if(aux instanceof Diseniador ){if(!pAux.agregarDiseniador(aux)){
			   JOptionPane.showMessageDialog(null, "Error");}}
		   if(aux instanceof Planificador){if(!pAux.agregarPlanificador(aux)){
			   JOptionPane.showMessageDialog(null, "Error");}}
		   if(aux instanceof Programador){if(!pAux.agregarProgramador(aux)){
			   JOptionPane.showMessageDialog(null, "Error");}}
		   loadTable1();
			}else{JOptionPane.showMessageDialog(null, "no se puede agregar mas de 5 empleados al equipo");}}
			
		});
		btnAgregar.setBounds(328, 94, 54, 29);
		panelEmpleado.add(btnAgregar);
		
		JButton btnEliminar = new JButton("X");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado aux = Empresa.getInstance().getMisEmpleados().get(table_1.getSelectedRow());
				pAux.getElEquipo().remove(aux);
				loadTable1();
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
		P2.setBounds(0, 0, 724, 428);
		contentPanel.add(P2);
		P2.setLayout(null);
		P2.setVisible(false);
		{
			JPanel panelBusqueda = new JPanel();
			panelBusqueda.setLayout(null);
			panelBusqueda.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Busqueda de cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelBusqueda.setBackground(SystemColor.control);
			panelBusqueda.setBounds(10, 26, 387, 104);
			P2.add(panelBusqueda);
			{
				JLabel label = new JLabel("C\u00E9dula: ");
				label.setBounds(10, 40, 55, 14);
				panelBusqueda.add(label);
			}
			{
				txtCedulabuscar = new JFormattedTextField();
				try {
					MaskFormatter ced = new MaskFormatter("###-#######-#");
					ced.setPlaceholderCharacter('_');
					txtCedulabuscar  = new JFormattedTextField(ced);
				} catch (Exception e) {}
				txtCedulabuscar.setColumns(10);
				txtCedulabuscar.setBounds(76, 37, 165, 20);
				panelBusqueda.add(txtCedulabuscar);
			}
			{
				JButton button = new JButton("<html><font color = black>Buscar</font></html>");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String buscarcedula=txtCedulabuscar.getText();
					
					Cliente c=Empresa.getInstance().buscarClientePorCedula(buscarcedula);
					
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
						JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente ", "Información", JOptionPane.INFORMATION_MESSAGE);
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
			panelInfo.setBounds(10, 153, 387, 239);
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
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(76, 154, 292, 20);
				panelInfo.add(txtDireccion);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
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
				txtApellido.setEditable(false);
				txtApellido.setColumns(10);
				txtApellido.setBounds(76, 118, 292, 20);
				panelInfo.add(txtApellido);
			}
			
			txtTelefonoclient = new JFormattedTextField();
			try {
				MaskFormatter ced = new MaskFormatter("###-###-####");
				ced.setPlaceholderCharacter('_');
				txtTelefonoclient = new JFormattedTextField(ced);
			} catch (Exception e) {}
			txtTelefonoclient.setBounds(76, 193, 140, 20);
			panelInfo.add(txtTelefonoclient);
			{
				txtCedulacliente = new JFormattedTextField();
				try {
					MaskFormatter ced = new MaskFormatter("###-#######-#");
					ced.setPlaceholderCharacter('_');
					txtCedulacliente = new JFormattedTextField(ced);
				} catch (Exception e) {}
				txtCedulacliente.setBounds(76, 32, 140, 20);
				panelInfo.add(txtCedulacliente);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Imagen que se quiera poner");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(458, 26, 217, 104);
			P2.add(lblNewLabel_1);
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
			JSpinner spnFechaEntrega = new JSpinner();
			getContentPane().add(spnFechaEntrega, BorderLayout.NORTH);
			spnFechaEntrega.setModel(new SpinnerDateModel(new Date(1511582400000L), null, null, Calendar.DAY_OF_YEAR));
		}
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
							P3.setVisible(false);
						}
						else if(P2.isVisible()){
							P1.setVisible(false);
							P2.setVisible(false);
							P3.setVisible(true);
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
							else if(P3.isVisible()){
								P1.setVisible(false);
								P2.setVisible(true);
								P3.setVisible(false);
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
}