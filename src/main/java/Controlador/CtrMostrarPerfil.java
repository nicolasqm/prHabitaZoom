package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Usuario;
import Vista.Vista;

public class CtrMostrarPerfil implements ActionListener {
	private Usuario usuario;
	private Vista vista;

	public CtrMostrarPerfil(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Editar Perfil")) {
			vista.setDatosModificarPerfil(usuario);
			vista.getMostrarPerfil().setVisible(false);
			vista.getModificarPerfil().borrarMensajeError();
			vista.getModificarPerfil().setVisible(true);
			vista.getModificarPerfil().getCancelar().setVisible(false);
		} else if (comando.equals("Cerrar Sesion")) {
			vista.getMostrarPerfil().setVisible(false);
			vista.getPanelPrincipal().setVisible(false);
			vista.borrarTextFieldsInicioSesion();
			vista.getIniciarSesion().setVisible(true);
		}
	}

}