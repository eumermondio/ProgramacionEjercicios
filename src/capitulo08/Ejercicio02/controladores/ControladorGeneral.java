package capitulo08.Ejercicio02.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import capitulo08.Ejercicio02.ConnectionManager;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.entidades.Nota;
import capitulo08.Ejercicio02.entidades.Profesor;
import capitulo08.Ejercicio02.entidades.Sexo;

public class ControladorGeneral {
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
	public static int guardarNota(Nota n) {
		return 0;

	}

	/**
	 * 
	 * @return
	 */
	public static void listadoSexos(List<Sexo> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from tipologiasexo;");
			while (rs.next()) {
				l.add(new Sexo(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoMaterias(List<Materia> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from materia;");
			while (rs.next()) {
				l.add(new Materia(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoProfes(List<Profesor> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from profesor;");
			while (rs.next()) {
				l.add(new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"), rs.getInt("idSexo"), rs.getBytes("imagen"),
						rs.getString("color")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
