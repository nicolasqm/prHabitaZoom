package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class ListaFavoritos extends JScrollPane {
	private ArrayList<VistaHabitacionFavoritos> listaHabitacionVistas;
	private int filas;
	private int nHabitaciones;
	private JPanel panel;
	private ActionListener controlador;
	
	public ListaFavoritos() {
		listaHabitacionVistas = new ArrayList<>();
		panel = new JPanel();

		filas = 6;
		nHabitaciones = 0;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());
		this.setViewportView(panel);

	}

	public ArrayList<VistaHabitacionFavoritos> getLista() {
		return listaHabitacionVistas;
	}

	public void anadirHabitacion(Anuncio anuncio) {
		VistaHabitacionFavoritos h = new VistaHabitacionFavoritos(anuncio);
		h.botonQuitar().addActionListener(controlador);
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
	
	public void anadirAnucios(List<Anuncio> anuncios) {
		for(int pos = 0; pos<anuncios.size(); pos++) {
			anadirHabitacion(anuncios.get(pos));
		}
	}
	
	public Anuncio buscarFavoritoSeleccionado(Usuario usuario) throws Excepcion {
		int pos = 0;
		Anuncio anuncio = null;
		VistaHabitacionFavoritos auxiiar = null;
		while(pos<listaHabitacionVistas.size() && anuncio == null) {
			auxiiar = listaHabitacionVistas.get(pos);
			if(auxiiar.botonQuitar().isSelected()) {
				anuncio = auxiiar.getAnuncio();
				auxiiar.setVisible(false);
				borrarAnuncioFavorito(auxiiar);
			}else {
				pos++;
			}	
			
		}		
		return anuncio;
	}
	
	public void borrarAnuncioFavorito(VistaHabitacionFavoritos v) {
		panel.remove(v);
		nHabitaciones--;
		listaHabitacionVistas.remove(v);
	}
	
	public void borrarHabitacionesFavoritas() {
		panel.removeAll();
		listaHabitacionVistas.clear();
		nHabitaciones = 0;
		filas = 6;
	}
	
	
	public void setActionListeners(ActionListener l) {
		controlador = l;
	}

}
