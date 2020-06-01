package TestsIteracion1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

class TestsIniciarSesion {
	private Vista v;
	private Usuario u;
	private Controlador c;

	@BeforeEach
	void init() {
		v = new Vista();
		u = new Usuario("", "", "", "", "", "");

		c = new Controlador(u, v);
	}

	@Test
	void testNoUsuario() {
		v.getIniciarSesion().getTextoUsuario().setText("nouser");
		v.getIniciarSesion().getTextoContrasena().setText("nopass");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();

		assertEquals("Error, no existe ese usuario", v.getIniciarSesion().getError().getText());
	}

	@Test
	void testUsuario() {
		try {
			Usuario previsto = new Usuario("Nicolas", "Quintana Marin", "nicoqm", "nico@gmail.com", "12355",
					"2000-04-25", "Modificado");
			Usuario login = Usuario.inicioSesion("nico@gmail.com", "12355");

			assertEquals(previsto, login);

		} catch (Excepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	void testContrasenaError() {
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("nopass");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();

		assertEquals("Error, contraseña incorrecta", v.getIniciarSesion().getError().getText());
	}

	@Test
	void testRegistrarse() {
		v.getIniciarSesion().getBotonRegistrarse().doClick();
		assertTrue(v.getEditarPerfil().isVisible());
	}

	@Test
	void testTodoBien() {
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("12355");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();

		assertTrue(v.getPanelPrincipal().isVisible());
	}
}