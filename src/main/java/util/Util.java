package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Util {

	public static void updateList(String[] textField) throws Exception {
		final String KEY = "5e639b55f80d8d6e0dbae529ebd8c6ae";

		String ws;

		if (textField.length == 0) {
			ws = "https://www.food2fork.com/api/search?key=" + KEY;
		} else {
			ws = "https://www.food2fork.com/api/search?key=" + KEY + "&q=";
			for (int i = 0; i < textField.length; i++) {
				if (i == 0) {
					ws += textField[i];
				} else {
					ws += "%20" + textField[i];
				}
			}
		}

		URLConnection url = new URL(ws).openConnection();
		url.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.10; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

		InputStreamReader in = new InputStreamReader(url.getInputStream());
		BufferedReader br = new BufferedReader(in);

		String data = "";
		while (br.ready()) {
			data += br.readLine();

		}
	}
}
