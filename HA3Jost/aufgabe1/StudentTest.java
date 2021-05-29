package aufgabe1;

import java.util.Date;

/**
 * Testklasse für Klasse <code>Student</code>.
 * Es sollen alle Anforderungen getestet werden 
 * durch Kontrolle der Text-Ausgaben auf die Konsole.
 */
public class StudentTest {

	/**
	 * Test der Klasse <code>Student</code>.
	 * @param args keine Start-Parameter.
	 */
	public static void main(String[] args) {
		//Prüfung der Invarianten nach Erzeugung der Klasse
		Student student = new Student("Muster", "Max", "123456789", "Stuttgart", "70125");
		//Studenten haben immer ein Immatrikulationsdatum
		//Immatrikulationsdatum liegt nicht in der Zukunft
		boolean result = testeKlasseninvarianten(student);
		if (result) {
			//fahre mit erweiterten Test-Szenarien fort
			Date exmatrikulationsDatum = student.getExmatrikulationsDatum();
			if (exmatrikulationsDatum != null) {
				System.out.println("Ein neu erzeugter Student darf noch kein Exmatrikulationsdatum haben!");
				result = false;
			}
			student.exmatrikulieren();
			if (exmatrikulationsDatum != null) {
				System.out.println("Ein exmatrikulierter Student muss ein Exmatrikulationsdatum haben!");
				result = false;
			}			
			//zweimal exmatrikulieren
			student.exmatrikulieren();
			//--> Bitte die Konsolenausgaben prüfen: Hier muss eine Fehlermeldung kommen aus der Methoden-Implementierung
			//Abschluss-Prüfung
			if (result) {
				System.out.println("Gratulation, diese Implementierung von Student hat alle Tests bestanden.");
			} else {
				System.out.println("Schade, diese Implementierung von Student hat nicht alle Tests bestanden.");
			}
		} else {
			System.out.println("Schade, diese Implementierung von Student hat nicht alle Tests bestanden.");
		}
	}

	/**
	 * Diese Funktion testet die Invarianten einer Studentenklasse.
	 * @param student die zu testende Instanz von Student.
	 * @return true, wenn erfolgreich getestet, sonst false.
	 */
	private static boolean testeKlasseninvarianten(Student student) {
		boolean validStudent = true;
		Date immatrikulationsDatum = student.getImmatrikulationsDatum();
		Date exmatrikulationsDatum = student.getExmatrikulationsDatum();
		if (immatrikulationsDatum == null) {
			System.out.println("Inkonsistenter Zustand der Klasse, ein Student ohne Immatrikulationsdatum darf es nicht geben");
			validStudent = false;
		} else {
			//Immatrikulationsdatum darf nicht in der Zukunft liegen
			Date now = new Date();
			if (now.before(student.getImmatrikulationsDatum())) {
				System.out.println("Immatrikulationsdatum darf nicht in der Zukunft liegen");
				validStudent = false;
			}
				
		}
		//Exmatrikulationsdatum ist optional und falls vorhanden liegt es nach dem Immatrikulationsdatum		
		if (exmatrikulationsDatum != null && student.getExmatrikulationsDatum().before(immatrikulationsDatum)) {
			System.out.println("Das Exmatrikulationsdatum darf nicht vor dem Immatrikulationsdatum liegen.");
			validStudent = false;
		}
		return validStudent;
	}
}
