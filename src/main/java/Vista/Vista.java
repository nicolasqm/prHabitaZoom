package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Vista extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					frame.getIniciarSesion().setVisible(false);
					frame.getPanelPrincipal().setVisible(true);
					for(int pos = 0; pos<10; pos++) {
						//frame.getPanelPrincipal().getGeneral().getLista().anadirHabitacion(new Habitacion());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
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
	//	PanelPrincipal.setActionListeners(l);
	}
	
}
