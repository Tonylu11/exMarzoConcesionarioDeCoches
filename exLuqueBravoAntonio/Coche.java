package exLuqueBravoAntonio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class Coche {
	/**
	 * Matricula del coche.
	 */
	private String matricula;
	/**
	 * Color del coche.
	 */
	private Colores color;
	/**
	 * Modelo del coche.
	 */
	private Modelo modelo;
	/**
	 * Expresion regular para la validacion de la matricula.
	 */
	private static final String MATRICULA_PATTERN = "^\\d{4}[- ]?[B-Z&&[^EIOUQ]]{3}$";
	/**
	 * Patron para la matricula del coche.
	 */
	private Pattern patron = Pattern.compile(MATRICULA_PATTERN);

	/**
	 * Constructor para Coche.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @param color
	 *            Color del coche.
	 * @param modelo
	 *            Modelo del coche.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula es invalida.
	 * @throws ColorNoValidoException
	 *             Cuando el color no es valido.
	 * @throws ModeloNoValidoException
	 *             Cuando el modelo no es valido.
	 */
	Coche(String matricula, Colores color, Modelo modelo)
			throws MatriculaInvalidaException, ColorNoValidoException, ModeloNoValidoException {
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Costructor para la busqueda del coche por matricula.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula es invalida.
	 */
	Coche(String matricula) throws MatriculaInvalidaException {
		setMatricula(matricula);
	}

	/**
	 * Getter de la matricula del coche.
	 * 
	 * @return Devuelve la matricula del coche.
	 */
	String getMatricula() {
		return matricula;
	}

	/**
	 * Setter de la matricula del coche.
	 * 
	 * @param matricula
	 *            Matricula del coche.
	 * @throws MatriculaInvalidaException
	 *             Cuando la matricula es invalida.
	 */
	private void setMatricula(String matricula) throws MatriculaInvalidaException {
		Matcher matcher = patron.matcher(matricula);
		if (!matcher.matches()) {
			throw new MatriculaInvalidaException(
					"Introduce cuatro n�meros y tres letras que no sean vocales ni Q ni � (1234-BBB � 1234BBB � 1234 BBB).");
		}
		this.matricula = matricula;
	}

	/**
	 * Getter del color del coche.
	 * 
	 * @return Devuelve el color del coche.
	 */
	Colores getColor() {
		return color;
	}

	/**
	 * Setter del color del coche.
	 * 
	 * @param color
	 *            Color del coche.
	 * @throws ColorNoValidoException
	 *             Cuando el color es invalido.
	 */
	private void setColor(Colores color) throws ColorNoValidoException {
		if (color == null) {
			throw new ColorNoValidoException("El color no es v�lido.");
		}
		this.color = color;
	}

	/**
	 * Getter del modelo del coche.
	 * 
	 * @return Modelo del coche.
	 */
	Modelo getModelo() {
		return modelo;
	}

	/**
	 * Setter para el modelo del coche.
	 * 
	 * @param modelo
	 *            Modelo del coche.
	 * @throws ModeloNoValidoException
	 *             Cuando el modelo no es valido.
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null) {
			throw new ModeloNoValidoException("El modelo no es v�lido.");
		}
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n\tMatricula: " + matricula + "\n\tMarca: " + modelo.getMarca() + "\n\tModelo: " + modelo
				+ "\n\tColor: " + color + ".";
	}

}
