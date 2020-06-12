package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import org.objenesis.instantiator.basic.NewInstanceInstantiator;

import Modelo.Anuncio;

@SuppressWarnings("serial")
public class VistaHabitacionFavoritos extends JPanel {

	private JPanel auxiliar;
	private JLabel direccion;
	private JLabel numero;
	private JLabel planta;
	private JLabel puerta;
	private JSeparator separator;
	private JLabel distrito;
	private JToggleButton quitarFavorito;
	private Anuncio anuncio;

	public VistaHabitacionFavoritos(Anuncio anuncio) {
		setLayout(new BorderLayout(0, 0));
		this.anuncio = anuncio;
		auxiliar = new JPanel();
		add(auxiliar, BorderLayout.CENTER);
		auxiliar.setLayout(new GridLayout(5, 0, 0, 0));

		direccion = new JLabel("Direccion: " + anuncio.getHabitacion().getDireccion());
		direccion.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(direccion);

		numero = new JLabel("Numero: " + anuncio.getHabitacion().getNumero());
		numero.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(numero);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		planta = new JLabel("Planta: " + anuncio.getHabitacion().getPlanta());
		planta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		panel.add(planta,BorderLayout.WEST);
		quitarFavorito = new JToggleButton("Quitar");
		panel.add(quitarFavorito,BorderLayout.EAST);
		distrito = new JLabel("Distrito: " + anuncio.getHabitacion().getDistrito().getNombre());
		distrito.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(panel);
		auxiliar.add(distrito);

		puerta = new JLabel("Puerta: " + anuncio.getHabitacion().getPuerta());
		puerta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(puerta);

		separator = new JSeparator();
		add(separator, BorderLayout.SOUTH);
		separator.setVisible(false);

	}

	public JSeparator getSeparator() {
		return separator;
	}
	
	public Anuncio getAnuncio() {
		return anuncio;
	}
	
	public JToggleButton botonQuitar() {
		return quitarFavorito;
	}

}
