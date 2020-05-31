package Vista;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel {

	private PanelBotones panelBotones;
	private General general;
	private JPanel seleccionPanel;
	private PublicarVista publicarVista;
	private MostrarPerfil mp;
	private EditarPerfil modificarPerfil;
	private VistaFiltro vistaFiltro;
	
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));
		panelBotones = new PanelBotones();
		add(panelBotones, BorderLayout.SOUTH);
		
		seleccionPanel = new JPanel();
		seleccionPanel.setLayout(new CardLayout(0, 0));
		general = new General();
		publicarVista = new PublicarVista();
		modificarPerfil = new EditarPerfil(false);
		vistaFiltro = new VistaFiltro();
		mp = new MostrarPerfil();
		seleccionPanel.add(general);
		seleccionPanel.add(publicarVista);
		seleccionPanel.add(mp);
		seleccionPanel.add(modificarPerfil);
		seleccionPanel.add(vistaFiltro);
		add(seleccionPanel,BorderLayout.CENTER);

	}
	
	public MostrarPerfil getMostrarPerfil() {
		return mp;
	}
	
	public General getGeneral() {
		return general;
	}
	
	public PanelBotones getBotones() {
		return panelBotones;
	}
	
	public PublicarVista getPublicarVista() {
		return publicarVista;
	}
	
	public EditarPerfil getModificarPerfil() {
		return modificarPerfil;
	}

	
	public VistaFiltro getVistaFiltro() {
		return vistaFiltro;
	}
	
	public void setActionListeners(ActionListener panelBotones,ActionListener publicar,ActionListener filtro,ActionListener general,ActionListener mostrarPefil,ActionListener modificarPefil) {
		this.general.setActionListeners(general);
		this.panelBotones.setActionListeners(panelBotones);
		publicarVista.setActionListeners(publicar);
		vistaFiltro.setActionListeners(filtro);
		mp.setActionListeners(mostrarPefil);
		this.modificarPerfil.setActionListeners(modificarPefil);
		
	}

}
