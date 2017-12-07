package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logic.Cliente;
import logic.Empleado;
import logic.Empresa;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField formattedTextFieldUsuario;
	private JPasswordField passwordField;
	private static Login login;

	private Login() { 
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/moneyArtboard 1@0.5x.png")));
		setBackground(new Color(102, 204, 255));
		setTitle("Login");
		setBounds(100, 100, 292, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/2191544-128.png")));
		lblNewLabel.setBounds(68, 43, 135, 137);
		contentPanel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(40, 209, 59, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClave.setBounds(40, 240, 59, 14);
		contentPanel.add(lblClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
					Empleado p=Empresa.getInstance().buscarEmpleadoPorCedula(formattedTextFieldUsuario.getText());
					char arrayC[]  = passwordField.getPassword(); 
					String pass = new String(arrayC); 
					if(p!=null && pass.equalsIgnoreCase(p.getPassword())){							
								Principal principal = Principal.getInstance();
								principal.setVisible(true);
								principal.setLocationRelativeTo(null);
								principal.loadTable();
								dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
						}
					
				}
			
		});
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/flecha-de-siguiente.png")));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBounds(78, 271, 114, 23);
		contentPanel.add(btnIngresar);
		
		MaskFormatter t;
		try {
			t = new MaskFormatter("###-#######-#");
			t.setPlaceholderCharacter('_');
			formattedTextFieldUsuario = new JFormattedTextField(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formattedTextFieldUsuario.setBounds(110, 207, 108, 20);
		contentPanel.add(formattedTextFieldUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 238, 109, 20);
		contentPanel.add(passwordField);
	}
	public static Login getInstance(){
		if(login==null){
			login=new Login();
		}
		return login;
	}
}
