package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Usuario;
import Vista.EditarPerfil;
import Vista.Vista;

public class CtrValoracion implements ActionListener{
	Usuario usuario;
	Vista vista;
	

	public CtrValoracion(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Enviar")) {
			vista.get;
		} 
	}
}
