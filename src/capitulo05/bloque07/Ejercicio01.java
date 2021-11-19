package capitulo05.bloque07;

public class Ejercicio01 {

	public static void main(String[] args) {
		int array[] = new int[] { 65, 66, 67, 68, 69, 70, };
		System.out.println(stringFromArray(array));
	}

	public static String stringFromArray(int array[]) {
		char c;
		String str = "";
		int i = 0;
		do {
			c = (char) array[i];
			str = str + c;
			i++;
		} while (i < array.length);
		return str;
	}

}
