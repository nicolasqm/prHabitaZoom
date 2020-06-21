package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

public class CtrModificarPerfil implements ActionListener {
	private Usuario usuario;
	private Vista vista;
	private AccesoBD bdd = AccesoBD.getInstance();

	public CtrModificarPerfil(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals("Confirmar Perfil")) {
			Usuario aux = new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getAlias(),
					usuario.getCorreo(), usuario.getContrasena(), usuario.getFecha_Nacimiento(),
					usuario.getDescripcion());
			try {
				if (!vista.getTextoAliasMod().getText().equals("") && !vista.getTextoApellidoMod().getText().equals("")
						&& !vista.getTextoApellido2Mod().getText().equals("") && !vista.getTextoNombreMod().getText().equals("") && !vista.getTextoContrasenaMod().getText().equals("")) {
					if (vista.getTextoConfirmarContrasenaMod().getText().equals(vista.getTextoContrasenaMod().getText())) {
						usuario.setAlias(vista.getTextoAliasMod().getText());
						usuario.setApellido(
								vista.getTextoApellidoMod().getText() + " " + vista.getTextoApellido2Mod().getText());
						usuario.setContrasena(vista.getModificarPerfil().getContrasena().getText());
						usuario.setCorreo(vista.getTextoCorreoMod().getText());
						usuario.setFecha_Nacimiento(vista.getTextoFechaNacimientoMod().getText());
						usuario.setNombre(vista.getTextoNombreMod().getText());

						bdd.updateUsuario(usuario);

						vista.getModificarPerfil().setVisible(false);
						vista.getMostrarPerfil().setVisible(true);
						vista.setUsuarioMostrarPerfil(usuario);
					} else {
						throw new Excepcion("contraseñas no iguales");
					}
				} else {
					throw new Excepcion("faltan datos");
				}
                
			} catch (Excepcion ex1) {
				vista.getModificarPerfil().getError().setText(ex1.getMessage());
				usuario.setNombre(aux.getNombre());
				usuario.setApellido(aux.getApellido());
				usuario.setAlias(aux.getAlias());
				usuario.setCorreo(aux.getCorreo());
				usuario.setContrasena(aux.getContrasena());
				usuario.setDescripcion(aux.getDescripcion());
				usuario.setFecha_Nacimiento(aux.getFecha_Nacimiento());
				vista.getModificarPerfil().setError(ex1.getMessage());
			}
		}
	}

}
