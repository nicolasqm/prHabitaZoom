package Vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

	private JButton general;
	private JButton calendario;
	private JButton publicar;
	private JButton chat;
	private JButton perfil;

	public PanelBotones() {
		setLayout(new GridLayout(0, 5, 0, 0));

		general = new JButton("General");
		general.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(general);

		calendario = new JButton("Calendario");
		calendario.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(calendario);

		publicar = new JButton("Publicar");
		publicar.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
		add(publicar);

		chat = new JButton("Chat");
		chat.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(chat);

		perfil = new JButton("Perfil");
		perfil.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		add(perfil);

	}

	public JButton getGeneral() {
		return general;
	}

	public JButton getCalendario() {
		return calendario;
	}

	public JButton getPublicar() {
		return publicar;
	}

	public JButton getChat() {
		return chat;
	}

	public JButton getPerfil() {
		return perfil;
	}

	public void setActionListeners(ActionListener l) {
		general.addActionListener(l);
		calendario.addActionListener(l);
		publicar.addActionListener(l);
		chat.addActionListener(l);
		perfil.addActionListener(l);
	}

}
