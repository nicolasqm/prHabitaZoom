package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Anuncio;
import Modelo.Usuario;
import Vista.Vista;

public class CtrFavoritos implements ActionListener {

	private Vista vista;
	private Usuario usuario;
	
	
	public CtrFavoritos(Vista v, Usuario u) {
		vista = v;
		usuario = u;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command.equals("Favorito")) {
			Anuncio anuncio = vista.getAnuncioListaAnuncio();
			vista.anadirAnuncioFavorito(anuncio);
		}
		
	}

}
