package menjacnica.utility;


import java.util.GregorianCalendar;


public class DatumUtility {
	public static String pisiDatum(GregorianCalendar datum){
		String dan =String.valueOf(datum.get(GregorianCalendar.DAY_OF_MONTH));
		String mesec =String.valueOf(datum.get(GregorianCalendar.MONTH));
		String godina =String.valueOf(datum.get(GregorianCalendar.YEAR));
		if(mesec.length()==1) mesec="0"+mesec;
		return dan+"."+mesec+"."+godina;
	}
	public static GregorianCalendar procitajDatum(String datumJson){
		int godina=Integer.parseInt(datumJson.substring(7, 10));
		int mesec=Integer.parseInt(datumJson.substring(4, 5));
		int dan=Integer.parseInt(datumJson.substring(1, 2));
		return new GregorianCalendar(godina,mesec,dan);
	}
}
