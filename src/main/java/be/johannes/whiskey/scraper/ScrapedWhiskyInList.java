package be.johannes.whiskey.scraper;

public class ScrapedWhiskyInList {

    private String urlMoreInfo;
    private String imageUrl;
    private String name;
    private String brand;
    private double price;
    private String moreInfo;
    private String distillery;
    private String region;
    private String style;
    
    public ScrapedWhiskyInList() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDistillery() {
        return distillery;
    }

    public void setDistillery(String distillery) {
        this.distillery = distillery;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
