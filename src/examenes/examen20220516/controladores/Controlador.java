package examenes.examen20220516.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import examenes.examen20220516.ConnectionManager;
import examenes.examen20220516.entidades.Artista;
import examenes.examen20220516.entidades.Municipio;
import examenes.examen20220516.entidades.Provincia;

public class Controlador {
	/**
	 * 
	 * @return
	 */
	public static void listadoProvincias(List<Provincia> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from provincia;");
			while (rs.next()) {
				l.add(new Provincia(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void filtrarArtista(String cadena, List<Artista> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from artista where nombre like '%" + cadena + "%';");
			while (rs.next()) {
				l.add(new Artista(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBytes(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void cargarMunicipiosDeProvincia(int idProv, List<Municipio> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from municipio where idProvincia = " + idProv + ";");
			while (rs.next()) {
				l.add(new Municipio(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static Provincia cargarProvinciaDeArtista(Artista a) {
		Provincia p = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select p.* from provincia p,artista a,municipio m where p.id = m.idProvincia and m.id = a.idMunicipio and a.id = "
							+ a.getId());
			if (rs.next()) {
				p = new Provincia(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 
	 */
	public static int actualizar(Artista a) {
		int registrosAfectados = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/artistas?serverTimezone=UTC", "java", "Abcdefgh.1");
			PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(
					"UPDATE artista set nombre = ?, idDisciplina = ?, idMunicipio = ?, imagen = ? where id = ?");

			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getIdDisciplina());
			ps.setInt(3, a.getIdMunicipio());
			ps.setBytes(4, a.getImagen());
			ps.setInt(5, a.getId());

			registrosAfectados = ps.executeUpdate();
			ps.close();

			// Cierre de los elementos
			conexion.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return registrosAfectados;
	}

	/**
	 * 
	 */
	public static Municipio cargarMunicipioDeArtista(Artista a) {
		Municipio m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from municipio where id = " + a.getIdMunicipio());
			if (rs.next()) {
				m = new Municipio(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
