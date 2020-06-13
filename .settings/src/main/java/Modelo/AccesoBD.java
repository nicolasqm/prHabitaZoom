package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoBD {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://database-iis.cobadwnzalab.eu-central-1.rds.amazonaws.com";
	static final String DB_SCHEMA = "habitazoomdb";
	
	static final String USER = "casero";
	static final String PASS = "recibidor";
	
	private static Connection conn;
	
	private static AccesoBD accesoBD = null;
	
	private AccesoBD () {
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
	
	public static AccesoBD getInstance () {
		if (accesoBD == null) {
			accesoBD = new AccesoBD();
		}
		return accesoBD;
	}
	
	public Usuario buscarUsuario (String correo) {
		String selectQueryBody = "SELECT * FROM Usuario WHERE Correo=?";
		Usuario res = null;
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
			preparedStatement.setString(1, correo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					res = new Usuario(rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(1), rs.getString(5), rs.getString(6),rs.getString(7));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void anadirUsuario (Usuario usuario) throws Excepcion {
		String insertBody = "INSERT INTO Usuario (Correo,Nombre,Apellidos,Alias,Contraseña,Fecha_Nacimiento,Descripcion)"
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
			throw new Excepcion("no se ha podido añadir al usuario");
		}
	}
	
	public void updateUsuario (Usuario usuario) {
		try {
			String updateBody = "UPDATE Usuario SET Nombre = ?, Apellidos = ?, Alias = ?, Contraseña = ?, "
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
			e.printStackTrace();
		}
	}
	
	public List<Habitacion> buscarMisHabitaciones(Propietario prop) {
        String correo = prop.getCorreo();
        String selectQueryBody = "SELECT *" + 
                " FROM Habitacion" + 
                " WHERE Propietario = ?";
        List<Habitacion> res = new ArrayList<Habitacion>();
        Habitacion aux;
        Distrito disAux;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, correo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    disAux = new Distrito(rs.getString(16),rs.getInt(17));
                    aux = new Habitacion(rs.getInt(1),prop,disAux,rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(7)); 
                    res.add(aux);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
	
	public void updateHabitacion (Habitacion habitacion) {
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
	
	public void añadirHabitacion (Habitacion hab) {
        String insertBody = "INSERT INTO Habitacion (idHabitacion,Direccion,Numero,Planta,Puerta,Descripcion,Tamaño,Parking,Terraza,Wifi,Fumadores,Mascotas,Solo_Estudiantes,Gastos_Incluidos,Propietario,DistritoNombre,DistritoCP)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, hab.getID());
            preparedStatement.setString(2, hab.getDireccion());
            preparedStatement.setInt(3, hab.getNumero());
            preparedStatement.setInt(4, hab.getPlanta());
            preparedStatement.setString(5, hab.getPuerta());
            preparedStatement.setString(6, hab.getDescripcion());
            preparedStatement.setInt(7, hab.getTamano());
            preparedStatement.setBoolean(8, hab.isParking());
            preparedStatement.setBoolean(9, hab.isTerraza());
            preparedStatement.setBoolean(10, hab.isWifi());
            preparedStatement.setBoolean(11, hab.isFumadores());
            preparedStatement.setBoolean(12, hab.isMascotas());
            preparedStatement.setBoolean(13, hab.isSoloEstudiantes());
            preparedStatement.setBoolean(14, hab.isGastosIncluidos());
            preparedStatement.setString(15, hab.getPropietario().getCorreo());
            preparedStatement.setString(16, hab.getDistrito().getNombre());
            preparedStatement.setInt(17, hab.getDistrito().getCodigoPostal());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
