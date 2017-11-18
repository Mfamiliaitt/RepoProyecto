package logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Proyecto {
	private String tipo;
	private String codigoProyecto;
	private Boolean activo; //Proyecto activo o pasivo
	private String estado; //prorrogado,atrazado
	private ArrayList<Empleado> elEquipo;
	public Proyecto(String tipo, String codigoProyecto, Boolean activo, String estado, ArrayList<Empleado> elEquipo) {
		super();
		this.tipo = tipo;
		this.codigoProyecto = codigoProyecto;
		this.activo = activo;
		this.estado = estado;
		this.elEquipo = elEquipo;
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
			
	}
	
	public void agregarProgramador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual, String lenguaje){
		Empleado programadorAux=new Programador(identificador, nombre, apellidos, direccion, sexo, edad, salario, nombreProyecto, evaluacionAnual, lenguaje);
		
	 elEquipo.add(programadorAux);
	}
	
	
	

}
