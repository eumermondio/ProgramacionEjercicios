package capitulo08.Ejercicio02.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import capitulo08.Ejercicio01.Fabricante;
import capitulo08.Ejercicio02.ConnectionManager;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.entidades.Profesor;
import capitulo08.Ejercicio02.entidades.Sexo;
import capitulo08.Ejercicio02.vista.GestionCurso;
import capitulo08.Ejercicio02.vista.GestionEstudiante;
import capitulo08.Ejercicio02.vista.GestionMateria;

public class ControladorEstudiante extends ControladorGeneral {
	/**
	 * 
	 */
	public static Estudiante findPrimer() {
		Estudiante e = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from estudiante order by id limit 1");
			if (rs.next()) {
				e = new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	/**
	 * 
	 */
	public static void findAllEstudiantes(List<Estudiante> l) {
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
	public static Estudiante findSiguiente(int idAnterior) {
		Estudiante e = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from estudiante where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				e = new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;

	}

	/**
	 * 
	 */
	public static int borrar(int id) {
		int rowAffected = 0;
		Estudiante e = new Estudiante();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from estudiante order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s
							.executeQuery("select * from estudiante where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						e.setId(rs3.getInt(1));
						e.setNombre(rs3.getString(2));
						e.setApellido1(rs3.getString(3));
						e.setApellido2(rs3.getString(4));
						e.setDni(rs3.getString(5));
						e.setDireccion(rs3.getString(6));
						e.setEmail(rs3.getString(7));
						e.setTlf(rs3.getString(8));
						GestionEstudiante.getInstance().mostrarEstudiante(e);
					}
				}
			} else {
				e.setId(0);
				e.setNombre("0");
				e.setApellido1("0");
				e.setApellido2("0");
				e.setDni("0");
				e.setDireccion("0");
				e.setEmail("0");
				e.setTlf("0");
				GestionEstudiante.getInstance().mostrarEstudiante(e);
			}
			ResultSet rs2 = s.executeQuery("select id from estudiante order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from estudiante where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						e.setId(rs4.getInt(1));
						e.setNombre(rs4.getString(2));
						e.setApellido1(rs4.getString(3));
						e.setApellido2(rs4.getString(4));
						e.setDni(rs4.getString(5));
						e.setDireccion(rs4.getString(6));
						e.setEmail(rs4.getString(7));
						e.setTlf(rs4.getString(8));
						GestionEstudiante.getInstance().mostrarEstudiante(e);
					}
				}
			} else {
				e.setId(0);
				e.setNombre("0");
				e.setApellido1("0");
				e.setApellido2("0");
				e.setDni("0");
				e.setDireccion("0");
				e.setEmail("0");
				e.setTlf("0");
				GestionEstudiante.getInstance().mostrarEstudiante(e);
			}
			rowAffected = s.executeUpdate("delete from estudiante where id = " + id + ";");
			return rowAffected;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + ex.getErrorCode(),
					"Gestion de estudiantes", 0);
		}
		return rowAffected;
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

	/**
	 * 
	 */
	public static int actualizarkk(Estudiante e) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from estudiante;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (e.getId() == 0) {
				rowAffected = s.executeUpdate("insert into estudiante values(" + idMax + "," + "'" + e.getNombre()
						+ "','" + e.getApellido1() + "','" + e.getApellido2() + "','" + e.getDni() + "','"
						+ e.getDireccion() + "','" + e.getEmail() + "','" + e.getTlf() + "'," + e.getSexo() + ");");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate(
						"update estudiante set nombre = " + "'" + e.getNombre() + "', apellido1 = '" + e.getApellido1()
								+ "', apellido2 = '" + e.getApellido2() + "', dni = '" + e.getDni() + "', direccion = '"
								+ e.getDireccion() + "', email = '" + e.getEmail() + "', telefono = '" + e.getTlf()
								+ "', idSexo = " + e.getSexo() + " where id = " + e.getId() + " ;");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + ex.getErrorCode(),
					"Gestion de estudiantes", 0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Estudiante findAnterior(int idSiguiente) {
		Estudiante e = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from estudiante where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				e = new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;

	}

	/**
	 * 
	 */
	public static Estudiante findUltimo() {
		Estudiante e = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from estudiante order by id desc limit 1");
			if (rs.next()) {
				e = new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;

	}

}
