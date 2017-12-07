package logic;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
public void addProyecto(Proyecto c){
	misProyectos.add(c);
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
			empleado.setEvaluacionAnual("Sobresaliente");
		}
		else if(prorrogado>=(0.50*suma) && prorrogado<(0.70*suma)){
			empleado.setEvaluacionAnual("Suficiente");
		}
		else{
			empleado.setEvaluacionAnual("Deficiente");
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
	 FileOutputStream cont = new FileOutputStream("misContratos.dat");
	 ObjectOutputStream contrato= new ObjectOutputStream(cont);
	 FileOutputStream client = new FileOutputStream("misClientes.dat");
	 ObjectOutputStream clienteCount= new ObjectOutputStream(client);
	 FileOutputStream Project = new FileOutputStream("misProyectos.dat");
	 ObjectOutputStream Pro= new ObjectOutputStream(Project);
	 cos.writeInt(misEmpleados.size());	
	 //System.out.println("guardado");
	 for (Empleado empleado : misEmpleados) {
		 cos.writeObject(empleado);		
	}
	 cu.close();
	 contrato.writeInt(misContratos.size());	 
	 for (Contrato contrat : misContratos) {
		 contrato.writeObject(contrat);		
	}
	 cont.close();
	 
	 clienteCount.writeInt(misClientes.size());
	 for(Cliente cliente: misClientes){
		 clienteCount.writeObject(cliente);
		 
	 }
	 client.close();
	 
	Pro.writeInt(misProyectos.size());
	 for(Proyecto proyecto: misProyectos){
		 Pro.writeObject(proyecto);
		 
	 }
	 Project.close();
	 
}
public void cargarArchivos() throws IOException, Exception{
	 FileInputStream cl=new FileInputStream("misEmpleados.dat");
	 ObjectInputStream cli=new ObjectInputStream(cl);	 
	 FileInputStream cos=new FileInputStream("misContratos.dat");
	 ObjectInputStream cont=new ObjectInputStream(cos);	
	 FileInputStream lectorCli=new FileInputStream("misClientes.dat");
	 ObjectInputStream contCli=new ObjectInputStream(lectorCli);
	 FileInputStream lectorPro=new FileInputStream("misProyectos.dat");
	 ObjectInputStream contPro=new ObjectInputStream(lectorPro);
	 
	 int count1=cli.readInt();	 
	 for(int i=0;i<count1;i++){
		 misEmpleados.add((Empleado) cli.readObject());		 
	 }	 
	cl.close();
	
	int count2=cont.readInt();	 
	 for(int i=0;i<count2;i++){
		 misContratos.add((Contrato) cont.readObject());		 
	 }	 
	cos.close();
	
	int count3=contCli.readInt();	 
	 for(int i=0;i<count3;i++){
		 misClientes.add((Cliente) contCli.readObject());		 
	 }	 
	lectorCli.close();
	
	int count4=contPro.readInt();	 
	 for(int i=0;i<count4;i++){
		 misProyectos.add((Proyecto) contPro.readObject());		 
	 }	 
	lectorPro.close();
	
}
public void informaciondelcliente(String id) throws IOException{
	File creador=new File("Cliente.txt"); 
	FileWriter doc =	new FileWriter(creador);	
	BufferedWriter escritor =new BufferedWriter(doc);
	
	String strin1 = "            *********************************            ";
	String string = "                    Información del cliente               ";
	String nombre = "Nombre: "+buscarClientePorCedula(id).getNombre();
	String apellido = "Apellido: "+buscarClientePorCedula(id).getApellido();
	String ced = "Cédula: "+buscarClientePorCedula(id).getId();
	String telefono = "Telefono: "+buscarClientePorCedula(id).getTelefono();
	String direccion = "Direccion: "+buscarClientePorCedula(id).getDireccion();
	escritor.write(strin1);
	escritor.newLine();
	escritor.write(string);
	escritor.newLine();
	escritor.write(nombre);
	escritor.newLine();
	escritor.write(apellido);
	escritor.newLine();
	escritor.write(ced);
	escritor.newLine();
	escritor.write(telefono);
	escritor.newLine();
	escritor.write(direccion);
	escritor.newLine();
	escritor.newLine();
	escritor.write("INFORMACION DE MIS PROYECTOS");
	escritor.newLine();
	escritor.newLine();
	
	for (Contrato contrato : misContratos) {
		if(contrato.getIdCliente().equalsIgnoreCase(id)){
			escritor.write("Codigo: "+contrato.getMiProyecto().getCodigoProyecto()+", Proyecto: "+contrato.getMiProyecto().getDescripcionDeProyecto()+", Estado Actual: "+contrato.getMiProyecto().getEstado()+", Precio: "+contrato.getCostoProyecto());
			escritor.newLine();		
		}
	
	}
	
	escritor.close();
	Desktop desktop = Desktop.getDesktop();
	if(creador.exists()){desktop.open(creador);}
	
}	
public double dameGanancia(){
	double aux1=0;
	double aux2=0;
	double t=0;
	for (Contrato losContratos : misContratos) {
	for (Empleado losempleados : losContratos.getMiProyecto().getElEquipo()) {
		aux1=aux1+losContratos.getCostoProyecto();
		aux2=aux2+losempleados.getSalario();
	}
}
	t=aux1-aux2;
	return t;	
}
public int cantidadDeProyectosPorTipo(String tipo){
	int cantidad=0;
	 
	for (Contrato contrato : misContratos) {
		for (Proyecto proyecto : misProyectos) {
			if (proyecto.getTipo().equalsIgnoreCase(tipo)){
				cantidad++;
			}	
		}
		
	}
	return cantidad;
	
}
public void crearEmpleadoInicial() throws IOException {
	FileOutputStream cu = new FileOutputStream("misEmpleados.dat");
	 ObjectOutputStream cos= new ObjectOutputStream(cu);
	 cos.writeInt(misEmpleados.size());	
		
		 for (Empleado empleado : misEmpleados) {
			 cos.writeObject(empleado);		
		}
		 cu.close();
}
public void cargarEmpleado() throws IOException, ClassNotFoundException{
	 FileInputStream cl=new FileInputStream("misEmpleados.dat");
	 ObjectInputStream cli=new ObjectInputStream(cl);
	
	 int count1=cli.readInt();	 
	 for(int i=0;i<count1;i++){
		 misEmpleados.add((Empleado) cli.readObject());		 
	 }	 
	cl.close();
	
}
public void revision(){
	for (Contrato contrato : misContratos) {
		contrato.estadoDeProyecto();
		
	}
	
	
}

public Double calculoDePerdida(){
	Double counter=(double) 0;
	for (Contrato contrato : misContratos) {
	counter+=contrato.costoDeProyectoAtrazado();
	
	}
	return counter;
}
}
