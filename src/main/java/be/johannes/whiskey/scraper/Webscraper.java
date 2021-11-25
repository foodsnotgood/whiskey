package be.johannes.whiskey.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Webscraper {

    public void getElements(String queryString) throws IOException {
        try{
            Document doc = Jsoup.connect("https://www.thewhiskyexchange.com/search?q=" + queryString).get();
            Elements elements = doc.select(".product-card");

        } catch (IOException exception){

        }


    }
}
