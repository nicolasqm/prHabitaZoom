package Modelo;

public class Inquilino extends Usuario {

	// public Habitacion habitacion;

	public Inquilino(String n, String a, String al, String c, String cont, String nac) {
		super(n, a, al, c, cont, nac);
		// this.habitacion= null;
	}

	public Inquilino(String n, String a, String al, String c, String cont, String nac, String descripcion) {
		super(n, a, al, c, cont, nac);
		this.setDescripcion(descripcion);
	}

	// public Habitacion getHabitacion() { //Este metodo devuelve el codigo de la
	// habitacion, o -1 si aun a este usuario no se le ha asignado ninguna
	// return habitacion;
	// }
	//
	// public void setHabitacion(Habitacion habitacion) { //para asignar una
	// habitacion a un inquilino, le pasamos a esta funcion por parametro
	// this.habitacion = habitacion; //el objeto (esa habitacion) y modificamos la
	// habitacion en cuestion seteandole en el metodo setInquilino
	// //habitacion.setInquilino(this.hashCode()); //el codigo del inquilino
	// }

}
