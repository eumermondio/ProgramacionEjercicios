package capitulo04.bloque02herencia.cuestionario;

public class Estandar extends Pregunta {
	protected String respuestaCorrecta;

	/**
	 * 
	 */
	public Estandar() {
		super();
	}

	/**
	 * @param respuestaCorrecta
	 */
	public Estandar(String respuestaCorrecta) {
		super();
		this.respuestaCorrecta = respuestaCorrecta;
	}

	/**
	 * @return the respuestaCorrecta
	 */
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	/**
	 * @param respuestaCorrecta the respuestaCorrecta to set
	 */
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Estandar [getPregunta()=" + getPregunta() + ", getRespuesta()=" + getRespuesta();
	}

}
