package logic;

import java.util.ArrayList;

public class JefeProyecto extends Empleado {
	protected int conteo_Trabajadores;
	protected String idProyecto;
	
	public JefeProyecto(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, ArrayList<String> misEstados,
			int conteo_Trabajadores) {
		
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual,
				misEstados);
		this.conteo_Trabajadores = conteo_Trabajadores;
		
	}

	
	public int getConteo_Trabajadores() {
		return conteo_Trabajadores;
	}
	public void setConteo_Trabajadores(int conteo_Trabajadores) {
		this.conteo_Trabajadores = conteo_Trabajadores;
	}
}
