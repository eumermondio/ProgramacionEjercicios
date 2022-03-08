package pruebasVarias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class PruebaDateCalendarSdf {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d.getTime());
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(d.getTime());
		System.out.println("Año: " + Calendar.getInstance().get(Calendar.YEAR));
		System.out.println("Mes: " + Calendar.getInstance().get(Calendar.MONTH));
		System.out.println("Dia: " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		System.out.println(d);
		System.out.println("Hora: " + Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto: " + Calendar.getInstance().get(Calendar.MINUTE));
		System.out.println("Segundo: " + Calendar.getInstance().get(Calendar.SECOND));
		Date d1 = new Date();
		System.out.println("\n\n");

		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(d1.getTime());

		System.out.println("Calendar ant: " + c1.get(Calendar.YEAR) + " date: " + d1);

		c1.add(Calendar.YEAR, 2);
		d1.setTime(c1.getTimeInMillis());

		System.out.println("Calendar dsp: " + c1.get(Calendar.YEAR) + " date: " + d1);

		System.out.println("\nDiff entre fecha: " + Math.abs(d.getTime() - d1.getTime()));
		String str;
		Date i12 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		str = JOptionPane.showInputDialog("Dame una fecha en formato dd/MM/yyyy");
		try {
			i12 = sdf.parse(str);
			System.out.println("Date: " + i12);
			str = sdf.format(d);
			System.out.println(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
