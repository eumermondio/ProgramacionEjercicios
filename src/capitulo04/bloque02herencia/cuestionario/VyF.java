package capitulo04.bloque02herencia.cuestionario;

public class VyF extends Pregunta {
	protected byte respuestaCorrecta;

	/**
	 * 
	 */
	public VyF() {
		super();
	}

	/**
	 * @param respuestaCorrecta
	 */
	public VyF(byte respuestaCorrecta) {
		super();
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "VyF [getPregunta()=" + getPregunta() + ", getRespuesta()="
				+ getRespuesta();
	}

}
