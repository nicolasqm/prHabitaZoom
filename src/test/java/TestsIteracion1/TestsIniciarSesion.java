package TestsIteracion1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.CtrInicioSesion;
import Controlador.CtrRegistrarse;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.Vista;

class TestsIniciarSesion {
	
	private Vista v;
	private Usuario u;
	private CtrRegistrarse registrarse;
	private CtrInicioSesion inicio;
	
	@BeforeEach
	void init () {
		v = new Vista();
		u = null;
		
		registrarse = new CtrRegistrarse(v,u);
		inicio = new CtrInicioSesion(u,v,registrarse);
	}
	
	@Test
	void testNoUsuario () {
		v.getIniciarSesion().getTextoUsuario().setText("nouser");
		v.getIniciarSesion().getTextoContrasena().setText("nopass");
		
		v.getIniciarSesion().getBotonIniciarSesion().doClick();
		
		assertEquals("Error, no existe ese usuario", v.getIniciarSesion().getError().getText());
	}
	
	@Test
	void testUsuario () {
		try {
			Usuario previsto = new Usuario("Nicolas", "Quintana", "nicoqm", "nico@gmail.com", "12355", "2012-12-12","Modificado");
			Usuario login = Usuario.inicioSesion("nico@gmail.com", "12355");
			
			assertEquals(previsto, login);
			
		} catch (Excepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testContrasenaError () {
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("nopass");
		
		v.getIniciarSesion().getBotonIniciarSesion().doClick();
		
		assertEquals("Error, contraseña incorrecta", v.getIniciarSesion().getError().getText());
	}
	
	@Test
	void testRegistrarse () {
		v.getIniciarSesion().getBotonRegistrarse().doClick();
		assertTrue(v.getEditarPerfil().isVisible());
	}
	
	@Test
	void testTodoBien () {
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("12355");
		
		v.getIniciarSesion().getBotonIniciarSesion().doClick();
		
		assertTrue(v.getPanelPrincipal().isVisible());
	}
	

}
