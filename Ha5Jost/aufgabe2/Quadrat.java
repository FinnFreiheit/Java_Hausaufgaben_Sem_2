package aufgabe2;

public class Quadrat {

	//Länge einer Kante
	private double kantenLaenge;

	/**
	 * Konstruktor zur Erzeugung eines Quadrats.
	 * @param kantenLaenge charakterische Kantenlänge eines Quadrats
	 */
	public Quadrat(int kantenLaenge) {
		super();
		this.kantenLaenge = kantenLaenge;
	}


	public double getKantenLaenge() {
		return kantenLaenge;
	}
	
	/**
	 * berechnet den Flächeninhalt eines Quadrats.
	 * @return Flächeninhalt des Quadrats.
	 */
	public double berechneFlaeche() {
		return kantenLaenge * kantenLaenge;
	}
	
	/**
	 * berechnet den Umfang eines Quadrats.
	 * @return Umfang des Quadrats.
	 */
	public double berechneUmfang() {
		return 4 * kantenLaenge;
	}
	
	@Override
	public String toString() {
		return "Quadrat mit der Kantenl�nge = " + getKantenLaenge();
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
		if (obj instanceof Quadrat) {
			Quadrat quadrat = (Quadrat) obj;
			return getKantenLaenge() == quadrat.getKantenLaenge();
		}
		if (obj instanceof Rechteck) {
			Rechteck rechteck = (Rechteck) obj;
			return getKantenLaenge() == rechteck.getA() && getKantenLaenge() == rechteck.getB();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = Double.valueOf(kantenLaenge).hashCode();
		//Implementierung synchron zu equals von Rechteck: Es spielt eine Rolle, welche Werte a und b
		//zwei Rechtecke, bei denen eines a = 3 und b = 5 hat und das andere a = 5 und b = 3 sind nicht gleich
		//deren hashCodes sind auch nicht gleich!
		//deswegen wurde für jedes Attribut der Klasse eine eigene Primzahl herangezogen.
		//Hier sieht man aber schön, wie verzwickt es werden kann, wenn man solche nicht offensichtlichen
		//Abhängigkeiten erzeugt!
		return 5 * hashCode + 13 * hashCode;
	}
		
	public static void main(String[] args) {
		Quadrat q1 = new Quadrat(2);
		//System.out.println("Kantenlänge des Quadrats: " + q1.getKantenLaenge() + ", Flächenhinhalt A = " + q1.berechneFlaeche() + ", Umfang U = " + q1.berechneUmfang());
		Quadrat q2 = new Quadrat(2);
		//System.out.println("Kantenlänge des Quadrats: " + q2.getKantenLaenge() + ", Flächenhinhalt A = " + q2.berechneFlaeche() + ", Umfang U = " + q2.berechneUmfang());
		Quadrat q3 = new Quadrat(5);
		//System.out.println("Kantenlänge des Quadrats: " + q3.getKantenLaenge() + ", Flächenhinhalt A = " + q3.berechneFlaeche() + ", Umfang U = " + q3.berechneUmfang());
		
		//Verwendung to toString
		System.out.println(" q1: " + q1.toString());
		System.out.println(" q2: " + q2.toString());
		System.out.println(" q3: " + q3.toString());
		
		//Test auf Gleichheit:
		if (q1 == q2) {
			System.out.println(" q1 == q2 ");
		} else {
			System.out.println(" q1 != q2 ");
		}
		System.out.println(" q1.equals(q2) : " + q1.equals(q2));

		if (q1 == q3) {
			System.out.println(" q1 == q3 ");
		} else {
			System.out.println(" q1 != q3 ");
		}
		System.out.println(" q1.equals(q3) : " + q1.equals(q3));
}
}
