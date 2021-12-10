package capitulo04.bloque001Videojuego;

public class CampoBatalla {

	private Humano arrayH[] = new Humano[5];
	private Alien arrayA[] = new Alien[5];

	public CampoBatalla() {
		crearAlien();
		crearHumano();
	}

	public void crearAlien() {
		for (int i = 0; i < arrayA.length; i++) {
			arrayA[i] = new Alien();
		}
		Alien ultimoAlien = arrayA[arrayA.length - 1];
		ultimoAlien.setVida(ultimoAlien.getVida() * 2);
	}

	public void crearHumano() {
		for (int i = 0; i < arrayH.length; i++) {
			arrayH[i] = new Humano();
		}
		Humano ultimoHumano = arrayH[arrayH.length - 1];
		ultimoHumano.setVida(ultimoHumano.getVida() * 2);
	}

}
