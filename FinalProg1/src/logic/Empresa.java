package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Empresa {
private ArrayList<Empleado> misEmpleados;
 private ArrayList<Contrato> misContratos;
 private ArrayList<Cliente> misClientes;
 private ArrayList<Proyecto> misProyectos;
 private static Empresa laEmpresa;
 private Empresa() {
		super();
		this.misEmpleados = new ArrayList<>();
		this.misContratos = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misProyectos=new ArrayList<>();
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


public void agregarClientes(Cliente c){

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
public Empleado buscarEmpleadoPorCedula(String cedula){
	Empleado c=null;
	for (Empleado losEmpleados : misEmpleados) {
		if(losEmpleados.getIdentificador().equalsIgnoreCase(cedula)){
			c=losEmpleados;
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
public void verificacionDeFechasDeContratos(){	
	for (Contrato contrato : misContratos) {
		contrato.estadoDeProyecto();
	}	
}
public void terminarProyecto(String id){
	buscarContratoDadoID(id).getMiProyecto().setTerminado(true);
	for (Empleado empleado : buscarContratoDadoID(id).getMiProyecto().getElEquipo()) {
		buscarEmpleadoPorCedula(empleado.getIdentificador()).getMisEstados().add(buscarContratoDadoID(id).getMiProyecto().getEstado());
	}
	
}
/*Termina un proyecto y le asigna al equipo de ese proyecto el estado en el que quedo el proyecto*/
public ArrayList<Proyecto> getMisProyectos() {
	return misProyectos;
}
public void setMisProyectos(ArrayList<Proyecto> misProyectos) {
	this.misProyectos = misProyectos;
}


public void evaluaciondelempleado(){
	int prorrogado=0;
	int atiempo=0;
	int atrasado=0;
	
	for ( Empleado empleado : misEmpleados) {
		prorrogado=0;
		atiempo=0;
		atrasado=0;
		for (  String estado: empleado.getMisEstados()){
			if(estado=="Prorrogado"){
				prorrogado++;
			}
			else if(estado=="A Tiempo"){
				atiempo++;
			}
			else{
				atrasado++;
			}
		}		
		int suma=prorrogado+atrasado+atiempo;
		if (atiempo>=(0.70*suma)){
			empleado.setEvaluacionAnual("Muy bueno");
		}
		else if(prorrogado>=(0.50*suma) && prorrogado<(0.70*suma)){
			empleado.setEvaluacionAnual("Bueno");
		}
		else{
			empleado.setEvaluacionAnual("Malo");
		}				
	}	
}
public boolean isempleadoregistrado(String cedula){
	boolean answer=false;
	Empleado e=buscarEmpleadoPorCedula(cedula);
	
		if (e!=null){
			answer=true;
		}
		else{
			answer=false;
		}
		return answer;
	}

public boolean isclienteregistrado(String cedula){
	boolean answer=false;
	Cliente c=buscarClientePorCedula(cedula);
	
		if (c!=null){
			answer=true;
		}
		else{
			answer=false;
		}
		return answer;
	}

/*Ficherooooooo*/
public void guardarEmpleados() throws IOException {
	 FileOutputStream cu = new FileOutputStream("misEmpleados.dat");
	 ObjectOutputStream cos= new ObjectOutputStream(cu);
	 cos.writeInt(misEmpleados.size());	 
	 for (Empleado empleado : misEmpleados) {
		 cos.writeObject(empleado);		
	}
	 cu.close();
}
public void cargarArchivos() throws IOException, Exception{
	 FileInputStream cl=new FileInputStream("misEmpleados.dat");
	 ObjectInputStream cli=new ObjectInputStream(cl);	 
	 int count1=cli.readInt();	 
	 for(int i=0;i<count1;i++){
		 misEmpleados.add((Empleado) cli.readObject());		 
	 }	 
	cl.close();
}
public double dameGanancia(){
	double aux1=0;
	double aux2=0;
	double t=0;
	for (Contrato losContratos : misContratos) {
		aux1=aux1+losContratos.getCostoProyecto();
	}
	for (Empleado losempleados : misEmpleados) {
		aux2=aux2+losempleados.getSalario();
	}
	t=aux1-aux2;
	return t;	
}
}
