package Modelo;


public class Distrito {
	private String nombre;
	private int codigoPostal;
	
	

	public Distrito(String nombre, int codigo) {
		this.nombre=nombre;
		this.codigoPostal=codigo;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
