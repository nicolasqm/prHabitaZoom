package Modelo;

public class Imagen {
	private int tamanoImgancho;
	private int tamanoImgAlto;

	public Imagen(int tamanoImgancho, int tamanoImgAlto) {
		super();
		this.tamanoImgancho = tamanoImgancho;
		this.tamanoImgAlto = tamanoImgAlto;
	}

	public int getTamanoImgancho() {
		return tamanoImgancho;
	}

	public void setTamanoImgancho(int tamanoImgancho) {
		this.tamanoImgancho = tamanoImgancho;
	}

	public int getTamanoImgAlto() {
		return tamanoImgAlto;
	}

	public void setTamanoImgAlto(int tamanoImgAlto) {
		this.tamanoImgAlto = tamanoImgAlto;
	}

}
