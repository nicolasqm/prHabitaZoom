package TestsIteracion2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.Vista;

class TestPublicarHabitacion {
	private Vista v;
	private Usuario u;
	private Controlador controlador;

	@BeforeEach
	void init() {
		v = new Vista();
		u = new Usuario("", "", "", "", "", "");

		controlador = new Controlador(u, v);
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("12355");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();
		v.getBotonPublicar().doClick();
	}
	@Test
	void testBotonPublicar() {
		assertTrue(v.getPublicarVista().isVisible());
	}
	
	@Test
	void testFaltaCampo() {
		v.getPublicarVista().getBotonAceptar().doClick();
		assertEquals("Error, faltan datos", v.getPublicarVista().getError().getText());
	}

}
