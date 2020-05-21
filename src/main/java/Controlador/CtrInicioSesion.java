package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Modelo.Excepcion;
import Modelo.Usuario;
import Vista.General;
import Vista.IniciarSesion;
import Vista.Vista;

public class CtrInicioSesion implements ActionListener {

	Vista v;
	Usuario usuario;
	General g;
	JTextField t1,t2;
		
	public CtrInicioSesion(Usuario u,Vista vista,CtrRegistrarse contR) {
		
		usuario=u;
		v=vista;
		g=v.getPanelPrincipal().getGeneral();

		v.setActionListeners(this,contR);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando=e.getActionCommand();
		System.out.println("Evento"+comando);
		if(comando.equals("Iniciar Sesion")) {
			try {
			IniciarSesion is=v.getIniciarSesion();
			t1=is.getTextoUsuario();
			t2=is.getTextoContrasena();
			String correo=t1.getText();
			System.out.println(correo);
			String contraseña=t2.getText();
			Usuario u=Usuario.inicioSesion(correo, contraseña);
			
			
				if(u!=null) {
					System.out.println(u.getAlias());
					v.getIniciarSesion().setVisible(false);
					v.getPanelPrincipal().setVisible(true);
				}
				
			} catch (Excepcion e1) {
				v.getIniciarSesion().setMensajeError(e1.getMessage());
			}
		
		
		}else if(comando.equals("Registrarse")) {
			v.getIniciarSesion().setVisible(false);
			v.getEditarPerfil().setVisible(true);
			
		}
		
	
	}
	}
	
	
	
	
	
	
	

