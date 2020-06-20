package TestsIteracion2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.Vista;

class TestFiltrar {
	private Vista v;
	private Usuario u;

	@BeforeEach
	void init() {
		v = new Vista();
		u = new Usuario("", "", "", "", "", "");

		new Controlador(u, v);
		v.getIniciarSesion().getTextoUsuario().setText("nico@gmail.com");
		v.getIniciarSesion().getTextoContrasena().setText("12355");

		v.getIniciarSesion().getBotonIniciarSesion().doClick();
		v.getGeneral().getBotonFiltro().doClick();
	}

	@Test
	void testPulsarFiltro() {
		assertTrue(v.getVistaFiltro().isVisible());
	}

	@Test
	void testFormatoErroneoPrecioMin() {
		v.getVistaFiltro().getPrecioMin().setText("adios");
		v.getVistaFiltro().getBuscar().doClick();
		assertEquals("Error, formato no valido", v.getVistaFiltro().getError().getText());
	}

	@Test
	void testFormatoErroneoPrecioMax() {
		v.getVistaFiltro().getPrecioMax().setText("adios");
		v.getVistaFiltro().getBuscar().doClick();
		assertEquals("Error, formato no valido", v.getVistaFiltro().getError().getText());
	}

	@Test
	void testPrecioMaxMininvalido() {
		v.getVistaFiltro().getPrecioMax().setText("1");
		v.getVistaFiltro().getPrecioMin().setText("2");
		v.getVistaFiltro().getBuscar().doClick();
		assertEquals("Error, precios mal puestos", v.getVistaFiltro().getError().getText());
	}

}
