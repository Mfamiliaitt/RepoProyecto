package logic;


import java.io.IOException;

import javax.swing.JOptionPane;

import Visual.IngresarEmpleado;
import Visual.Principal;
import Visual.Splash;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Empresa.getInstance().cargarArchivos(); //Aqui se cargan para poder hacer login buscando empleados
			new Thread(new Splash()).start();
		}  catch (Exception e) {	
			
			try {
				Empresa.getInstance().cargarEmpleado();
				new Thread(new Splash()).start();
				} catch (Exception e1) {
				// TODO Auto-generated catch block
					Principal.getInstance().main();
			}
			
		
			
		}		
		
		
	}
}
