package aufgabe3.student;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aufgabe2.student.Student;
import aufgabe2.student.StudentFilter;
import aufgabe2.student.StudentListe;

public class StudentListeTest {

	private StudentListe sample;
	
	@Before
	public void initialize() {
		//erzeuge für jeden Test eine neue Liste.
		sample = new StudentListe();
	}
	
	@Test
	public void testStudentenListe() {
		assertNotNull("Klasse konnte nicht instantiiert werden.", sample);
		//Klasseninvarianten überprüfen
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
	}

	@Test
	public void testAddStudent() {
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
		Student test = new Student("Max", "Muster", "123456789", "Musterstrasse", "01245", "Musterhausen");
		sample.addStudent(test);
		assertEquals("Liste ist immer noch leer", 1, sample.getAnzahlStudenten());
	}

	@Test
	public void testRemoveStudent() {
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
		Student test = new Student("Max", "Muster", "123456789", "Musterstrasse", "01245", "Musterhausen");
		sample.addStudent(test);
		assertEquals("Liste ist immer noch leer", 1, sample.getAnzahlStudenten());
		sample.removeStudent(test.getMatrikelNummer());
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
	}

	@Test
	public void testGetAnzahlStudenten() {
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
	}

	@Test
	public void testSuche() {
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
		Student test = new Student("Max", "Muster", "123456789", "Musterstrasse", "01245", "Musterhausen");
		sample.addStudent(test);
		assertEquals("Liste ist immer noch leer", 1, sample.getAnzahlStudenten());
		StudentFilter filter = new StudentFilter(test.getMatrikelNummer(), null, null, null);
		Student[] suchErgebnis = sample.suche(filter);
		assertEquals("keine Treffer", 1, suchErgebnis.length);
	}

	@Test
	public void testPrintListe() {
		//keine richtigen Tests möglich, da kein Methodenspezifisches Rückgabeergebnis abgefragt werden kann		
	}

	@Test
	public void testSort() {
		assertEquals("Liste ist nicht leer", 0, sample.getAnzahlStudenten());
		Student maxStudent = new Student("Max", "Ende", "123456789", "Musterstrasse 1", "01245", "Musterhausen");
		sample.addStudent(maxStudent);
		Student tanjaStudent = new Student("Tanja", "Anfang", "234567891", "Irgendwo-Gasse 3", "12345", "Nirgendwo");
		sample.addStudent(tanjaStudent);
		
		//Achtung: Sortierung von Arrays führt zu Nullpointer-Exceptions, wenn Array nicht vollständig gefüllt ist!
		
		//sort sortiert nach Matrikelnummer
		Student[] ergebnis = sample.sort();
		assertSame("nicht nach Matrikelnummer sortiert", maxStudent, ergebnis[0]);
		assertSame("nicht nach Matrikelnummer sortiert", tanjaStudent, ergebnis[1]);
		//sortiere nach Name
		ergebnis = sample.sortName();
		assertSame("nicht nach Nachnamen sortiert", tanjaStudent, ergebnis[0]);
		assertSame("nicht nach Nachnamen sortiert", maxStudent, ergebnis[1]);
		//sortiere nach Ort
		ergebnis = sample.sortOrt();
		assertSame("nicht nach Ort sortiert", maxStudent, ergebnis[0]);
		assertSame("nicht nach Ort sortiert", tanjaStudent, ergebnis[1]);
	}

}
