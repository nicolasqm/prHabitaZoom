package Vista;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {

	private PanelBotones panelBotones;
	private General general;
	private JPanel seleccionPanel;
	
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));
		panelBotones = new PanelBotones();
		add(panelBotones, BorderLayout.SOUTH);
		
		seleccionPanel = new JPanel();
		seleccionPanel.setLayout(new CardLayout(0, 0));
		general = new General();
		seleccionPanel.add(general);
		add(seleccionPanel,BorderLayout.CENTER);

	}
	
	public General getGeneral() {
		return general;
	}
	
	public PanelBotones getBotones() {
		return panelBotones;
	}
	
	public void setActionListeners(ActionListener l) {
		general.setActionListeners(l);
		panelBotones.setActionListeners(l);
	}

}
