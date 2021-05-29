package aufgabe1;

/**
 * Fahrzeug erbt von DrivingImpl.
 */
public class Car extends DrivingImpl {

	/**
	 * Erforderlich, da die Ausgabe "Car" liefert.
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Car";
	}
}
