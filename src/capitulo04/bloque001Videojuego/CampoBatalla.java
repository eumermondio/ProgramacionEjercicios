package capitulo04.bloque001Videojuego;

public class CampoBatalla {

	private Humano arrayH[] = new Humano[5];
	private Alien arrayA[] = new Alien[5];

	public CampoBatalla() {
		for (int i = 0; i < arrayA.length; i++) {
			arrayA[i] = new Alien();
		}
		Alien ultimoAlien = arrayA[arrayA.length - 1];
		ultimoAlien.setVida(ultimoAlien.getVida() * 2);
	}

}
