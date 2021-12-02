package capitulo04.bloque00PrimerosObjetos;

public class GestionaCromos {

	public static void main(String[] args) {

		CromosBaloncesto cromo1 = new CromosBaloncesto("Jordan", 194, 98, 37);
		CromosBaloncesto cromo2 = new CromosBaloncesto("Kobe Bryant", 198, 96, 81);
		CromosBaloncesto cromo3 = new CromosBaloncesto("Stephen Curry", 188, 86, 50);
		CromosBaloncesto cromo4 = new CromosBaloncesto("Muresan", 231, 147, 31);
		CromosBaloncesto cromo5 = new CromosBaloncesto("Paul Gasol", 215, 113, 45);

		System.out.println(cromo1.toString());
		System.out.println(cromo2.toString());
		System.out.println(cromo3.toString());
		System.out.println(cromo4.toString());
		System.out.println(cromo5.toString());

	}

}
