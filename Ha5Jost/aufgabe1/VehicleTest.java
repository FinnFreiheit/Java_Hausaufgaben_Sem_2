package aufgabe1;

/**
 * Die Testklasse, welche die Eigenschaften der <code>Vehicle</code> testet. 
 */
public class VehicleTest {

	/**
	 * Erzeugt Ausgaben auf der Konsole für die Tests der Eigenschaften.
	 * @param vehicle die zu prüfende Vehicle-Instanz.
	 */
    private static void testAbilities(Vehicle vehicle) {
        System.out.println("----> Object: "+vehicle);
        if (vehicle instanceof Driving) {
            System.out.println("Can drive:");
            ((Driving)vehicle).drive();
        }
        if (vehicle instanceof Swimming) {
            System.out.println("Can swim:");
            ((Swimming)vehicle).swim();
        }
    }

    /**
     * Startet Test.
     * @param args keine Eingabeparameter.
     */
    public static void main(String[] args) {
        testAbilities(new Car());
        testAbilities(new Amphibious());
    }
}
