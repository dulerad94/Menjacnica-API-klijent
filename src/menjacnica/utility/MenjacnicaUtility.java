package menjacnica.utility;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.Menjacnica;
import menjacnica.Valuta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MenjacnicaUtility {
	public static JsonObject pisiMenjacnicu(LinkedList<Valuta> valute,GregorianCalendar datum){
		JsonObject mJson=new JsonObject();
		mJson.addProperty("datum",DatumUtility.pisiDatum(datum));
		mJson.add("kursnaLista", ValutaUtility.pisiValute(valute));
		return mJson;
	}
	public static Menjacnica procitajMenjacnicu(JsonObject mJson){
		Menjacnica m= new Menjacnica();
		String datumJson=mJson.get("datum").toString();
		m.setDatum(DatumUtility.procitajDatum(datumJson));
		JsonArray valuteJson=(JsonArray) mJson.get("kursnaLista");
		m.setKursnaLista(ValutaUtility.procitajValute(valuteJson));
		return m;
	}
}
