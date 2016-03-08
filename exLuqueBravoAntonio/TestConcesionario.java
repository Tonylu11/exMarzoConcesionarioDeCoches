package exLuqueBravoAntonio;

import utiles.Menu;
import utiles.Teclado;

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
public class TestConcesionario {
	/**
	 * Menu de Concesionario.
	 */
	static Menu menuConcesionario = new Menu("Concesionario IES Gran Capitán.",
			new String[] { "Alta coche.", "Baja coche.", "Mostrar coche.", "Mostrar concesionario.",
					"Número de coches en el concesionario.", "Mostrar coches por color.", "Salir." });
	/**
	 * Menu de colores.
	 */
	static Menu menuColores = new Menu("Colores.", Colores.generarOpcionesMenu());
	/**
	 * Menu de los modelos.
	 */
	static Menu menuModelo = new Menu("Modelo.", Modelo.generarOpcionesMenu());
	/**
	 * Concesionario.
	 */
	static Concesionario concesionario = new Concesionario();

	public static void main(String[] args) {
		gestionarMenuConcesionario();
	}

	/**
	 * Gestiona el menu de concesionario.
	 */
	private static void gestionarMenuConcesionario() {
		int opcion;
		do {
			opcion = menuConcesionario.gestionar();
			switch (opcion) {
			case 1:
				altaCoche();
				break;
			case 2:
				bajaCoche();
				break;
			case 3:
				mostrarCoche();
				break;
			case 4:
				mostrarConcesionario();
				break;
			case 5:
				System.out.println(concesionario.contarCoches());
				break;
			case 6:
				mostrarCochesPorColor();
				break;
			case 7:
				System.out.println("Adiooos...");
				break;
			}
		} while (opcion != 7);
	}

	/**
	 * Muestra los coches que compartan el mismo color.
	 */
	private static void mostrarCochesPorColor() {
		try {
			System.out.println(concesionario.mostrarCochesPorColor(pedirColor()));
		} catch (OpcionInvalidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Muestra el concesionario por completo.
	 */
	private static void mostrarConcesionario() {
		System.out.println(concesionario.mostrarConcesionario());
	}

	/**
	 * Muestra un coche por su matricula.
	 */
	private static void mostrarCoche() {
		try {
			System.out.println(concesionario.getCoche(Teclado.leerCadena("Introduce la matricula del coche.")));
		} catch (CocheNoExisteException | MatriculaInvalidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Da de baja a un coche en el concesionario.
	 */
	private static void bajaCoche() {
		try {
			concesionario.eliminarCoche(Teclado.leerCadena("Introduce la matrícula del coche a eliminar."));
		} catch (CocheNoExisteException | MatriculaInvalidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Da de alta a un coche en el concesionario.
	 */
	private static void altaCoche() {
		try {
			concesionario.annadirCoche(Teclado.leerCadena("Introduce la matrícula del coche."), pedirColor(),
					pedirModelo());
			System.out.println("Coche añadido con exito al concesionario.");
		} catch (MatriculaInvalidaException | CocheExisteException | ColorNoValidoException | ModeloNoValidoException
				| OpcionInvalidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Pide el modelo al usuario.
	 * 
	 * @return Devuelve el modelo que ha sido seleccionado.
	 * @throws OpcionInvalidaException
	 *             Cuando la opcion es invalida.
	 */
	private static Modelo pedirModelo() throws OpcionInvalidaException {
		int opcion = menuModelo.gestionar();
		Modelo[] modelo = Modelo.getValues();
		if (opcion == modelo.length + 1) {
			throw new OpcionInvalidaException("");
		}
		return modelo[opcion - 1];
	}

	/**
	 * Pide el color al usuario.
	 * 
	 * @return Devuelve el color seleccionado.
	 * @throws OpcionInvalidaException
	 *             Cuando la opcion es invalida.
	 */
	private static Colores pedirColor() throws OpcionInvalidaException {
		int opcion = menuColores.gestionar();
		Colores[] colores = Colores.getValues();
		if (opcion == colores.length + 1) {
			throw new OpcionInvalidaException("");
		}
		return colores[opcion - 1];
	}
}
