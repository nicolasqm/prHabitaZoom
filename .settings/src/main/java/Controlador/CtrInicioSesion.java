package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.General;
import Vista.IniciarSesion;
import Vista.Vista;

public class CtrInicioSesion implements ActionListener {
	Usuario usuario;
	Vista vista;
	General g;
	JTextField t1, t2;

	public CtrInicioSesion(Usuario u, Vista v) {
		usuario = u;
		vista = v;
		g = vista.getPanelPrincipal().getGeneral();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Iniciar Sesion")) {
			try {
				IniciarSesion is = vista.getIniciarSesion();
				t1 = is.getTextoUsuario();
				t2 = is.getTextoContrasena();
				String correo = t1.getText();
				String contrasena = t2.getText();
				Usuario u = Usuario.inicioSesion(correo, contrasena);
				if (u != null) {
					vista.getIniciarSesion().setVisible(false);
					vista.getPanelPrincipal().setVisible(true);
				}
			} catch (Excepcion e1) {
				vista.getIniciarSesion().setMensajeError(e1.getMessage());
			}
		} else if (comando.equals("Registrarse")) {
			vista.getIniciarSesion().setVisible(false);
			vista.getEditarPerfil().setVisible(true);
		}
	}
}