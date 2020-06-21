package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

public class CtrPanelBotones implements ActionListener {
	private Usuario usuario;
	private Vista vista;

	public CtrPanelBotones(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals("Publicar")) {
			vista.getGeneral().setVisible(false);
			vista.getModificarPerfil().setVisible(false);
			vista.getPublicarVista().setVisible(true);
			vista.getMostrarPerfil().setVisible(false);
			vista.getVistaFiltro().setVisible(false);
			vista.getVistaFavoritos().setVisible(false);
			vista.getSolicitudesVista().setVisible(false);
			vista.borrarErrorFiltrar();
			vista.borrarErrorModificarPerfil();
		} else if (comando.equals("General")) {
			if (vista.getPublicarVista().isVisible()) {
				vista.borrarTextFieldPublicar();
			}
			vista.getVistaFiltro().setVisible(false);
			vista.getModificarPerfil().setVisible(false);
			vista.getPublicarVista().setVisible(false);
			vista.getMostrarPerfil().setVisible(false);
			vista.getGeneral().setVisible(true);
			vista.getVistaFavoritos().setVisible(false);
			vista.getSolicitudesVista().setVisible(false);
			vista.borrarErrorFiltrar();
			vista.borrarErrorModificarPerfil();
		} else if (comando.equals("Perfil")) {
			if (vista.getPublicarVista().isVisible()) {
				vista.borrarTextFieldPublicar();
			}
			vista.setUsuarioMostrarPerfil(usuario);
			vista.getVistaFiltro().setVisible(false);
			vista.getMostrarPerfil().setVisible(true);
			vista.getGeneral().setVisible(false);
			vista.getPublicarVista().setVisible(false);
			vista.getModificarPerfil().setVisible(false);
			vista.getVistaFavoritos().setVisible(false);
			vista.getSolicitudesVista().setVisible(false);
			vista.borrarErrorFiltrar();
			vista.borrarErrorModificarPerfil();
		} else if (comando.equals("Favoritos")) {
			if (vista.getPublicarVista().isVisible()) {
				vista.borrarTextFieldPublicar();
			}
			vista.setUsuarioMostrarPerfil(usuario);
			vista.getVistaFiltro().setVisible(false);
			vista.getMostrarPerfil().setVisible(false);
			vista.getGeneral().setVisible(false);
			vista.getPublicarVista().setVisible(false);
			vista.getModificarPerfil().setVisible(false);
			vista.getSolicitudesVista().setVisible(false);
			vista.getVistaFavoritos().setVisible(true);
			vista.borrarErrorFiltrar();
			vista.borrarErrorModificarPerfil();
			try {
				vista.borrarTodosLosFavoritos();
				vista.anadirListaFavoritos(AccesoBD.getInstance().getFavoritos(usuario));
			} catch (Excepcion e) {
				e.printStackTrace();
			}
		} else if (comando.equals("Solicitudes")) {
			if (vista.getPublicarVista().isVisible()) {
				vista.borrarTextFieldPublicar();
			}
			vista.getVistaFiltro().setVisible(false);
			vista.getMostrarPerfil().setVisible(false);
			vista.getGeneral().setVisible(false);
			vista.getPublicarVista().setVisible(false);
			vista.getModificarPerfil().setVisible(false);
			vista.getVistaFavoritos().setVisible(false);
			vista.getSolicitudesVista().setVisible(true);
			vista.borrarErrorFiltrar();
			vista.borrarErrorModificarPerfil();
			try {
				vista.borrarTodosLasSolicitudes();
				vista.anadirListaSolicitudes(AccesoBD.getInstance().getSolicitudes(usuario));
			} catch (Excepcion e) {
				e.printStackTrace();
			}
		}

	}

}
