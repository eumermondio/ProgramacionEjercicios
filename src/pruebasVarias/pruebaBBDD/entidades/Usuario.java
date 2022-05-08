package pruebasVarias.pruebaBBDD.entidades;

public class Usuario {
	private int id;
	private String email;
	private String usuario;
	private String password;
	private int idIdioma;

	/**
	 * 
	 */
	public Usuario() {
		super();
	}

	/**
	 * @param id
	 * @param email
	 * @param usuario
	 * @param password
	 * @param idIdioma
	 */
	public Usuario(int id, String email, String usuario, String password, int idIdioma) {
		super();
		this.id = id;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.idIdioma = idIdioma;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the idIdioma
	 */
	public int getIdIdioma() {
		return idIdioma;
	}

	/**
	 * @param idIdioma the idIdioma to set
	 */
	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

}
