package Modelo;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class AccesoBD {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://database-iis.cobadwnzalab.eu-central-1.rds.amazonaws.com";
	static final String DB_SCHEMA = "habitazoomdb";

	static final String USER = "casero";
	static final String PASS = "recibidor";

	private static Connection conn;

	private static AccesoBD accesoBD = null;

	private AccesoBD() {
		try {
			// create connection for database called DBB_SCHEMA in a server installed in
			// DB_URL, with a user USER with password PASS
			conn = DriverManager.getConnection(DB_URL + "/" + DB_SCHEMA, USER, PASS);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AccesoBD getInstance() {
		if (accesoBD == null) {
			accesoBD = new AccesoBD();
		}
		return accesoBD;
	}

	public Usuario buscarUsuario(String correo) {
		String selectQueryBody = "SELECT * FROM Usuario WHERE Correo=?";
		Usuario res = null;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, correo);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					res = new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(1),
							rs.getString(5), rs.getString(6), rs.getString(7));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void anadirUsuario(Usuario usuario) throws Excepcion {
		String insertBody = "INSERT INTO Usuario (Correo,Nombre,Apellidos,Alias,Contrasena,Fecha_Nacimiento,Descripcion)"
				+ " values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, usuario.getCorreo());
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getApellido());
			preparedStatement.setString(4, usuario.getAlias());
			preparedStatement.setString(5, usuario.getContrasena());
			preparedStatement.setString(6, usuario.getFecha_Nacimiento());
			preparedStatement.setString(7, usuario.getDescripcion());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new Excepcion("No se ha podido añadir al usuario");
		}
	}

	public void updateUsuario(Usuario usuario) throws Excepcion {
		try {
			String updateBody = "UPDATE Usuario SET Nombre = ?, Apellidos = ?, Alias = ?, Contrasena = ?, "
					+ "Fecha_Nacimiento = ?, Descripcion = ? WHERE (Correo = ?)";

			PreparedStatement preparedStatement = conn.prepareStatement(updateBody);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getApellido());
			preparedStatement.setString(3, usuario.getAlias());
			preparedStatement.setString(4, usuario.getContrasena());
			preparedStatement.setString(5, usuario.getFecha_Nacimiento());
			preparedStatement.setString(6, usuario.getDescripcion());
			preparedStatement.setString(7, usuario.getCorreo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new Excepcion("No se ha podido modificar el usuario");
		}
	}

	public List<Habitacion> buscarMisHabitaciones(Propietario prop) {
		String correo = prop.getCorreo();
		String selectQueryBody = "SELECT *" + " FROM Habitacion" + " WHERE Propietario = ?";
		List<Habitacion> res = new ArrayList<Habitacion>();
		Habitacion aux;
		Distrito disAux;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, correo);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					disAux = new Distrito(rs.getString(16), rs.getInt(17));
					aux = new Habitacion(rs.getInt(1), prop, disAux, rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5), rs.getInt(7));
					res.add(aux);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void updateHabitacion(Habitacion habitacion) {
		try {
			String updateBody = "UPDATE Habitacion SET Descripcion = ?, Parking = ?, Terraza = ?, "
					+ "Wifi = ?, Fumadores = ?, Mascotas = ?, Solo_Estudiantes = ?, Gastos_Incluidos = ? "
					+ "WHERE (idHabitacion = ?)";

			PreparedStatement preparedStatement = conn.prepareStatement(updateBody);
			preparedStatement.setString(1, habitacion.getDescripcion());
			preparedStatement.setBoolean(2, habitacion.isParking());
			preparedStatement.setBoolean(3, habitacion.isTerraza());
			preparedStatement.setBoolean(4, habitacion.isWifi());
			preparedStatement.setBoolean(5, habitacion.isFumadores());
			preparedStatement.setBoolean(6, habitacion.isMascotas());
			preparedStatement.setBoolean(7, habitacion.isSoloEstudiantes());
			preparedStatement.setBoolean(8, habitacion.isGastosIncluidos());
			preparedStatement.setInt(9, habitacion.getID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void anadirHabitacion(Habitacion hab) throws Excepcion {
		String insertBody = "INSERT INTO Habitacion (Direccion,Numero,Planta,Puerta,Descripcion,Tamaño,Parking,Terraza,Wifi,Fumadores,Mascotas,Solo_Estudiantes,Gastos_Incluidos,Propietario,DistritoNombre,DistritoCP)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, hab.getDireccion());
			preparedStatement.setInt(2, hab.getNumero());
			preparedStatement.setInt(3, hab.getPlanta());
			preparedStatement.setString(4, hab.getPuerta());
			preparedStatement.setString(5, hab.getDescripcion());
			preparedStatement.setInt(6, hab.getTamano());
			preparedStatement.setBoolean(7, hab.isParking());
			preparedStatement.setBoolean(8, hab.isTerraza());
			preparedStatement.setBoolean(9, hab.isWifi());
			preparedStatement.setBoolean(10, hab.isFumadores());
			preparedStatement.setBoolean(11, hab.isMascotas());
			preparedStatement.setBoolean(12, hab.isSoloEstudiantes());
			preparedStatement.setBoolean(13, hab.isGastosIncluidos());
			preparedStatement.setString(14, hab.getPropietario().getCorreo());
			preparedStatement.setString(15, hab.getDistrito().getNombre());
			preparedStatement.setInt(16, hab.getDistrito().getCodigoPostal());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			int idHabitacion = 0;
			while (rs.next()) {
				idHabitacion = rs.getInt(1);
			}

			hab.setId(idHabitacion);

		} catch (SQLException e) {
			throw new Excepcion("fallo al añadir la habitacion");
		}

	}

	public Vector<String> getDistritos() {
		String selectQueryBody = "SELECT * FROM Distrito";
		Vector<String> res = new Vector<String>();
		res.add("");

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				res.add(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public Distrito buscarDistrito(String nombre) {
		String selectQueryBody = "SELECT * FROM Distrito WHERE Nombre = ?";
		Distrito res = null;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, nombre);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				res = new Distrito(rs.getString(2), rs.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println(", al buscar distrito");
			e.printStackTrace();
		}

		return res;
	}

	public void anadirAnuncio(Anuncio anuncio) throws Excepcion {
		String insertBody = "INSERT INTO Anuncio (idAnuncio,Precio,Fianza,Habitacion)" + " values (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, anuncio.getHabitacion().getID());
			preparedStatement.setDouble(2, anuncio.getPrecioMes());
			preparedStatement.setDouble(3, anuncio.getFianza());
			preparedStatement.setInt(4, anuncio.getHabitacion().getID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new Excepcion("no se ha podido añadir el anuncio");
		}
	}

	public List<Anuncio> filtrar(Distrito distrito, double pMinimo, double pMaximo, boolean parking, boolean terraza,
			boolean wifi, boolean fumadores, boolean mascotas, boolean estudiantes, boolean gastos) {

		String selectQueryBody = "SELECT * "
				+ "FROM Habitacion as H join Anuncio as A on (H.idHabitacion = A.Habitacion) "
				+ "WHERE A.Precio > ? AND A.Precio < ? ";

		if (distrito != null)
			selectQueryBody += "AND H.DistritoNombre = ? ";
		if (parking)
			selectQueryBody += "AND H.Parking = ? ";
		if (terraza)
			selectQueryBody += "AND H.Terraza = ? ";
		if (wifi)
			selectQueryBody += "AND H.Wifi = ? ";
		if (fumadores)
			selectQueryBody += "AND H.Fumadores = ? ";
		if (mascotas)
			selectQueryBody += "AND H.Mascotas = ? ";
		if (estudiantes)
			selectQueryBody += "AND H.Solo_Estudiantes = ? ";
		if (gastos)
			selectQueryBody += "AND H.Gastos_Incluidos = ? ";

		List<Anuncio> res = new LinkedList<Anuncio>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);

			preparedStatement.setDouble(1, pMinimo);
			preparedStatement.setDouble(2, pMaximo);
			int i = 3;

			if (distrito != null) {
				preparedStatement.setString(i, distrito.getNombre());
				i++;
			}
			if (parking) {
				preparedStatement.setBoolean(i, parking);
				i++;
			}
			if (terraza) {
				preparedStatement.setBoolean(i, terraza);
				i++;
			}
			if (wifi) {
				preparedStatement.setBoolean(i, wifi);
				i++;
			}
			if (fumadores) {
				preparedStatement.setBoolean(i, fumadores);
				i++;
			}
			if (mascotas) {
				preparedStatement.setBoolean(i, mascotas);
				i++;
			}
			if (estudiantes) {
				preparedStatement.setBoolean(i, estudiantes);
				i++;
			}
			if (gastos) {
				preparedStatement.setBoolean(i, gastos);
				i++;
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Propietario propietario = new Propietario(buscarUsuario(rs.getString(15)));
				Distrito dist = buscarDistrito(rs.getString(16));

				Habitacion hab = new Habitacion(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14),
						true, propietario, dist);

				Anuncio anuncio = new Anuncio(rs.getDouble(19), rs.getDouble(20), hab);
				res.add(anuncio);

			}

		} catch (SQLException e) {
			System.out.println("fallo al filtrar");
		}
		return res;
	}

	public List<Anuncio> getAnuncios() {
		String selectQueryBody = "SELECT * "
				+ "FROM Habitacion as H join Anuncio as A on (H.idHabitacion = A.Habitacion)";

		List<Anuncio> res = new LinkedList<Anuncio>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Propietario propietario = new Propietario(buscarUsuario(rs.getString(15)));
				Distrito distrito = buscarDistrito(rs.getString(16));

				Habitacion hab = new Habitacion(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14),
						true, propietario, distrito);

				Anuncio anuncio = new Anuncio(rs.getDouble(19), rs.getDouble(20), hab);
				res.add(anuncio);

			}

		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		}
		return res;
	}

	public List<Anuncio> getFavoritos(Usuario u) throws Excepcion {
		String selectQueryBody = "SELECT * " + "FROM Favoritos as F join Anuncio as A on (F.idAnuncio = A.idAnuncio) "
				+ "join Habitacion as H on (H.idHabitacion = F.idAnuncio) " + "WHERE F.correoUsuario = ?";

		List<Anuncio> res = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, u.getCorreo());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Propietario propietario = new Propietario(buscarUsuario(rs.getString(1)));
				Distrito distrito = buscarDistrito(rs.getString(22));
				Habitacion habitacion = new Habitacion(rs.getInt(2), rs.getString(8), rs.getInt(9), rs.getInt(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getBoolean(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19), rs.getBoolean(20),
						true, propietario, distrito);
				Anuncio anuncio = new Anuncio(rs.getDouble(4), rs.getDouble(5), habitacion);
				res.add(anuncio);
			}

		} catch (SQLException e) {
			throw new Excepcion("no se ha podido obtener los favoritos");
		}

		return res;
	}

	public void anadirFavorito(Usuario u, Anuncio a) throws Excepcion {
		String insertBody = "INSERT INTO Favoritos (correoUsuario, idAnuncio)" + " values (?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody);

			preparedStatement.setString(1, u.getCorreo());
			preparedStatement.setInt(2, a.getHabitacion().getID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
		}
	}

	public void eliminarFavorito(Usuario u, Anuncio a) throws Excepcion {
		String deleteBody = "DELETE FROM Favoritos WHERE (correoUsuario = ? AND idAnuncio = ?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(deleteBody);
			preparedStatement.setString(1, u.getCorreo());
			preparedStatement.setInt(2, a.getHabitacion().getID());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new Excepcion("no se ha podido eliminar el favorito");
		}
	}

	public void anadirValoracion(Usuario u, Habitacion hab, int est, String com) throws Excepcion {
		String insertBody = "INSERT INTO Valoracion (Usuario,Habitacion,Estrellas,Comentario)" + " values (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody);

			preparedStatement.setString(1, u.getCorreo());
			preparedStatement.setInt(2, hab.getID());
			preparedStatement.setInt(3, est);
			preparedStatement.setString(4, com);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new Excepcion("no se ha podido añadir el favorito");
		}
	}

	public double obtenerMediaHabitacion(Habitacion habitacion) throws Excepcion {
		String selectBody = "SELECT AVG(Estrellas) FROM Valoracion WHERE Habitacion = ?";
		Double res = null;
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectBody);
			preparedStatement.setInt(1, habitacion.getID());

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				res = rs.getDouble(1);
			}

			if (res == null)
				res = 0.0;

		} catch (SQLException e) {
			throw new Excepcion("no se ha podido obtener la media");
		}
		return res;
	}

	public void enviarSolicitud(Solicitud sol) throws Excepcion {
		String insertBody = "INSERT INTO Solicitud (Fecha_Solicitud,Fecha_Inicio_Alquiler,Fecha_Fin_Alquiler,Estado_Solicitud,Solicitante,Anuncio_Solicitado)"
				+ " values (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertBody);

			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			preparedStatement.setString(1, dt.format(now));
			preparedStatement.setString(2, sol.getFechaInicioAlq());
			preparedStatement.setString(3, sol.getFechaFinAlq());
			preparedStatement.setBoolean(4, false);
			preparedStatement.setString(5, sol.getSolicitante().getCorreo());
			preparedStatement.setInt(6, sol.getAnuncioSolicitado().getHabitacion().getID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new Excepcion("Fechas no validas");
		}
	}

	public List<Solicitud> getSolicitudes(Usuario u) throws Excepcion {
		String selectQueryBody = "SELECT * "
				+ "FROM Solicitud as S join Anuncio as A on (S.Anuncio_Solicitado = A.idAnuncio) "
				+ "join Habitacion as H on (H.idHabitacion = A.idAnuncio) " + "WHERE H.Propietario = ?";

		List<Solicitud> res = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, u.getCorreo());

			ResultSet rs = preparedStatement.executeQuery();

			Propietario propietario;
			Distrito distrito;
			Habitacion habitacion;
			Anuncio anuncio;
			Solicitud solicitud;

			while (rs.next()) {
				propietario = new Propietario(buscarUsuario(rs.getString(5)));
				distrito = buscarDistrito(rs.getString(26));
				habitacion = new Habitacion(rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16), rs.getInt(17), rs.getBoolean(18), rs.getBoolean(19),
						rs.getBoolean(20), rs.getBoolean(21), rs.getBoolean(22), rs.getBoolean(23), rs.getBoolean(24),
						true, propietario, distrito);
				anuncio = new Anuncio(rs.getDouble(8), rs.getDouble(9), habitacion);
				solicitud = new Solicitud(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						propietario, anuncio);
				res.add(solicitud);
			}

		} catch (SQLException e) {
			throw new Excepcion("no se ha podido modificar el estado de la solicitud");
		}

		return res;
	}

}