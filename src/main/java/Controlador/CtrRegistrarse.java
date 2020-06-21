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
				if(!vista.getTextoCorreo().getText().equals("") && !vista.getTextoAlias().getText().equals("") && !vista.getTextoApellido().getText().equals("")
                        && !vista.getTextoApellido2().getText().equals("") && !vista.getTextoNombre().getText().equals("") && !vista.getTextoContrasena().getText().equals("")) {
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
				}else {
					throw new Excepcion("faltan datos");
				}
			} catch (Excepcion ex1) {
				vista.getEditarPerfil().setError(ex1.getMessage());
			}
		} else if (action.equals("Cancelar")) {
			vista.getEditarPerfil().setVisible(false);
			vista.getIniciarSesion().setVisible(true);
			vista.getEditarPerfil().borra();
			vista.getEditarPerfil().borrarMensajeError();

		}
	}
}