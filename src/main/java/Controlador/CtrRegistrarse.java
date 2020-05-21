package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;


public class CtrRegistrarse implements ActionListener {

	Vista vista;
	Usuario usuario;
	AccesoBD bdd = AccesoBD.getInstance();

	public CtrRegistrarse(Vista v, Usuario u) {
		vista = v;
		usuario = u;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals("Confirmar Perfil")) {
			try {
				System.out.println(vista.getEditarPerfil().getCorreo().getText());
				if (bdd.buscarUsuario(vista.getEditarPerfil().getCorreo().getText()) == null) {
					if (vista.getEditarPerfil().getConfirmarContrasena().getText().equals(vista.getEditarPerfil().getContrasena().getText())) {
						Usuario.nuevoUsuario(vista.getEditarPerfil().getNombre().getText(),
							vista.getEditarPerfil().getApellido().getText() + " " + vista.getEditarPerfil().getApellido2().getText(),
							vista.getEditarPerfil().getAlias().getText(), vista.getEditarPerfil().getCorreo().getText(),
							vista.getEditarPerfil().getConfirmarContrasena().getText(),
							vista.getEditarPerfil().getFechaNacimiento().getText(),null);
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
		}
	}
}
