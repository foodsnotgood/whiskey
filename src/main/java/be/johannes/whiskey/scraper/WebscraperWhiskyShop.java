package be.johannes.whiskey.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebscraperWhiskyShop {

    public ArrayList<ScrapedWhiskyInList> getListElements(String queryString) throws IOException {
        try {
            Document doc = Jsoup.connect("https://www.whiskyshop.com/catalogsearch/result/?q=" + queryString).get();
            ArrayList<ScrapedWhiskyInList> listOfWhiskyInList = new ArrayList<>();
            Elements listOfElements = doc.select("ol.product-items");
            Elements infoElements = listOfElements.select("div.product-item-info");
            for (int i = 0; infoElements.size() < 8 ? i < infoElements.size() : i < 8; i++) {
                ScrapedWhiskyInList whiskyInList = new ScrapedWhiskyInList();
                whiskyInList.setName(infoElements.get(i).select("a").attr("data-name"));
                whiskyInList.setUrlMoreInfo(infoElements.get(i).select("a").attr("href"));
                whiskyInList.setBrand(infoElements.get(i).select("a").attr("data-brand"));
                whiskyInList.setImageUrl(infoElements.get(i).select("span.product-image-container span").select("img").attr("src"));
                whiskyInList.setPrice(Double.parseDouble(infoElements.get(i).select("a").attr("data-price")));
                whiskyInList.setMoreInfo(getMoreInfo(whiskyInList.getUrlMoreInfo()));

                whiskyInList.setDistillery(getDistillery(whiskyInList.getUrlMoreInfo()));
                whiskyInList.setRegion(getRegion(whiskyInList.getUrlMoreInfo()));
                whiskyInList.setStyle(getStyle(whiskyInList.getUrlMoreInfo()));
                //whiskyInList.setAbv(getABV(whiskyInList.getUrlMoreInfo()).replaceAll("[^0-9]", ""));
                //whiskyInList.setSize(getSize(whiskyInList.getUrlMoreInfo()).replaceAll("[^0-9]", ""));
                listOfWhiskyInList.add(whiskyInList);
            }
            return listOfWhiskyInList;

        } catch (IOException exception) {
            System.out.println(exception);
        }
        return null;
    }

    private String getMoreInfo(String urlMoreInfo) throws IOException {
        return getDocumentFromUrl(urlMoreInfo).select("div[itemprop='description']").text();
    }

    private String getDistillery(String urlMoreInfo) throws IOException {
        Elements elements = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Distillery)");
        //String distillery = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Distillery)").first().nextElementSibling().text();
        return !elements.isEmpty() ? elements.first().nextElementSibling().text() : "not applicable";
    }

    private String getRegion(String urlMoreInfo) throws IOException {
        Elements elements = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Region)");
        //String region = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Region)").first().nextElementSibling().text();
        return !elements.isEmpty() ? elements.first().nextElementSibling().text() : "not applicable";
    }

    private String getStyle(String urlMoreInfo) throws IOException {
        Elements elements = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Style)");
        //String style = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Style)").first().nextElementSibling().text();
        return !elements.isEmpty() ? elements.first().nextElementSibling().text() : "not applicable";
    }

    private String getSize(String urlMoreInfo) throws IOException {
        Elements elements = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Size)");
        //String size = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(Size)").first().nextElementSibling().text();
        return !elements.isEmpty() ? elements.first().nextElementSibling().text() : "not applicable";
    }

    private String getABV(String urlMoreInfo) throws IOException {
        Elements elements = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(ABV)");
        //String abv = getDocumentFromUrl(urlMoreInfo).select("dl > dt:contains(ABV)").first().nextElementSibling().text();
        return !elements.isEmpty() ? elements.first().nextElementSibling().text() : "not applicable";
    }

    private Document getDocumentFromUrl(String url) throws IOException {
        return Jsoup.connect(url).get();
    }


    public static void main(String[] args) throws IOException {
        WebscraperWhiskyShop ws = new WebscraperWhiskyShop();
        ws.getListElements("oban");
    }
}
