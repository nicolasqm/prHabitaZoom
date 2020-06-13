package Vista;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class General extends JPanel {

	private JPanel panelSecundario;
	private JLabel general;
	private JButton filtros;
	private ListaHabitaciones listaHabitaciones;

	public General() {
		setLayout(new BorderLayout(0, 0));

		panelSecundario = new JPanel();
		add(panelSecundario, BorderLayout.NORTH);
		panelSecundario.setLayout(new GridLayout(0, 2, 0, 0));

		general = new JLabel("General: ");
		general.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		panelSecundario.add(general);

		filtros = new JButton("Filtro");
		filtros.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		panelSecundario.add(filtros);

		listaHabitaciones = new ListaHabitaciones(false);
		add(listaHabitaciones, BorderLayout.CENTER);

		listaHabitaciones.setVisible(true);

	}

	public JButton getBotonFiltro() {
		return filtros;
	}

	public ListaHabitaciones getLista() {
		return listaHabitaciones;
	}

	public void setActionListeners(ActionListener l,ActionListener favoritos,ActionListener valoracion) {
		filtros.addActionListener(l);
		listaHabitaciones.setActionListeners(favoritos,valoracion);
		
	}

}
