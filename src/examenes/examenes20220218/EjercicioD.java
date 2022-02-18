package examenes.examenes20220218;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EjercicioD {

	private static Properties propiedades = null;

	public static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
			try {
				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/examenes/examenes20220218/ejercicioD.properties");
				propiedades.load(new FileReader(file));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty(String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}

	/*
	 * 
	 */
	public static boolean getBooleanProperty(String nombrePropiedad) {
		return Boolean.parseBoolean(getPropiedades().getProperty(nombrePropiedad));
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty(String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		int userLog = EjercicioD.getIntProperty("USER_LOG_ID");
		String password = EjercicioD.getProperty("PASSWORD");
		float userTimed = EjercicioD.getFloatProperty("USER_TIMED_LOGED");
		boolean userConn = EjercicioD.getBooleanProperty("USER_CONNECTION_STATUS");

		System.out.println(userLog);
		System.out.println(password);
		System.out.println(userTimed);
		System.out.println(userConn);
	}

}
