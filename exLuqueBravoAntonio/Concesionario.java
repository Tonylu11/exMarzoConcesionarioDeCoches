package exLuqueBravoAntonio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
public class Concesionario {
	/**
	 * ArrayList donde se almacenaran todos los coches del concesionario.
	 */
	static ArrayList<Coche> concesionario = new ArrayList<Coche>();

	/**
	 * A&ntilde;ade un coche al concesionario.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @param color
	 *            Color del coche.
	 * @param modelo
	 *            Modelo del coche.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula es invalida.
	 * @throws CocheExisteException
	 *             Cuando el coche no existe en el concesionario.
	 * @throws ColorNoValidoException
	 *             Cuando el color no es valido.
	 * @throws ModeloNoValidoException
	 *             Cuando el modelo no es valido.
	 */
	void annadirCoche(String matricula, Colores color, Modelo modelo)
			throws MatriculaInvalidaException, CocheExisteException, ColorNoValidoException, ModeloNoValidoException {
		if (concesionario.contains(new Coche(matricula))) {
			throw new CocheExisteException("El coche ya existe en el concesionario.");
		}
		concesionario.add(new Coche(matricula, color, modelo));
	}

	/**
	 * Elimina un coche del concesionario.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @throws CocheNoExisteException
	 *             Cuando el coche no existe en el concesionario.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula no es valida.
	 */
	void eliminarCoche(String matricula) throws CocheNoExisteException, MatriculaInvalidaException {
		if (!concesionario.contains(new Coche(matricula))) {
			throw new CocheNoExisteException("El coche no existe en el concesionario.");
		}
		concesionario.remove(new Coche(matricula));
	}

	/**
	 * Muestra un coche del concesionario.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @return Devuelve el coche encontrado por su matricula.
	 * @throws CocheNoExisteException
	 *             Cuando el coche no existe en el concesionario.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula no es valida.
	 */
	Coche getCoche(String matricula) throws CocheNoExisteException, MatriculaInvalidaException {
		if (!concesionario.contains(new Coche(matricula))) {
			throw new CocheNoExisteException("El coche no existe en el concesionario.");
		}
		return concesionario.get(concesionario.indexOf(new Coche(matricula)));
	}

	/**
	 * Muestra todo el concesionario.
	 * 
	 * @return Cadena que concatena todos los coches del concesionario.
	 */
	String mostrarConcesionario() {
		Iterator<Coche> it = concesionario.iterator();
		String cadena = "";
		int i = 1;
		while (it.hasNext()) {
			cadena += "Coche número " + i++ + ": " + it.next() + "\n";
		}
		return cadena;
	}

	/**
	 * Cuenta los coches que hay en el concesionario.
	 * 
	 * @return Devuelve una cadena con los coches del concesionario.
	 */
	String contarCoches() {
		return "Hay " + concesionario.size() + " coches en el concesionario.";
	}

	/**
	 * Muestra los coches por su color.
	 * 
	 * @param color
	 *            Color del coche.
	 * @return Devuelve una cadena con los coches con identico color.
	 */
	String mostrarCochesPorColor(Colores color) {
		ListIterator<Coche> li = concesionario.listIterator();
		String cadena = "";
		while (li.hasNext()) {
			Coche coche = li.next();
			if (coche.getColor().equals(color))
				cadena += "" + coche.toString();
		}
		return cadena;
	}
}
