package Modelo;


public class Propietario extends Usuario {
	
	public int n;
	
	public Propietario(String n, String a, String al, String c, String cont, String nac,String descripcion) {
		super(n, a, al, c, cont, nac);
		this.setDescripcion(descripcion);
	}
	
//	public int anadirHabitacion() {
//		//Habitacion habitacion = new Habitacion(hashCode());
//		//return habitacion.hashCode();
//		return 0;
//	}
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
