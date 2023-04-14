package es.ifp.programacion.ejercicio.retouf4;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private int telefono;
	
	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	public Usuario(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param email
	 * @param telefono
	 */
	public Usuario(String nombre, String apellidos, String dni, String email, int telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		String res =  "Nombre: " + getNombre()+ "\n" + 
				"Apellidos: " + getApellidos()+ "\n" + 
				"dni: " + getDni();
				if(this.email != null) 
					res += "\n" + "Email: " + getEmail() + "\n";
				if(this.telefono != 0) 
					res += "Telefono: " + getTelefono();
		return res;
	}
	
	
}
	
	
