package aufgabe2.student;

import java.util.Comparator;

/**
 * Sortiert Instanzen von <code>Student</code> nach dem Wohnort.
 */
public class OrtComparator implements Comparator<Student> {

	/**
	 * Sortiert Instanzen von <code>Student</code> nach dem Wohnort.
	 * @param o1 erste Referenz für Vergleich.
	 * @param o2 zweite Referenz für Vergleich.
	 * @return {@inheritDoc} bgzl. dem Kriterium Ort.
	 */
	@Override
	public int compare(Student o1, Student o2) {
		//reduziere Problem auf den Vergleich von Strings
		return o1.getOrt().compareTo(o2.getOrt());
	}

	
}
