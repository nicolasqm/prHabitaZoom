package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

public class CtrRegistrarse implements ActionListener {
	private Vista vista;
	private AccesoBD bdd = AccesoBD.getInstance();

	public CtrRegistrarse(Vista v) {
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals("Confirmar Perfil")) {
			try {
				if (bdd.buscarUsuario(vista.getEditarPerfil().getCorreo().getText()) == null) {
					if (vista.getEditarPerfil().getConfirmarContrasena().getText()
							.equals(vista.getEditarPerfil().getContrasena().getText())) {
						Usuario.nuevoUsuario(vista.getEditarPerfil().getNombre().getText(),
								vista.getEditarPerfil().getApellido().getText() + " "
										+ vista.getEditarPerfil().getApellido2().getText(),
								vista.getEditarPerfil().getAlias().getText(),
								vista.getEditarPerfil().getCorreo().getText(),
								vista.getEditarPerfil().getConfirmarContrasena().getText(),
								vista.getEditarPerfil().getFechaNacimiento().getText(), null);
						vista.getEditarPerfil().setVisible(false);
						vista.getIniciarSesion().setVisible(true);
					} else {
						throw new Excepcion("contraseñas no iguales");
					}
				}
			} catch (Excepcion ex1) {
				if (vista.getEditarPerfil().getCorreo().getText().equals("")) {
					vista.getEditarPerfil().setError("faltan datos");
				} else {
					vista.getEditarPerfil().setError(ex1.getMessage());
				}
			}
		} else if (action.equals("Cancelar")) {
			vista.getEditarPerfil().setVisible(false);
			vista.getIniciarSesion().setVisible(true);
			vista.getEditarPerfil().borra();
			vista.getEditarPerfil().borrarMensajeError();

		}
	}
}