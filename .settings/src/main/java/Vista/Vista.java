package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.Habitacion;

import java.awt.CardLayout;

public class Vista extends JFrame {
	
	private JPanel panel;
	private PanelPrincipal PanelPrincipal;
	private IniciarSesion IniciarSesion;
	private EditarPerfil registrarse;
	
	public Vista() {
		this.setTitle("HabitaZoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		IniciarSesion = new IniciarSesion();
		PanelPrincipal = new PanelPrincipal();
		registrarse=new EditarPerfil();
		panel.setLayout(new CardLayout(0, 0));
		panel.add(IniciarSesion);
		panel.add(PanelPrincipal);
		panel.add(registrarse);
		setContentPane(panel);
		this.pack();
	}
	
	public IniciarSesion getIniciarSesion() {
		return IniciarSesion;
	}
	
	public PanelPrincipal getPanelPrincipal() {
		return PanelPrincipal;
	}
	
	public EditarPerfil getEditarPerfil() {
		return registrarse;
	}
	
	public void setActionListeners(ActionListener l,ActionListener r) {
		IniciarSesion.setActionListeners(l);
		registrarse.setActionListeners(r);
		PanelPrincipal.setActionListeners(l);
	}
	
	//----------------------------------------------------
	// Aqui empeiza los botones y los texto de InicarUsuario
	//----------------------------------------------------
	public JTextField getTextoUsuarioIniciarSesion() {
		return IniciarSesion.getTextoUsuario();
	}
	
	public JTextField getTextoContrasenaIniciarSesion() {
		return IniciarSesion.getTextoContrasena();
	}
	
	public JButton getBotonIniciarSesion() {
		return IniciarSesion.getBotonIniciarSesion();
	}
	
	public JButton getBotonRegistrarseIniciarSesion() {
		return IniciarSesion.getBotonRegistrarse();
	}
	
	public JLabel getErrorIniciarSesion() {
		return IniciarSesion.getError();
	}
	
	public void setMensajeErrorIniciarSesion(String txt) {
		IniciarSesion.setMensajeError(txt);
	}
	
	public void borrarMensajeErrorIniciarSesion() {
		IniciarSesion.borrarMensaejError();
	}
	//----------------------------------------------------------
	// Aqui empeiza los botones y texto de registrarses
	//--------------------------------------------------------
	
	//---------------------------------------------------------
	//Aqui empieza los botones y texto de panel principal
	//-------------------------------------------------------
	//Primero el panel de botones
	
	public JButton getBotonGeneral() {
		return PanelPrincipal.getBotones().getGeneral();
	}
	
	public JButton getBotonCalendario() {
		return PanelPrincipal.getBotones().getCalendario();
	}
	
	public JButton getBotonPublicar() {
		return PanelPrincipal.getBotones().getPublicar();
	}
	
	public JButton getBotonChat() {
		return PanelPrincipal.getBotones().getChat();
	}
	
	public JButton getBotonPerfil() {
		return PanelPrincipal.getBotones().getPerfil();
	}
	
	// Segundo es el panel del general
	
	public JButton getBotonFiltrar() {
		return PanelPrincipal.getGeneral().getBotonFiltro();
	}
	
	// Tercero es el panel habitaciones que esta contenido en el general
	
	public void anadirHabitacion(Habitacion h) {
		PanelPrincipal.getGeneral().getLista().anadirHabitacion(h);
	}
	//---------------------------------------------------------------------
	//--------------------------------------------------------------------
	
	
	
	
}
