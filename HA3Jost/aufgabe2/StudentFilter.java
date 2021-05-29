package aufgabe2;

import aufgabe1.Student;

/**
 * Diese Klasse repräsentiert einen Filter für die Suche nach Studenten.
 * @inv. nicht alle Suchkriterien dürfen leer sein
 */
public class StudentFilter {

	private String matrikelNummer;
	private String vorname;
	private String nachname;
	private String ort;
	
	
	/**
	 * Konstruktor für Filter.
	 * @param matrikelNummer die Matrikelnummer (optional)
	 * @param vorname der Vorname (optional)
	 * @param nachname der Nachname (optional)
	 * @param ort der Wohnort (optional)
	 * @pre. nicht alle Attribute sind leer
	 * @post. nicht alle Attribute sind leer
	 */
	public StudentFilter(String matrikelNummer, String vorname, String nachname, String ort) {
		//es erfolgt keine explizite Überprüfung auf die Vorbedingungen
		//damit sind dann aber auch die Nachbedingungen nicht mehr gesichert.
		super();
		this.matrikelNummer = matrikelNummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.ort = ort;
	}
	
	/**
	 * prüft, ob ein <code>Student</code> den Krierien entspricht.
	 * @param student der gegen den Filter zu prüfende Student.
	 * @return true, wenn alle Filterkriterien erfüllt sind, sonst false.
	 * @pre. Es darf kein leeres Studenten-Objekt übergeben werden.
	 */
	public boolean matchFilter(Student student) {
		boolean result = true;
		if (matrikelNummer != null) {
			result = matrikelNummer.equals(student.getMatrikelNummer());
		}
		if (vorname != null) {
			result = vorname.equals(student.getVorname());
		}
		if (nachname != null) {
			result = nachname.equals(student.getNachname());
		}
		if (ort != null) {
			result = ort.equals(student.getOrt());
		}
		return result;
	}
}
