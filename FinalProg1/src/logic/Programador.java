package logic;

public class Programador extends Diseniador {
	protected String lenguaje;
	
	public Programador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String lenguaje) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual);
		this.lenguaje = lenguaje;
	}
	
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
}
 