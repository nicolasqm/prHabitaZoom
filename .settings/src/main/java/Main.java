import Controlador.Controlador;
import Modelo.Usuario;
import Vista.Vista;

public class Main {
	public static void main(String[] args) {
		Usuario usuario = null;
		Vista vista = new Vista();
		Controlador controlador = new Controlador(usuario, vista);
		
		vista.setVisible(true);
	}
}