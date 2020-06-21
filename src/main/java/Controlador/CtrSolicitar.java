package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Excepcion;
import Modelo.Solicitud;
import Modelo.Usuario;
import Vista.HabitacionVista;
import Vista.Vista;

public class CtrSolicitar implements ActionListener{
	private Usuario usuario;
	private Vista vista;
	
	public CtrSolicitar(Usuario usuario, Vista vista) {
		this.usuario = usuario;
		this.vista= vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("Solicitar")) {
			HabitacionVista hv = vista.getAnuncioSolicitud();
			String fechaIni = hv.getIniAlq().getText();
			String fechaFin = hv.getFinAlq().getText();
			try {
				if(fechaIni.compareTo(fechaFin)>0) {
					throw new Excepcion("Fechas no validas");
				}
				Solicitud s = new Solicitud(null, fechaIni, fechaFin, false, usuario, hv.getAnuncio()); 
				AccesoBD.getInstance().enviarSolicitud(s);
			} catch (Excepcion e1) {
				// TODO Auto-generated catch block
				hv.errorVal().setText(e1.getMessage());
			}
		}
	}

}
