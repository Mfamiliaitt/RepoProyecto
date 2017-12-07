package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import logic.Contrato;
import logic.Empresa;
import logic.GraficoBarra;
import logic.GraficoPie;
import logic.Proyecto;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Button;
import javax.swing.JButton;
import org.edisoncor.gui.varios.ClockFace;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JTable tableProyectosPendientes;
	private static Principal principal;
	private JPanel paneldegrafica;
	private GraficoPie nuevo = new GraficoPie();
	private GraficoBarra nuevo2 = new GraficoBarra();
	private JPanel panelgrafica2;
	//private GraficoPie nuevo = new GraficoPie();

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = Principal.getInstance();
					 frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					
					 
				try {
					
					frame.addWindowListener(new WindowAdapter() {
        				@Override
        				public void windowClosing(java.awt.event.WindowEvent we){
        					try {
        						    Empresa.getInstance().guardarEmpleados();
        					     
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						
        					}
        					System.exit(0);
        				}
        					
        				
        			});
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			} catch (Exception e) {
				
			}
		}});
	}

	/**
	 * Create the frame.
	 */
	private Principal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setTitle("SoftMasters");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVer = new JMenu("Ver");
		mnVer.setBorder(null);
		mnVer.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
		mnVer.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/periodico-doblado (1).png")));
		menuBar.add(mnVer);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.setBorder(null);
		mntmListadoDeClientes.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/solicitud-de-amistad.png")));
		mntmListadoDeClientes.setBackground(Color.WHITE);
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoClientes c = new ListadoClientes();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		mnVer.add(mntmListadoDeClientes);
		
		JMenuItem mntmListadoDeEmpleados = new JMenuItem("Listado de Empleados");
		mntmListadoDeEmpleados.setBorder(null);
		mntmListadoDeEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/avatar-grande.png")));
		mntmListadoDeEmpleados.setBackground(Color.WHITE);
		mntmListadoDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEmpleados c = new ListadoEmpleados();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmListaDeContratos = new JMenuItem("Listado de Contratos");
		mntmListaDeContratos.setBorder(null);
		mntmListaDeContratos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/accept-file-or-checklist.png")));
		mntmListaDeContratos.setBackground(Color.WHITE);
		mntmListaDeContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoContrato c = new ListadoContrato();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmListadoDeProyectos = new JMenuItem("Listado de Proyectos");
		mntmListadoDeProyectos.setBorder(null);
		mntmListadoDeProyectos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/compartiendo.png")));
		mntmListadoDeProyectos.setBackground(Color.WHITE);
		mntmListadoDeProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProyecto c = new ListadoProyecto();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		mnVer.add(mntmListadoDeProyectos);
		mnVer.add(mntmListaDeContratos);
		mnVer.add(mntmListadoDeEmpleados);
		
		JMenu mnNewMenu = new JMenu("Empleados");
		mnNewMenu.setBorder(null);
		mnNewMenu.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/avatar-grande (1).png")));
		menuBar.add(mnNewMenu);		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/agregar-usuario.png")));
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Evento para abrir la ventana de ingresar empleado
				IngresarEmpleado ingempleado = new IngresarEmpleado();
				ingempleado.setModal(true);
				ingempleado.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Evaluaci\u00F3n anual");
		mntmNewMenuItem_7.setBorder(null);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluacionAnual lol = new EvaluacionAnual();
				lol.setVisible(true);
				lol.setLocationRelativeTo(null);
			}
		});
		mntmNewMenuItem_7.setBackground(Color.WHITE);
		mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/boton-de-una-estrella (1).png")));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Proyectos");
		mnNewMenu_1.setBorder(null);
		mnNewMenu_1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/compartiendo (1).png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear proyecto");
		mntmNewMenuItem_2.setBorder(null);
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/escribir-documento.png")));
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Evento para abrir la ventana crear proyecto
				CrearProyecto crearproject = new CrearProyecto();
				crearproject.setModal(true);
				crearproject.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(null);
		panel.setBounds(172, 23, 559, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(43, 68, 477, 231);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		tableProyectosPendientes = new JTable();
		tableProyectosPendientes .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columnNames = {"Código","Cliente","Tipo","Fecha de creacion","Fecha de termino","Estado"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		tableProyectosPendientes .setModel(model);
		
		scrollPane.setViewportView(tableProyectosPendientes);
		
		
		JLabel lblNewLabel = new JLabel("Proyectos Pendientes");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 11, 416, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBorder(null);
		panel_1.setBounds(10, 23, 145, 663);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		ClockFace clockFace = new ClockFace();
		clockFace.setBounds(10, 26, 125, 133);
		panel_1.add(clockFace);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(761, 23, 559, 326);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		paneldegrafica = new JPanel();
		paneldegrafica.setBackground(new Color(153, 204, 255));
		paneldegrafica.setBounds(0, 0, 559, 326);
		panel_2.add(paneldegrafica);
		//GraficoPie nuevo = new GraficoPie();
		
		paneldegrafica.add(nuevo.init());
		paneldegrafica.setLayout(new GridLayout(1, 0, 0, 0));
		//paneldegrafica.setLayout();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(new Color(153, 204, 255));
		panel_4.setBounds(172, 360, 559, 326);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelgrafica2 = new JPanel();
		panel_4.add(panelgrafica2);
		//GraficoBarra nuevo2 = new GraficoBarra();
		panelgrafica2.add(nuevo2.init());
		panelgrafica2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(153, 204, 255));
		panel_5.setBounds(761, 360, 559, 326);
		contentPane.add(panel_5);
		setLocationRelativeTo(null);
		
		 
		
	}
	public static Principal getInstance(){
		if(principal==null){
			principal=new Principal();
		}
		return principal;
	}
	public void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fecha2 = new SimpleDateFormat("dd/MM/yyyy");
		for (Contrato losContratos : Empresa.getInstance().getMisContratos()) {			
			if(!losContratos.getMiProyecto().getEstado().equalsIgnoreCase("Terminado")){			
			fila[0] = losContratos.getCodigoProyecto();
			fila[1] = Empresa.getInstance().buscarClientePorCedula(losContratos.getIdCliente()).getNombre();
			fila[2] = losContratos.getMiProyecto().getTipo();
			fila[3] = fecha.format(losContratos.getFechaInicio());
			fila[4] = fecha2.format(losContratos.getFechaTermino());
			fila[5] = losContratos.getMiProyecto().getEstado();
			model.addRow(fila);
			}			
	}
		
	}
	public void cargarGrafica(){
		paneldegrafica.removeAll();
		paneldegrafica.revalidate();
		paneldegrafica.add(nuevo.init());
		
		paneldegrafica.repaint();
	}
}