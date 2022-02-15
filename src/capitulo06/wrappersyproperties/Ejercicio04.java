package capitulo06.wrappersyproperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Ejercicio04 {

	private static Properties propiedades = null;

	public static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
			try {
				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/capitulo06/wrappersyproperties/ejemplo.properties");
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
		int userLog = Ejercicio04.getIntProperty("USER_LOG_ID");
		String password = Ejercicio04.getProperty("PASSWORD");
		float userTimed = Ejercicio04.getFloatProperty("USER_TIMED_LOGED");
		boolean userConn = Ejercicio04.getBooleanProperty("USER_CONNECTION_STATUS");

		System.out.println(userLog);
		System.out.println(password);
		System.out.println(userTimed);
		System.out.println(userConn);
	}

}
