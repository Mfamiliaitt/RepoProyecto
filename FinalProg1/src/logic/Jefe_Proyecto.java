package logic;

public class Jefe_Proyecto extends Diseniador {
	protected int conteo_Trabajadores;
	public Jefe_Proyecto(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int conteo_Trabajadores) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual);
		this.conteo_Trabajadores = conteo_Trabajadores;
	}
	public int getConteo_Trabajadores() {
		return conteo_Trabajadores;
	}
	public void setConteo_Trabajadores(int conteo_Trabajadores) {
		this.conteo_Trabajadores = conteo_Trabajadores;
	}
}
