package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Usuario;
import Vista.Vista;

public class CtrPanelBotones implements ActionListener{

	private Vista v;
	private Usuario usuario;
	
	public CtrPanelBotones(Vista vista,Usuario u) {
		v = vista;
		usuario = u;
	}

	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if(comando.equals("Publicar")) {
			v.getGeneral().setVisible(false);
			v.getModificarPerfil().setVisible(false);
			v.getPublicarVista().setVisible(true);
			v.getMostrarPerfil().setVisible(false);
			v.getVistaFiltro().setVisible(false);
			v.borrarErrorFiltrar();
			v.borrarErrorModificarPerfil();
		}else if(comando.equals("General")) {
			if(v.getPublicarVista().isVisible()) {
				v.borrarTextFieldPublicar();
			}
			v.getVistaFiltro().setVisible(false);
			v.getModificarPerfil().setVisible(false);
			v.getPublicarVista().setVisible(false);
			v.getMostrarPerfil().setVisible(false);
			v.getGeneral().setVisible(true);
			v.borrarErrorFiltrar();
			v.borrarErrorModificarPerfil();
		}else if(comando.equals("Perfil")) {
			if(v.getPublicarVista().isVisible()) {
				v.borrarTextFieldPublicar();
			}
			v.setUsuarioMostrarPerfil(usuario);
			v.getVistaFiltro().setVisible(false);
			v.getMostrarPerfil().setVisible(true);
			v.getGeneral().setVisible(false);
			v.getPublicarVista().setVisible(false);
			v.getModificarPerfil().setVisible(false);
			v.borrarErrorFiltrar();
			v.borrarErrorModificarPerfil();
		}
		
	}

	
	
}
