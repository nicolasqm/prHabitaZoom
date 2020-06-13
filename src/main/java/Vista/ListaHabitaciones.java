package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class ListaHabitaciones extends JScrollPane {
	private ArrayList<HabitacionVista> listaHabitacionVistas;
	private int filas;
	private int nHabitaciones;
	private JPanel panel;
	private boolean favoritos;
	private int sancho;
	private int panza;

	public ListaHabitaciones(boolean favoritos) {
		listaHabitacionVistas = new ArrayList<HabitacionVista>();
		panel = new JPanel();
		this.favoritos = favoritos;
		filas = 6;
		nHabitaciones = 0;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());
		List<Anuncio> lista = null;
		if(!favoritos) {
			lista = AccesoBD.getInstance().getAnuncios();
		}else {
		//	lista = AccesoBD.getInstance().getAnuncios();
			lista = new ArrayList<Anuncio>();
		//	lista = AccesoBD.getInstance().getFavoritos(usuario);
		}
		anadirListaAnuncios(lista);
		this.setViewportView(panel);
		
		

		sancho = panel.getWidth();
		panza = panel.getHeight();
	}

	public ArrayList<HabitacionVista> getLista() {
		return listaHabitacionVistas;
	}

	public void anadirHabitacion(Anuncio anuncio) {
		HabitacionVista h = new HabitacionVista(anuncio,favoritos);
		listaHabitacionVistas.add(h);
		nHabitaciones++;
		if (nHabitaciones == filas + 1) {
			filas = filas + 1;
			panel.setLayout(new GridLayout(filas, 0, 0, 0));
			Dimension dim = panel.getSize();
			panel.setPreferredSize(new Dimension(dim.width, dim.height + 400));
		}
		if (nHabitaciones != 1) {
			listaHabitacionVistas.get(nHabitaciones - 2).getSeparator().setVisible(true);
		}
		panel.add(h);
	}

	public void borrarTodasLasHabitaciones() {
		panel.setSize(new Dimension(sancho,panza));
		panel.setLayout(new GridLayout(6,0,0,0));
		panel.removeAll();
		listaHabitacionVistas.clear();
		nHabitaciones = 0;
		filas = 6;
	}

	public void anadirListaAnuncios(List<Anuncio> lista) {
		for (int pos = 0; pos < lista.size(); pos++) {
			anadirHabitacion(lista.get(pos));
		}
	}
	
	public Anuncio buscarHabitacion() {
		int pos = 0;
		boolean parar = false;
		while(!parar) {
			if(listaHabitacionVistas.get(pos).getBotonFavoritos().isSelected()) {
				if(listaHabitacionVistas.get(pos).estaEnFavoritos()) {
					pos++;
				}else {
					parar = true;
				}
			}else {
				pos++;
			}
		}
		listaHabitacionVistas.get(pos).setFavoritos(true);
		listaHabitacionVistas.get(pos).getBotonFavoritos().setSelected(false);
		listaHabitacionVistas.get(pos).getBotonFavoritos().setVisible(false);
		return listaHabitacionVistas.get(pos).getAnuncio();
	}
	
	public void setActionListeners(ActionListener favoritos,ActionListener valoracion) {
		for (int pos = 0; pos < listaHabitacionVistas.size(); pos++) {
			listaHabitacionVistas.get(pos).setActionListeners(favoritos,valoracion);
			
		}
	}
	
	public HabitacionVista buscarValoracion () {
		int i=0;
		boolean p=false;
		while(i<listaHabitacionVistas.size() && (!p)) {
			if(listaHabitacionVistas.get(i).getEnviar().isSelected()) {
				listaHabitacionVistas.get(i).getEnviar().setSelected(false);
				p=true;
			}
			i++;
		}
		
		return listaHabitacionVistas.get(i-1);
	}

}
