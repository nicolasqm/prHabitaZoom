package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

public class CtrModificarPerfil implements ActionListener{
	Usuario usuario;
	Vista vista;
	AccesoBD bdd = AccesoBD.getInstance();

	public CtrModificarPerfil(Usuario u, Vista v) {
		usuario = u;
		vista = v;
	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals("Confirmar Perfil")) {
			Usuario aux = new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getAlias(), usuario.getCorreo(), usuario.getContrasena(), usuario.getFecha_Nacimiento(),usuario.getDescripcion());
			try {
				if (vista.getModificarPerfil().getConfirmarContrasena().getText()
						.equals(vista.getModificarPerfil().getContrasena().getText())) {
					usuario.setAlias(vista.getModificarPerfil().getAlias().getText());
					usuario.setApellido(vista.getModificarPerfil().getApellido().getText()+
							" " +vista.getModificarPerfil().getApellido2().getText());
					usuario.setContrasena(vista.getModificarPerfil().getContrasena().getText());
					usuario.setCorreo(vista.getModificarPerfil().getCorreo().getText());
					usuario.setFecha_Nacimiento(vista.getModificarPerfil().getFechaNacimiento().getText());
					usuario.setNombre(vista.getModificarPerfil().getNombre().getText());
					
					bdd.updateUsuario(usuario);
					
					vista.getModificarPerfil().setVisible(false);
					vista.getMostrarPerfil().setVisible(true);
					vista.setUsuarioMostrarPerfil(usuario);
				} else {
					throw new Excepcion("contraseñas no iguales");
				}
			} catch (Excepcion ex1) {
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
