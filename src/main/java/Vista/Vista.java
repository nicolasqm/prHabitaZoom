package Vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Anuncio;
import Modelo.Usuario;

import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Vista extends JFrame {

//	public static void main(String[] args) {
//		Vista v = new Vista();
//
//	}

	private JPanel panel;
	private PanelPrincipal PanelPrincipal;
	private IniciarSesion IniciarSesion;
	private EditarPerfil registrarse;
	private HabitacionVista habvis;

	public Vista() {
		this.setTitle("HabitaZoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		IniciarSesion = new IniciarSesion();
		PanelPrincipal = new PanelPrincipal();
		registrarse = new EditarPerfil();
		panel.setLayout(new CardLayout(0, 0));
		panel.add(IniciarSesion);
		panel.add(PanelPrincipal);
		panel.add(registrarse);
		setContentPane(panel);
		this.setVisible(true);
		this.pack();
	}

	public IniciarSesion getIniciarSesion() {
		return IniciarSesion;
	}

	public PanelPrincipal getPanelPrincipal() {
		return PanelPrincipal;
	}

	public EditarPerfil getEditarPerfil() {
		return registrarse;
	}

	public General getGeneral() {
		return PanelPrincipal.getGeneral();
	}

	public PublicarVista getPublicarVista() {
		return PanelPrincipal.getPublicarVista();
	}

	public MostrarPerfil getMostrarPerfil() {
		return PanelPrincipal.getMostrarPerfil();
	}

	public EditarPerfil getModificarPerfil() {
		return PanelPrincipal.getModificarPerfil();
	}

	public VistaFiltro getVistaFiltro() {
		return PanelPrincipal.getVistaFiltro();
	}
	
	public VistaFavoritos getVistaFavoritos() {
		return PanelPrincipal.getVistaFavoritos();
	}

	public void setActionListeners(ActionListener iniciarSesion, ActionListener registrarse,
			ActionListener panelBotones, ActionListener publicar, ActionListener filtro, ActionListener general,
			ActionListener mostrarPerfil, ActionListener modificarPerfil, ActionListener favoritos ,ActionListener valoracion) {
		IniciarSesion.setActionListeners(iniciarSesion);
		this.registrarse.setActionListeners(registrarse);
		PanelPrincipal.setActionListeners(panelBotones, publicar, filtro, general, mostrarPerfil, modificarPerfil,favoritos,valoracion);
	}

	// ----------------------------------------------------
	// Aqui empeiza los botones y los texto de InicarUsuario
	// ----------------------------------------------------
	public JTextField getTextoUsuarioIniciarSesion() {
		return IniciarSesion.getTextoUsuario();
	}

	public JTextField getTextoContrasenaIniciarSesion() {
		return IniciarSesion.getTextoContrasena();
	}

	public JButton getBotonIniciarSesion() {
		return IniciarSesion.getBotonIniciarSesion();
	}

	public JButton getBotonRegistrarseIniciarSesion() {
		return IniciarSesion.getBotonRegistrarse();
	}

	public JLabel getErrorIniciarSesion() {
		return IniciarSesion.getError();
	}
	
	public void setMensajeErrorIniciarSesion(String txt) {
		IniciarSesion.setMensajeError(txt);
	}

	public void borrarMensajeErrorIniciarSesion() {
		IniciarSesion.borrarMensajeError();
	}

	public void borrarTextFieldsInicioSesion() {
		IniciarSesion.borra();
	}

	// ----------------------------------------------------------
	// Aqui empeiza los botones y texto de registrarse
	// --------------------------------------------------------
	public JButton getBotonCancelar() {
		return registrarse.getCancelar();
	}
	// ---------------------------------------------------------
	// Aqui empieza los botones y texto de panel principal
	// -------------------------------------------------------
	// Primero el panel de botones

	public JButton getBotonGeneral() {
		return PanelPrincipal.getBotones().getGeneral();
	}

	public JButton getBotonCalendario() {
		return PanelPrincipal.getBotones().getCalendario();
	}

	public JButton getBotonPublicar() {
		return PanelPrincipal.getBotones().getPublicar();
	}

	public JButton getBotonFavoritos() {
		return PanelPrincipal.getBotones().getFavoritos ();
	}

	public JButton getBotonPerfil() {
		return PanelPrincipal.getBotones().getPerfil();
	}

	// Segundo es el panel del general

	public JButton getBotonFiltrar() {
		return PanelPrincipal.getGeneral().getBotonFiltro();
	}
	public Anuncio getAnuncioListaAnuncio() {
		return getGeneral().getLista().buscarHabitacion();
	}
	
	
	public int getValoracion() {
		return habvis.getValoracion();
	}
	public HabitacionVista getAnuncioValoracion() {
		return PanelPrincipal.getGeneral().getLista().buscarValoracion();
	}
	public JLabel getErrorValoracion() {
		return habvis.errorVal();
	}
	
	// Tercero es el panel habitaciones que esta contenido en el general

	public void anadirHabitacion(Anuncio anuncio) {
		PanelPrincipal.getGeneral().getLista().anadirHabitacion(anuncio);
	}

	// ---------------------------------------------------------------------
	// Getters y setters de publicar
	// --------------------------------------------------------------------
	public JTextField getTextoDireccion() {
		return PanelPrincipal.getPublicarVista().getDireccion();
	}

	public JTextField getTextoNumero() {
		return PanelPrincipal.getPublicarVista().getNumero();
	}

	public void setPublicarError(String error) {
		PanelPrincipal.getPublicarVista().setError(error);
	}

	public void borrarPublicarError() {
		PanelPrincipal.getPublicarVista().borrarError();
	}

	public JTextField getTextoPlanta() {
		return PanelPrincipal.getPublicarVista().getPlanta();
	}

	public JTextField getTextoPuerta() {
		return PanelPrincipal.getPublicarVista().getPuerta();
	}

	public JTextField getTextoDescripcion() {
		return PanelPrincipal.getPublicarVista().getDescripcion();
	}

	public JTextField getTextoTamano() {
		return PanelPrincipal.getPublicarVista().getTamano();
	}

	public JCheckBox getOpcionParking() {
		return PanelPrincipal.getPublicarVista().getParking();
	}

	public JCheckBox getOpcionTerraza() {
		return PanelPrincipal.getPublicarVista().getTerraza();
	}

	public JCheckBox getOpcionFumadores() {
		return PanelPrincipal.getPublicarVista().getFumadores();
	}

	public JCheckBox getOpcionMascotas() {
		return PanelPrincipal.getPublicarVista().getMascotas();
	}

	public JCheckBox getOpcionSoloEstudiantes() {
		return PanelPrincipal.getPublicarVista().getSoloEstudiantes();
	}

	public JCheckBox getOpcionGastosIncluidos() {
		return PanelPrincipal.getPublicarVista().getGastosIncluidos();
	}

	public JComboBox<String> getTextoDistrito() {
		return PanelPrincipal.getPublicarVista().getDistrito();
	}

	public JCheckBox getOpcionWifi() {
		return PanelPrincipal.getPublicarVista().getWifi();
	}

	public void borrarTextFieldPublicar() {
		PanelPrincipal.getPublicarVista().borra();
	}

	public JTextField getTextoFianza() {
		return PanelPrincipal.getPublicarVista().getFianza();
	}

	public JTextField getTextoPrecioMes() {
		return PanelPrincipal.getPublicarVista().getprecioMes();
	}

	//
	//
	//
	public void setUsuarioMostrarPerfil(Usuario u) {
		PanelPrincipal.getMostrarPerfil().setUsuario(u);
	}
	//
	//
	//
//	public JPanel getvistaFiltro() {
//		return PanelPrincipal.getVistaFiltro().getFiltro();
//	}

	public void setDatosModificarPerfil(Usuario u) {
		PanelPrincipal.getModificarPerfil().setDatosUsuario(u);
	}

	// ---------------------------------------------------------------------
	// Getters y setters de filtrar
	// --------------------------------------------------------------------

	public void setErrorFiltrar(String error) {
		PanelPrincipal.getVistaFiltro().setError(error);
	}

	public void borrarErrorFiltrar() {
		PanelPrincipal.getVistaFiltro().borrarError();
	}

//    public JPanel getFiltro() {
//        return getVistaFiltro().getFiltro();
//    }

	public JButton getBuscar() {
		return getVistaFiltro().getBtnBuscar();
	}

	public JButton getCancelar() {
		return getVistaFiltro().getBtnCancelar();
	}

	public JTextField getPrecioMax() {
		return getVistaFiltro().getPrecioMax();
	}

	public JTextField getPrecioMin() {
		return getVistaFiltro().getPrecioMin();
	}

	public JCheckBox getWifi() {
		return getVistaFiltro().getWifi();
	}

	public JCheckBox getMascota() {
		return getVistaFiltro().getMascota();
	}

	public JCheckBox getGastosIncluidos() {
		return getVistaFiltro().getGastosIncluidos();
	}

	public JCheckBox getSoloEstudiantes() {
		return getVistaFiltro().getSoloEstudiantes();
	}

	public JCheckBox getTerraza() {
		return getVistaFiltro().getTerraza();
	}

	public JCheckBox getFumador() {
		return getVistaFiltro().getFumador();
	}

	public JCheckBox getParking() {
		return getVistaFiltro().getParking();
	}

	public JComboBox<String> getDistrito() {
		return getVistaFiltro().getDistrito();
	}

	public void borrarErrorModificarPerfil() {
		getModificarPerfil().getError().setText("");
	}
	
	//
	// Cosas necesarias para el favoritos
	//
	public void anadirAnuncioFavorito(Anuncio anuncio) {
		this.getVistaFavoritos().getListaFavoritos().anadirHabitacion(anuncio);
	}
	
	
	
	

}
