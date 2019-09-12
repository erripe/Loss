package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebApiThread extends Thread {

	public WebApiThread() {
	}

	public void run() {
		try {

			int page = 2;
			String url = "https://www.ourivesariatavares.pt/loja-online/?product-page=" + page;
			Document doc = Jsoup.connect(url).ignoreContentType(true).post();

			// System.out.println(doc.toString());

			// <div data-id="45e517f"
			// "div[data-id=45e517]"
			// Elements div = doc.select("div[data-id=45e517f");

			// System.out.println(div.text());

			for (Element li : doc.select("ul[class=products columns-3]").select("li")) {

				System.out.println(li.text());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
