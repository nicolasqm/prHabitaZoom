package Vista;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IniciarSesion extends JPanel {

	private JPanel panelLogo;
	private JLabel logoLabel;
	
	private JPanel panelUsuario;
	private JTextField dondeEscribeUsuario;
	private JLabel textoUsuario;
	
	private JPanel panelContrasena;
	private JPasswordField dondeEscribeContrasena;
	private JLabel textoContrasena;
	
	
	
	private JPanel panelBotonUsuario;
	private JButton buttonInicioSesion;
	private JLabel mensajeError;
	
	
	private JPanel panelBotonRegistrarse;
	private JLabel labelRegistrarse;
	private JButton buttonRegistrarse;
	
	
	public IniciarSesion() {
		setLayout(new GridLayout(5, 1, 0, 0));

		
		setLogo("src/main/resources/HabitaZoomLogo.jpeg");
		add(panelLogo);
		
		setPanelUsuario();
		add(panelUsuario);
		
		setPanelContrasena();
		add(panelContrasena);

		setBotonIniciarSesion();
		add(panelBotonUsuario);
		
		setBotonRegistrarse();
		add(panelBotonRegistrarse);
		
		
	}
	private void setPanelUsuario() {
		panelUsuario = new JPanel();
		textoUsuario = new JLabel("Usuario: ");
		textoUsuario.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		panelUsuario.add(textoUsuario);
		
		dondeEscribeUsuario = new JTextField();
		
		panelUsuario.add(dondeEscribeUsuario);
		dondeEscribeUsuario.setFont(new Font(Font.DIALOG,Font.ROMAN_BASELINE,20));
		dondeEscribeUsuario.setColumns(20);
	}
	
	private void setPanelContrasena() {
		panelContrasena = new JPanel();
		textoContrasena = new JLabel("Contraseña: ");
		textoContrasena.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		panelContrasena.add(textoContrasena);
		
		dondeEscribeContrasena = new JPasswordField();
		
		panelContrasena.add(dondeEscribeContrasena);
		dondeEscribeContrasena.setFont(new Font(Font.DIALOG,Font.ROMAN_BASELINE,20));
		dondeEscribeContrasena.setColumns(20);
	}

	private void setBotonIniciarSesion() {
		panelBotonUsuario = new JPanel();
		
		buttonInicioSesion = new JButton("Iniciar Sesion");
		buttonInicioSesion.setPreferredSize(new Dimension (250,25));
		buttonInicioSesion.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		panelBotonUsuario.add(buttonInicioSesion);
		
		mensajeError = new JLabel();
		panelBotonUsuario.add(mensajeError);
		mensajeError.setFont(new Font(Font.DIALOG,Font.BOLD,13));
		
		
	}
	
	private void setBotonRegistrarse() {
		panelBotonRegistrarse = new JPanel();
		
		labelRegistrarse = new JLabel("¿Todavía no estas registrado?");
		labelRegistrarse.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		panelBotonRegistrarse.add(labelRegistrarse);
		
		buttonRegistrarse = new JButton("Registrarse");
		buttonRegistrarse.setPreferredSize(new Dimension (250,25));
		buttonRegistrarse.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		panelBotonRegistrarse.add(buttonRegistrarse);
	}
	
	private void setLogo(String path) {
		panelLogo = new JPanel();
		panelLogo.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(path));
		panelLogo.add(logoLabel);
	}
	
	public JTextField getTextoUsuario() {
		return dondeEscribeUsuario;
	}
	public JTextField getTextoContrasena() {
		return dondeEscribeContrasena;
	}
	
	public JButton getBotonIniciarSesion() {
		return buttonInicioSesion;
	}
	
	public JButton getBotonRegistrarse() {
		return buttonRegistrarse;
	}
	
	public JLabel getError () {
		return mensajeError;
	}
	
	public void setMensajeError(String txt) {
		this.mensajeError.setText("Error, " + txt);
	}
	
	public void borrarMensaejError() {
		this.mensajeError.setText("");
	}
	
	
	
	public void setActionListeners(ActionListener l) {
		this.getBotonIniciarSesion().addActionListener(l);
		this.getBotonRegistrarse().addActionListener(l);
	}
	
	

}
