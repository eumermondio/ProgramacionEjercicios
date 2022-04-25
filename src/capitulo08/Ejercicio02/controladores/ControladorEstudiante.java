package capitulo08.Ejercicio02.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import capitulo08.Ejercicio01.Fabricante;
import capitulo08.Ejercicio02.ConnectionManager;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.vista.GestionCurso;
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
				e = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoCursos(List<Curso> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from curso;");
			while (rs.next()) {
				l.add(new Curso(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static Materia findSiguienteMateria(int idAnterior) {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from materia where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

	/**
	 * 
	 */
	public static int borrarMateria(int id) {
		int rowAffected = 0;
		Materia m = new Materia();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from materia order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s
							.executeQuery("select * from materia where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						m.setId(rs3.getInt(1));
						m.setNombre(rs3.getString(2));
						m.setAcronimo(rs3.getString(3));
						m.setIdCurso(rs3.getInt(4));
						GestionMateria.getInstance().mostrarMateria(m);
					}
				}
			} else {
				m.setId(0);
				m.setNombre("0");
				m.setAcronimo("0");
				m.setIdCurso(0);
				GestionMateria.getInstance().mostrarMateria(m);
			}
			ResultSet rs2 = s.executeQuery("select id from materia order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from materia where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						m.setId(rs4.getInt(1));
						m.setNombre(rs4.getString(2));
						m.setAcronimo(rs4.getString(3));
						m.setIdCurso(rs4.getInt(4));
						GestionMateria.getInstance().mostrarMateria(m);
					}
				}
			} else {
				m.setId(0);
				m.setNombre("0");
				m.setAcronimo("0");
				m.setIdCurso(0);
				GestionMateria.getInstance().mostrarMateria(m);
			}
			rowAffected = s.executeUpdate("delete from materia where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de materias", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static int actualizarMateria(Materia m) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from materia;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (m.getId() == 0) {
				rowAffected = s.executeUpdate("insert into materia values(" + idMax + "," + "'" + m.getNombre() + "','"
						+ m.getAcronimo() + "'," + m.getIdCurso() + ");");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update materia set nombre = " + "'" + m.getNombre() + "', acronimo = '"
						+ m.getAcronimo() + "', curso_id = " + m.getIdCurso() + " where id = " + m.getId() + " ;");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(), "Gestion de materias",
					0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Materia findAnteriorMateria(int idSiguiente) {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from materia where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

	/**
	 * 
	 */
	public static Materia findUltimoMateria() {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from materia order by id desc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

}
