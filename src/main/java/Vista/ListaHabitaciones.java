package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.CompoundControl;
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
	private ActionListener controlador;

	public ListaHabitaciones() {
		listaHabitacionVistas = new ArrayList<HabitacionVista>();
		panel = new JPanel();

		filas = 6;
		nHabitaciones = 0;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());
		List<Anuncio> lista = AccesoBD.getInstance().getAnuncios();
		anadirListaAnuncios(lista);
		this.setViewportView(panel);

	}

	public ArrayList<HabitacionVista> getLista() {
		return listaHabitacionVistas;
	}

	public void anadirHabitacion(Anuncio anuncio) {
		HabitacionVista h = new HabitacionVista(anuncio);
		if(controlador != null) {
			h.getBotonFavoritos().addActionListener(controlador);	
		}
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
	
	public Anuncio buscarAnuncioSeleccionado(Usuario usuario) throws Excepcion {
		List<Anuncio> anunciosYaFavoritos = AccesoBD.getInstance().getFavoritos(usuario);
		int pos = 0;
		Anuncio anuncio = null;
		HabitacionVista auxiiar = null;
		while(pos<listaHabitacionVistas.size() && anuncio == null) {
			auxiiar = listaHabitacionVistas.get(pos);
			if(auxiiar.getBotonFavoritos().isSelected() && !anunciosYaFavoritos.contains(auxiiar.getAnuncio())) {
				anuncio = auxiiar.getAnuncio();
				auxiiar.getBotonFavoritos().setVisible(false);
				auxiiar.getBotonFavoritos().setSelected(false);
			}else {
				pos++;
			}	
			
		}		
		return anuncio;
	}
	
	public void setActionListeners(ActionListener l) {
		controlador = l;
		for(int pos = 0; pos<listaHabitacionVistas.size(); pos++) {
			listaHabitacionVistas.get(pos).getBotonFavoritos().addActionListener(l);
		}
	}
	
	public void desactivarBotonesFavoritos(List<Anuncio> anuciosFavoritos) {
		for(int pos = 0; pos<listaHabitacionVistas.size(); pos++) {
			if(anuciosFavoritos.contains(listaHabitacionVistas.get(pos).getAnuncio())) {
				listaHabitacionVistas.get(pos).getBotonFavoritos().setSelected(false);
				listaHabitacionVistas.get(pos).getBotonFavoritos().setVisible(false);
			}
		}
	}
	
	public void activarBotonFavorito(Anuncio anuncio) {
		int pos = 0;
		while(pos<listaHabitacionVistas.size() && !anuncio.equals(listaHabitacionVistas.get(pos).getAnuncio())) {
			pos++;
		}
		listaHabitacionVistas.get(pos).getBotonFavoritos().setVisible(true);
	}

}
