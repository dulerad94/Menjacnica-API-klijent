package menjacnica;

public class Valuta {
	private String naziv;
	private double kurs;
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getKurs() {
		return kurs;
	}
	public void setKurs(double kurs) {
		this.kurs = kurs;
	}
	@Override
	public String toString() {
		return "Valuta [naziv=" + naziv + ", kurs=" + kurs + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Valuta){
			Valuta v=(Valuta) obj;
			return v.naziv.equals(naziv);
		}
		return false;
	}
}
