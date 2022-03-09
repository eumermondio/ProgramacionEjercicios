package pruebasVarias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PedirFechasConFormato {

	public static void main(String[] args) {
		Date d = null;
		d = pideFechaConFormat("dd/MM/yyyy");
		System.out.println(d);
	}

	private static Date pideFechaConFormat(String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		do {
			try {
				return sdf.parse(JOptionPane.showInputDialog("Intoduzca una fecha con formato dd/MM/yyy:"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}
