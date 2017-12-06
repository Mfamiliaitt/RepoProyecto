package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setBackground(new Color(102, 204, 255));
		setTitle("Login");
		setBounds(100, 100, 292, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/2191544-128.png")));
		lblNewLabel.setBounds(68, 43, 135, 137);
		contentPanel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(109, 203, 109, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(40, 209, 59, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClave.setBounds(40, 240, 59, 14);
		contentPanel.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(109, 234, 109, 20);
		contentPanel.add(txtClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/flecha-de-siguiente.png")));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBounds(78, 271, 114, 23);
		contentPanel.add(btnIngresar);
	}
}
