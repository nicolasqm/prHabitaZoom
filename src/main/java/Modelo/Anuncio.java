package Modelo;

public class Anuncio {
	private double precioMes;
	private double fianza;
	private Habitacion habitacion;
	
	
	public Anuncio(double precioMes, double fianza, Habitacion habitacion) {
		this.precioMes = precioMes;
		this.fianza = fianza;
		this.habitacion = habitacion;
	}

	
	public Habitacion getHabitacion() {
		return habitacion;
	}
	
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public double getPrecioMes() {
		return precioMes;
	}


	public void setPrecioMes(double precioMes) {
		this.precioMes = precioMes;
	}


	public double getFianza() {
		return fianza;
	}


	public void setFianza(double fianza) {
		this.fianza = fianza;
	}


//	public boolean isParking() {
//		return parking;
//	}
//
//
//	public void setParking(boolean parking) {
//		this.parking = parking;
//	}
//
//
//	public boolean isTerraza() {
//		return terraza;
//	}
//
//
//	public void setTerraza(boolean terraza) {
//		this.terraza = terraza;
//	}
//
//
//	public boolean isFumadores() {
//		return fumadores;
//	}
//
//
//	public void setFumadores(boolean fumadores) {
//		this.fumadores = fumadores;
//	}
//
//
//	public boolean isMascotas() {
//		return mascotas;
//	}
//
//
//	public void setMascotas(boolean mascotas) {
//		this.mascotas = mascotas;
//	}
//
//
//	public boolean isSoloEstudiantes() {
//		return soloEstudiantes;
//	}
//
//
//	public void setSoloEstudiantes(boolean soloEstudiantes) {
//		this.soloEstudiantes = soloEstudiantes;
//	}
//
//
//	public boolean isGastosIncluidos() {
//		return gastosIncluidos;
//	}
//
//
//	public void setGastosIncluidos(boolean gastosIncluidos) {
//		this.gastosIncluidos = gastosIncluidos;
//	}
	
	
}
