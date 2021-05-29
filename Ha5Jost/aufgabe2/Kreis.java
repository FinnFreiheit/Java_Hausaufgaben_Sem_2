package aufgabe2;

public class Kreis {

	//radius des Kreises.
	private double radius;

	public Kreis(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Getter für Radius des Kreises.
	 * @return Radius des Kreises.
	 */
	public double getRadius() {
		return radius;
	}
	
	public double berechneUmfang() {
		return 2 * radius * Math.PI;
	}
	
	public double berechneFlaeche() {
		return radius * radius * Math.PI;
	}
	
	@Override
	public String toString() {
		return "Kreis mit Radius = " + radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Kreis) {
			Kreis kreis = (Kreis) obj;
			return kreis.getRadius() == getRadius();
		} 
		return false;
	}
	
	@Override
	public int hashCode() {
		return Double.valueOf(radius).hashCode();
	}
}
