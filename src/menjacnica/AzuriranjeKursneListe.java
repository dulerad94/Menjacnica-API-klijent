package menjacnica;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.utility.MenjacnicaUtility;
import komunikacija.JsonRatesAPIKomunikacija;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class AzuriranjeKursneListe {
	private final String putanja="data/kursnaLista.json";
	
	private LinkedList<Valuta> ucitajValute(){
		try {
			FileReader in= new FileReader(putanja);
			Gson gson=new GsonBuilder().create();
			JsonObject mJson=gson.fromJson(in, JsonObject.class);
			Menjacnica m=MenjacnicaUtility.procitajMenjacnicu(mJson);
			in.close();
			return m.getKursnaLista();
		} catch (IOException e) {
			return null;
		}
	}
	private void upisiValute(LinkedList<Valuta> valute, GregorianCalendar datum){
		try {
			FileWriter out=new FileWriter(putanja);
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			JsonObject mJson=MenjacnicaUtility.pisiMenjacnicu(valute, datum);
			out.write(gson.toJson(mJson));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void azurirajValute(){
		LinkedList<Valuta> valute=ucitajValute();
		String[] v=new String[valute.size()];
		for (int i = 0; i < v.length; i++) {
			v[i]=valute.get(i).getNaziv();
		}
		JsonRatesAPIKomunikacija j=new JsonRatesAPIKomunikacija();
		valute=j.vratiIznosKurseva(v);
		upisiValute(valute,new GregorianCalendar());
	}
}
