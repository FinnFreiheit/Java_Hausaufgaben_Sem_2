package aufgabe2;

import aufgabe1.Student;

/**
 * Diese Klasse testet die Klasse <code>StudentenListe</code>.
 */
public class StudentenListeTest {

	/**
	 * testet die Implementierung von <code>StudentenListe</code>.
	 * @param args keine Start-Parameter.
	 */
	public static void main(String[] args) {
		
		StudentenListe liste = new StudentenListe();
		//für den Test der Liste fehlen nun Methoden, die für die eigentliche Funktion nicht erforderlich sind
		//a) eine Ausgabe des Inhalts
		//b) eine Ausgabe der Anzahl der enthaltenen Studenten
		//Nach der Implementierung muss die Liste leer sein
		int anz = liste.getAnzahlStudenten();
		if (anz > 0) {
			System.out.println("Eine neue instanziierte Liste darf noch keine Elemente enthalten");
		}
		//füge einen Studenten der Liste hinzu
		liste.addStudent(generateDummyStudent(0));
		if (liste.getAnzahlStudenten() != 1) {
			System.out.println("Der Student wurde nicht hinzugefügt.");
		}
		//füge denselben Studenten nochmal hinzu
		liste.addStudent(generateDummyStudent(0));
		if (liste.getAnzahlStudenten() == 2) {
			System.out.println("Derselbe Student wurde zweimal hinzugefügt!");
		}
		
		//Wähle eine Anzahl größer als MAX_ANZAHL_STUDENT (10)
		for (int i = 1; i < 20; i++) {
			liste.addStudent(generateDummyStudent(i));
		}
		//Prüfe, dass die Anzahl nicht größer als MAX_ANZAHL_STUDENT (10) ist.
		if (liste.getAnzahlStudenten() > 10) {
			System.out.println("Es wurden zuviele Studenten der Liste hinzugefügt");
		}
		//prüfe Suche
		String matrikelNummer = formatMatrikelNummer(5);
		StudentFilter filterMatrikelNummer = new StudentFilter(matrikelNummer, null, null, null);
		Student[] sucheMatrikelNummer = liste.suche(filterMatrikelNummer);
		System.out.println("Suche nach Matrikelnummer " + matrikelNummer + ":");
		for (Student student : sucheMatrikelNummer) {
			//hinweis: es dürfen keine Lücken im Ergebnis sein!
			System.out.println(student.toString());
			if (!student.getMatrikelNummer().equals(matrikelNummer)) {
				System.out.println("Die Suche nach der Matrikelnummer hat ein falsches Ergebnis geliefert.");
			}
		}
		
		StudentFilter filterStuttgart = new StudentFilter(null, null, null, "Stuttgart");
		Student[] sucheStuttgart = liste.suche(filterStuttgart);
		System.out.println("Suche nach Wohnort Stuttgart:");
		for (Student student : sucheStuttgart) {
			//hinweis: es dürfen keine Lücken im Ergebnis sein!
			System.out.println(student.toString());
			if (!student.getOrt().equals("Stuttgart")) {
				System.out.println("Die Suche nach Ort 'Stuttgart' hat ein falsches Ergebnis geliefert.");
			}
		}
		
		//Systemausgabe:
		System.out.println();
		liste.printListe();
	}
	
	/**
	 * erzeugt Test-instanzen von Student.
	 * @param i laufender Index für Erzeugung der Studenten-Instanzen.
	 * @return Test-Instanz von Student.
	 */
	private static Student generateDummyStudent(int i) {
		if (i % 2 == 0) {
			return new Student("Muster" + i, "Max", formatMatrikelNummer(i), "Stuttgart", "70100");
		}
		return new Student("Maier" + i, "Tanja", formatMatrikelNummer(i), "Karlsruhe", "75100");
	}
	
	/**
	 * erzeugt eine 9-stellige Matrikelnummer aus einer übergebenen kleineren Zahl.
	 * @param nummer die zu formatierende Nummer.
	 * @return 9-stellige Matrikelnummer.
	 */
	private static String formatMatrikelNummer(int nummer) {
		String matrikelnummer = "";
		int length = String.valueOf(nummer).length();
		for (int i = 0; i < 9 - length; i++) {
			matrikelnummer += i;
		}
		return matrikelnummer + nummer;
	}
}
