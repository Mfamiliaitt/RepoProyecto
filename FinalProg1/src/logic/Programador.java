package logic;

import java.util.ArrayList;

public class Programador extends Empleado {
	protected String lenguaje;
	public Programador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, String lenguaje) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual);
		this.lenguaje = lenguaje;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
}
 