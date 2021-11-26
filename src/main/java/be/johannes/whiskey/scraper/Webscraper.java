package be.johannes.whiskey.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Webscraper {

    public void getElements(String queryString) throws IOException {
        try{
            Document doc = Jsoup.connect("https://drankdozijn.be/zoeken?zoekterm=" + queryString).get();
            Elements listOfElements = doc.select("div.animatedParent");
            System.out.println(listOfElements.select("div.animated").size());

        } catch (IOException exception){
            System.out.println(exception);
        }
    }

    public static void main(String[] args) throws IOException {
        Webscraper ws = new Webscraper();
        ws.getElements("oban");
    }
}
