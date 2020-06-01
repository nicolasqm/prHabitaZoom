package Modelo;

public class Valoracion {
	private int estrellas;
	private String comentario;

	public Valoracion(int estrellas, String comentario) {
		super();
		this.estrellas = estrellas;
		this.comentario = comentario;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
