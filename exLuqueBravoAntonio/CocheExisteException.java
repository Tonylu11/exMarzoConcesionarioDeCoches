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
public class CocheExisteException extends Exception {
	public CocheExisteException(String message) {
		super(message);
	}
}
