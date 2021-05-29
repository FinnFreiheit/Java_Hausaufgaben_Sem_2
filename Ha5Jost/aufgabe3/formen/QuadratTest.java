package aufgabe3.formen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aufgabe2.formen.Quadrat;

public class QuadratTest {

	private static final int KANTE = 3;
	private Quadrat sample;
	
	@Before
	public void initialize() {
		//erzeuge für jeden Test eine neue Instanz von Quadrat mit vorgegebener Kantenlänge
		sample = new Quadrat(KANTE);
	}	
	
	@Test
	public void testHashCode() {
		Quadrat test1 = new Quadrat(KANTE);
		//gleicher Hashcode für gleiche Kantenlänge
		assertEquals("hashCode unterscheidet sich für gleiche Kantenlänge", sample.hashCode(), test1.hashCode());
		Quadrat test2 = new Quadrat(4);
		//ungleicher Hashcode für ungleiche Kantenlänge
		assertNotEquals("hashCode unterscheidet sich nicht für unterschiedliche Kantenlänge", sample.hashCode() ,test2.hashCode());
	}

	@Test
	public void testQuadrat() {
		assertNotNull("Klasse konnte nicht instantiiert werden.", sample);
	}

	@Test
	public void testGetKantenLaenge() {
		assertEquals("Falscher Radius", KANTE, sample.getKantenLaenge(), 0);
	}

	@Test
	public void testBerechneFlaeche() {
		assertEquals("Falscher Fläche", 9, sample.berechneFlaeche(), 0.01);
	}

	@Test
	public void testBerechneUmfang() {
		assertEquals("Falscher Umfang", 12, sample.berechneUmfang(), 0.01);
	}

	@Test
	public void testToString() {
		Quadrat test1 = new Quadrat(KANTE);
		//gleicher Zustand für gleiche Kantenlänge
		assertEquals("toString unterscheidet sich für gleiche Kantenlänge", sample.toString(), test1.toString());
		Quadrat test2 = new Quadrat(4);
		//ungleicher Zustand für ungleiche Kantenlänge
		assertNotEquals("toString unterscheidet sich nicht für verschiedene Kantenlänge", sample.toString(), test2.toString());
	}

	@Test
	public void testEqualsObject() {
		Quadrat test1 = new Quadrat(KANTE);
		//equals für gleiche Kantenlänge
		assertTrue("equals unterscheidet sich für gleiche Kantenlänge", sample.equals(test1));
		Quadrat test2 = new Quadrat(4);
		//not equals für ungleiche Kantenlänge
		assertFalse("equals unterscheidet sich nicht für unterschiedliche Kantenlänge", sample.equals(test2));
	}

}
