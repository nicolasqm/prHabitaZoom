package Vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Habitacion;

import java.awt.Dimension;

public class ListaHabitaciones extends JScrollPane {
	private ArrayList<HabitacionVista> lista;
	private int filas;
	private int nHabitaciones;
	private JPanel panel;

	public ListaHabitaciones() {
		lista = new ArrayList<>();
		panel = new JPanel();
		
		filas = 4;
		nHabitaciones = 0;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());
		
		
		
		
		this.setViewportView(panel);
		
	}
	
	public ArrayList<HabitacionVista> getLista(){
		return lista;
	}
		
	public void anadirHabitacion(Habitacion habi) {
		HabitacionVista h = new HabitacionVista(habi);
		lista.add(h);
		nHabitaciones++;
		if(nHabitaciones == filas+1) {
			filas = filas+1;
			panel.setLayout(new GridLayout(filas,0,0,0));
			Dimension dim = panel.getSize();
			panel.setPreferredSize(new Dimension(dim.width, dim.height+400));
		}
		if(nHabitaciones != 1) {
			lista.get(nHabitaciones-2).getSeparator().setVisible(true);
		}
		panel.add(h);
	}

}
