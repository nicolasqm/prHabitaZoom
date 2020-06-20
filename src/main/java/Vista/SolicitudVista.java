package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import Modelo.Solicitud;

@SuppressWarnings("serial")
public class SolicitudVista extends HabitacionVista {

	private JPanel botones;
	private JToggleButton aceptar;
	private JToggleButton cancelar;
	private JLabel solicitante;
	private JLabel fechaSolicitud;
	private JLabel fechaInicioAlq;
	private JLabel fechaFinAlq;
	

	public SolicitudVista(Solicitud solicitud) {
		super(solicitud.getAnuncioSolicitado());
		
		JPanel datosSolicitud = new JPanel();
		datosSolicitud.setLayout(new GridLayout(4, 0, 0, 0));
		
		solicitante = new JLabel("Solicitante: " + solicitud.getSolicitante().getAlias()
				+ "("+ solicitud.getSolicitante().getCorreo() +")");
		solicitante.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		datosSolicitud.add(solicitante);
		
		fechaSolicitud = new JLabel("Fecha de solicitud: " + solicitud.getFechaSolicitud());
		fechaSolicitud.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		datosSolicitud.add(fechaSolicitud);
		
		fechaInicioAlq = new JLabel("Fecha de incio alquiler: " + solicitud.getFechaInicioAlq());
		fechaInicioAlq.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		datosSolicitud.add(fechaInicioAlq);
		
		fechaFinAlq = new JLabel("Fecha de fin alquiler: " + solicitud.getFechaFinAlq());
		fechaFinAlq.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		datosSolicitud.add(fechaFinAlq);

		botones = new JPanel();
		botones.setLayout(new GridLayout(0, 2, 0, 0));

		aceptar = new JToggleButton("Aceptar");
		aceptar.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		botones.add(aceptar);

		cancelar = new JToggleButton("Cancelar");
		cancelar.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		botones.add(cancelar);

		this.add(datosSolicitud, BorderLayout.CENTER);
		this.add(botones, BorderLayout.EAST);
	}

	public JToggleButton getAceptarBoton() {
		return aceptar;
	}

	public JToggleButton getCancelarBoton() {
		return cancelar;
	}

	public void setActionListeners(ActionListener l) {
		aceptar.addActionListener(l);
		cancelar.addActionListener(l);
	}

}