package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.IniciarSesion;
import Vista.Vista;

public class CtrInicioSesion implements ActionListener {
	private Usuario usuario;
	private Vista vista;

	public CtrInicioSesion(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Iniciar Sesion")) {
			try {
				IniciarSesion is = vista.getIniciarSesion();
				String correo = is.getTextoUsuario().getText();
				String contrasena = is.getTextoContrasena().getText();
				Usuario u = Usuario.inicioSesion(correo, contrasena);
				if (u != null) {
					vista.getIniciarSesion().setVisible(false);
					vista.getIniciarSesion().borrarMensajeError();
					vista.getPanelPrincipal().setVisible(true);
					usuario.setCorreo(u.getCorreo());
					usuario.setAlias(u.getAlias());
					usuario.setApellido(u.getApellido());
					usuario.setNombre(u.getNombre());
					usuario.setContrasena(u.getContrasena());
					usuario.setFecha_Nacimiento(u.getFecha_Nacimiento());
					usuario.setDescripcion(u.getDescripcion());
					vista.quitarBotonesFavoritos(AccesoBD.getInstance().getFavoritos(usuario));
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