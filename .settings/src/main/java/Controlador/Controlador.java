package Controlador;

import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
	Usuario usuario;
	Vista vista;
	CtrInicioSesion inicioSesion;
	CtrRegistrarse registrarse;

	public Controlador(Usuario u, Vista v) {
		usuario = u;
		vista = v;

		inicioSesion = new CtrInicioSesion(usuario, vista);
		registrarse = new CtrRegistrarse(usuario, vista);

		vista.setActionListeners(inicioSesion, registrarse);
	}

	public CtrInicioSesion getCtrInicioSesion() {
		return inicioSesion;
	}

	public CtrRegistrarse getCtrRegistrarse() {
		return registrarse;
	}
}