package logic;

public class Contrato {
	
	private String identificador;
	private String idCliente;
	private String nombreProyecto;
	
	public Contrato(String identificador, String idCliente, String nombreProyecto) {
		super();
		this.identificador = identificador;
		this.idCliente = idCliente;
		this.nombreProyecto = nombreProyecto;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	

}
