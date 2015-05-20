package menjacnica.utility;

import java.util.LinkedList;

import menjacnica.Valuta;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ValutaUtility {
	public static JsonArray pisiValute(LinkedList<Valuta> valute){
		JsonArray valuteJson=new JsonArray();
		for (int i = 0; i < valute.size(); i++) {
			Valuta v=valute.get(i);
			JsonObject vJson=new JsonObject();
			vJson.addProperty("naziv", v.getNaziv());
			vJson.addProperty("kurs",v.getKurs());
			valuteJson.add(vJson);
		}
		return valuteJson;
	}
	public static LinkedList<Valuta> procitajValute(JsonArray valuteJson){
		LinkedList<Valuta> valute=new LinkedList<Valuta>();
		for (int i = 0; i < valuteJson.size(); i++) {
			JsonObject vJson=(JsonObject) valuteJson.get(i);
			Valuta v=new Valuta();
			v.setKurs(vJson.get("kurs").getAsInt());
			v.setNaziv(vJson.get("naziv").getAsString());
			valute.add(v);
		}
		return valute;
	}
}
