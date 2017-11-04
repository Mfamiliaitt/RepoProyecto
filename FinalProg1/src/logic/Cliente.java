package logic;

import java.util.ArrayList;

public class Cliente {
	
	private String id;
	private String nombre;
	private String direccion;
	private int cantproyectos;
	private ArrayList<Contrato> contratosCliente;
	
	

	public Cliente(String id, String nombre, String direccion, int cantproyectos,
			ArrayList<Contrato> contratosCliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantproyectos = cantproyectos;
		this.contratosCliente = contratosCliente;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Contrato> getContratosCliente() {
		return contratosCliente;
	}

	public void setContratosCliente(ArrayList<Contrato> contratosCliente) {
		this.contratosCliente = contratosCliente;
	}
	
	

}
