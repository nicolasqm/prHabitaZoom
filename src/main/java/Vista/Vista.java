package Vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Anuncio;
import Modelo.Excepcion;
import Modelo.Solicitud;
import Modelo.Usuario;

import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel panel;
	private PanelPrincipal PanelPrincipal;
	private IniciarSesion IniciarSesion;
	private EditarPerfil registrarse;

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

	public SolicitudesVista getSolicitudesVista() {
		return PanelPrincipal.getSolicitudesVista();
	}

	public void setActionListeners(ActionListener iniciarSesion, ActionListener registrarse,
			ActionListener panelBotones, ActionListener publicar, ActionListener filtro, ActionListener general,
			ActionListener mostrarPerfil, ActionListener modificarPerfil, ActionListener favoritos,
			ActionListener valoracion, ActionListener solicitudes, ActionListener crearSolicitudes) {
		IniciarSesion.setActionListeners(iniciarSesion);
		this.registrarse.setActionListeners(registrarse);
		PanelPrincipal.setActionListeners(panelBotones, publicar, filtro, general, mostrarPerfil, modificarPerfil,
				favoritos, valoracion, solicitudes, crearSolicitudes);
	}

	// -------------------------------------------------------
	// Aqui empiezan los botones y los textos de IniciarSesion
	// -------------------------------------------------------

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

	public void anadirListaAnuncio(List<Anuncio> lista) {
		PanelPrincipal.getGeneral().getLista().anadirListaAnuncios(lista);
	}

	// -----------------------------------------------------
	// Aqui empiezan los botones y los textos de Registrarse
	// -----------------------------------------------------

	public JTextField getTextoNombre() {
		return registrarse.getNombre();
	}

	public JTextField getTextoApellido() {
		return registrarse.getApellido();
	}

	public JTextField getTextoApellido2() {
		return registrarse.getApellido2();
	}

	public JTextField getTextoAlias() {
		return registrarse.getAlias();
	}

	public JTextField getTextoCorreo() {
		return registrarse.getCorreo();
	}

	public JTextField getTextoContrasena() {
		return registrarse.getContrasena();
	}

	public JTextField getTextoConfirmarContrasena() {
		return registrarse.getConfirmarContrasena();
	}

	public JTextField getTextoFechaNacimiento() {
		return registrarse.getFechaNacimiento();
	}

	public JButton getBotonCancelar() {
		return registrarse.getCancelar();
	}

	// --------------------------------------------------
	// Aqui empieza los botones y texto de PanelPrincipal
	// --------------------------------------------------

	// PanelBotones

	public JButton getBotonGeneral() {
		return PanelPrincipal.getBotones().getGeneral();
	}

	public JButton getBotonSolicitudes() {
		return PanelPrincipal.getBotones().getSolicitudes();
	}

	public JButton getBotonPublicar() {
		return PanelPrincipal.getBotones().getPublicar();
	}

	public JButton getBotonFavoritos() {
		return PanelPrincipal.getBotones().getFavoritos();
	}

	public JButton getBotonPerfil() {
		return PanelPrincipal.getBotones().getPerfil();
	}

	// General

	public JButton getBotonFiltrar() {
		return PanelPrincipal.getGeneral().getBotonFiltro();
	}

	public HabitacionVista getAnuncioValoracion() {
		return PanelPrincipal.getGeneral().getLista().buscarValoracion();
	}

	public HabitacionVista getAnuncioSolicitud() {
		return PanelPrincipal.getGeneral().getLista().buscarHabitacionSolicitada();
	}

	// ListaHabitaciones

	public void anadirHabitacion(Anuncio anuncio) {
		PanelPrincipal.getGeneral().getLista().anadirHabitacion(anuncio);
	}

	public void quitarBotonesFavoritos(List<Anuncio> anuncios) {
		PanelPrincipal.getGeneral().getLista().desactivarBotonesFavoritos(anuncios);
	}

	// -----------------------------
	// Getters y setters de Publicar
	// -----------------------------

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

	// ----------------------------------
	// Getters y setters de MostrarPerfil
	// ----------------------------------

	public void setUsuarioMostrarPerfil(Usuario u) {
		PanelPrincipal.getMostrarPerfil().setUsuario(u);
	}

	public void setDatosModificarPerfil(Usuario u) {
		PanelPrincipal.getModificarPerfil().setDatosUsuario(u);
	}

	public JTextField getTextoNombreMod() {
		return PanelPrincipal.getModificarPerfil().getNombre();
	}

	public JTextField getTextoApellidoMod() {
		return PanelPrincipal.getModificarPerfil().getApellido();
	}

	public JTextField getTextoApellido2Mod() {
		return PanelPrincipal.getModificarPerfil().getApellido2();
	}

	public JTextField getTextoAliasMod() {
		return PanelPrincipal.getModificarPerfil().getAlias();
	}

	public JTextField getTextoCorreoMod() {
		return PanelPrincipal.getModificarPerfil().getCorreo();
	}

	public JTextField getTextoContrasenaMod() {
		return PanelPrincipal.getModificarPerfil().getContrasena();
	}

	public JTextField getTextoConfirmarContrasenaMod() {
		return PanelPrincipal.getModificarPerfil().getConfirmarContrasena();
	}

	public JTextField getTextoFechaNacimientoMod() {
		return PanelPrincipal.getModificarPerfil().getFechaNacimiento();
	}

	// ----------------------------
	// Getters y setters de Filtrar
	// ----------------------------

	public void setErrorFiltrar(String error) {
		PanelPrincipal.getVistaFiltro().setError(error);
	}

	public void borrarErrorFiltrar() {
		PanelPrincipal.getVistaFiltro().borrarError();
	}

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

	// ----------------------
	// Métodos para Favoritos
	// ----------------------

	public void anadirAnuncioFavorito(Anuncio anuncio) {
		this.getVistaFavoritos().getListaFavoritos().anadirHabitacion(anuncio);
	}

	public Anuncio getFavoritoSeleccinado(Usuario usuario) throws Excepcion {
		return PanelPrincipal.getVistaFavoritos().getListaFavoritos().buscarFavoritoSeleccionado(usuario);
	}

	public void anadirListaFavoritos(List<Anuncio> anuncios) {
		PanelPrincipal.getVistaFavoritos().getListaFavoritos().anadirAnucios(anuncios);
	}

	public void borrarTodosLosFavoritos() {
		PanelPrincipal.getVistaFavoritos().getListaFavoritos().borrarHabitacionesFavoritas();
	}

	public Anuncio getAnuncioSeleccionado(Usuario usuario) throws Excepcion {
		return getGeneral().getLista().buscarAnuncioSeleccionado(usuario);
	}

	public void activarBotonFavorito(Anuncio anuncio) {
		PanelPrincipal.getGeneral().getLista().activarBotonFavorito(anuncio);
	}

	public void borrarTodasLasHabitaciones() {
		this.getGeneral().getLista().borrarTodasLasHabitaciones();
	}

	public void resetearFiltro() {
		getVistaFiltro().getError().setText("");
		getPanelPrincipal().getVistaFiltro().getDistrito().setSelectedItem(null);
		getPrecioMin().setText("");
		getPrecioMax().setText("");
		getParking().setSelected(false);
		getTerraza().setSelected(false);
		getWifi().setSelected(false);
		getFumador().setSelected(false);
		getMascota().setSelected(false);
		getSoloEstudiantes().setSelected(false);
		getGastosIncluidos().setSelected(false);
	}

	// ------------------------
	// Métodos para Solicitudes
	// ------------------------

	public void anadirListaSolicitudes(List<Solicitud> solicitudes) {
		PanelPrincipal.getSolicitudesVista().getListaSolicitudes().anadirSolicitudes(solicitudes);
	}

	public void borrarTodosLasSolicitudes() {
		PanelPrincipal.getSolicitudesVista().getListaSolicitudes().borrarListaSolicitudes();
	}

	public void buscarBotonAceptarSolicitud() {
		this.getSolicitudesVista().getListaSolicitudes().buscarBotonAceptar();
	}

	public void buscarBotonCancelarSolicitud() {
		this.getSolicitudesVista().getListaSolicitudes().buscarBotonCancelar();
	}
}
