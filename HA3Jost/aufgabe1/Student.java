package aufgabe1;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Studenten sind eindeutig durch eine 9-stellige Matrikelnummer identifizierbar. 
 * Sie haben ferner einen Vornamen, einen Nachname, eine Anschrift bestehend aus einer Straße, einer Postleitzahl und einem Ort. 
 */
public class Student {

	private String nachname;
	private String vorname;
	private String matrikelNummer;
	private String ort;
	private String plz;
	private Date immatrikulationsDatum;
	private Date exmatrikulationsDatum;
	
	//wird für die Darstellung von Datum verwendet
	//für unterstützte Formate nach Javadoc von SimpleDateFormat goggeln.
	private SimpleDateFormat datumsFormatter = new SimpleDateFormat("dd.MMM yyyy");
	
	/**
	 * Konstruktor für Studenten.
	 * Ein Student existiert erst mit der Immatrikulation, vorher macht es keinen Sinn!
	 * Die Matrikelnummer wird durch das System vergeben und kommt von aussen.
	 * Diese identifiziert einen Studenten eindeutig.
	 * Eine Änderung der Daten ist nur durch spezielle Methoden vorgesehen.
	 * Diese gibt es aktuell noch nicht. 
	 * @inv. Immatrikulationsdatum liegt in der Vergangenheit 
	 * @inv. Exmatrikulationsdatum ist optional, wenn es vorliegt, liegt es nach der Immatrikulation
	 * 
	 * @param nachname der Nachname des Studenten (Pflichtfeld)
	 * @param vorname der Vorname des Studenten (Pflichtfeld)
	 * @param matrikelNummer die identifizierende 9-stellige Matrikelnummer (Pflichtfeld)
	 * @param ort der Wohnort (Pflichtfeld)
	 * @param plz die Postleitzahl des Wohnorts (Pflichtfeld)
	 */
	public Student(String nachname, String vorname, String matrikelNummer, String ort, String plz) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		//Es wird hier nicht explizit geprüft, ob die Matrikelnummer eine valide neunstellige Id ist.
		this.matrikelNummer = matrikelNummer;
		this.ort = ort;
		//Es wird hier nicht explizit geprüft, ob die PLZ eine valide 5 stellige ID ist.
		this.plz = plz;
		//Setze das Immatrikulationsdatum durch das akutelle Datum
		this.immatrikulationsDatum = new Date();
	}


	/**
	 * Student wird exmatrikuliert.
	 * @pre. Student muss immatrikuliert sein (Datum muss vor heutigem Datum liegen und er darf noch nicht exmatrikuliert sein)
	 * @post. Student ist exmatrikuliert (Datum liegt vor und liegt nach dem Immatrikulationsdatum) 
	 * 
	 */
	public void exmatrikulieren() {
		//Student muss immatrikuliert sein!
		if (immatrikulationsDatum == null) {
			System.out.println("Der Student ist noch nicht immatrikuliert");
			return;
		}
		//Student muss noch immatrikuliert sein
		if (exmatrikulationsDatum != null) {
			System.out.println("Der Student ist bereits exmatrikuliert.");
		}
		//Immatrikulationsdatum muss vor dem Exmatrikulationsdatum liegen
		Date now = new Date();
		if (now.before(immatrikulationsDatum)) {
			System.out.println("Der Student ist noch nicht immatrikuliert und kann daher nicht exmatrikuliert werden.");
			return;
		} 
		exmatrikulationsDatum = now;
	}


	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}


	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}


	/**
	 * @return the matrikelNummer
	 */
	public String getMatrikelNummer() {
		return matrikelNummer;
	}


	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}


	/**
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}


	/**
	 * @return the immatrikulationsDatum
	 */
	public Date getImmatrikulationsDatum() {
		return immatrikulationsDatum;
	}


	/**
	 * @return the exmatrikulationsDatum
	 */
	public Date getExmatrikulationsDatum() {
		return exmatrikulationsDatum;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Student [nachname=" + nachname + ", vorname=" + vorname + ", matrikelNummer=" + matrikelNummer
				+ ", ort=" + ort + ", plz=" + plz + ", immatrikulationsDatum=" + formatDate(immatrikulationsDatum)
				+ ", exmatrikulationsDatum=" + formatDate(exmatrikulationsDatum) + "]";
	}

	private String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		return datumsFormatter.format(date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Studenten sind eindeutig durch ihre Matrikelnummer identifiziert.
	 * Hinweis: equals und hashcode müssen immer synchron implementiert sein!
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		//repräsentiert diesselbe Instanz
		if (this == obj) {
			return true;
		}
		//sichere ab, das beide Klassen identisch sind
		//verschiedene Subklassen sollen nicht gleiche Objekte repräsentieren.
		if (obj.getClass() == getClass()) {
			Student student = (Student) obj;
			return getMatrikelNummer().equals(student.getMatrikelNummer()); 
		}
		return false;
	}


	/**
	 * {@inheritDoc}
	 * Hinweis: equals und hashcode müssen immer synchron implementiert sein!
	 */
	@Override
	public int hashCode() {
		//Hashcode des identifizierenden Merkmals
		return matrikelNummer.hashCode();
	}
	
	
	
}
