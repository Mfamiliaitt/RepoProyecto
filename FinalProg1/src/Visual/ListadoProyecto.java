package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Cliente;
import logic.Contrato;
import logic.Empleado;
import logic.Empresa;
import logic.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ListadoProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

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
	public ListadoProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoProyecto.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Listado de Proyectos\r\n");
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
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ListadoProyecto.class.getResource("/Imagenes/signo-de-comprobado.png")));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(29, 27, 665, 379);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Nombre","Tipo","Estado"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Proyecto losProyectos : Empresa.getInstance().getMisProyectos()) {
			
			fila[0] = losProyectos.getDescripcionDeProyecto();
			fila[1] = losProyectos.getTipo();
			fila[2] = losProyectos.getEstado();
			
			model.addRow(fila);
	}
	}

}
