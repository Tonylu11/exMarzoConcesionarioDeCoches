package exLuqueBravoAntonio;

/**
 * Crea otra versi�n de Concesionario de coches, ahora mediante excepciones. Las
 * excepciones que has de lanzar ser�n:
 * 
 * En coche: MatriculaNoValidaException ColorNoValidoException
 * ModeloNoValidoException En Concesionario: CocheNoExisteException
 * CocheYaExisteException
 * 
 * Algunos detalles con respecto a la nueva versi�n
 * 
 * Hay que eliminar instanciarCoche() y eliminar la privacidad a los
 * constructores Coche(). Indica por qu�. Has de lanzar las excepciones (throw
 * new...) en setMatricula(), setModelo() y setColor(). Indica d�nde se tratan
 * Indica los m�todos que se interrumpen en cada una de las excepciones Con
 * respecto a Concesionario.annadir() Indica por qu� no necesita devolver
 * boolean Indica cu�ntas excepciones lanza/relanza Simplifica su signatura al
 * m�ximo no expecificando todas las excepciones de forma expl�cita (utiliza
 * java.lang.Exception). Indica si var�a en algo a la hora de capturarlas. Con
 * respecto a Concesionario.get(), indica qu� sucede si el coche no est� en el
 * concesionario
 * 
 * Los mensajes de error se basar�n en los atributos message de las excepciones
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public enum Colores {
	/**
	 * Color plata.
	 */
	PLATA,
	/**
	 * Color rojo.
	 */
	ROJO,
	/**
	 * Color azul.
	 */
	AZUL;
	/**
	 * Array que contiene los colores de los coches.
	 */
	private static final Colores[] VALUES = Colores.values();

	/**
	 * Genera las opciones del menu de colores.
	 * 
	 * @return Devuelve un array con las opciones de los colores del coche.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Colores color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir.";
		return opcionesMenu;
	}

	/**
	 * Getter de los valores de los colores del coche.
	 * 
	 * @return Devuelve un array con los colores.
	 */
	public static Colores[] getValues() {
		return VALUES;
	}
}
