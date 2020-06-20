package Vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

	private JButton general;
	private JButton solicitudes;
	private JButton publicar;
	private JButton favoritos;
	private JButton perfil;

	public PanelBotones() {
		setLayout(new GridLayout(0, 5, 0, 0));

		general = new JButton("General");
		general.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(general);

		solicitudes = new JButton("Solicitudes");
		solicitudes.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(solicitudes);

		publicar = new JButton("Publicar");
		publicar.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
		add(publicar);

		favoritos = new JButton("Favoritos");
		favoritos.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(favoritos);

		perfil = new JButton("Perfil");
		perfil.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(perfil);

	}

	public JButton getGeneral() {
		return general;
	}

	public JButton getSolicitudes() {
		return solicitudes;
	}

	public JButton getPublicar() {
		return publicar;
	}

	public JButton getFavoritos() {
		return favoritos;
	}

	public JButton getPerfil() {
		return perfil;
	}

	public void setActionListeners(ActionListener l) {
		general.addActionListener(l);
		solicitudes.addActionListener(l);
		publicar.addActionListener(l);
		favoritos.addActionListener(l);
		perfil.addActionListener(l);
	}

}
