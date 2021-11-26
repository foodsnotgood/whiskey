package be.johannes.whiskey.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Webscraper {

    public ArrayList<ScrapedWhiskyInList> getElements(String queryString) throws IOException {
        try{
            Document doc = Jsoup.connect("https://www.whiskyshop.com/catalogsearch/result/?q=" + queryString).get();
            ArrayList<ScrapedWhiskyInList> listOfWhiskyInList = new ArrayList<>();
            Elements listOfElements = doc.select("ol.product-items");
               Elements infoElements = listOfElements.select("div.product-item-info");
               for (int i = 0; infoElements.size() < 8 ? i < infoElements.size() : i < 8; i++){
                   ScrapedWhiskyInList whiskyInList = new ScrapedWhiskyInList();
                   whiskyInList.setName(infoElements.get(i).select("a").attr("data-name"));
                   whiskyInList.setUrlMoreInfo(infoElements.get(i).select("a").attr("href"));
                   whiskyInList.setBrand(infoElements.get(i).select("a").attr("data-brand"));
                   whiskyInList.setImageUrl(infoElements.get(i).select("span.product-image-container span").select("img").attr("src"));
                   whiskyInList.setPrice(Double.parseDouble(infoElements.get(i).select("a").attr("data-price")));
                   System.out.println(whiskyInList.getName());
                   System.out.println(whiskyInList.getImageUrl());
                   System.out.println(whiskyInList.getUrlMoreInfo());
                   listOfWhiskyInList.add(whiskyInList);
               }
               return listOfWhiskyInList;

        } catch (IOException exception){
            System.out.println(exception);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Webscraper ws = new Webscraper();
        ws.getElements("oban");
    }
}
