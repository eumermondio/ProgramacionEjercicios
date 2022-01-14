package capitulo04.bloque02herencia.cuestionario;

public class Estandar extends Pregunta {
	protected byte respuestaCorrecta;

	/**
	 * 
	 */
	public Estandar() {
		super();
	}

	/**
	 * @param respuestaCorrecta
	 */
	public Estandar(byte respuestaCorrecta) {
		super();
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Estandar [getPregunta()=" + getPregunta()
				+ ", getRespuesta()=" + getRespuesta();
	}

}
