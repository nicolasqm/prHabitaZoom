package TestsIteracion1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

class TestsRegistrarse {
	private Vista v;
	private Usuario u;
	private Controlador controlador;

	@BeforeEach
	void init() {
		v = new Vista();
		u = null;

		controlador = new Controlador(u, v);
	}

	@Test
	void testUsuarioExistente() {
		Exception e = assertThrows(Excepcion.class, () -> Usuario.nuevoUsuario("Nicolas", "Quintana", "nicoqm",
				"nico@gmail.com", "12355", "2012-12-12", "Modificado"));
		assertEquals("no se ha podido añadir al usuario", e.getMessage());
	}

	@Test
	void testErrorContrasena() {

		v.getEditarPerfil().getCorreo().setText("Correo");
		v.getEditarPerfil().getNombre().setText("Nombre");
		v.getEditarPerfil().getApellido().setText("ap");
		v.getEditarPerfil().getApellido2().setText("ap2");
		v.getEditarPerfil().getAlias().setText("alias");
		v.getEditarPerfil().getFechaNacimiento().setText("2000-01-12");
		v.getEditarPerfil().getContrasena().setText("pass");
		v.getEditarPerfil().getConfirmarContrasena().setText("nopass");
		v.getEditarPerfil().getButton().doClick();
		assertEquals("Error, contraseñas no iguales", v.getEditarPerfil().getError().getText());
	}

	@Test
	void testFaltanDatos() {
		v.getEditarPerfil().getButton().doClick();
		assertEquals("Error, faltan datos", v.getEditarPerfil().getError().getText());
	}
}