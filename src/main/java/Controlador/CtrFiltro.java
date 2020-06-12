package Controlador;

import java.util.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Distrito;
import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.General;
import Vista.Vista;
import Vista.VistaFiltro;

public class CtrFiltro implements ActionListener{

	Vista vista;
	General general;
	VistaFiltro filtro;
	Usuario usuario;
	
	public CtrFiltro(Vista v, Usuario u) {
		vista=v;
		usuario = u;
	}
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("Cancelar")) {

			vista.getVistaFiltro().getError().setText("");
			vista.getVistaFiltro().setVisible(false);
			vista.getGeneral().setVisible(true);
			vista.getPublicarVista().setVisible(false);
			vista.getMostrarPerfil().setVisible(false);
		}else if(comando.equals("Buscar")) {
			//hacer procedimiento
			try {
			AccesoBD accesobd = AccesoBD.getInstance();
			
			double PrecioMin;
			double PrecioMax;
			Distrito dist;
			if (vista.getDistrito().getItemAt(vista.getPanelPrincipal().getVistaFiltro().getDistrito().getSelectedIndex()).equals("")) {
				dist = null;
			} else {
				dist = accesobd.buscarDistrito(vista.getDistrito().getItemAt(vista.getPanelPrincipal().getVistaFiltro().getDistrito().getSelectedIndex()));
			}
			
			
			
			if(vista.getPrecioMin().getText().equals("")) {
				PrecioMin=0;
			}else {
				PrecioMin = Double.parseDouble(vista.getPrecioMin().getText());
			}
			if(vista.getPrecioMax().getText().equals("")) {
				PrecioMax=Double.MAX_VALUE;
			}else {
				PrecioMax = Double.parseDouble(vista.getPrecioMax().getText());
			}
			if(PrecioMax < PrecioMin) {
				throw new Excepcion("precios mal puestos");
			}
			
			boolean parking = vista.getParking().isSelected();
			boolean terraza = vista.getTerraza().isSelected();
			boolean wifi = vista.getWifi().isSelected();
			boolean fumadores = vista.getFumador().isSelected();
			boolean mascotas = vista.getMascota().isSelected();
			boolean estudiantes = vista.getSoloEstudiantes().isSelected();
			boolean gastos = vista.getGastosIncluidos().isSelected();
			
			
			
			
			
			
			List<Anuncio> anuncio= accesobd.filtrar(dist, PrecioMin, PrecioMax, parking, terraza, wifi, fumadores, mascotas, estudiantes, gastos);
			
			
			vista.getPanelPrincipal().getGeneral().getLista().borrarTodasLasHabitaciones();
			vista.getPanelPrincipal().getGeneral().getLista().anadirListaAnuncios(anuncio);
			
			
			vista.getVistaFiltro().getError().setText("");
			vista.getVistaFiltro().setVisible(false);
			vista.getGeneral().setVisible(true);
			vista.getPublicarVista().setVisible(false);
			vista.getMostrarPerfil().setVisible(false);
		
			vista.quitarBotonesFavoritos(AccesoBD.getInstance().getFavoritos(usuario));
			
			
		}catch (NumberFormatException et) {
			vista.setErrorFiltrar("formato no valido");
		}catch(Excepcion et2) {
			vista.setErrorFiltrar(et2.getMessage());
		}
		}
	}
	
}
