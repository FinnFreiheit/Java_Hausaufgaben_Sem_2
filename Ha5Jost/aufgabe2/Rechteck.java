package aufgabe2;
import java.util.Arrays;


public class Rechteck implements Comparable<Rechteck> {

	//Länge der Kante a
	private double a;
	
	//Länge der Kante b
	private double b;

	/**
	 * Konstruktor mit Feldern.
	 * @param a Seitenlänge a.
	 * @param b Seitenlänge b.
	 * @pre. die Seitenlängen a und b müssen positiv sein.
	 */
	public Rechteck(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}
	
	/**
	 * berechnet den Flächeninhalt eines Rechtecks.
	 * @return Flächeninhalt des Rechtecks.
	 */
	public double berechneFlaeche() {
		return a * b;
	}
	
	/**
	 * berechnet den Umfang eines Rechtecks.
	 * @return Umfang des Rechtecks.
	 */
	public double berechneUmfang() {
		return 2 * (a + b);
	}
	
	@Override
	public String toString() {
		return "Rechteck mit der Seitenl�nge a = " + getA() + " und b = " + getB();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		// Eine solche Fallunterscheidung ist zulässig, aber verstösst gegen Symmetrie-Betrachtungen
		// Wenn zwei Instanzen nicht von derselben Klasse sind, sollten sie auch nicht als gleich betrachtet werden
		// Es kann aber fachliche Überlegungen geben, die dann im Einzelfall hier zu dokumentieren sind.
		// Hier wird fachlich festgelegt, dass Sonderfälle explizit als gleich behandelt werden sollen.
		// Es muss dann aber auch die hashCode-Methode synchron sein.
		if (obj instanceof Rechteck) {
			Rechteck rechteck = (Rechteck) obj;
			return getA() == rechteck.getA() && getB() == rechteck.getB();
		}
		if (obj instanceof Quadrat) {
			Quadrat quadrat = (Quadrat) obj;
			return getA() == quadrat.getKantenLaenge() && getB() == quadrat.getKantenLaenge();
		}
		return false;
	}

	@Override
	public int hashCode() {
		int aHashCode = Double.valueOf(a).hashCode();
		int bHashCode = Double.valueOf(b).hashCode();
		//Implementierung synchron zu equals: Es spielt eine Rolle, welche Werte a und b
		//zwei Rechtecke, bei denen eines a = 3 und b = 5 hat und das andere a = 5 und b = 3 sind nicht gleich
		//deren hashCodes sind auch nicht gleich!
		//deswegen wurde für jedes Attribut der Klasse eine eigene Primzahl herangezogen.
		return 5 * aHashCode + 13 * bHashCode;
	}
	
	@Override
	public int compareTo(Rechteck o) {
		// Sortierung nach Umfang
		double umfang1 = this.berechneUmfang();
		double umfang2 = o.berechneUmfang();
		if (umfang1 == umfang2) {
			return 0;
		} else if (umfang1 > umfang2) {
			return 1;
		}
		return -1;
	}

	public static String printArray(Rechteck[] array) {
		StringBuilder str = new StringBuilder();
		for (Rechteck rechteck : array) {
			str.append(rechteck.toString());
			str.append("\n");
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		//Beispiel Sortierung intrinischer Methode von Rechtecken nach compareTo
		Rechteck[] eckArray = { new Rechteck(2,2), new Rechteck(3,5), new Rechteck(3,3), new Rechteck(1,1)};
		System.out.println("unsortierte Reihenfolge");
		System.out.println(printArray(eckArray));
		
		System.out.println("sortiert nach comparable");
		Arrays.sort(eckArray);
		System.out.println(printArray(eckArray));
		
		System.out.println("sortiert nach Comparator");
		Arrays.sort(eckArray, new RechteckFlaecheComparator());
		System.out.println(printArray(eckArray));
	}
}
