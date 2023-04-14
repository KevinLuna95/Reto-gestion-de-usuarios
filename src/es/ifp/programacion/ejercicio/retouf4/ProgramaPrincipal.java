package es.ifp.programacion.ejercicio.retouf4;

import java.util.HashMap;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * Estructuras de datos.
 * Se desea modelar la gestión de usuarios de una empresa. Para ello se define el concepto de
 * usuario con las siguientes características:
 * - Nombre
 * - Apellidos.
 * - DNI.
 * - Correo electrónico
 * - Teléfono.
 * Otros requisitos relativos al comportamiento de la aplicación:
 * • Un usuario podrá ser dado de alta en el sistema a partir de su nombre, apellidos y DNI.
 * • También se podrá dar de alta con todos los datos del usuario.
 * • Se permitirá la modificación de todos sus datos.
 * 5
 * • Crea un programa de pruebas que contenga una estructura de datos en la que haya dos
 * usuarios. La estructura deberá seleccionarse en base a que cada usuario esté asociado a
 * su dni (ya que es un dato único). Esto es, la estructura deberá ser del tipo: 
 * [IMAGEN]
 * Esto significa que tenemos que buscar una estructura de datos de pares clave/valor donde la clave
 * es el DNI y el valor será “algo” que contenga toda la información del usuario correspondiente.
 * • El programa de pruebas deberá mostrar todos los datos, recorriendo la estructura de datos
 * y mostrando en consola la información de los dos usuarios creados.
 * @author Kevin Luna Botey
 *
 */
public class ProgramaPrincipal {

	public static void main(String[] args) {
		char opcion = '0';
		Scanner sc = new Scanner(System.in);
		HashMap<String, Usuario> mapa= new HashMap<String, Usuario>();

		Usuario usuario1 = new Usuario("Pepe","Lopez","48065888M");
		Usuario usuario2 = new Usuario("Antonio","Gomez", "99887766P","antongo2gmail.com",666555444);
		
		mapa.put(usuario1.getDni(), usuario1);
		mapa.put(usuario2.getDni(), usuario2);
		
		do {
			mostrarMenu();
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion){
			case '1':
				crearUsuario(mapa);
				break;
			case '2':
				mostrarUsuarios(mapa);
				break;
			case '3':
				buscarUsuario(mapa);
				break;
			case '4':
				modificarUsuario(mapa);
				break;
			case '5':
				eliminarUsuario(mapa);
				break;
			case '6': 
				System.out.println("Fin del programa");
				break;
			default :System.out.println("Error en el dato");
			break;
			};
			
		} while(opcion != '6');
		
	}
	
	public static void modificarUsuario(HashMap<String, Usuario> mapa) {
		Scanner sc = new Scanner(System.in);
		char opcion = '0';
		String dni = "";
		Usuario usuario;
		System.out.println("Indica el DNI del usuario que desea modificar:");
		dni = sc.nextLine();
		
		if (mapa.containsKey(dni)) {
			usuario = mapa.get(dni);
			do {
			System.out.println("Estas en el menu de MODIFICACION");
			System.out.println("Que deseas modificar?");
			System.out.println("1. Nombre");
			System.out.println("2. Apellidos");
			System.out.println("3. DNI");
			System.out.println("4. Email");
			System.out.println("5. Telefono");
			System.out.println("6. Salir");
			System.out.println("Escoge la opcion");
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion) {
			case '1':System.out.println("Indica el nuevo nombre:");
				usuario.setNombre(sc.nextLine());
				mapa.replace(dni, usuario);
				break;
			case '2':System.out.println("Indica los nuevos apellidos:");
				usuario.setApellidos(sc.nextLine());
				mapa.replace(dni, usuario);
				break;
			case '3':System.out.println("Indica el nuevo DNI:");
				dni = sc.nextLine();
				usuario.setDni(dni);
				mapa.replace(dni, usuario);
				usuario = mapa.get(dni);
				break;
			case '4':System.out.println("Indica el nuevo email:");
				usuario.setEmail(sc.nextLine());
				mapa.replace(dni, usuario);
				break;
			case '5':System.out.println("Indica el nuevo telefono:");
				usuario.setTelefono(Integer.parseInt(sc.nextLine()));
				mapa.replace(dni, usuario);
				break;
			case '6': break;
			default: System.out.println("La opcion no es correcta 6 para salir");
			}
			}while(opcion != '6');
		} else
			System.out.println("El DNI no ha sido encontrado");
	}
	
	public static void mostrarUsuarios(HashMap<String, Usuario> mapa) {
		String tmp = "";
		for(String elemento : mapa.keySet()) {
			tmp +=mapa.get(elemento).toString();
			tmp +="\n"+"----------------------------------"+"\n";
		}
		System.out.println(tmp);
	}
	
	public static void buscarUsuario(HashMap<String, Usuario> mapa){
		String dni = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el DNI que deseas buscar:");
		dni = sc.nextLine();
		
		if(mapa.containsKey(dni))
			System.out.println(mapa.get(dni).toString());
		else
			System.out.println("El DNI no ha sido encontrado");
	}
	
	public static void eliminarUsuario(HashMap<String, Usuario> mapa){
		String dni = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el DNI que deseas eliminar:");
		dni = sc.nextLine();
		
		if(mapa.containsKey(dni)) {
			System.out.println("Esta seguro que desea eliminarlo? S/N");
			if(sc.nextLine().toUpperCase().equals("S")) {
				mapa.remove(dni);
				System.out.println("El DNI "+ dni +" ha sido eliminado correctamente");
			}
			else
				System.out.println("No ha sido eliminado");
		}
		else
			System.out.println("El DNI no ha sido encontrado");
	}
	
	public static void mostrarMenu() {
		System.out.println("===================================================");
		System.out.println("Opciones:");
		System.out.println("1. Crear Usuario");
		System.out.println("2. Ver todos los usuarios");
		System.out.println("3. Buscar un usuario");
		System.out.println("4. Modificar usuario");
		System.out.println("5. Eliminar un usuario");
		System.out.println("6. Salir");
		System.out.println("===================================================");
		System.out.println("Escoge la opcion entre el 1 y el 6");
	}

	public static void crearUsuario(HashMap<String, Usuario> mapa) {
		String nombre = "";
		String apellidos = "";
		String dni = "";
		String email = "";
		int telefono = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del usuario");
		nombre = sc.nextLine();
		System.out.println("Introduce los apellidos del usuario");
		apellidos = sc.nextLine();
		System.out.println("Introduce el DNI del usuario");
		dni = sc.nextLine();
		System.out.println("Quieres intoducir email y telefono? S/N");
		if(sc.nextLine().toUpperCase().equals("S")) {
			System.out.println("Introduce el email del usuario");
			email = sc.nextLine();
			System.out.println("Introduce el telefono del usuario");
			telefono = Integer.parseInt(sc.nextLine());
			Usuario usuario = new Usuario(nombre, apellidos, dni, email, telefono);
			mapa.put(usuario.getDni(), usuario);
			System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos() + " creado correctamente");
		} else {
			Usuario usuario = new Usuario(nombre, apellidos, dni);
			mapa.put(usuario.getDni(), usuario);
			System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos() + " creado correctamente");
		}
	}
	
}


