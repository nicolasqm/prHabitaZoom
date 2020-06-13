package Vista;

import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import Modelo.Anuncio;


@SuppressWarnings("serial")
public class prueba extends JPanel {

	private JPanel auxiliar;
	private JLabel direccion;
	private JLabel numero;
	private JLabel planta;
	private JLabel puerta;
	private JSeparator separator;
	private JLabel distrito;
	private JToggleButton anadirFavorito;
	private boolean favoritos;
	private Anuncio anuncio;

	public prueba(Anuncio anuncio,boolean favoritos) {
		this.anuncio = anuncio;
		this.favoritos = favoritos;
		setLayout(new BorderLayout(0, 0));
		auxiliar = new JPanel();
		add(auxiliar, BorderLayout.CENTER);
		auxiliar.setLayout(new GridLayout(5, 0, 0, 0));

		direccion = new JLabel("Direccion: " + anuncio.getHabitacion().getDireccion());
		direccion.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(direccion);

		numero = new JLabel("Numero: " + anuncio.getHabitacion().getNumero());
		numero.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(numero);

		JPanel prueba = new JPanel();
		prueba.setLayout(new BorderLayout(0,0));
		planta = new JLabel("Planta: " + anuncio.getHabitacion().getPlanta());
		planta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		prueba.add(planta, BorderLayout.WEST);
		
		anadirFavorito = new JToggleButton("Favorito");
		prueba.add(anadirFavorito, BorderLayout.EAST);
			
		distrito = new JLabel("Distrito: " + anuncio.getHabitacion().getDistrito().getNombre());
		distrito.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(prueba);
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
	
	public void setActionListeners(ActionListener l) {
		anadirFavorito.addActionListener(l);
	}
	
	public JToggleButton getBotonFavoritos() {
		return anadirFavorito;
	}
	
	public boolean estaEnFavoritos() {
		return favoritos;
	}
	public void setFavoritos(boolean p) {
		favoritos = p;
	}

}
