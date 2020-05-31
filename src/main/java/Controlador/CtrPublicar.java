package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.AccesoBD;
import Modelo.Anuncio;
import Modelo.Distrito;
import Modelo.Excepcion;
import Modelo.Habitacion;
import Modelo.Propietario;
import Modelo.Usuario;
import Vista.Vista;

public class CtrPublicar implements ActionListener {
	private Usuario usuario;
	private Propietario propietario;
	private Vista vista;

    public CtrPublicar(Vista v,Usuario usuario) {
        this.usuario = usuario;
        vista = v;
    }

    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Aceptar")) {
        	try {
        		propietario = new Propietario(usuario);
        		Distrito d = AccesoBD.getInstance().buscarDistrito(vista.getTextoDistrito().getItemAt(vista.getTextoDistrito().getSelectedIndex()));
            	String direccion = vista.getTextoDireccion().getText();
            	String numero = vista.getTextoNumero().getText();
            	String planta = vista.getTextoPlanta().getText();
            	String puerta = vista.getTextoPuerta().getText();
            	String descripcion = vista.getTextoDescripcion().getText();
            	String tamano = vista.getTextoTamano().getText();
            	
            	if(direccion.equals("") || numero.equals("") || planta.equals("") || puerta.equals("") || descripcion.equals("") || tamano.equals("")) {
            		throw new Excepcion("Error falta algun campo");
            	}
            	int num = Integer.parseInt(numero);
            	int plant = Integer.parseInt(planta);
        		int tam = Integer.parseInt(tamano);
        		
        		Habitacion habitacion = new Habitacion (0,direccion,num, plant, puerta, descripcion, tam, 
            			vista.getOpcionParking().isSelected(), vista.getOpcionTerraza().isSelected(),
            			vista.getOpcionWifi().isSelected(), vista.getOpcionFumadores().isSelected(), vista.getOpcionMascotas().isSelected(), vista.getOpcionSoloEstudiantes().isSelected(),
            			vista.getOpcionGastosIncluidos().isSelected(), true, propietario, d);	
            	
        		String precioMes = vista.getTextoPrecioMes().getText();
        		String fianza = vista.getTextoFianza().getText();
        		if(precioMes.equals("") || fianza.equals("")) {
        			throw new Excepcion("Error faltan datos");
        		}
        		
        		Anuncio anuncio = new Anuncio(Double.parseDouble(vista.getTextoPrecioMes().getText()), Double.parseDouble(vista.getTextoFianza().getText()), habitacion);
            	propietario.anadirHabitacion(habitacion);
            	propietario.anadirAnuncio(anuncio);
                vista.anadirHabitacion(anuncio);
                vista.borrarPublicarError();
                vista.borrarTextFieldPublicar();
                vista.getPublicarVista().setVisible(false);
                vista.getGeneral().setVisible(true);
        	}catch (NumberFormatException et) {
        		vista.setPublicarError("Error, formato de los datos");
        	}catch(Excepcion et) {
        		vista.setPublicarError("Error, faltan datos");
        	}


            
        }
    }

}