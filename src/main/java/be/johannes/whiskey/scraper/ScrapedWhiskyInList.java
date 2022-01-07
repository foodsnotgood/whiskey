package be.johannes.whiskey.scraper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScrapedWhiskyInList {

    private String urlMoreInfo;
    private String imageUrl;
    private String name;
    private String brand;
    private String moreInfo;
    private String distillery;
    private String region;
    private String style;

    public ScrapedWhiskyInList() {
    }
}
