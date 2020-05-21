package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JSeparator;

import Modelo.Habitacion;

public class HabitacionVista extends JPanel {

	private Habitacion habitacion;
	private JPanel auxiliar;
	private JLabel direccion;
	private JLabel foto;
	private JLabel numero;
	private JLabel planta;
	private JLabel puerta;
	private JSeparator separator;
	
	
	
	
	public HabitacionVista(Habitacion habi) {
		setLayout(new BorderLayout(0, 0));
		habitacion = habi;
		foto = new JLabel("Foto");
		add(foto, BorderLayout.WEST);
		
		auxiliar = new JPanel();
		add(auxiliar, BorderLayout.CENTER);
		auxiliar.setLayout(new GridLayout(4, 0, 0, 0));
		
		
		direccion = new JLabel("Direccion: "+habitacion.getDireccion());
		direccion.setFont(new Font(Font.DIALOG,Font.BOLD,13));
		auxiliar.add(direccion);
		
		numero = new JLabel("Numero: "+habitacion.getNumero());
		numero.setFont(new Font(Font.DIALOG,Font.BOLD,13));
		auxiliar.add(numero);
		
		planta = new JLabel("Planta: "+habitacion.getPlanta());
		planta.setFont(new Font(Font.DIALOG,Font.BOLD,13));
		auxiliar.add(planta);
		
		puerta = new JLabel("Puerta: "+habitacion.getPuerta());
		puerta.setFont(new Font(Font.DIALOG,Font.BOLD,13));
		auxiliar.add(puerta);
		
		separator = new JSeparator();
		add(separator, BorderLayout.SOUTH);
		separator.setVisible(false);

	}
	
	public JSeparator getSeparator() {
		return separator;
	}

}
