package logic;

public class Diseniador {
	
	protected String identificador;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
    protected String sexo;
    protected int edad;
    protected double salario;
    protected String nombreProyecto;
    protected String evaluacionAnual;
	public String getIdentificador() {
		return identificador;
	}
	
	public Diseniador(String identificador, String nombre, String apellidos, String direccion, String sexo, int edad,
			double salario, String nombreProyecto, String evaluacionAnual) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.sexo = sexo;
		this.edad = edad;
		this.salario = salario;
		this.nombreProyecto = nombreProyecto;
		this.evaluacionAnual = evaluacionAnual;
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
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getEvaluacionAnual() {
		return evaluacionAnual;
	}
	public void setEvaluacionAnual(String evaluacionAnual) {
		this.evaluacionAnual = evaluacionAnual;
	}
    
    
    
    
    
}
