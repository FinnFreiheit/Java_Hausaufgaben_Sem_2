package aufgabe3.student;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import aufgabe2.student.ExmatrikulationException;
import aufgabe2.student.Student;

public class StudentTest {

	private Student sample;
	
	@Before
	public void initialize() {
		sample = new Student("Max", "Mustermann", "123456789", "Mustergasse 3", "12345", "Musterhausen");
	}
	
	@Test
	public void testStudentStringStringStringStringStringStringDateDate() {
		Student test = new Student("Max", "Mustermann", "123456789", "Mustergasse 3", "12345", "Musterhausen", new Date(), new Date());
		assertNotNull(test);
	}

	@Test
	public void testStudentStringStringStringStringStringString() {
		assertNotNull(sample);
	}

	@Test
	public void testExmatrikulieren() {
		try {
			sample.exmatrikulieren();
		} catch (ExmatrikulationException ex) {
			fail("unberechtigt ExmatrikulationException geworfen");		
		}
		try {
			sample.exmatrikulieren();
			fail("keine Exmatrikulationsexception geworfen");
		} catch (ExmatrikulationException ex) {
			assertNotNull(ex);
		}
	}

	@Test
	public void testReImmatrikulieren() {
		try {
			sample.reImmatrikulieren();
			fail("keine Exmatrikulationsexception geworfen");
		} catch (ExmatrikulationException ex) {
			assertNotNull(ex);		
		}
		try {
			sample.exmatrikulieren();
			sample.reImmatrikulieren();
		} catch (ExmatrikulationException ex) {
			fail("unberechtigt ExmatrikulationException geworfen");
		}
	}

	@Test
	public void testIsImmatrikuliert() {
		assertTrue(sample.isImmatrikuliert());
	}

	@Test
	public void testIsExmatrikuliert() throws ExmatrikulationException {
		assertFalse(sample.isExmatrikuliert());
		sample.exmatrikulieren();
		assertTrue(sample.isExmatrikuliert());
	}

	@Test
	public void testGetVorname() {
		assertEquals("Vorname falsch", "Max",  sample.getVorname());
	}

	@Test
	public void testGetNachname() {
		assertEquals("Nachname falsch", "Mustermann",  sample.getNachname());
	}

	@Test
	public void testGetMatrikelNummer() {
		assertEquals("Nachname falsch", "123456789",  sample.getMatrikelNummer());
	}

	@Test
	public void testGetStrasse() {
		assertEquals("Strasse falsch", "Mustergasse 3",  sample.getStrasse());
	}

	@Test
	public void testGetPlz() {
		assertEquals("Plz falsch", "12345",  sample.getPlz());
	}

	@Test
	public void testGetOrt() {
		assertEquals("Ort falsch", "Musterhausen",  sample.getOrt());
	}

	@Test
	public void testGetImmatrikulationsDatum() {
		assertNotNull(sample.getImmatrikulationsDatum());
	}

	@Test
	public void testGetExmatrikulationsDatum() {
		assertNull(sample.getExmatrikulationsDatum());
	}

}
