package Vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Usuario;

@SuppressWarnings("serial")
public class MostrarPerfil extends JPanel {
	private JLabel tModificarPerfil;

	private JLabel tNombre = new JLabel("Nombre: ");
	private JLabel tApellido1 = new JLabel("Primer apellido: ");
	private JLabel tApellido2 = new JLabel("Segundo apellido: ");
	private JLabel tAlias = new JLabel("Alias: ");
	private JLabel tCorreo = new JLabel("Correo: ");
	private JLabel tFechaNacimiento = new JLabel("Fecha de nacimiento: ");

	private JLabel nombre;
	private JLabel apellido1;
	private JLabel apellido2;
	private JLabel alias;
	private JLabel correo;
	private JLabel fechaNacimiento;

	private JButton editarPerfil = new JButton("Editar Perfil");
	private JButton cerrarSesion = new JButton("Cerrar Sesion");

	public MostrarPerfil() {
		tModificarPerfil = new JLabel("Perfil");

		nombre = new JLabel();
		apellido1 = new JLabel();
		apellido2 = new JLabel();
		fechaNacimiento = new JLabel();
		alias = new JLabel();
		correo = new JLabel();

		setLayout(new GridLayout(10, 1, 0, 0));
		tModificarPerfil.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(tModificarPerfil);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		tNombre.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		nombre.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p1.add(tNombre);
		p1.add(nombre);
		add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		tApellido1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		apellido1.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p2.add(tApellido1);
		p2.add(apellido1);
		add(p2);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		tApellido2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		apellido2.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p3.add(tApellido2);
		p3.add(apellido2);
		add(p3);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		tFechaNacimiento.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		fechaNacimiento.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p4.add(tFechaNacimiento);
		p4.add(fechaNacimiento);
		add(p4);

		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		tAlias.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		alias.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p5.add(tAlias);
		p5.add(alias);
		add(p5);

		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout());
		tCorreo.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		correo.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
		p6.add(tCorreo);
		p6.add(correo);
		add(p6);

		JPanel p7 = new JPanel();
		editarPerfil.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		p7.add(editarPerfil);
		add(p7);

		JPanel p8 = new JPanel();
		cerrarSesion.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		p8.add(cerrarSesion);
		add(p8);
	}

	public void setUsuario(Usuario usuario) {
		nombre.setText(usuario.getNombre());
		String[] apellidos = usuario.getApellido().split("[ ]");
		apellido1.setText(apellidos[0]);
		apellido2.setText(apellidos[1]);
		fechaNacimiento.setText(usuario.getFecha_Nacimiento());
		alias.setText(usuario.getAlias());
		correo.setText(usuario.getCorreo());
	}

	public JButton getEditarPerfil() {
		return editarPerfil;
	}

	public JButton getCerrarSesion() {
		return cerrarSesion;
	}

	public void setActionListeners(ActionListener l) {
		editarPerfil.addActionListener(l);
		cerrarSesion.addActionListener(l);
	}
}