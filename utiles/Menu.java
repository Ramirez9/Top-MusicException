package utiles;

/**
 * Clase que muestra un menu y recoge la opcion introducida
 * 
 * @author Francisco Ramirez
 *
 */
public class Menu {
	/**
	 * Titulo y opciones del menu
	 */
	String titulo;
	String [] opciones;
	
	/**
	 * Constructor de la clase Menu que establece un titulo y las distintas opciones de este
	 * @param titulo Titulo del menu
	 * @param opciones Opciones del menu
	 */
	public Menu(String titulo, String [] opciones) {
		setTitulo(titulo);
		setOpciones(opciones);
	}

	/**
	 * Devuelve el titulo del menu
	 * @return Titulo del  menu
	 */
	private String getTitulo() {
		return titulo;
	}

	/**
	 * Asigna un titulo al campo titulo de la clase
	 * @param titulo
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve un vector con las distintas opciones del menu
	 * @return Vector con las opciones
	 */
	private String[] getOpciones() {
		return opciones;
	}

	/**
	 * Asigna un vector de opciones al vector de la clase
	 * @param opciones Vector con las opciones
	 */
	private void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Muestra el menu y recoge la opcion
	 * @return Opcion recogida por el teclado
	 */
	public int gestionar(){
		mostrar();
		return recogerOpcion();
	}
	
	/**
	 * Muestra el título y las distintas opciones del menu
	 */
	private void mostrar(){
		System.out.println(getTitulo());
		for (int i = 0; i < getOpciones().length; i++) {
			System.out.println("\n\t" + (i+1) + ". " + getOpciones()[i]);
		}
	}
	
	/**
	 * Recoge una opcion por teclado
	 * @return Opcion recogida
	 */
	private int recogerOpcion(){
		return Teclado.leerEntero("\n>>>Opcion: ");
	}
	

}
