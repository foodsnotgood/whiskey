package be.johannes.whiskey.scraper;

import java.util.List;

public class ScraperListHolder {
    private List<ScrapedWhiskyInList> whiskies;

    public ScraperListHolder() {
    }

    public List<ScrapedWhiskyInList> getWhiskies() {
        return whiskies;
    }

    public void setWhiskies(List<ScrapedWhiskyInList> whiskies) {
        this.whiskies = whiskies;
    }

    public boolean isEmpty() {
        return this.whiskies.isEmpty();
    }
}
