package logic;

public class Planificador extends Diseniador {
	protected int cantDias;
	public Planificador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int cantDias) {
		super(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual);
		this.cantDias = cantDias;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
}
