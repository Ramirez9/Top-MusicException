package topMusicException;

import java.util.ArrayList;

public class TopMusic {

	private ArrayList<Cancion> lista = new ArrayList<Cancion>();

	/**
	 * añade una cancion
	 * 
	 * @param posicion
	 * @param cancion
	 * @return msg
	 * @throws topMusicException.IndiceFueraDeRangoException
	 */
	String anadirCancion(int posicion, Cancion cancion) throws topMusicException.IndiceFueraDeRangoException {

		try {
			lista.add(posicion, cancion);
			return "\nCanción introducida.";
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("Error al añadir la cancion. Índice fuera de rango.");
		}

	}

	/**
	 * Borra la cancion
	 * 
	 * @param posicion
	 * @return posicion eliminada
	 * @throws IndiceFueraDeRangoException
	 *             Si el indice está fuera de rango.
	 */
	Cancion borrarCancion(int posicion) throws IndiceFueraDeRangoException {

		try {
			return lista.remove(posicion - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("Error al borrar la cancion. Esta vacia");
		}

	}

	/**
	 * Sube el puesto de la cancion
	 * 
	 * @param posicion
	 * @return msg
	 * @throws IndiceFueraDeRangoException
	 *             Si esta fuera de rango
	 * @throws VaciaException
	 *             Si la lista esta vacia
	 */
	String subirPuesto(int posicion) throws IndiceFueraDeRangoException {

		try {
			lista.add(posicion - 2, lista.get(posicion - 1));
			lista.remove(posicion);
			return "Se ha subido un puesto";
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("Error al subir la cancion. Esta vacia");
		}
	}

	/**
	 * Baja el puesto de la canción
	 * 
	 * @param posicion
	 * @return msg
	 * @throws IndiceFueraDeRangoException
	 *             Si esta fuera de rango
	 * @throws VaciaException
	 *             Si la lista esta vacia
	 */
	String bajarPuesto(int posicion) throws IndiceFueraDeRangoException {

		try {
			Cancion aux = lista.get(posicion);
			lista.set(posicion, lista.get(posicion - 1));
			lista.set(posicion - 1, aux);
			return "Se ha bajado un puesto";
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("Error al bajar la cancion. Esta vacia");
		}
	}

	/**
	 * Muestra la lista
	 * 
	 * @return
	 * @throws IndiceFueraDeRangoException
	 *             Si la lista esta vacia
	 */
	String toStringLista() throws IndiceFueraDeRangoException {
		
		StringBuilder cadena = new StringBuilder();
		try {

			for (Cancion cancion : lista) {

				// Devuelve una referencia este objeto, que es cancion
				cadena.append(cancion);
			}
			return cadena.toString();
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("La lista está vacía");
		}
	}

	/**
	 * Controla la canción más escuchada
	 * 
	 * @param cancion
	 * @return posicion 0
	 * @throws IndiceFueraDeRangoException
	 *             Si la lista esta vacia
	 */
	Cancion masEscuchada() throws IndiceFueraDeRangoException {
		try {
			return lista.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceFueraDeRangoException("La lista está vacía");
		}

	}

	/**
	 * Está vacia
	 * 
	 * @return lista vacia
	 */
	boolean isEmpty() {

		return lista.isEmpty();
	}

	/**
	 * Tamaño
	 * 
	 * @return tamaño de la lista
	 */
	int size() {
		return lista.size();
	}

	/**
	 * seleccionar la posicion del elemento
	 * 
	 * @param posicion
	 * @return elemento posicion
	 */
	Cancion get(int posicion) {
		return lista.get(posicion);
	}
}
