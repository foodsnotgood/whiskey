package be.johannes.whiskey.model;

import javax.persistence.*;

@Entity
public class Whisky {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whisky_generator")
    @SequenceGenerator(name = "whisky_generator", sequenceName = "whisky_seq", allocationSize = 1)
    @Id
    private int id;
    private String name;
    private String metaData;
    private int cl;
    private int volAlc;
    private String description;

    public Whisky(){};

    public Whisky(String name, String metaData, int cl, int volAlc, String description) {
        this.name = name;
        this.metaData = metaData;
        this.cl = cl;
        this.volAlc = volAlc;
        this.description = description;
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

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public int getVolAlc() {
        return volAlc;
    }

    public void setVolAlc(int volAlc) {
        this.volAlc = volAlc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
