package examenes.examen20220516.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import capitulo08.Ejercicio02.controladores.ControladorGeneral;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.vista.GestionCurso;
import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.entidades.Idioma;
import examenes.examen20220509.entidades.Pais;
import examenes.examen20220509.entidades.Usuario;

public class Controlador {

	/**
	 * EJERCICIO PAISES IDIOMA USUARIOS
	 */

	/**
	 * 
	 * @return
	 */
	public static void listadoPaises(List<Pais> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from pais;");
			while (rs.next()) {
				l.add(new Pais(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoIdiomas(Pais p, List<Idioma> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from idioma where idPais = " + p.getId());
			while (rs.next()) {
				l.add(new Idioma(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String traduccionChkBox(Idioma i) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			if (i != null) {
				ResultSet rs = s.executeQuery("select * from acuerdo where idIdioma = " + i.getId() + ";");

				if (rs.next()) {
					return rs.getString(2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Hubo un fallo en la traducción";
	}

	/**
	 * 
	 */
	public static int maxId(String tabla) {
		int id = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from " + tabla);
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (id + 1);
	}

	/**
	 * 
	 */
	public static boolean comprobarUser(String user) {
		int c = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from usuario where usuario = '" + user + "'");
			if (rs.next()) {
				c++;
			}
			if (c != 0) {
				JOptionPane.showMessageDialog(null, "El nombre de usuario está en uso");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 */
	public static int guardar(Usuario u) {
		int registrosAfectados = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/altausuarios?serverTimezone=UTC", "java", "Abcdefgh.1");
			PreparedStatement ps = (PreparedStatement) conexion
					.prepareStatement("insert into usuario values(?,?,?,?,?)");

			ps.setInt(1, maxId("usuario"));
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getUsuario());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getIdIdioma());

			registrosAfectados = ps.executeUpdate();
			ps.close();

			// Cierre de los elementos
			conexion.close();
		} catch (

		ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return registrosAfectados;
	}

	/**
	 * EJERCICIO 2 EJEMPLOS METODOS
	 */

	/**
	 * 
	 */
	public static Curso findPrimer() {
		Curso c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from curso order by id limit 1");
			if (rs.next()) {
				c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * 
	 */
	public static Curso findSiguiente(int idAnterior) {
		Curso c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from curso where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	* 
	*/
	public static Curso findAnterior(int idSiguiente) {
		Curso c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from curso where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static Curso findUltimo() {
		Curso c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from curso order by id desc limit 1");
			if (rs.next()) {
				c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static int borrar(int id) {
		int rowAffected = 0;
		Curso c = new Curso();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from curso order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s.executeQuery("select * from curso where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						c.setId(rs3.getInt(1));
						c.setDescripcion(rs3.getString(2));
						GestionCurso.getInstance().mostrarCurso(c);
					}
				}
			} else {
				c.setId(0);
				c.setDescripcion("0");
				GestionCurso.getInstance().mostrarCurso(c);
			}
			ResultSet rs2 = s.executeQuery("select id from curso order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from curso where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						c.setId(rs4.getInt(1));
						c.setDescripcion(rs4.getString(2));
						GestionCurso.getInstance().mostrarCurso(c);
					}
				}
			} else {
				c.setId(0);
				c.setDescripcion("0");
				GestionCurso.getInstance().mostrarCurso(c);
			}
			rowAffected = s.executeUpdate("delete from curso where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de cursos", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static void findAll(List<Estudiante> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM estudiante;");
			while (rs.next()) {
				l.add(new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static int actualizar(Estudiante e) {
		int registrosAfectados = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/centroeducativo?serverTimezone=UTC", "java", "Abcdefgh.1");
			if (e.getId() != 0) {
				PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(
						"UPDATE centroeducativo.estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ?, idSexo = ?, imagen = ?,color = ? where id = ?");

				ps.setString(1, e.getNombre());
				ps.setString(2, e.getApellido1());
				ps.setString(3, e.getApellido2());
				ps.setString(4, e.getDni());
				ps.setString(5, e.getDireccion());
				ps.setString(6, e.getEmail());
				ps.setString(7, e.getTlf());
				ps.setInt(8, e.getSexo());
				ps.setBytes(9, e.getImagen());
				ps.setString(10, e.getColor());
				ps.setInt(11, e.getId());

				registrosAfectados = ps.executeUpdate();
				ps.close();
			} else {
				PreparedStatement ps = (PreparedStatement) conexion
						.prepareStatement("insert into estudiante values(?,?,?,?,?,?,?,?,?,?)");

				ps.setInt(1, ControladorGeneral.maxId("estudiante"));
				ps.setString(2, e.getNombre());
				ps.setString(3, e.getApellido1());
				ps.setString(4, e.getApellido2());
				ps.setString(5, e.getDni());
				ps.setString(6, e.getDireccion());
				ps.setString(7, e.getEmail());
				ps.setString(8, e.getTlf());
				ps.setInt(9, e.getSexo());
				ps.setBytes(10, e.getImagen());

				registrosAfectados = ps.executeUpdate();
				ps.close();
			}

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

}
