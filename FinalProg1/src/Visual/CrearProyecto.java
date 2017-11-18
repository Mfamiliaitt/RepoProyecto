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

public class CrearProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 740, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Icono de un proyecto \r\nque se va a dise\u00F1ar");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(85, 41, 178, 178);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(25, 230, 300, 187);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
				lblNewLabel_1.setBounds(10, 29, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo:");
				lblNewLabel_2.setBounds(10, 85, 46, 14);
				panel.add(lblNewLabel_2);
			}
			{
				textField = new JTextField();
				textField.setBounds(10, 54, 86, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(10, 107, 86, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Descripci\u00F3n del proyecto:");
				lblNewLabel_3.setBounds(10, 141, 151, 14);
				panel.add(lblNewLabel_3);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar cliente existente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(349, 23, 365, 54);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_4 = new JLabel("C\u00E9dula:");
				lblNewLabel_4.setBounds(21, 29, 56, 14);
				panel.add(lblNewLabel_4);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(67, 23, 130, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setBounds(206, 20, 89, 23);
				panel.add(btnNewButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(349, 90, 365, 234);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(349, 335, 365, 82);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_5 = new JLabel("Elegir equipo:");
				lblNewLabel_5.setBounds(10, 33, 101, 14);
				panel.add(lblNewLabel_5);
			}
			{
				JButton btnNewButton_1 = new JButton("Elegir");
				btnNewButton_1.setBounds(91, 33, 89, 23);
				panel.add(btnNewButton_1);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
