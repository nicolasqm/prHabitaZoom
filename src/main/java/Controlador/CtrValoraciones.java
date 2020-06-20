package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;

public class CtrValoraciones implements ActionListener {
	private Usuario usuario;
	private Vista vista;

	public CtrValoraciones(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		HabitacionVista hab = vista.getAnuncioValoracion();
		if (comando.equals("Enviar")) {
			try {
				AccesoBD accesobd = AccesoBD.getInstance();

				accesobd.anadirValoracion(usuario, hab.getAnuncio().getHabitacion(), hab.getValoracion(), null);
				hab.setValoracion(AccesoBD.getInstance().obtenerMediaHabitacion(hab.getAnuncio().getHabitacion()));

			} catch (Excepcion o) {
				hab.errorVal().setText("El anuncio ya ha sido valorado");
			}

		}

	}

}
