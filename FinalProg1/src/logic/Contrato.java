package logic;

import java.util.Date;

public class Contrato {
	private String codigoProyecto;
	private String idCliente;
	private double costoProyecto;
	private Date fechaInicio;
	private Date fechaTermino;	
	private Boolean firmado=false;
	private Proyecto miProyecto;
	public Contrato(String codigoProyecto, String idCliente, double costoProyecto, Date fechaInicio, Date fechaTermino,
			Boolean firmado) {
		super();
		this.codigoProyecto = codigoProyecto;
		this.idCliente = idCliente;
		this.costoProyecto = costoProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.firmado = firmado;
	}
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public double getCostoProyecto() {
		return costoProyecto;
	}
	public void setCostoProyecto(double costoProyecto) {
		this.costoProyecto = costoProyecto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public Boolean getFirmado() {
		return firmado;
	}
	public void setFirmado(Boolean firmado) {
		this.firmado = firmado;
	}
	
	public boolean VerificacionDeFechas(){
		boolean respuesta=false;		
		Date dateAux=new Date();
		if(fechaTermino.before(dateAux)){			
		respuesta=true;	
		}		
	return respuesta;	
	/*Si verificacion de fecha=true, significa que el contrato esta atrazado, porque dateAux devuelve la fecha actual*/
	}
	public Proyecto getMiProyecto() {
		return miProyecto;
	}
	public void setMiProyecto(Proyecto miProyecto) {
		this.miProyecto = miProyecto;
	}	

}
