package TestsIteracion3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;
import Vista.VistaHabitacionFavoritos;

class TestFavoritos {
	private Vista v;
	private Usuario u;

	@BeforeEach
	void init() {
		v = new Vista();
		u = new Usuario("", "", "", "", "", "");
		new Controlador(u, v);
		v.getIniciarSesion().getTextoUsuario().setText("Test");
		v.getIniciarSesion().getTextoContrasena().setText("1234");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();
	}
	
	@Test
	void testBotonFavoritos() {
		v.getPanelPrincipal().getBotones().getFavoritos().doClick();
		assertTrue(v.getVistaFavoritos().isVisible());
	}
	
	@Test 
	void testAll() {
		HabitacionVista hv = v.getGeneral().getLista().getLista().get(0);
		hv.getBotonFavorito().doClick();
		v.getPanelPrincipal().getBotones().getFavoritos().doClick();
		VistaHabitacionFavoritos hvf = v.getVistaFavoritos().getListaFavoritos().getLista().get(0);
		assertEquals(hv.getAnuncio(),hvf.getAnuncio());
		hvf.botonQuitar().doClick();
		v.getPanelPrincipal().getBotones().getGeneral().doClick();
		assertTrue(hv.getBotonFavorito().isVisible());
	}
	
	

}
