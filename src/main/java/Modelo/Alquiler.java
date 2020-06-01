package Modelo;

public class Alquiler {

	private double precio;
	private String fechaInicio;
	private String fechaFin;
	private double fianza;

	public Alquiler(double precio, String fechaInicio, String fechaFin, double fianza) {
		this.precio = precio;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.fianza = fianza;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getFianza() {
		return fianza;
	}

	public void setFianza(double fianza) {
		this.fianza = fianza;
	}

}
