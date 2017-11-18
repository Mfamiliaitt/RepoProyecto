package logic;

import java.util.ArrayList;
import java.util.Date;



public class Cliente {
	private String id;
	private String nombre;
	private String direccion;
	private ArrayList<Contrato> miContrato;
	public Cliente(String id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
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
public void agregarContrato(String codigoProyecto, String idCliente, double costoProyecto, Date fechaInicio, Date fechaTermino,
		Boolean firmado){
	Contrato c = new Contrato(codigoProyecto, idCliente, costoProyecto, fechaInicio, fechaTermino, firmado);
	miContrato.add(c);
	Empresa.getInstance().addContrato(c);
}



	

}
