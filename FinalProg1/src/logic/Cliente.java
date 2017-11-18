package logic;

import java.util.ArrayList;

public class Cliente {
	private String id;
	private String nombre;
	private String direccion;
	private ArrayList<Proyecto> miProyecto;

	public Cliente(String id, String nombre, String direccion, ArrayList<Proyecto> miProyecto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.miProyecto = miProyecto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public ArrayList<Proyecto> getMiProyecto() {
		return miProyecto;
	}
	public void setMiProyecto(ArrayList<Proyecto> miProyecto) {
		this.miProyecto = miProyecto;
	}




	

}
