package logic;

import java.util.ArrayList;

public class Diseniador extends Empleado {
	private String tipoDisenio;

	public Diseniador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual, ArrayList<String> misEstados,
			String tipoDisenio) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, idProyecto, evaluacionAnual,
				misEstados);
		this.tipoDisenio = tipoDisenio;
	}
	public String getTipoDisenio() {
		return tipoDisenio;
	}

	public void setTipoDisenio(String tipoDisenio) {
		this.tipoDisenio = tipoDisenio;
	}

}
