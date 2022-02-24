package capitulo06.math_calendar_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {

		String str = JOptionPane.showInputDialog("Dime la fecha: ");
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Date d = null;
		try {
			d = sdf.parse(str);
			System.out.println(d);
		} catch (ParseException e) {
			System.out.println("No se pudo parsear la fecha");
			e.printStackTrace();
		}

		System.out.println(d.getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);

		System.out.println("Calendar año: " + cal.get(Calendar.YEAR));
		System.out.println("Date año: " + d.getYear());
		System.out.println("Calendar mes: " + cal.get(Calendar.MONTH));
		System.out.println("Date mes: " + d.getMonth());
		System.out.println("Calendar dia: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Date dia: " + d.getDay());
		System.out.println("Calendar hora: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Date hora: " + d.getHours());
		System.out.println("Calendar hora: " + cal.get(Calendar.MINUTE));
		System.out.println("Date hora: " + d.getMinutes());
		System.out.println("Calendar hora: " + cal.get(Calendar.SECOND));
		System.out.println("Date hora: " + d.getSeconds());

		System.out.println("");

		cal.add(Calendar.DAY_OF_YEAR, 3);
		System.out.println("Calendar año: " + cal.get(Calendar.YEAR));
		System.out.println("Calendar mes: " + cal.get(Calendar.MONTH));
		System.out.println("Calendar dia: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar hora: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Calendar hora: " + cal.get(Calendar.MINUTE));
		System.out.println("Calendar hora: " + cal.get(Calendar.SECOND));
		System.out.println("");
		cal.add(Calendar.WEEK_OF_YEAR, -2);
		System.out.println("Calendar año: " + cal.get(Calendar.YEAR));
		System.out.println("Calendar mes: " + cal.get(Calendar.MONTH));
		System.out.println("Calendar dia: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar hora: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Calendar hora: " + cal.get(Calendar.MINUTE));
		System.out.println("Calendar hora: " + cal.get(Calendar.SECOND));
		System.out.println("");
		cal.add(Calendar.DAY_OF_YEAR, 300);
		System.out.println("Calendar año: " + cal.get(Calendar.YEAR));
		System.out.println("Calendar mes: " + cal.get(Calendar.MONTH));
		System.out.println("Calendar dia: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar hora: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Calendar hora: " + cal.get(Calendar.MINUTE));
		System.out.println("Calendar hora: " + cal.get(Calendar.SECOND));
		System.out.println("");
		cal.add(Calendar.YEAR, 4);
		System.out.println("Calendar año: " + cal.get(Calendar.YEAR));
		System.out.println("Calendar mes: " + cal.get(Calendar.MONTH));
		System.out.println("Calendar dia: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar hora: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Calendar hora: " + cal.get(Calendar.MINUTE));
		System.out.println("Calendar hora: " + cal.get(Calendar.SECOND));
		System.out.println("");

	}

}
