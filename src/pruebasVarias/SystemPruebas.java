package pruebasVarias;

import java.util.Scanner;

public class SystemPruebas {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		System.out.println("A");
		for (int i = 0; i < 50; i++) {
			System.out.println(i + " - " + System.currentTimeMillis());
			Thread.sleep(30);
		}
		System.out.println(System.getLogger("log"));
		System.gc();

		System.out.println("Preparate!");

		Thread.sleep(100);
		System.out.println("AAAAAAAAAAAAAAAAA");
		Thread.sleep(60);
		int c = 0;
		while (true) {
			c++;
			System.out.print((int) Math.round(Math.random() * 9));
			if (c == 150) {
				c = 0;
				System.out.println("");
			}
			Thread.sleep(1);
		}

	}

}
