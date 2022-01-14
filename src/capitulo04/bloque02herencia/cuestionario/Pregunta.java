package capitulo04.bloque02herencia.cuestionario;

public class Pregunta {
	protected String pregunta;
	protected String respuestas;

	/**
	 * 
	 */
	public Pregunta() {
		super();
	}

	/**
	 * @param pregunta
	 * @param respuesta
	 */
	public Pregunta(String pregunta, String respuesta) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuesta;
	}

	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuestas;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuestas = respuesta;
	}

}
