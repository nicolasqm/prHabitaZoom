package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Solicitud;

@SuppressWarnings("serial")
public class ListaSolicitudesVista extends JScrollPane {

	private List<SolicitudVista> listaSolicitudes;
	private JPanel panel;
	private int nSolicitudes;
	private ActionListener ctrSolicitudes;

	public ListaSolicitudesVista() {
		listaSolicitudes = new ArrayList<SolicitudVista>();
		panel = new JPanel();
		nSolicitudes = 0;

		this.setViewportView(panel);
	}
	
	public void anadirSolicitud(Solicitud solicitud) {
		SolicitudVista s = new SolicitudVista(solicitud);
		listaSolicitudes.add(s);
		nSolicitudes++;
		panel.setLayout(new GridLayout(nSolicitudes, 0, 0, 0));
		panel.setPreferredSize(panel.getSize());
		if (nSolicitudes > 1) {
			listaSolicitudes.get(nSolicitudes - 2).getSeparator().setVisible(true);
		}
		panel.add(s);
	}

	public void anadirSolicitudes(List<Solicitud> solicitudes) {
		for (int pos = 0; pos < solicitudes.size(); pos++) {
			anadirSolicitud(solicitudes.get(pos));
		}
		setActionListeners(ctrSolicitudes);
		this.ocultarGeneral();
	}
	
	public void borrarListaSolicitudes() {
		panel.removeAll();
		listaSolicitudes.clear();
		nSolicitudes = 0;
	}

	public List<SolicitudVista> getListaSolicitud() {
		return listaSolicitudes;
	}

	public JPanel getPanel() {
		return panel;
	}

	public int getNumSolicitudes() {
		return nSolicitudes;
	}

	public void buscarBotonAceptar() {
		int i = 0;
		boolean encontrado = false;
		while (i < listaSolicitudes.size() && !encontrado) {
			if (listaSolicitudes.get(i).getAceptarBoton().isSelected()) {
				encontrado = true;
				listaSolicitudes.get(i).setVisible(false);
				panel.remove(listaSolicitudes.get(i));
				listaSolicitudes.remove(i);
			}
			i++;
		}
	}

	public void buscarBotonCancelar() {
		int i = 0;
		boolean encontrado = false;
		while (i < listaSolicitudes.size() && !encontrado) {
			if (listaSolicitudes.get(i).getCancelarBoton().isSelected()) {
				encontrado = true;
				listaSolicitudes.get(i).setVisible(false);
				panel.remove(listaSolicitudes.get(i));
				listaSolicitudes.remove(i);
			}
			i++;
		}
	}

	public void ocultarGeneral() {
		for (SolicitudVista sv : listaSolicitudes) {
			sv.getBotonFavorito().setVisible(false);
			sv.getPanelValoracion().setVisible(false);
		}
	}

	public void setActionListeners(ActionListener l) {
		ctrSolicitudes = l;
		for (SolicitudVista sv : listaSolicitudes) {
			sv.setActionListeners(ctrSolicitudes);
		}
	}
}
