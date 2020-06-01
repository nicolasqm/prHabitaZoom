package Modelo;

public class Propietario extends Usuario {

	public Propietario(String n, String a, String al, String c, String cont, String nac, String descripcion) {
		super(n, a, al, c, cont, nac, descripcion);
	}

	public Propietario(Usuario usuario) {
		this(usuario.getNombre(), usuario.getApellido(), usuario.getAlias(), usuario.getCorreo(),
				usuario.getContrasena(), usuario.getFecha_Nacimiento(), usuario.getDescripcion());
	}

	public void anadirAnuncio(Anuncio anuncio) throws Excepcion {
		AccesoBD accesoBD = AccesoBD.getInstance();
		accesoBD.anadirAnuncio(anuncio);
	}

	public void anadirHabitacion(Habitacion habi) throws Excepcion {
		AccesoBD accesoBD = AccesoBD.getInstance();
		accesoBD.anadirHabitacion(habi);
	}
//	
//	public boolean alquilar(Habitacion habitacion,Inquilino inquilino) {
//		
//		Habitacion aux = new Habitacion(hashCode());
//		boolean res=false;
//		
//		if(aux.hashCode()!=habitacion.hashCode()) {
//			habitacion.setActiva(true);
//			habitacion.setInquilino(inquilino.hashCode());
//			inquilino.setHabitacion(habitacion);
//		}
//		
//		
//		return res;
//	}
//	
}
