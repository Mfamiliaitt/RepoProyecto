package logic;


import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1605090248129560152L;
	private String tipo;
	private String codigoProyecto;
	private Boolean activo; //Proyecto activo o pasivo
	private String estado; //prorrogado,atrazado 
	private boolean terminado=false;
	private ArrayList<Empleado> elEquipo=new ArrayList<>();
	private String descripcionDeProyecto;
	public Proyecto(String tipo, String codigoProyecto, Boolean activo, String estado, ArrayList<Empleado> elEquipo,String descripcionDeProyecto ) {
		super();
		this.tipo = tipo;
		this.codigoProyecto = codigoProyecto;
		this.activo = activo;
		this.estado = estado;
		
		this.descripcionDeProyecto=descripcionDeProyecto;
	}
	public Proyecto(){}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ArrayList<Empleado> getElEquipo() {
		return elEquipo;
	}
	public void setElEquipo(ArrayList<Empleado> elEquipo) {
		this.elEquipo = elEquipo;
	}
	

	public boolean agregarJefeProyecto(Empleado a){		
		boolean respuesta=false;
		
		if(cantidadDeJefeDeProyecto()<1){
		//Empleado JefeAux=new JefeProyecto(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", evaluacionAnual, conteo_Trabajadores, certificadoEnProjectManaguer);
	
		elEquipo.add(a);
		
		respuesta=true;
		
		}else if(cantidadDeJefeDeProyecto()>=1){
			respuesta=false;
		}
		
		return respuesta;
	}
	
	public boolean agregarProgramador(Empleado a){
		boolean respuesta=false;
		if(cantidadDeProgramadores()<2){
	//	Empleado programadorAux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, "", evaluacionAnual, lenguaje);
	 elEquipo.add(a);
	
	 respuesta=true;
	}else if(cantidadDeProgramadores()>=2){
		respuesta=false; 
	}
		
	return respuesta; 
	}
	
	public boolean agregarPlanificador(Empleado a){
		boolean respuesta=false;
		
		if(cantidadDePlanificadores()<1){
		
		elEquipo.add(a);
		respuesta=true;}
		else if(cantidadDePlanificadores()>=1){
		respuesta=false;	
		}
		
		return respuesta;
	}
	
	public boolean agregarDiseniador(Empleado a){
		boolean respuesta=false;
		if(cantidadDeDiseniadores()<1){
	    elEquipo.add(a);
	    respuesta=true;
	    }else if(cantidadDeDiseniadores()>=1){
	    respuesta=false;	
	    }
	   return respuesta; 
	}
	
	public int cantidadDeDiseniadores(){
		int countAux=0;
		
		for (Empleado empleado : elEquipo) {
			if(empleado instanceof Diseniador){
				countAux++;
			}	
		}	
		return countAux;
	}
	
	
public int cantidadDeJefeDeProyecto(){
	
	int countAux=0;
	
	for (Empleado empleado : elEquipo) {
		if(empleado instanceof JefeProyecto){
			countAux++;
		}	
	}	
	return countAux;
	
}


public int cantidadDePlanificadores(){
	
int countAux=0;
	
	for (Empleado empleado : elEquipo) {
		if(empleado instanceof Planificador){
			countAux++;
		}	
	}	
	return countAux;
}




public int cantidadDeProgramadores(){
	
int countAux=0;
	
	for (Empleado empleado : elEquipo) {
		if(empleado instanceof Programador){
			countAux++;
		}	
	}	
	return countAux;
}
public boolean isTerminado() {
	return terminado;
}
public void setTerminado(boolean terminado) {
	this.terminado = terminado;
}
public String getDescripcionDeProyecto() {
	return descripcionDeProyecto;
}
public void setDescripcionDeProyecto(String descripcionDeProyecto) {
	this.descripcionDeProyecto = descripcionDeProyecto;
}
	
public float sumatoriaDeSueldosBases(){
	float auxValue=0;
	for (Empleado empleado : elEquipo) {
		auxValue+=empleado.getSalario();
	}
	
	return auxValue;
} 
public int contadorDeEmpleados(){
int counter=0;
 
for (Empleado empleado : elEquipo) {
	counter++;
}
	
	
return counter;	
}
public Empleado buscarEmpleadoPorCedula(String cedula){
	Empleado c=null;
	for (Empleado losEmpleados : elEquipo) {
		if(losEmpleados.getIdentificador().equalsIgnoreCase(cedula)){
			c=losEmpleados;
		}		
	}
	return c;
}
}

