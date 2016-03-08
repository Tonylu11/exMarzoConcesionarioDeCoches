package exLuqueBravoAntonio;

/**
 * Crea otra versión de Concesionario de coches, ahora mediante excepciones. Las
 * excepciones que has de lanzar serán:
 * 
 * En coche: MatriculaNoValidaException ColorNoValidoException
 * ModeloNoValidoException En Concesionario: CocheNoExisteException
 * CocheYaExisteException
 * 
 * Algunos detalles con respecto a la nueva versión
 * 
 * Hay que eliminar instanciarCoche() y eliminar la privacidad a los
 * constructores Coche(). Indica por qué. Has de lanzar las excepciones (throw
 * new...) en setMatricula(), setModelo() y setColor(). Indica dónde se tratan
 * Indica los métodos que se interrumpen en cada una de las excepciones Con
 * respecto a Concesionario.annadir() Indica por qué no necesita devolver
 * boolean Indica cuántas excepciones lanza/relanza Simplifica su signatura al
 * máximo no expecificando todas las excepciones de forma explícita (utiliza
 * java.lang.Exception). Indica si varía en algo a la hora de capturarlas. Con
 * respecto a Concesionario.get(), indica qué sucede si el coche no está en el
 * concesionario
 * 
 * Los mensajes de error se basarán en los atributos message de las excepciones
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
