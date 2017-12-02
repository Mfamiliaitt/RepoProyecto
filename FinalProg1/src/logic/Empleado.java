package logic;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Empleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737972801718319184L;
	protected String identificador;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
    protected String sexo;
    protected int edad;
    protected double salario;
    protected String idProyecto;
    protected String evaluacionAnual;
    protected boolean ocupado=false;
    protected ArrayList<String> misEstados=new ArrayList<>();
	public Empleado(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String idProyecto, String evaluacionAnual) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.sexo = sexo;
		this.edad = edad;
		this.salario = salario;
		this.idProyecto = idProyecto;
		this.evaluacionAnual = evaluacionAnual;
		
	}

	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNombreProyecto() {
		return idProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.idProyecto = nombreProyecto;
	}
	public String getEvaluacionAnual() {
		return evaluacionAnual;
	}
	public void setEvaluacionAnual(String evaluacionAnual) {
		this.evaluacionAnual = evaluacionAnual;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public ArrayList<String> getMisEstados() {
		return misEstados;
	}

	public void setMisEstados(ArrayList<String> misEstados) {
		this.misEstados = misEstados;
	}
    
    
    
    
    
}
