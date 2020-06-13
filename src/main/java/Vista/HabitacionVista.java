package Vista;

import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Usuario;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HabitacionVista extends JPanel {

	private JPanel auxiliar;
	private JLabel direccion;
	private JLabel numero;
	private JLabel planta;
	private JLabel puerta;
	private JSeparator separator;
	private JLabel distrito;
	private JPanel panel;
	private JLabel valoracion;
	private JComboBox<Integer> cvaloracion;
	private JLabel valoracionMedia;
	private JToggleButton anadirFavorito;
	private boolean favoritos;
	private Anuncio anuncio;
	private JLabel cvaloracionMedia;
	private JToggleButton enviar;
	private JLabel errorvalorado;

	public HabitacionVista(Anuncio anuncio,boolean favoritos){
		setLayout(new BorderLayout(0, 0));
		this.favoritos=favoritos;
		this.anuncio = anuncio;

		separator = new JSeparator();
		add(separator, BorderLayout.SOUTH);
		separator.setVisible(false);

		this.favoritos=favoritos;
            										
		auxiliar = new JPanel();
		add(auxiliar, BorderLayout.WEST);
		auxiliar.setLayout(new GridLayout(0, 1, 0, 0));

		direccion = new JLabel("Direccion: " + anuncio.getHabitacion().getDireccion());
		direccion.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(direccion);

		numero = new JLabel("Numero: " + anuncio.getHabitacion().getNumero());
		numero.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(numero);

		planta = new JLabel("Planta: " + anuncio.getHabitacion().getPlanta());
		planta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		distrito = new JLabel("Distrito: " + anuncio.getHabitacion().getDistrito().getNombre());
		distrito.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(planta);
		auxiliar.add(distrito);

		puerta = new JLabel("Puerta: " + anuncio.getHabitacion().getPuerta());
		puerta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		auxiliar.add(puerta);
		if(!favoritos) {
			anadirFavorito = new JToggleButton("Favorito");
			add(anadirFavorito, BorderLayout.EAST);
		}

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		valoracion = new JLabel("Valoración:");
		valoracion.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		panel.add(valoracion);
		
		Vector<Integer> valor = new Vector<>();
		for(int i=0;i<6;i++) {
			valor.add( i);
		}
		cvaloracion = new JComboBox<Integer>(valor) ;
		cvaloracion.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		panel.add(cvaloracion);
		
		enviar = new JToggleButton("Enviar");
		panel.add(enviar);
		
		try {
			valoracionMedia = new JLabel("Valoración media: "+AccesoBD.getInstance().obtenerMediaHabitacion(anuncio.getHabitacion()));
			valoracionMedia.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
			panel.add(valoracionMedia);
		}catch(Excepcion e) {
			e.printStackTrace();
		}
		
		
		
		errorvalorado = new JLabel();
		errorvalorado.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		panel.add(errorvalorado);
		/*
		cvaloracionMedia = new JLabel("0.0");
		cvaloracionMedia.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		panel.add(cvaloracionMedia);
		*/
		
		
	}
	public void setValoracion(double d) {
		valoracionMedia.setText("Valoración media: "+d);
	}
	
	
	public int getValoracion(){
		return cvaloracion.getItemAt(cvaloracion.getSelectedIndex());
	}
	
	public JToggleButton getEnviar() {
		return enviar;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setActionListeners(ActionListener l,ActionListener v) {
		anadirFavorito.addActionListener(l);
		enviar.addActionListener(v);
	}
	
	public JLabel errorVal () {
		return errorvalorado;
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