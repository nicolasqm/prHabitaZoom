package Vista;

import java.awt.BorderLayout;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VistaFavoritos extends JPanel{

	private ListaHabitaciones listaHabitaciones;
	
	public VistaFavoritos() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel etiquiteaFavoritos = new JLabel("Favoritos: ");
		etiquiteaFavoritos.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		add(etiquiteaFavoritos,BorderLayout.NORTH);
		
		listaHabitaciones = new ListaHabitaciones(true);
		add(listaHabitaciones, BorderLayout.CENTER);
	}
	
	public ListaHabitaciones getListaFavoritos() {
		return listaHabitaciones;
	}
}
