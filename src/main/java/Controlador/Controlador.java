package Controlador;

import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
	private Vista vista;
	private Usuario usuario;
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
	private CtrSolicitudes solicitudes;
	private CtrSolicitar solicitar;

	public Controlador(Usuario u, Vista v) {
		usuario = u;
		vista = v;

		inicioSesion = new CtrInicioSesion(usuario, vista);
		registrarse = new CtrRegistrarse(vista);
		panelBotones = new CtrPanelBotones(usuario, vista);
		publicar = new CtrPublicar(usuario, vista);
		filtro = new CtrFiltro(usuario, vista);
		general = new CtrGeneral(vista);
		mostrarPerfil = new CtrMostrarPerfil(usuario, vista);
		modificarPerfil = new CtrModificarPerfil(usuario, vista);
		favoritos = new CtrFavoritos(usuario, vista);
		valoraciones = new CtrValoraciones(usuario, vista);
		solicitudes = new CtrSolicitudes(vista);
		solicitar = new CtrSolicitar(usuario, vista);

		vista.setActionListeners(inicioSesion, registrarse, panelBotones, publicar, filtro, general, mostrarPerfil,
				modificarPerfil, favoritos, valoraciones, solicitudes, solicitar);
	}

}