package menjacnica;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class Menjacnica {
	private GregorianCalendar datum;
	private LinkedList<Valuta> kursnaLista;
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		this.datum = datum;
	}
	public LinkedList<Valuta> getKursnaLista() {
		return kursnaLista;
	}
	public void setKursnaLista(LinkedList<Valuta> kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	
	
}
