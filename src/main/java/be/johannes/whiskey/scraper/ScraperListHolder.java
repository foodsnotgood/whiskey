package be.johannes.whiskey.scraper;

import java.util.List;

public class ScraperListHolder {
    private List<ScrapedWhiskyInList> whiskies;
    private String name;

    public ScraperListHolder(List<ScrapedWhiskyInList> whiskies, String name) {
        this.whiskies = whiskies;
        this.name = name;
    }

    public ScraperListHolder() {
    }

    public String getName() {
        return name;
    }
    public List<ScrapedWhiskyInList> getWhiskies() {
        return whiskies;
    }

    public void setWhiskies(List<ScrapedWhiskyInList> whiskies) {
        this.whiskies = whiskies;
    }
}
