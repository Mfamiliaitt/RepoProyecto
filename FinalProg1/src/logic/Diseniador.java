package logic;

import java.util.ArrayList;

public class Diseniador extends Empleado {
	private String tipoDisenio;

	public Diseniador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, 
			String tipoDisenio) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual
				);
		this.tipoDisenio = tipoDisenio;
	}
	public String getTipoDisenio() {
		return tipoDisenio;
	}

	public void setTipoDisenio(String tipoDisenio) {
		this.tipoDisenio = tipoDisenio;
	}

}
