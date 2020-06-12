package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.HabitacionVista;
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
			try {
				Anuncio anuncio = vista.getAnuncioSeleccionado(usuario);
				AccesoBD.getInstance().anadirFavorito(usuario, anuncio);
				vista.anadirUnAnuncioFavorito(anuncio);
			} catch (Excepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("Quitar")) {
			try {
				Anuncio anuncio = vista.getFavoritoSeleccinado(usuario);
				AccesoBD.getInstance().eliminarFavorito(usuario, anuncio);
				vista.activarBotonFavorito(anuncio);
			} catch (Excepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
