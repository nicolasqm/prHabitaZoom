package TestsIteracion2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.Vista;

class TestModificarPerfil {
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
		v.getBotonPerfil().doClick();
	}
	
	@Test
	void testAbrirMostrarPerfil() {
		assertTrue(v.getMostrarPerfil().isVisible());
	}
	
	@Test
	void testAbrirEditarPerfil() {
		v.getMostrarPerfil().getEditarPerfil().doClick();
		assertTrue(v.getModificarPerfil().isVisible());
	}
	
	@Test
	void testContrasenaDistintas() {
		v.getMostrarPerfil().getEditarPerfil().doClick();
		
		v.getModificarPerfil().getContrasena().setText("pass");
		v.getModificarPerfil().getConfirmarContrasena().setText("nopass");
		v.getModificarPerfil().getButton().doClick();
		
		assertEquals("Error, contraseñas no iguales", v.getModificarPerfil().getError().getText());
		
	}
	
	@Test
	void testAliasIguales() {
		v.getMostrarPerfil().getEditarPerfil().doClick();
		
		v.getModificarPerfil().getAlias().setText("Test");
		v.getModificarPerfil().getButton().doClick();
		
		
		assertEquals("Error, no se ha podido modificar el usuario", v.getModificarPerfil().getError().getText());
	}
	
	@Test
	void testFechaNoCorrecta() {
		v.getMostrarPerfil().getEditarPerfil().doClick();
		
		v.getModificarPerfil().getFechaNacimiento().setText("12-2-2000");
		v.getModificarPerfil().getButton().doClick();
		
		assertEquals("Error, no se ha podido modificar el usuario", v.getModificarPerfil().getError().getText());
	}
	


}
