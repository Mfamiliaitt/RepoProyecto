package logic;

public class Contrato {

	private String codigoContrato;
	private String idCliente;
	private String nombreProyecto;
	private String descipcionDelProyecto;

	public Contrato(String identificador, String idCliente, String nombreProyecto, String descipcionDelProyecto) {
		super();
		this.codigoContrato = identificador;
		this.idCliente = idCliente;
		this.nombreProyecto = nombreProyecto;
		this.descipcionDelProyecto = descipcionDelProyecto;
	}
	
	public String getIdentificador() {
		return codigoContrato;
	}

	public void setIdentificador(String identificador) {
		this.codigoContrato = identificador;
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
