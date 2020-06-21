package TestsIteracion3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;

class TestSolicitudes {
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
		v.getPanelPrincipal().getBotones().getSolicitudes().doClick();
	}
	
	@Test
	void testBotonSolicitudes() {
		assertTrue(v.getSolicitudesVista().isVisible());
	}
	
	@Test
	void testFechaIniMayorFechaFin() {
		HabitacionVista hv = v.getGeneral().getLista().getLista().get(0);
		hv.getIniAlq().setText("2000-01-02");
		hv.getFinAlq().setText("2000-01-01");
		hv.getSolicitar().doClick();
		assertEquals("Fechas no validas",hv.errorVal().getText());
	}
	
	@Test
	void testFormatoErroneo() {
		HabitacionVista hv = v.getGeneral().getLista().getLista().get(0);
		hv.getIniAlq().setText("2000-01-02");
		hv.getFinAlq().setText("2000-01-01");
		hv.getSolicitar().doClick();
		assertEquals("Fechas no validas",hv.errorVal().getText());
	}
	
	

}
