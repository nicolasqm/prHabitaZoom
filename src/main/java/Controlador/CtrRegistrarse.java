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
				if (bdd.buscarUsuario(vista.getTextoCorreo().getText()) == null) {
					if (vista.getTextoConfirmarContrasena().getText().equals(vista.getTextoContrasena().getText())) {
						Usuario.nuevoUsuario(vista.getTextoNombre().getText(),
								vista.getTextoApellido().getText() + " " + vista.getTextoApellido2().getText(),
								vista.getTextoAlias().getText(), vista.getTextoCorreo().getText(),
								vista.getTextoContrasena().getText(), vista.getTextoFechaNacimiento().getText(), null);
						vista.getEditarPerfil().setVisible(false);
						vista.getIniciarSesion().setVisible(true);
					} else {
						throw new Excepcion("contraseñas no iguales");
					}
				}
			} catch (Excepcion ex1) {
				if (vista.getTextoCorreo().getText().equals("")) {
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