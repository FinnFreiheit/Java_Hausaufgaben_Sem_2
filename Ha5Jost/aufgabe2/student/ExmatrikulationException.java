package aufgabe2.student;

/**
 * Fachliche Ausnahme, wenn ein Student, welcher nicht immatrikuliert ist versucht wird
 * zu exmatrikulieren.
 */
public class ExmatrikulationException extends Exception {

	/** serial version id.	 */
	private static final long serialVersionUID = 4238964496568817687L;

	public ExmatrikulationException() {
		super();
	}

	public ExmatrikulationException(String message) {
		super(message);
	}
}
