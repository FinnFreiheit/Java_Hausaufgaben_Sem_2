package aufgabe2.student;


import java.util.Date;

/**
 * Fachklasse für einen Studenten.
 */
public class Student implements Comparable<Student> {

	private String vorname;
	private String nachname;
	private String matrikelNummer;
	private String strasse;
	private String plz;
	private String ort;
	private Date immatrikulationsDatum;
	private Date exmatrikulationsDatum;

	/**
	 * Konstruktor für CSV-Datei-Import
	 * 
	 * @param vorname
	 *            Vorname des Studenten.
	 * @param nachname
	 *            Nachname des Studenten.
	 * @param matrikelnummer
	 *            eindeutige Matrikelnummer.
	 * @param strasse
	 *            Strasse der Adresse des Studenten.
	 * @param plz
	 *            Postleitzahl der Adresse des Studenten.
	 * @param ort
	 *            Wohnort der Adresse des Studenten.
	 * @param immatrikulationsDatum
	 *            Datum der Einschreibung.
	 * @param exmatrikulationsDatum
	 *            Datum der Exmatrikulation.
	 */
	public Student(String vorname, String nachname, String matrikelnummer,
			String strasse, String plz, String ort, Date immatrikulationsDatum,
			Date exmatrikulationsDatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelNummer = matrikelnummer;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.immatrikulationsDatum = immatrikulationsDatum;
		this.exmatrikulationsDatum = exmatrikulationsDatum;
	}

	/**
	 * Konstruktor für Erzeugung eines Studenten während der Einschreibung.
	 * 
	 * @param vorname
	 *            Vorname des Studenten.
	 * @param nachname
	 *            Nachname des Studenten.
	 * @param matrikelnummer
	 *            eindeutige Matrikelnummer.
	 * @param strasse
	 *            Strasse der Adresse des Studenten.
	 * @param plz
	 *            Postleitzahl der Adresse des Studenten.
	 * @param ort
	 *            Wohnort der Adresse des Studenten.
	 */
	public Student(String vorname, String nachname, String matrikelnummer,
			String strasse, String plz, String ort) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelNummer = matrikelnummer;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.immatrikulationsDatum = new Date();
		this.exmatrikulationsDatum = null;
	}

	// Methoden
	/**
	 * Führt Exmatrikulation eines immatrikulierten Studenten aus.
	 * @pre Student muss immatrikuliert sein
	 * @after Student ist exmatrikuliert.
	 * @throws ExmatrikulationException wenn Student nicht immatrikuliert war.
	 */
	public void exmatrikulieren() throws ExmatrikulationException {
		if (!isImmatrikuliert()) {
			throw new ExmatrikulationException("nicht immatrikuliert");
		}
		this.exmatrikulationsDatum = new Date();
	}

	/**
	 * Führt für einen exmatrikulierten Studenten eine erneute Immatrikulation aus.
	 * @pre Student muss exmatrikuliert sein.
	 * @after Student ist immatrikuliert. 
	 * @throws ExmatrikulationException wenn Student nicht exmatrikuliert war.
	 */
	public void reImmatrikulieren() throws ExmatrikulationException {
		if (!isExmatrikuliert()) {
			throw new ExmatrikulationException("nicht exmatrikuliert");
		}
		this.immatrikulationsDatum = new Date();
		this.exmatrikulationsDatum = null;
	}
	
	// Eigenschaften

	public boolean isImmatrikuliert() {
		return immatrikulationsDatum != null && exmatrikulationsDatum == null;
	}

	public boolean isExmatrikuliert() {
		return immatrikulationsDatum != null && exmatrikulationsDatum != null;
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
	 * @return the Strasse
	 */
	public String getStrasse() {
		return strasse;
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
	
	@Override
	public int compareTo(Student student) {
		// reduziere Vergleich auf alphanumerischen Vergleich der Matrikelnummern.
		return matrikelNummer.compareTo(student.getMatrikelNummer());
	}
	
}
