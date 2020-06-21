package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Vista;

public class CtrSolicitudes implements ActionListener {
	private Vista vista;

	public CtrSolicitudes(Vista v) {
		vista = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Aceptar")) {
			vista.buscarBotonAceptarSolicitud();
		} else if (comando.equals("Cancelar")) {
			vista.buscarBotonCancelarSolicitud();
		}
	}
}