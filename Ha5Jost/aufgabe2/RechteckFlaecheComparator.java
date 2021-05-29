package aufgabe2;
import java.util.Comparator;


public class RechteckFlaecheComparator implements Comparator<Rechteck> {

	@Override
	public int compare(Rechteck o1, Rechteck o2) {
		double flaeche1 = o1.berechneFlaeche();
		double flaeche2 = o2.berechneFlaeche();
		if (flaeche1 == flaeche2) {
			return 0;
		}
		if (flaeche1 > flaeche2) {
			return 1;
		}
		return -1;
	}

}
