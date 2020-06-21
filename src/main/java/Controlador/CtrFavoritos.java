package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

public class CtrFavoritos implements ActionListener {
	private Usuario usuario;
	private Vista vista;

	public CtrFavoritos(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if (command.equals("Favorito")) {
			try {
				Anuncio anuncio = vista.getAnuncioSeleccionado(usuario);
				AccesoBD.getInstance().anadirFavorito(usuario, anuncio);
				vista.anadirAnuncioFavorito(anuncio);
			} catch (Excepcion e) {
				e.printStackTrace();
			}
		} else if (command.equals("Quitar")) {
			try {
				Anuncio anuncio = vista.getFavoritoSeleccinado(usuario);
				AccesoBD.getInstance().eliminarFavorito(usuario, anuncio);
				vista.activarBotonFavorito(anuncio);
			} catch (Excepcion e) {
				e.printStackTrace();
			}

		}
	}

}
