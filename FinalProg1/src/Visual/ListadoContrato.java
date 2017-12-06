package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.time.Millisecond;

import logic.Cliente;
import logic.Contrato;
import logic.Empleado;
import logic.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class ListadoContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table=new JTable();
	private static Object[] fila;
	private static DefaultTableModel model;
	private JButton btnTerminar;
	private JButton btnProrrogar;
	private JPanel panelPrórroga;
	private JSpinner spnFechadeentrega;
	private JSpinner spnProrroga;
	private JButton btnRealizarProrroga;
	

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
	public ListadoContrato() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoContrato.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("Listado de Contratos");
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
				JButton btnOk = new JButton("OK");
				btnOk.setIcon(new ImageIcon(ListadoContrato.class.getResource("/Imagenes/signo-de-comprobado.png")));
				btnOk.setBackground(SystemColor.control);
				btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnProrrogar = new JButton("Prorrogar");
					btnProrrogar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//Aqui el panel prorroga se hace visible 
							panelPrórroga.setVisible(true);
							try {
								spnFechadeentrega.setModel(new SpinnerDateModel(Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getFechaTermino(), null, null, Calendar.MILLISECOND));
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						/*	try {
								spnFechadeentrega.setValue(Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getFechaTermino());
							} catch (Exception e2) {
								// TODO: handle exception
							}
							*/
					
							
							
							
							
							
						}
					});
					btnProrrogar.setEnabled(false);
					buttonPane.add(btnProrrogar);
				}
				{
					btnTerminar = new JButton("Terminar");
					btnTerminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//Este código es para decidir terminar el proyecto
							
							  int dialogButton=JOptionPane.YES_NO_OPTION;
							int dialogResult=  JOptionPane.showConfirmDialog(null, "Deseas terminar el proyecto?", "Warning", dialogButton);
							  
							  if (dialogResult==JOptionPane.YES_OPTION){
								  
								  Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getMiProyecto().setEstado("Terminado");
								 

								  
								  for (Empleado empleado : Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getMiProyecto().getElEquipo() )
								  { System.out.println(table.getSelectedRow());
									  
									  Empresa.getInstance().buscarEmpleadoPorCedula(empleado.getIdentificador()).setOcupado(false);
									  Empresa.getInstance().buscarEmpleadoPorCedula(empleado.getIdentificador()).agregarEstadoEmpleado( Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getMiProyecto().getEstado());
								}
							  }
							  else{
								  remove(dialogButton);
							  }
							  loadTable();
							
						}
					});
					btnTerminar.setEnabled(false);
					buttonPane.add(btnTerminar);
				}
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(ListadoContrato.class.getResource("/Imagenes/boton-de-cerrar.png")));
				btnCancelar.setBackground(SystemColor.control);
				btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		{
			JPanel panelTabla = new JPanel();
			panelTabla.setBackground(Color.WHITE);
			panelTabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contratos registrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTabla.setBounds(29, 27, 663, 324);
			contentPanel.add(panelTabla);
			panelTabla.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow()!= -1){
						
						btnTerminar.setEnabled(true);
						btnProrrogar.setEnabled(true);
						}
						else{
							
							btnTerminar.setEnabled(false);
							btnProrrogar.setEnabled(false);
						}
						
						
						
					}
				});
			
				
				panelTabla.add(scrollPane, BorderLayout.CENTER);
				{
					
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					model = new DefaultTableModel();
					String[] columnNames = {"Código","Solicitante","Tipo de Proyecto","Estado", "Fecha de creacion", "Fecha de vencimiento"};
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		
		panelPrórroga = new JPanel();
		panelPrórroga.setBackground(Color.WHITE);
		panelPrórroga.setBorder(new TitledBorder(null, "Pr\u00F3rroga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrórroga.setBounds(29, 367, 663, 50);
		contentPanel.add(panelPrórroga);
		panelPrórroga.setLayout(null);
		panelPrórroga.setVisible(false);
		
		
		JLabel lblNewLabel = new JLabel("Fecha de entrega:");
		lblNewLabel.setBounds(67, 25, 104, 14);
		panelPrórroga.add(lblNewLabel);
		
		spnFechadeentrega = new JSpinner();
		spnFechadeentrega.setEnabled(false);
		if(table.getSelectedRow()!=-1){
		spnFechadeentrega.setModel(new SpinnerDateModel(Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getFechaTermino(), null, null, Calendar.MILLISECOND));}else{
			spnFechadeentrega.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MILLISECOND));
		}
		spnFechadeentrega.setBounds(181, 22, 117, 20);
		panelPrórroga.add(spnFechadeentrega);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00F3rroga:");
		lblNewLabel_1.setBounds(351, 25, 65, 14);
		panelPrórroga.add(lblNewLabel_1);
		Date date=new Date();
		spnProrroga = new JSpinner();
		spnProrroga.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MILLISECOND));
		try {
		//	spnProrroga.setModel(new SpinnerDateModel(null, new Date(), null, );
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		spnProrroga.setBounds(426, 22, 109, 20);
		panelPrórroga.add(spnProrroga);
		
		btnRealizarProrroga = new JButton("Realizar");
		btnRealizarProrroga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).setFechaTermino((Date)spnProrroga.getValue());
				spnFechadeentrega.setValue(Empresa.getInstance().getMisContratos().get(table.getSelectedRow()).getFechaTermino());
				JOptionPane.showMessageDialog(null, "Prorroga realizada exitosamente");
				panelPrórroga.setVisible(false);

			}
		});
		btnRealizarProrroga.setBounds(564, 21, 89, 23);
		panelPrórroga.add(btnRealizarProrroga);
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fecha2 = new SimpleDateFormat("dd/MM/yyyy");
		for (Contrato losContratos : Empresa.getInstance().getMisContratos()) {
			
			fila[0] = losContratos.getCodigoProyecto();
			fila[1] = Empresa.getInstance().buscarClientePorCedula(losContratos.getIdCliente()).getNombre();
			fila[2] = losContratos.getMiProyecto().getTipo();
			fila[3] = losContratos.getMiProyecto().getEstado();
			fila[4] = fecha.format(losContratos.getFechaInicio());
			fila[5] = fecha2.format(losContratos.getFechaTermino());
			
			model.addRow(fila);
	}
	}
}
