package Vista;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.Usuario;

@SuppressWarnings("serial")
public class EditarPerfil extends JPanel {

	private JLabel tModificarPerfil;

	private JLabel tNombre = new JLabel("Nombre: ");
	private JLabel tApellido1 = new JLabel("Primer apellido: ");
	private JLabel tApellido2 = new JLabel("Segundo apellido: ");
	private JLabel tAlias = new JLabel("Alias: ");
	private JLabel tCorreo = new JLabel("Correo: ");
	private JLabel tContrasena = new JLabel("Contraseña: ");
	private JLabel tConfirmarContrasena = new JLabel("Confirmar Contraseña: ");
	private JLabel tFechaNacimiento = new JLabel("Fecha de nacimiento: ");
	private JLabel tError = new JLabel();

	private JTextField nombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField alias;
	private JTextField correo;
	private JPasswordField contrasena;
	private JPasswordField confirmarContrasena;
	private JTextField fechaNacimiento;

	private JButton confirmarPerfil = new JButton("Confirmar Perfil");
	private JButton cancelar = new JButton("Cancelar");

	// obligatorios: true = se debe rellenar los campos obligatorios, false = todos
	// los campos son opcionales
	private boolean obligatorios;

	public EditarPerfil(boolean camposObligatorios) {
		obligatorios = camposObligatorios;
		tModificarPerfil = new JLabel(
				obligatorios ? "Introduzca los datos para crear perfil" : "Modifique los datos del perfil");
		nombre = new JTextField();
		apellido1 = new JTextField();
		apellido2 = new JTextField();
		fechaNacimiento = new JTextField();
		alias = new JTextField();
		correo = new JTextField();
		contrasena = new JPasswordField();
		confirmarContrasena = new JPasswordField();

		setLayout(new GridLayout(11, 1, 0, 0));
		tModificarPerfil.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(tModificarPerfil);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		tNombre.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		nombre.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		nombre.setColumns(20);
		p1.add(tNombre);
		p1.add(nombre);
		add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		tApellido1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		apellido1.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		apellido1.setColumns(20);
		p2.add(tApellido1);
		p2.add(apellido1);
		add(p2);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		tApellido2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		apellido2.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		apellido2.setColumns(20);
		p3.add(tApellido2);
		p3.add(apellido2);
		add(p3);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		tFechaNacimiento.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		fechaNacimiento.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		fechaNacimiento.setColumns(20);
		p4.add(tFechaNacimiento);
		p4.add(fechaNacimiento);
		add(p4);

		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		tAlias.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		alias.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		alias.setColumns(20);
		p5.add(tAlias);
		p5.add(alias);
		add(p5);

		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout());
		tCorreo.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		correo.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		correo.setColumns(20);
		p6.add(tCorreo);
		p6.add(correo);
		add(p6);

		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout());
		tContrasena.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		contrasena.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		contrasena.setColumns(20);
		p7.add(tContrasena);
		p7.add(contrasena);
		add(p7);

		JPanel p8 = new JPanel();
		p8.setLayout(new FlowLayout());
		tConfirmarContrasena.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		confirmarContrasena.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		confirmarContrasena.setColumns(20);
		p8.add(tConfirmarContrasena);
		p8.add(confirmarContrasena);
		add(p8);

		JPanel p9 = new JPanel();
		p9.setLayout(new FlowLayout());
		confirmarPerfil.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		p9.add(confirmarPerfil);
		p9.add(tError);
		add(p9);

		JPanel p10 = new JPanel();
		p10.setLayout(new FlowLayout());
		cancelar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		p10.add(cancelar);
		add(p10);

	}

	public EditarPerfil() {
		this(true);
	}

	public void setDatosUsuario(Usuario u) {
		nombre.setText(u.getNombre());
		String[] apellido = u.getApellido().split("[ ]");
		apellido1.setText(apellido[0]);
		if (apellido.length == 1) {
			apellido2.setText("");
		} else {
			apellido2.setText(apellido[1]);
		}
		alias.setText(u.getAlias());
		correo.setText(u.getCorreo());
		correo.setEditable(false);
		contrasena.setText(u.getContrasena());
		confirmarContrasena.setText(u.getContrasena());
		fechaNacimiento.setText(u.getFecha_Nacimiento());
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getApellido() {
		return apellido1;
	}

	public JTextField getApellido2() {
		return apellido2;
	}

	public JTextField getAlias() {
		return alias;
	}

	public JTextField getCorreo() {
		return correo;
	}

	public JTextField getContrasena() {
		return contrasena;
	}

	public JTextField getConfirmarContrasena() {
		return confirmarContrasena;
	}

	public JTextField getFechaNacimiento() {
		return fechaNacimiento;
	}

	public JButton getButton() {
		return confirmarPerfil;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setError(String txt) {
		tError.setText("Error, " + txt);
	}

	public JLabel getError() {
		return tError;
	}

	public void borrarMensajeError() {
		this.tError.setText("");
	}

	public void borra() {
		nombre.setText("");
		apellido1.setText("");
		apellido2.setText("");
		alias.setText("");
		correo.setText("");
		contrasena.setText("");
		confirmarContrasena.setText("");
		fechaNacimiento.setText("");
	}

	public void setActionListeners(ActionListener l) {
		confirmarPerfil.addActionListener(l);
		cancelar.addActionListener(l);
	}

}