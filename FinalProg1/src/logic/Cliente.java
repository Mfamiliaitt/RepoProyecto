package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7871524758566677061L;
	private String id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private ArrayList<Contrato> miContrato = new ArrayList<>();
	public Cliente(String id, String nombre, String apellido, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
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
	public ArrayList<Contrato> getMiContrato() {
		return miContrato;
	}
	public void setMiContrato(ArrayList<Contrato> miContrato) {
		this.miContrato = miContrato;
	}
public void agregarContrato(String codigoProyecto, String idCliente, Date fechaInicio, Date fechaTermino,
		Boolean firmado){
	Contrato c = new Contrato(codigoProyecto, idCliente, fechaInicio, fechaTermino, firmado);
	miContrato.add(c);
	Empresa.getInstance().addContrato(c);
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
}
