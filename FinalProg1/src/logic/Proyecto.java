package logic;


import java.util.ArrayList;

public class Proyecto {
	private String tipo;
	private String codigoProyecto;
	private Boolean activo; //Proyecto activo o pasivo
	private String estado; //prorrogado,atrazado 
	private boolean terminado=false;
	private ArrayList<Empleado> elEquipo;
	private String descripcionDeProyecto;
	public Proyecto(String tipo, String codigoProyecto, Boolean activo, String estado, ArrayList<Empleado> elEquipo,String descripcionDeProyecto ) {
		super();
		this.tipo = tipo;
		this.codigoProyecto = codigoProyecto;
		this.activo = activo;
		this.estado = estado;
		this.elEquipo = new ArrayList<>();
		this.descripcionDeProyecto=descripcionDeProyecto;
	}
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
	

	public boolean agregarJefeProyecto(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int conteo_Trabajadores,boolean certificadoEnProjectManaguer){		
		boolean respuesta=false;
		
		if(cantidadDeJefeDeProyecto()<1){
		Empleado JefeAux=new JefeProyecto(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, null, conteo_Trabajadores,certificadoEnProjectManaguer);
	
		elEquipo.add(JefeAux);
		Empresa.getInstance().addEmpleado(JefeAux);
		respuesta=true;
		
		}else if(cantidadDeJefeDeProyecto()>=1){
			respuesta=false;
		}
		
		return respuesta;
	}
	
	public boolean agregarProgramador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String lenguaje){
		boolean respuesta=false;
		if(cantidadDeProgramadores()<2){
		Empleado programadorAux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, null, lenguaje);
	 elEquipo.add(programadorAux);
	 Empresa.getInstance().addEmpleado(programadorAux);//se agregaron empleados en la empresa de nuevo, se debe crear un metodo para registrar empleado aparte
	 respuesta=true;
	}else if(cantidadDeProgramadores()>=2){
		respuesta=false;
	}
		
	return respuesta; 
	}
	
	public boolean agregarPlanificador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int cantDias){
		boolean respuesta=false;
		
		if(cantidadDePlanificadores()<1){
		Empleado planificadorAux=new Planificador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, null, cantDias);
		elEquipo.add(planificadorAux);
		Empresa.getInstance().addEmpleado(planificadorAux);
		respuesta=true;}
		else if(cantidadDePlanificadores()>=1){
		respuesta=false;	
		}
		
		return respuesta;
	}
	
	public void agregarDiseniador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String tipoDisenio){
		
		Empleado diseniadorAux=new Diseniador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, null, tipoDisenio);
	    elEquipo.add(diseniadorAux);
	    Empresa.getInstance().addEmpleado(diseniadorAux);
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
		if(empleado instanceof JefeProyecto){
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


}

