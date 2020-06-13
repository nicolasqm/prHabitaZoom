package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;

public class CtrValoraciones implements ActionListener{

	private Vista vista;
	private Usuario usuario;
	
	public CtrValoraciones(Vista v,Usuario u) {
		vista = v;
		usuario = u;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		HabitacionVista hab = vista.getAnuncioValoracion();
		
		if(comando.equals("Enviar")) {
			try {
				AccesoBD accesobd = AccesoBD.getInstance();
				
				accesobd.anadirValoracion(usuario,hab.getAnuncio().getHabitacion(),hab.getValoracion(),null);
				hab.setValoracion(AccesoBD.getInstance().obtenerMediaHabitacion(hab.getAnuncio().getHabitacion()));
				
			}catch(Excepcion o) {
				//o.printStackTrace();
				hab.errorVal().setText("El anuncio ya ha sido valorado");
			}
			
		}
		
		
		
		
	}
	
	
	
}
