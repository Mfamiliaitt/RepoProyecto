package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Empresa;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Splash extends JFrame implements Runnable {

	private JPanel contentPane;
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 223);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/Imagenes/WhatsApp Image 2017-11-30 at 4.19.18 PM.jpeg")));
		lblNewLabel.setBounds(0,0, 462, 223);
		contentPane.add(lblNewLabel);
	}
/*	public void delay(int segundos){
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/
	@Override
	public void run() {
		try {
			Splash frame= new Splash();
			frame.setVisible(true);
			Thread.sleep(3000);
			frame.dispose();
			Login login = Login.getInstance();
			login.setVisible(true);
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
