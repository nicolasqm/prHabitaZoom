package Modelo;

public class Solicitud {
	
	String fechaSolicitud;
	String fechaInicioAlq;
	String fechaFinAlq;
	boolean estadoSolicitud;
	
	
	public Solicitud(String fechaSolicitud, String fechaInicioAlq, String fechaFinAlq, boolean estadoSolicitud) {
		this.estadoSolicitud=estadoSolicitud;
		this.fechaFinAlq=fechaFinAlq;
		this.fechaInicioAlq=fechaInicioAlq;
		this.fechaSolicitud=fechaSolicitud;
	}


	public String getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getFechaInicioAlq() {
		return fechaInicioAlq;
	}


	public void setFechaInicioAlq(String fechaInicioAlq) {
		this.fechaInicioAlq = fechaInicioAlq;
	}


	public String getFechaFinAlq() {
		return fechaFinAlq;
	}


	public void setFechaFinAlq(String fechaFinAlq) {
		this.fechaFinAlq = fechaFinAlq;
	}


	public boolean isEstadoSolicitud() {
		return estadoSolicitud;
	}


	public void setEstadoSolicitud(boolean estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
}
