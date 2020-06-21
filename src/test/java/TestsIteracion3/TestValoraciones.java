package TestsIteracion3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;

class TestValoraciones {
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
	void testValoracionHechaAntes() {
		HabitacionVista hv = v.getGeneral().getLista().getLista().get(0);
		hv.getEnviar().doClick();
		assertEquals("El anuncio ya ha sido valorado",hv.errorVal().getText());
	}

}
