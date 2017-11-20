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

public class CrearProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JTextField txtCedula;

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
			JLabel lblNewLabel = new JLabel("Icono de un proyecto \r\nque se va a dise\u00F1ar");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(47, 41, 247, 178);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel PDatosDelProyecto = new JPanel();
			PDatosDelProyecto.setBorder(new TitledBorder(null, "Datos del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PDatosDelProyecto.setBounds(25, 230, 300, 187);
			contentPanel.add(PDatosDelProyecto);
			PDatosDelProyecto.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
				lblNewLabel_1.setBounds(10, 29, 46, 14);
				PDatosDelProyecto.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo:");
				lblNewLabel_2.setBounds(10, 85, 46, 14);
				PDatosDelProyecto.add(lblNewLabel_2);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setBounds(10, 54, 151, 20);
				PDatosDelProyecto.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtTipo = new JTextField();
				txtTipo.setBounds(10, 107, 151, 20);
				PDatosDelProyecto.add(txtTipo);
				txtTipo.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Descripci\u00F3n del proyecto:");
				lblNewLabel_3.setBounds(10, 141, 151, 14);
				PDatosDelProyecto.add(lblNewLabel_3);
			}
		}
		{
			JPanel PBuscarCliente = new JPanel();
			PBuscarCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar cliente existente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PBuscarCliente.setBounds(349, 23, 365, 54);
			contentPanel.add(PBuscarCliente);
			PBuscarCliente.setLayout(null);
			{
				JLabel lblNewLabel_4 = new JLabel("C\u00E9dula:");
				lblNewLabel_4.setBounds(21, 29, 56, 14);
				PBuscarCliente.add(lblNewLabel_4);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(67, 23, 130, 20);
				PBuscarCliente.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(206, 20, 89, 23);
				PBuscarCliente.add(btnBuscar);
			}
		}
		{
			JPanel PInformacionDelCliente = new JPanel();
			PInformacionDelCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PInformacionDelCliente.setBounds(349, 90, 365, 234);
			contentPanel.add(PInformacionDelCliente);
		}
		{
			JPanel PEquipo = new JPanel();
			PEquipo.setBorder(new TitledBorder(null, "Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PEquipo.setBounds(349, 335, 365, 82);
			contentPanel.add(PEquipo);
			PEquipo.setLayout(null);
			{
				JLabel lblNewLabel_5 = new JLabel("Elegir equipo:");
				lblNewLabel_5.setBounds(10, 33, 101, 14);
				PEquipo.add(lblNewLabel_5);
			}
			{
				JButton btnElegir = new JButton("Elegir");
				btnElegir.setBounds(91, 33, 89, 23);
				PEquipo.add(btnElegir);
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
