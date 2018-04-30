package topMusicException;

//import java.util.Calendar;

public class Cancion {
	
	//Calendario para controlar una fecha correcta al añadir cancion
	//private static Calendar fecha = Calendar.getInstance();
    //private static int anioActual = fecha.get(Calendar.YEAR);
	
    private String titulo;
    private String artista;
    private int anio;
 
    public Cancion(String titulo, String artista, int anio) {
        this.titulo = titulo;
        this.artista = artista;
        this.anio = anio;
    }
    /*
    static Cancion getInstance(String titulo, String artista, int anioNuevo) {
        String anio = Integer.toString(anioNuevo);
        //Integer.toString(NUMERO) Controla la fecha segun la hora del sistema.
        
        return new Cancion(titulo, artista, anio);
    }*/
    @Override
    public String toString() {
        return "\n"+titulo+" De "+artista+" Lanzado en el año "+anio;
    }
	
}  