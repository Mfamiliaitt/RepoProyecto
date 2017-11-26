package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logic.Contrato;
import logic.Empleado;
import logic.Empresa;
import logic.JefeProyecto;
import logic.Proyecto;
import logic.Planificador;
import logic.Programador;
import logic.Diseniador;


import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class DetalleProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetalleProyecto dialog = new DetalleProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetalleProyecto() {
		setTitle("Informacion de Proyecto");
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Crear proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(new Color(220, 220, 220));
			panel.setBounds(0, 0, 724, 471);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Informaci\u00F3n del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBackground(SystemColor.control);
				panel_1.setBounds(10, 23, 704, 88);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Nombre:");
					label.setBounds(10, 16, 63, 21);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Tipo:");
					label.setBounds(10, 45, 63, 21);
					panel_1.add(label);
				}
				{
					textField = new JTextField();
					textField.setEditable(false);
					textField.setColumns(10);
					textField.setBounds(135, 16, 398, 21);
					panel_1.add(textField);
				}
				{
					JLabel label = new JLabel("Fecha de Entrega:");
					label.setBounds(276, 45, 106, 21);
					panel_1.add(label);
				}
				{
					textField_1 = new JTextField();
					textField_1.setEditable(false);
					textField_1.setColumns(10);
					textField_1.setBounds(135, 46, 131, 20);
					panel_1.add(textField_1);
				}
				{
					textField_2 = new JTextField();
					textField_2.setText((String) null);
					textField_2.setEditable(false);
					textField_2.setColumns(10);
					textField_2.setBounds(374, 45, 159, 20);
					panel_1.add(textField_2);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Mi equipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBackground(SystemColor.control);
				panel_1.setBounds(10, 122, 704, 163);
				panel.add(panel_1);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 24, 684, 128);
					panel_1.add(scrollPane);
					{
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						String[] columnNames = {"Cedula","Nombre","Salario","Tipo de empleado"};
						model = new DefaultTableModel();
						model.setColumnIdentifiers(columnNames);
						table.setModel(model);
						loadTable();
						scrollPane.setViewportView(table);
					}
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Proyecto proyectos : Empresa.getInstance().getMisProyectos()) {
			for (Empleado losEmpleados : proyectos.getElEquipo()) {
				fila[0] = losEmpleados.getIdentificador();
				fila[1] = losEmpleados.getNombre();
				fila[2] = losEmpleados.getSalario();
				if(losEmpleados instanceof JefeProyecto )
					fila[3] = "Jefe de Proyecto";
				if(losEmpleados instanceof Planificador )
					fila[3] = "Planificador";
				if(losEmpleados instanceof Diseniador)
					fila[3] = "Diseñador";
				if(losEmpleados instanceof Programador)
					fila[3] = "Programador";
				model.addRow(fila);
			}
		
			
		
	}
	}

}
