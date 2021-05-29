package aufgabe3.formen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aufgabe2.formen.Kreis;

public class KreisTest {

	private static final int RADIUS = 3;
	private Kreis sample;
	
	@Before
	public void initialize() {
		//erzeuge für jeden Test eine neue Instanz von Kreis mit vorgegebenem Radius
		sample = new Kreis(RADIUS);
	}
	
	@Test
	public void testHashCode() {
		Kreis test1 = new Kreis(RADIUS);
		//gleicher Hashcode für gleichen Radius
		assertEquals("hashCode unterscheidet sich für gleichen Radius", sample.hashCode(), test1.hashCode());
		Kreis test2 = new Kreis(4);
		//ungleicher Hashcode für ungleichen Radius
		assertNotEquals("hashCode unterscheidet sich nicht für unterschiedlichen Radius", sample.hashCode() ,test2.hashCode());
	}

	@Test
	public void testKreis() {
		assertNotNull("Klasse konnte nicht instantiiert werden.", sample);
	}

	@Test
	public void testGetRadius() {
		assertEquals("Falscher Radius", RADIUS, sample.getRadius(), 0);
	}

	@Test
	public void testBerechneUmfang() {
		assertEquals("Falscher Umfang", 18.85, sample.berechneUmfang(), 0.01);
	}

	@Test
	public void testBerechneFlaeche() {
		assertEquals("Falsche Fläche", 28.27, sample.berechneFlaeche(), 0.01);
	}

	@Test
	public void testToString() {
		Kreis test1 = new Kreis(RADIUS);
		//gleicher Zustand für gleichen Radius
		assertEquals("toString unterscheidet sich für gleichen Radius", sample.toString(), test1.toString());
		Kreis test2 = new Kreis(4);
		//ungleicher Zustand für ungleichen Radius
		assertNotEquals("toString unterscheidet sich nicht für verschiedenen Radius", sample.toString(), test2.toString());
	}

	@Test
	public void testEqualsObject() {
		Kreis test1 = new Kreis(RADIUS);
		//equals für gleichen Radius
		assertTrue("equals unterscheidet sich für gleichen Radius", sample.equals(test1));
		Kreis test2 = new Kreis(4);
		//not equals für ungleichen Radius
		assertFalse("equals unterscheidet sich nicht für unterschiedlichen Radius", sample.equals(test2));
	}

}
