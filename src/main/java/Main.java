import Controlador.CtrInicioSesion;
import Controlador.CtrRegistrarse;
import Modelo.Usuario;
import Vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Usuario u = null;
		
		CtrRegistrarse registrarse = new CtrRegistrarse(vista, u);
		CtrInicioSesion inicioSesion = new CtrInicioSesion(u, vista, registrarse);
		
		vista.setVisible(true);

	}

}
