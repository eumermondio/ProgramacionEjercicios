package capitulo04.bloque02herencia.cuestionario;

public class VyF extends Pregunta {
	protected String respuestaCorrecta;

	/**
	 * 
	 */
	public VyF() {
		super();
	}

	/**
	 * @param respuestaCorrecta
	 */
	public VyF(String respuestaCorrecta) {
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
		return "VyF [getPregunta()=" + getPregunta() + ", getRespuesta()=" + getRespuesta();
	}

}
