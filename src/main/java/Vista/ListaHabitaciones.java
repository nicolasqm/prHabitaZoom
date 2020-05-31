package Vista;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.AccesoBD;
import Modelo.Anuncio;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class ListaHabitaciones extends JScrollPane {
	private ArrayList<HabitacionVista> listaHabitacionVistas;
	private int filas;
	private int nHabitaciones;
	private JPanel panel;

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
	
	public ArrayList<HabitacionVista> getLista(){
		return listaHabitacionVistas;
	}
		
	public void anadirHabitacion(Anuncio anuncio) {
		HabitacionVista h = new HabitacionVista(anuncio);
		listaHabitacionVistas.add(h);
		nHabitaciones++;
		if(nHabitaciones == filas+1) {
			filas = filas+1;
			panel.setLayout(new GridLayout(filas,0,0,0));
			Dimension dim = panel.getSize();
			panel.setPreferredSize(new Dimension(dim.width, dim.height+400));
		}
		if(nHabitaciones != 1) {
			listaHabitacionVistas.get(nHabitaciones-2).getSeparator().setVisible(true);
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
		for(int pos = 0; pos<lista.size(); pos++) {
			anadirHabitacion(lista.get(pos));
		}
	}

}
