package be.johannes.whiskey.model;

import javax.persistence.*;

@Entity
public class Whisky {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whisky_generator")
    @SequenceGenerator(name = "whisky_generator", sequenceName = "whisky_seq", allocationSize = 1)
    @Id
    private int id;
    private String name;
    private String imageUrl;
    @Column(length = 2000)
    private String moreInfo;
    private String distillery;
    private String style;
    @ManyToOne
    private Region region;


    public Whisky() {
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getDistillery() {
        return distillery;
    }

    public void setDistillery(String distillery) {
        this.distillery = distillery;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
