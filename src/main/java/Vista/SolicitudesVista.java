package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SolicitudesVista extends JPanel {

	private JPanel panelSecundario;
	private JLabel solicitudes;
	private ListaSolicitudesVista listaSolicitudes;

	public SolicitudesVista() {
		setLayout(new BorderLayout(0, 0));

		panelSecundario = new JPanel();
		add(panelSecundario, BorderLayout.NORTH);
		panelSecundario.setLayout(new GridLayout(0, 2, 0, 0));

		solicitudes = new JLabel("Solicitudes: ");
		solicitudes.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		panelSecundario.add(solicitudes);

		listaSolicitudes = new ListaSolicitudesVista();
		add(listaSolicitudes, BorderLayout.CENTER);

		listaSolicitudes.setVisible(true);
	}

	public JPanel getPanelSecundario() {
		return panelSecundario;
	}

	public ListaSolicitudesVista getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setActionListeners(ActionListener l) {
		listaSolicitudes.setActionListeners(l);
	}

}
