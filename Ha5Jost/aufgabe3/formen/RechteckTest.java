package aufgabe3.formen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aufgabe2.formen.Rechteck;

public class RechteckTest {

	private static final int SEITE_A = 3;
	private static final int SEITE_B = 4;
	private Rechteck sample;
	
	@Before
	public void initialize() {
		//erzeuge für jeden Test eine neue Instanz von Rechteck mit vorgegebenen Kantenlängen A und B.
		sample = new Rechteck(SEITE_A, SEITE_B);
	}	

	@Test
	public void testHashCode() {
		Rechteck test1 = new Rechteck(SEITE_A, SEITE_B);
		//gleicher Hashcode für gleiche Kantenlänge
		assertEquals("hashCode unterscheidet sich für gleiche Kantenlängen", sample.hashCode(), test1.hashCode());
		Rechteck test2 = new Rechteck(SEITE_B, SEITE_A);
		//ungleicher Hashcode für ungleiche Kantenlänge
		assertNotEquals("hashCode unterscheidet sich nicht für unterschiedliche Kantenlängen", sample.hashCode() ,test2.hashCode());

	}

	@Test
	public void testRechteck() {
		assertNotNull("Klasse konnte nicht instantiiert werden.", sample);
	}

	@Test
	public void testGetA() {
		assertEquals("Falsche Kantenlänge A", SEITE_A, sample.getA(), 0);
	}

	@Test
	public void testGetB() {
		assertEquals("Falsche Kantenlänge B", SEITE_B, sample.getB(), 0);
	}

	@Test
	public void testBerechneFlaeche() {
		assertEquals("Falsche Fläche", 12, sample.berechneFlaeche(), 0.01);
	}

	@Test
	public void testBerechneUmfang() {
		assertEquals("Falscher Umfang", 14, sample.berechneUmfang(), 0.01);
	}

	@Test
	public void testToString() {
		Rechteck test1 = new Rechteck(SEITE_A, SEITE_B);
		//gleicher Zustand für gleiche Kantenlänge
		assertEquals("toString unterscheidet sich für gleiche Kantenlängen", sample.toString(), test1.toString());
		Rechteck test2 = new Rechteck(SEITE_B, SEITE_A);
		//ungleicher Zustand für ungleiche Kantenlänge
		assertNotEquals("toString unterscheidet sich nicht für verschiedene Kantenlängen", sample.toString(), test2.toString());
	}

	@Test
	public void testEqualsObject() {
		Rechteck test1 = new Rechteck(SEITE_A, SEITE_B);
		//equals für gleiche Kantenlängen
		assertTrue("equals unterscheidet sich für gleiche Kantenlängen", sample.equals(test1));
		Rechteck test2 = new Rechteck(SEITE_B, SEITE_A);
		//not equals für ungleiche Kantenlänge
		assertFalse("equals unterscheidet sich nicht für unterschiedliche Kantenlängen", sample.equals(test2));		
	}

	@Test
	public void testCompareTo() {
		//Rechteck A,B ist gleich wie Rechteck B,A
		Rechteck baRechteck = new Rechteck(SEITE_B, SEITE_A);
		assertEquals("Rechteck A,B ist nicht gleich wie Rechteck B,A", 0, sample.compareTo(baRechteck));
		//Rechteck A,A ist kleiner wie Rechteck A,B
		Rechteck aaRechteck = new Rechteck(SEITE_A, SEITE_A);
		assertEquals("Rechteck A,B ist nicht gleich wie Rechteck B,A", +1, sample.compareTo(aaRechteck));
		//Rechteck B,B ist größer wie Rechteck A,B,
		Rechteck bbRechteck = new Rechteck(SEITE_B, SEITE_B);
		assertEquals("Rechteck A,B ist nicht gleich wie Rechteck B,A", -1, sample.compareTo(bbRechteck));
	}

}
