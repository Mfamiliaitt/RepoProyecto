package logic;


import java.util.ArrayList;

public class Proyecto {
	private String tipo;
	private String codigoProyecto;
	private Boolean activo; //Proyecto activo o pasivo
	private String estado; //prorrogado,atrazado o terminado
	private ArrayList<Empleado> elEquipo;
	public Proyecto(String tipo, String codigoProyecto, Boolean activo, String estado) {
		super();
		this.tipo = tipo;
		this.codigoProyecto = codigoProyecto;
		this.activo = activo;
		this.estado = estado;
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
	
	
	public void agregarJefeProyecto(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int conteo_Trabajadores){
		Empleado JefeAux=new JefeProyecto(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, conteo_Trabajadores);
		elEquipo.add(JefeAux);
		Empresa.getInstance().addEmpleado(JefeAux);
	}
	
	public void agregarProgramador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String lenguaje){
		Empleado programadorAux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, lenguaje);
		
	 elEquipo.add(programadorAux);
	 Empresa.getInstance().addEmpleado(programadorAux);
	}
	
	public void agregarPlanificador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, int cantDias){
		Empleado planificadorAux=new Planificador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, cantDias);
		
		elEquipo.add(planificadorAux);
		Empresa.getInstance().addEmpleado(planificadorAux);
	}
	
	public void agregarDiseniador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String tipoDisenio){
		
		Empleado diseniadorAux=new Diseniador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, tipoDisenio);
	    elEquipo.add(diseniadorAux);
	    Empresa.getInstance().addEmpleado(diseniadorAux);
	}
	

}
