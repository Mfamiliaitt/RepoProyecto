package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logic.Cliente;
import logic.Diseniador;
import logic.Empleado;
import logic.Empresa;
import logic.JefeProyecto;
import logic.Planificador;
import logic.Programador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

public class ListadoClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JButton btnBuscarCliente;
	private JFormattedTextField txtbusc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoClientes dialog = new ListadoClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoClientes.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Listado de Clientes");
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
				JButton btnSalir = new JButton("Salir");
				btnSalir.setBackground(SystemColor.control);
				btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnSalir.setIcon(new ImageIcon(ListadoClientes.class.getResource("/Imagenes/boton-de-cerrar.png")));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "Clientes registrados ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(29, 68, 665, 338);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.setGridColor(Color.WHITE);
					table.setBackground(Color.WHITE);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Cédula","Nombre","Dirección"};
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
				lblNewLabel.setBounds(10, 14, 140, 14);
				panel.add(lblNewLabel);
			}
			
			try {
				MaskFormatter t = new MaskFormatter("###-#######-#");
				t.setPlaceholderCharacter('_');
				txtbusc = new JFormattedTextField(t);
			} catch (Exception e) {}
			txtbusc.setBounds(124, 12, 135, 20);
			panel.add(txtbusc);			
			btnBuscarCliente = new JButton("Buscar");
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cliente c=Empresa.getInstance().buscarClientePorCedula(txtbusc.getText());
					
					if(c!=null){
							loadTable2(txtbusc.getText());		
						}
					else{
							JOptionPane.showMessageDialog(null, "El cliente no existe");
							txtbusc.setText("");
							loadTable();	
						}
				}
			});
			btnBuscarCliente.setBackground(SystemColor.control);
			btnBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscarCliente.setIcon(new ImageIcon(ListadoClientes.class.getResource("/Imagenes/magnifier.png")));
			btnBuscarCliente.setBounds(269, 10, 114, 23);
			panel.add(btnBuscarCliente);
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Cliente cliente : Empresa.getInstance().getMisClientes()) {
			
			fila[0] = cliente.getId();
			fila[1] = cliente.getNombre();
			fila[2] = cliente.getDireccion();
			
			model.addRow(fila);
	}
	}
	private void loadTable2(String id){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cliente c=Empresa.getInstance().buscarClientePorCedula(id);	
				fila[0] = c.getId();
				fila[1] = c.getNombre();
				fila[2] = c.getDireccion();				
				model.addRow(fila);	
						
	}
}
