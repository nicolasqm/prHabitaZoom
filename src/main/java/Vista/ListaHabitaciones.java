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
	private ActionListener controladorFavorito;
	private ActionListener controladorValoracion;
	private int width;
	private int height;
	private ActionListener controladorSolicitud;

	public ListaHabitaciones() {
		listaHabitacionVistas = new ArrayList<HabitacionVista>();
		panel = new JPanel();

		filas = 6;
		nHabitaciones = 0;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());
		this.setViewportView(panel);

		width = panel.getWidth();
		height = panel.getHeight();
	}

	public ArrayList<HabitacionVista> getLista() {
		return listaHabitacionVistas;
	}

	public void anadirHabitacion(Anuncio anuncio) {
		HabitacionVista h = new HabitacionVista(anuncio);
		h.getBotonFavorito().addActionListener(controladorFavorito);
		h.getEnviar().addActionListener(controladorValoracion);
		h.getSolicitar().addActionListener(controladorSolicitud);
		listaHabitacionVistas.add(h);
		nHabitaciones++;
		if (nHabitaciones > filas ) {
			panel.setLayout(new GridLayout(nHabitaciones, 0, 0, 0));
			Dimension dim = panel.getSize();
			panel.setPreferredSize(new Dimension(dim.width, dim.height + 400));
		}
		if (nHabitaciones != 1) {
			listaHabitacionVistas.get(nHabitaciones - 2).getSeparator().setVisible(true);
		}
		panel.add(h);
	}

	public void borrarTodasLasHabitaciones() {
		panel.setSize(new Dimension(width, height));
		panel.setLayout(new GridLayout(6, 0, 0, 0));
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
		while (pos < listaHabitacionVistas.size() && anuncio == null) {
			auxiiar = listaHabitacionVistas.get(pos);
			if (auxiiar.getBotonFavorito().isSelected() && !anunciosYaFavoritos.contains(auxiiar.getAnuncio())) {
				anuncio = auxiiar.getAnuncio();
				auxiiar.getBotonFavorito().setVisible(false);
				auxiiar.getBotonFavorito().setSelected(false);
			} else {
				pos++;
			}

		}
		return anuncio;
	}

	public void setActionListeners(ActionListener l, ActionListener v, ActionListener s) {
		controladorFavorito = l;
		controladorValoracion = v;
		controladorSolicitud = s;
	}

	public void desactivarBotonesFavoritos(List<Anuncio> anuciosFavoritos) {
		for (int pos = 0; pos < listaHabitacionVistas.size(); pos++) {
			if (anuciosFavoritos.contains(listaHabitacionVistas.get(pos).getAnuncio())) {
				listaHabitacionVistas.get(pos).getBotonFavorito().setSelected(false);
				listaHabitacionVistas.get(pos).getBotonFavorito().setVisible(false);
			}
		}
	}

	public void activarBotonFavorito(Anuncio anuncio) {
		int pos = 0;
		while (pos < listaHabitacionVistas.size() && !anuncio.equals(listaHabitacionVistas.get(pos).getAnuncio())) {
			pos++;
		}
		listaHabitacionVistas.get(pos).getBotonFavorito().setVisible(true);
	}

	public HabitacionVista buscarValoracion() {
		int i = 0;
		boolean p = false;
		while (i < listaHabitacionVistas.size() && (!p)) {
			if (listaHabitacionVistas.get(i).getEnviar().isSelected()) {
				listaHabitacionVistas.get(i).getEnviar().setSelected(false);
				p = true;
			}
			i++;
		}

		return listaHabitacionVistas.get(i - 1);
	}
	
	public HabitacionVista buscarHabitacionSolicitada() {
		int i = 0;
		boolean p = false;
		while (i < listaHabitacionVistas.size() && (!p)) {
			if (listaHabitacionVistas.get(i).getSolicitar().isSelected()) {
				listaHabitacionVistas.get(i).getSolicitar().setSelected(false);
				p = true;
			}
			i++;
		}
		return listaHabitacionVistas.get(i-1);
	}

}
