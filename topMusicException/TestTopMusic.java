package topMusicException;

import utiles.Menu;
import utiles.Teclado;

/**
 * <p>
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá:
 * <li>a. Añadir una canción (en una posición) al TopMusic.
 * <li>b. Sacar un elemento del TopMusic.
 * <li>c. Subir un puesto en el TopMusic.
 * <li>d. Bajar un puesto en el TopMusic.
 * <li>e. Mostrar la lista TopMusic.
 * <li>f. Mostrar la canción más escuchada.
 * <p>
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación.
 * 
 * @author Francisco Ramirez Ruiz
 *
 */
public class TestTopMusic {

	private static TopMusic lista = new TopMusic();

	public static void main(String[] args) {

		introduccion();

	}

	private static void introduccion() {
		String[] opciones = { "Enseñar lista", "Borrar canción", "Subir canción", "Bajar canción",
				"Canción más escuchada", "Añadir canción a la lista", "SALIR" };
		Menu menu = new Menu("\n-------------TOP MUSIC-----------", opciones);

		int opcion=0;
		do {
			try {

				opcion = menu.gestionar();

				casos(opcion);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (opcion != 7);
	}

	/**
	 * Muestra la lista de canciones generadas
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void mostrar() throws IndiceFueraDeRangoException {

		System.out.println(lista.toStringLista());

	}

	/**
	 * Elimina una cancion de la lista segun su posicion
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void eliminar() throws IndiceFueraDeRangoException {

		System.out.println(lista.borrarCancion(mostrarCancion()));

	}

	/**
	 * Sube la cancion segun el puesto y muestra antes la lista
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void sube() throws IndiceFueraDeRangoException {

		System.out.println(lista.subirPuesto(mostrarCancion()));

	}

	/**
	 * Baja la cancion segun el puesto y muestra antes la lista
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void baja() throws IndiceFueraDeRangoException {

		System.out.println(lista.bajarPuesto(mostrarCancion()));

	}

	/**
	 * Muestra la cancion mas escuchada
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void escuchada() throws IndiceFueraDeRangoException {

		System.out.println(lista.masEscuchada());

	}

	/**
	 * Añade una canción segun la posicion preguntada
	 * 
	 * @throws IndiceFueraDeRangoException
	 */
	private static void anadir() throws IndiceFueraDeRangoException {

		System.out.println(lista.anadirCancion(
				Teclado.leerEntero("Introduce una posicion entre 1 y " + (lista.size() + 1) + ": ") - 1,
				crearCancion()));

	}

	/**
	 * Crea una cancion segun el titulo, artista y año
	 * 
	 * @return Cancion generada
	 */
	private static Cancion crearCancion() {

		String titulo = Teclado.leerCadena("Introduce un titulo: ");
		String artista = Teclado.leerCadena("Introduce el artista: ");
		int anio = Teclado.leerEntero("Introduce el año: ");
		Cancion cancion = new Cancion(titulo, artista, anio);
		return cancion;
	}

	/**
	 * Muestra una cancion
	 * 
	 * @return Metodo gestionar de la clase menu
	 */
	private static int mostrarCancion() {

		if (lista.isEmpty()) {
			return -1; // Devuelve -1, por que es una posición que no puede estar.
		}
		String[] opciones = new String[lista.size()];

		for (int i = 0; i < lista.size(); i++) {
			opciones[i] = lista.get(i).toString();
		}
		Menu menu = new Menu("----TOP MUSIC---", opciones);

		return menu.gestionar();
	}

	private static void casos(int opcion) throws IndiceFueraDeRangoException {
		switch (opcion) {
		case 1:
			mostrar(); // Enseña la lista al usuario
			break;
		case 2:
			eliminar(); // Elimina una cancion
			break;
		case 3:
			sube(); // Sube una cancion
			break;
		case 4:
			baja(); // Baja una cancion
			break;
		case 5:
			escuchada(); // Muestra la mas escuchada
			break;
		case 6:
			anadir(); // Añade una canción
			break;
		case 7:
			System.out.println("ADIOS");
			break;
		default:
			System.out.println("\nPor favor introduzca una opción correcta.");
		}
	}
}
