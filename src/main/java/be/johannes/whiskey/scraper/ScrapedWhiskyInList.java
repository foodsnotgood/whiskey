package be.johannes.whiskey.scraper;

public class ScrapedWhiskyInList {

    private String urlMoreInfo;
    private String imageUrl;
    private String name;
    private String brand;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ScrapedWhiskyInList(String urlMoreInfo, String imageUrl, String name, String brand) {
        this.urlMoreInfo = urlMoreInfo;
        this.imageUrl = imageUrl;
        this.name = name;
        this.brand = brand;
    }

    public ScrapedWhiskyInList() {
    }

    public String getUrlMoreInfo() {
        return urlMoreInfo;
    }

    public void setUrlMoreInfo(String urlMoreInfo) {
        this.urlMoreInfo = urlMoreInfo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
