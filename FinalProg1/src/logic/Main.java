package logic;

import java.io.IOException;
import Visual.Login;
import Visual.Splash;
public class Main {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		Empresa.getInstance().cargarArchivos();		
		Splash frame = new Splash();
		frame.setVisible(true);
		frame.delay(2);
		Login login = Login.getInstance();
		login.setVisible(true);
		frame.dispose();		
	}
}
