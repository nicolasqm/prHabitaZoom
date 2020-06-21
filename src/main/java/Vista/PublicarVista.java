package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Distrito;

@SuppressWarnings("serial")
public class PublicarVista extends JPanel {
	private JTextField direccion;
	private JTextField numero;
	private JTextField planta;
	private JTextField puerta;
	private JTextField descripcion;
	private JTextField tamano;
	private JCheckBox parking;
	private JCheckBox terraza;
	private JCheckBox wifi;
	private JCheckBox fumadores;
	private JCheckBox mascotas;
	private JCheckBox soloEstudiantes;
	private JCheckBox gastosIncluidos;
	private JComboBox<String> distrito;
	private JButton botonAceptar;
	private JTextField precioMes;
	private JTextField fianza;
	private JLabel error;

	public PublicarVista() {
		setLayout(new GridLayout(8, 0, 0, 0));

		JPanel panel8 = new JPanel();
		JLabel label8 = new JLabel("Añade una nueva habitación");
		label8.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel8.add(label8);

		add(panel8);

		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("Dirección: ");
		label1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		direccion = new JTextField();
		direccion.setColumns(20);
		direccion.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel.add(label1);
		panel.add(direccion);
		JLabel label12 = new JLabel("Precio al mes: ");
		label12.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		precioMes = new JTextField();
		precioMes.setColumns(5);
		precioMes.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel.add(label12);
		panel.add(precioMes);
		JLabel label13 = new JLabel("Fianza: ");
		label13.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		fianza = new JTextField();
		fianza.setColumns(5);
		fianza.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel.add(label13);
		panel.add(fianza);
		add(panel);

		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("Numero: ");
		label2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		numero = new JTextField();
		numero.setColumns(2);
		numero.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel2.add(label2);
		panel2.add(numero);
		JLabel label3 = new JLabel("Planta: ");
		label3.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		planta = new JTextField();
		planta.setColumns(2);
		planta.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel2.add(label3);
		panel2.add(planta);
		JLabel label4 = new JLabel("Puerta: ");
		label4.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		puerta = new JTextField();
		puerta.setColumns(2);
		puerta.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel2.add(label4);
		panel2.add(puerta);
		JLabel label6 = new JLabel("Tamaño: ");
		label6.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		tamano = new JTextField();
		tamano.setColumns(2);
		tamano.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel2.add(label6);
		panel2.add(tamano);
		add(panel2);

		JPanel panel3 = new JPanel();
		JLabel label5 = new JLabel("Descripción: ");
		label5.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		descripcion = new JTextField();
		descripcion.setColumns(53);
		descripcion.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		panel3.add(label5);
		panel3.add(descripcion);
		add(panel3);

		JPanel panel4 = new JPanel();
		parking = new JCheckBox("Parking");
		parking.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel4.add(parking);
		terraza = new JCheckBox("Terraza");
		terraza.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel4.add(terraza);
		wifi = new JCheckBox("Wifi");
		wifi.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel4.add(wifi);
		fumadores = new JCheckBox("Fumadores");
		fumadores.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel4.add(fumadores);
		add(panel4);

		JPanel panel5 = new JPanel();
		mascotas = new JCheckBox("Mascotas");
		mascotas.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel5.add(mascotas);
		soloEstudiantes = new JCheckBox("Solo estudiantes");
		soloEstudiantes.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel5.add(soloEstudiantes);
		gastosIncluidos = new JCheckBox("Gastos incluidos");
		gastosIncluidos.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel5.add(gastosIncluidos);
		add(panel5);

		JPanel panel6 = new JPanel();
		JLabel label7 = new JLabel("Distrito: ");
		distrito = new JComboBox<String>(Distrito.getDistritos());
		label7.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		distrito.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panel6.add(label7);
		panel6.add(distrito);
		add(panel6);

		JPanel panel7 = new JPanel();

		add(panel7);

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		error = new JLabel();
		panel7.add(botonAceptar);
		panel7.add(error);

		this.setPreferredSize(new Dimension(1000, 700));

	}

	public void setError(String error) {
		this.error.setText(error);
	}

	public void borrarError() {
		this.error.setText("");
	}

	public JTextField getDireccion() {
		return direccion;
	}

	public JLabel getError() {
		return error;
	}

	public JTextField getNumero() {
		return numero;
	}

	public JTextField getPlanta() {
		return planta;
	}

	public JTextField getPuerta() {
		return puerta;
	}

	public JTextField getDescripcion() {
		return descripcion;
	}

	public JTextField getTamano() {
		return tamano;
	}

	public JCheckBox getParking() {
		return parking;
	}

	public JCheckBox getTerraza() {
		return terraza;
	}

	public JCheckBox getWifi() {
		return wifi;
	}

	public JCheckBox getFumadores() {
		return fumadores;
	}

	public JCheckBox getMascotas() {
		return mascotas;
	}

	public JCheckBox getSoloEstudiantes() {
		return soloEstudiantes;
	}

	public JCheckBox getGastosIncluidos() {
		return gastosIncluidos;
	}

	public JComboBox<String> getDistrito() {
		return distrito;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JTextField getFianza() {
		return fianza;
	}

	public JTextField getprecioMes() {
		return precioMes;
	}

	public void setActionListeners(ActionListener l) {
		botonAceptar.addActionListener(l);
	}

	public void borra() {
		direccion.setText("");
		numero.setText("");
		planta.setText("");
		puerta.setText("");
		descripcion.setText("");
		tamano.setText("");
		fianza.setText("");
		precioMes.setText("");
		terraza.setSelected(false);
		wifi.setSelected(false);
		parking.setSelected(false);
		fumadores.setSelected(false);
		mascotas.setSelected(false);
		soloEstudiantes.setSelected(false);
		gastosIncluidos.setSelected(false);
		error.setText("");
	}
}
