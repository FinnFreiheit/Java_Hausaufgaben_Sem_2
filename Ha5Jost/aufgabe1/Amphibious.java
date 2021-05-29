package aufgabe1;

/**
 * Mehrfach-Vererbung ist in Java nicht möglich.
 * Hingegen können beliebig viele Interfaces implementiert werden.
 * Wird in der Regel durch Delegation-Pattern gelöst.
 * Alternativ hätte man auch von einer implementierenden Instanz erben können und die anderen interfaces implementieren.
 */
public class Amphibious implements Swimming, Driving {

	/** Instanz welche das interface Driving implementiert. */
	private Driving driving;
	
	/** Instanz welche das interface Swimming implementiert. */
	private Swimming swimming;
	
	/**
	 * Default Konstruktor.
	 * Erzeugt die beiden Instanzen für Delegation.
	 */
	public Amphibious() {
		driving = new DrivingImpl();
		swimming = new SwimmingImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void drive() {
		driving.drive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void swim() {
		swimming.swim();
	}

	/**
	 * Erforderlich für die Ausgabe in der Konsole.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Amphibious";
	}
}
