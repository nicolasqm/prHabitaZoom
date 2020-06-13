package Controlador;

import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
	private Usuario usuario;
	private Vista vista;
	private CtrInicioSesion inicioSesion;
	private CtrRegistrarse registrarse;
	private CtrPanelBotones panelBotones;
	private CtrPublicar publicar;
	private CtrFiltro filtro;
	private CtrGeneral general;
	private CtrMostrarPerfil mostrarPerfil;
	private CtrModificarPerfil modificarPerfil;
	private CtrFavoritos favoritos;
	private CtrValoraciones valoraciones;

	public Controlador(Usuario u, Vista v) {
		usuario = u;
		vista = v;

		inicioSesion = new CtrInicioSesion(usuario, vista);
		registrarse = new CtrRegistrarse(usuario, vista);
		panelBotones = new CtrPanelBotones(usuario, vista);
		publicar = new CtrPublicar(usuario, vista);
		filtro = new CtrFiltro(vista);
		general = new CtrGeneral(vista);
		mostrarPerfil = new CtrMostrarPerfil(usuario, vista);
		modificarPerfil = new CtrModificarPerfil(usuario, vista);
		favoritos = new CtrFavoritos(vista, usuario);
		valoraciones =  new CtrValoraciones(vista , usuario);

		vista.setActionListeners(inicioSesion, registrarse, panelBotones, publicar, filtro, general, mostrarPerfil,
				modificarPerfil, favoritos, valoraciones);
	}

}