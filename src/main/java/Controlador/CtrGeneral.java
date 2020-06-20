package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Vista;

public class CtrGeneral implements ActionListener {
	private Vista vista;

	public CtrGeneral(Vista v) {
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Filtro")) {
			vista.getGeneral().setVisible(false);
			vista.getVistaFiltro().setVisible(true);
		}

	}

}