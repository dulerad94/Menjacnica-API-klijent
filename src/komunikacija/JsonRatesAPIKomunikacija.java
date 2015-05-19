package komunikacija;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import menjacnica.Valuta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonRatesAPIKomunikacija {
	private static final String kraj = "&to=RSD&apikey=jr-ba8999934fc5a7ab64a4872fb4ed9af7";
	private static final String jsonRatesURL = "http://jsonrates.com/get/";
	
	public LinkedList<Valuta> vratiIznosKurseva(String[] valute){
		LinkedList<Valuta> valuteLista=new LinkedList<>();
		for (int i = 0; i < valute.length; i++) {
			String url=jsonRatesURL+"?from="+valute[i]+kraj;
			String rezultat;
			try {
				rezultat = sendGet(url);
				Gson gson = new GsonBuilder().create();
				JsonObject jsonResult = gson.fromJson(rezultat, JsonObject.class);
				Valuta v=new Valuta();
				v.setNaziv(valute[i]);
				v.setKurs(Double.parseDouble(jsonResult.get("rate").getAsString()));
				valuteLista.add(v);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return valuteLista;
	}
	
	private String sendGet(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		
		boolean endReading = false;
		String response = "";
		
		while (!endReading) {
			String s = in.readLine();
			
			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();
 
		return response.toString();
	}
}
