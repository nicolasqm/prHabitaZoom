package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.AccesoBD;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class VistaFiltro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Filtro;
	private JButton Buscar;
	private JButton Cancelar;
	private JTextField precioMax;
	private JTextField precioMin;
	private JCheckBox Wifi;
	private JCheckBox Mascota;
	private JCheckBox GastosIncluidos;
	private JCheckBox SoloEstudiantes;
	private JCheckBox Terraza;
	private JCheckBox Fumador;
	private JCheckBox Parking;
	private JComboBox<String> Distrito;
	private JComboBox<String> Ciudad;
	private JLabel error;

	public VistaFiltro() {
		setLayout(new GridLayout(8, 2, 0, 0));

		JPanel panel = new JPanel();
		add(panel);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel.add(lblCiudad);

		Ciudad = new JComboBox<String>();
		Ciudad.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel.add(Ciudad);

		JPanel panel_1 = new JPanel();
		add(panel_1);

		Wifi = new JCheckBox("Wifi");
		Wifi.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_1.add(Wifi);

		JPanel panel_2 = new JPanel();
		add(panel_2);

		JLabel lblDistrito = new JLabel("Distrito");
		lblDistrito.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_2.add(lblDistrito);

		Distrito = new JComboBox<String>(AccesoBD.getInstance().getDistritos());
		Distrito.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_2.add(Distrito);

		JPanel panel_3 = new JPanel();
		add(panel_3);

		Mascota = new JCheckBox("Mascota");
		Mascota.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_3.add(Mascota);

		JPanel panel_4 = new JPanel();
		add(panel_4);

		JLabel lblPrecioMax = new JLabel("Precio Max");
		lblPrecioMax.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_4.add(lblPrecioMax);

		precioMax = new JTextField();
		precioMax.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel_4.add(precioMax);
		precioMax.setColumns(10);

		JPanel panel_5 = new JPanel();
		add(panel_5);

		GastosIncluidos = new JCheckBox("Gastos Incluidos");
		GastosIncluidos.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_5.add(GastosIncluidos);

		JPanel panel_6 = new JPanel();
		add(panel_6);

		JLabel lblPrecioMin = new JLabel("Precio Min");
		lblPrecioMin.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_6.add(lblPrecioMin);

		precioMin = new JTextField();
		precioMin.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel_6.add(precioMin);
		precioMin.setColumns(10);

		JPanel panel_7 = new JPanel();
		add(panel_7);

		SoloEstudiantes = new JCheckBox("Solo Estudiantes");
		SoloEstudiantes.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_7.add(SoloEstudiantes);

		JPanel panel_8 = new JPanel();
		add(panel_8);

		JPanel panel_9 = new JPanel();
		add(panel_9);

		Terraza = new JCheckBox("Terraza");
		Terraza.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_9.add(Terraza);

		JPanel panel_10 = new JPanel();
		add(panel_10);

		Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_10.add(Cancelar);

		JPanel panel_11 = new JPanel();
		add(panel_11);

		Fumador = new JCheckBox("Fumador");
		Fumador.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_11.add(Fumador);

		JPanel panel_12 = new JPanel();
		add(panel_12);

		Buscar = new JButton("Buscar");
		Buscar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_12.add(Buscar);

		JPanel panel_13 = new JPanel();
		add(panel_13);

		Parking = new JCheckBox("Parking");
		Parking.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_13.add(Parking);

		JPanel panel_14 = new JPanel();
		add(panel_14);

		error = new JLabel();
		error.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel_14.add(error);

		JPanel panel_15 = new JPanel();
		add(panel_15);

	}

	public void setError(String error) {
		this.error.setText("Error, " + error);
	}

	public void borrarError() {
		this.error.setText("");
	}

	public JComboBox<String> getDistrito() {
		return Distrito;
	}

	/*
	 * public JComboBox<String> getCiudad() { return Ciudad; }
	 */

	public void setActionListeners(ActionListener l) {
		Cancelar.addActionListener(l);
		Buscar.addActionListener(l);
	}

	public JButton getBtnBuscar() {
		return Buscar;
	}

	public JButton getBtnCancelar() {
		return Cancelar;
	}

	public JPanel getFiltro() {
		return Filtro;
	}

	public JButton getBuscar() {
		return Buscar;
	}

	public JButton getCancelar() {
		return Cancelar;
	}

	public JTextField getPrecioMax() {
		return precioMax;
	}

	public JTextField getPrecioMin() {
		return precioMin;
	}

	public JLabel getError() {
		return error;
	}

	public JCheckBox getWifi() {
		return Wifi;
	}

	public JCheckBox getMascota() {
		return Mascota;
	}

	public JCheckBox getGastosIncluidos() {
		return GastosIncluidos;
	}

	public JCheckBox getSoloEstudiantes() {
		return SoloEstudiantes;
	}

	public JCheckBox getTerraza() {
		return Terraza;
	}

	public JCheckBox getFumador() {
		return Fumador;
	}

	public JCheckBox getParking() {
		return Parking;
	}
}
