package logic;

import java.util.ArrayList;

public class Planificador extends Empleado {
	protected int cantDias;
	public Planificador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, int cantDias) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual);
		this.cantDias = cantDias;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
}
