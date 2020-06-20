package Modelo;

public class Inquilino extends Usuario {

	public Inquilino(String n, String a, String al, String c, String cont, String nac) {
		super(n, a, al, c, cont, nac);
	}

	public Inquilino(String n, String a, String al, String c, String cont, String nac, String descripcion) {
		super(n, a, al, c, cont, nac);
		this.setDescripcion(descripcion);
	}

}
