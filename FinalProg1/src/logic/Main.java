package logic;


import Visual.Splash;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Empresa.getInstance().cargarArchivos(); //Aqui se cargan para poder hacer login buscando empleados
		}  catch (Exception e) {			
			//Empleado j = new JefeProyecto("", nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual, conteo_Trabajadores, certificadoEnProjectManaguer)
		}		
		new Thread(new Splash()).start();
		
	}
}
