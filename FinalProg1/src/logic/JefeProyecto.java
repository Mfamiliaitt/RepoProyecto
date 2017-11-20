package logic;

import java.util.ArrayList;

public class JefeProyecto extends Empleado {
	
	private int conteo_Trabajadores;
	private String idProyecto;
	private boolean certificadoEnProjectManaguer; 
	
	
	public JefeProyecto(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, ArrayList<String> misEstados,
			int conteo_Trabajadores, boolean certificadoEnProjectManaguer) {
		
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual,
				misEstados);
		this.conteo_Trabajadores = conteo_Trabajadores;
		this.certificadoEnProjectManaguer=certificadoEnProjectManaguer;
		
	}

	
	public int getConteo_Trabajadores() {
		return conteo_Trabajadores;
	}
	public void setConteo_Trabajadores(int conteo_Trabajadores) {
		this.conteo_Trabajadores = conteo_Trabajadores;
	}
	
}
