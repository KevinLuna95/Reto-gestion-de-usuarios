package es.ifp.programacion.ejercicio.retouf4;

public class Dni {
	private String dni;
	
	public Dni(String dni) {
		this.dni=dni;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	
	public Boolean checkDni() {
		char[] a;
		int num = 0;
		boolean resultado = false;
		char letra = 0;
		
		a = this.dni.toCharArray();
		int size = a.length;
		for(int i=0;i<size;i++) {
			if(i <= 7)
				num += a[i];
			else
				letra = a[i];
		}
		System.out.println(num);
		
		
		return true;
	}
	
}
