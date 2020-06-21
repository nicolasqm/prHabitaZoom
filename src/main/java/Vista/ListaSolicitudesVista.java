package Vista;

import java.awt.Dimension;
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
	private int filas;

	public ListaSolicitudesVista() {
		listaSolicitudes = new ArrayList<SolicitudVista>();
		panel = new JPanel();
		nSolicitudes = 0;
		filas = 6;
		panel.setLayout(new GridLayout(filas, 0, 0, 0));
		panel.setPreferredSize(this.getSize());

		this.setViewportView(panel);
	}

	public void anadirSolicitud(Solicitud solicitud) {
		SolicitudVista s = new SolicitudVista(solicitud);
		listaSolicitudes.add(s);
		s.setActionListeners(ctrSolicitudes);
		nSolicitudes++;
		if (nSolicitudes == filas + 1) {
			filas = filas + 1;
			panel.setLayout(new GridLayout(filas, 0, 0, 0));
			panel.setPreferredSize(panel.getSize());
			Dimension dim = panel.getSize();
			panel.setPreferredSize(new Dimension(dim.width, dim.height + 400));
		}
		if (nSolicitudes > 1) {
			listaSolicitudes.get(nSolicitudes - 2).getSeparator().setVisible(true);
		}
		panel.add(s);
	}

	public void anadirSolicitudes(List<Solicitud> solicitudes) {
		for (int pos = 0; pos < solicitudes.size(); pos++) {
			anadirSolicitud(solicitudes.get(pos));
		}
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
			sv.getSolicitar().setVisible(false);
			sv.getIniAlq().setVisible(false);
			sv.getFinAlq().setVisible(false);
			sv.gettextFinAlq().setVisible(false);
			sv.gettextIniAlq().setVisible(false);
		}
	}

	public void setActionListeners(ActionListener l) {
		ctrSolicitudes = l;
		for (SolicitudVista sv : listaSolicitudes) {
			sv.setActionListeners(ctrSolicitudes);
		}
	}
}
