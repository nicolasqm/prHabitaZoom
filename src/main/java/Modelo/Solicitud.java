package Modelo;

public class Solicitud {

	private String fechaSolicitud;
	private String fechaInicioAlq;
	private String fechaFinAlq;
	private boolean estadoSolicitud;
	private Usuario solicitante;
	private Anuncio anuncioSolicitado;

	public Solicitud(String fechaSolicitud, String fechaInicioAlq, String fechaFinAlq, boolean estadoSolicitud, Usuario solicitante, Anuncio anuncioSolicitado) {
		this.estadoSolicitud = estadoSolicitud;
		this.fechaFinAlq = fechaFinAlq;
		this.fechaInicioAlq = fechaInicioAlq;
		this.fechaSolicitud = fechaSolicitud;
		this.solicitante = solicitante;
		this.anuncioSolicitado = anuncioSolicitado;
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
	
	public Usuario getSolicitante() {
		return solicitante;
	}
	
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public Anuncio getAnuncioSolicitado() {
		return anuncioSolicitado;
	}
	
	public void setAnuncioSolicitado(Anuncio anuncioSolicitado) {
		this.anuncioSolicitado = anuncioSolicitado;
	}

}