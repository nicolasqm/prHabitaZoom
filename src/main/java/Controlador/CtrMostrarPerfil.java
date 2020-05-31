package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Usuario;
import Vista.EditarPerfil;
import Vista.Vista;

public class CtrMostrarPerfil implements ActionListener {
	Usuario usuario;
	Vista vista;
	EditarPerfil editarPerfil;
	
	public CtrMostrarPerfil(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("Editar Perfil")) {
			vista.setDatosModificarPerfil(usuario);
			vista.getMostrarPerfil().setVisible(false);
			vista.getModificarPerfil().setVisible(true);
			vista.getModificarPerfil().getCancelar().setVisible(false);
		}
	}
	
}
