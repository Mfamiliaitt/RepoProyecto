package logic;

public class Contrato {

	private String identificador;
	private String idCliente;
	private String nombreProyecto;
	private String descipcionDelProyecto;

	public Contrato(String identificador, String idCliente, String nombreProyecto, String descipcionDelProyecto) {
		super();
		this.identificador = identificador;
		this.idCliente = idCliente;
		this.nombreProyecto = nombreProyecto;
		this.descipcionDelProyecto = descipcionDelProyecto;
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

	public String getDescipcionDelProyecto() {
		return descipcionDelProyecto;
	}

	public void setDescipcionDelProyecto(String descipcionDelProyecto) {
		this.descipcionDelProyecto = descipcionDelProyecto;
	}
	
	

}
