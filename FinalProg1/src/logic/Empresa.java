package logic;

import java.util.ArrayList;
public class Empresa {
private ArrayList<Empleado> misEmpleados;
 private ArrayList<Contrato> misContratos;
 private ArrayList<Cliente> misClientes;
 private static Empresa laEmpresa;
 private Empresa() {
		super();
		this.misEmpleados = new ArrayList<>();
		this.misContratos = new ArrayList<>();
		this.misClientes = new ArrayList<>();
	}
 public static Empresa getInstance(){
		if(laEmpresa==null){
			laEmpresa=new Empresa();
		}
		return laEmpresa;
	}
public ArrayList<Empleado> getMisEmpleados() {
	return misEmpleados;
}
public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
	this.misEmpleados = misEmpleados;
}
public ArrayList<Contrato> getMisContratos() {
	return misContratos;
}
public void setMisContratos(ArrayList<Contrato> misContratos) {
	this.misContratos = misContratos;
}
public ArrayList<Cliente> getMisClientes() {
	return misClientes;
}
public void setMisClientes(ArrayList<Cliente> misClientes) {
	this.misClientes = misClientes;
}

public void agregarClientes(String id, String nombre, String direccion){
	Cliente c = new Cliente(id, nombre, direccion);
	misClientes.add(c);
}
public void addContrato(Contrato c){
	misContratos.add(c);
}
public void addEmpleado(Empleado e){
	misEmpleados.add(e);
}
public Cliente buscarClientePorCedula(String cedula){
	Cliente c=null;
	for (Cliente losClientes : misClientes) {
		if(losClientes.getId().equalsIgnoreCase(cedula)){
			c=losClientes;
		}		
	}
	return c;
}
public Contrato buscarContratoDadoID(String idContrato){
	Contrato c=null;
	for (Contrato elContrato : misContratos) {
		if(elContrato.getCodigoProyecto().equalsIgnoreCase(idContrato)){
			c=elContrato;
		}
	}
	return c;
}
}
