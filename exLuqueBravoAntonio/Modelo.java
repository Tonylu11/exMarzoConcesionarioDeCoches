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
public enum Modelo {
	/**
	 * Modelo Leon de la marca Seat.
	 */
	LEON(Marca.SEAT),
	/**
	 * Modelo Ibiza de la marca Seat.
	 */
	IBIZA(Marca.SEAT),
	/**
	 * Modelo Cordoba de la marca Seat.
	 */
	CORDOBA(Marca.SEAT),
	/**
	 * Modelo Serie 1 de la marca BMW.
	 */
	SERIE1(Marca.BMW),
	/**
	 * Modelo Serie 2 de la marca BMW.
	 */
	SERIE2(Marca.BMW),
	/**
	 * Modelo Serie 3 de la marca BMW.
	 */
	SERIE3(Marca.BMW),
	/**
	 * Modelo Serie 5 de la mcarca BMW.
	 */
	SERIE5(Marca.BMW);
	/**
	 * Marca del coche.
	 */
	private Marca marca;

	/**
	 * Constructor del Modelo del coche.
	 * 
	 * @param marca
	 *            Marca del coche.
	 */
	Modelo(Marca marca) {
		setMarca(marca);
	}

	/**
	 * Setter de la marca del coche.
	 * 
	 * @param marca
	 *            Marca del coche.
	 */
	private void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Getter de la marca del coche.
	 * 
	 * @return Devuelve la marca del coche.
	 */
	Marca getMarca() {
		return marca;
	}

	/**
	 * Valores de los modelos del coche.
	 */
	private static final Modelo[] VALUES = values();

	/**
	 * Genera el menu para el modelo del coche.
	 * 
	 * @return Devuelve un array que almacena todas las opciones de los modelos
	 *         de coches.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Getter de los valores de los modelos.
	 * 
	 * @return Devuelve un array con los valores de los modelos.
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}
}
