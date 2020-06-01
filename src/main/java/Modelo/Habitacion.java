package Modelo;

public class Habitacion {

	private int id;
	private String direccion;
	private int numero;
	private int planta;
	private String puerta;
	private String descripcion;
	private int tamano;
	private boolean parking;
	private boolean terraza;
	private boolean wifi;
	private boolean fumadores;
	private boolean mascotas;
	private boolean soloEstudiantes;
	private boolean gastosIncluidos;
	private boolean activa;
	private Propietario propietario;
	private Distrito distrito;

	public Habitacion(int i, Propietario propietario, Distrito distrito, String direccion, int numero, int planta,
			String puerta, int tamano) {
		this.id = i;
		this.activa = false;
		this.direccion = direccion;
		this.fumadores = false;
		this.gastosIncluidos = false;
		this.mascotas = false;
		this.numero = numero;
		this.parking = false;
		this.planta = planta;
		this.puerta = puerta;
		this.soloEstudiantes = false;
		this.tamano = tamano;
		this.terraza = false;
		this.wifi = false;
		this.propietario = propietario;
		this.distrito = distrito;
	}

	public Habitacion(int i, String direccion, int numero, int planta, String puerta, int tamano, boolean parking,
			boolean terraza, boolean wifi, boolean fumadores, boolean mascotas, boolean soloEstudiantes,
			boolean gastosIncluidos, boolean activa, Propietario propietario, Distrito distrito) {
		this.id = i;
		this.activa = activa;
		this.direccion = direccion;
		this.fumadores = fumadores;
		this.gastosIncluidos = gastosIncluidos;
		this.mascotas = mascotas;
		this.numero = numero;
		this.parking = parking;
		this.planta = planta;
		this.puerta = puerta;
		this.soloEstudiantes = soloEstudiantes;
		this.tamano = tamano;
		this.terraza = terraza;
		this.wifi = wifi;
		this.propietario = propietario;
		this.distrito = distrito;
	}

	public Habitacion(int i, String direccion, int numero, int planta, String puerta, String descripcion, int tamano,
			boolean parking, boolean terraza, boolean wifi, boolean fumadores, boolean mascotas,
			boolean soloEstudiantes, boolean gastosIncluidos, boolean activa, Propietario propietario,
			Distrito distrito) {
		this(i, direccion, numero, planta, puerta, tamano, parking, terraza, wifi, fumadores, mascotas, soloEstudiantes,
				gastosIncluidos, activa, propietario, distrito);
		this.descripcion = descripcion;
	}

	public void setId(int i) {
		id = i;
	}

	public int getID() {
		return id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isTerraza() {
		return terraza;
	}

	public void setTerraza(boolean terraza) {
		this.terraza = terraza;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isFumadores() {
		return fumadores;
	}

	public void setFumadores(boolean fumadores) {
		this.fumadores = fumadores;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}

	public boolean isSoloEstudiantes() {
		return soloEstudiantes;
	}

	public void setSoloEstudiantes(boolean soloEstudiantes) {
		this.soloEstudiantes = soloEstudiantes;
	}

	public boolean isGastosIncluidos() {
		return gastosIncluidos;
	}

	public void setGastosIncluidos(boolean gastosIncluidos) {
		this.gastosIncluidos = gastosIncluidos;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + numero;
		result = prime * result + planta;
		result = prime * result + propietario.hashCode();
		result = prime * result + puerta.hashCode();
		result = prime * result + distrito.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (numero != other.numero)
			return false;
		if (planta != other.planta)
			return false;
		if (!propietario.equals(other.propietario))
			return false;
		if (!puerta.equals(other.puerta))
			return false;
		if (!distrito.equals(other.distrito))
			return false;
		return true;
	}

}
