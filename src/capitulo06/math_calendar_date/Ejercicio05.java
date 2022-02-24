package capitulo06.math_calendar_date;

import java.util.Calendar;
import java.util.TimeZone;

public class Ejercicio05 {

	public static void main(String[] args) {
		Calendar roma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar washington = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+5"));

		System.out.println("Hora en Roma: " + roma.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora en Washington: " + washington.get(Calendar.HOUR_OF_DAY));
		int x = roma.get(Calendar.HOUR_OF_DAY);
		int y = washington.get(Calendar.HOUR_OF_DAY);
		System.out.println("Diferencia horaria: " + (x - y));

	}
}
