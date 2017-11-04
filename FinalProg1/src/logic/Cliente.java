package logic;

public class Cliente {
	
	private String id;
	private String nombre;
	private String direccion;
	private int cantproyectos;
	
	public Cliente(String cedula, String nombre, String direccion, int cantproyectos) {
		super();
		this.id = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantproyectos = cantproyectos;
	}

	public String getCedula() {
		return id;
	}

	public void setCedula(String cedula) {
		this.id = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantproyectos() {
		return cantproyectos;
	}

	public void setCantproyectos(int cantproyectos) {
		this.cantproyectos = cantproyectos;
	}
	
	

}
