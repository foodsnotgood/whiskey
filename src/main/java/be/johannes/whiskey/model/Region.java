package be.johannes.whiskey.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "region_generator")
    @SequenceGenerator(name = "region_generator", sequenceName = "region_seq", allocationSize = 1)
    @Id
    private int id;
    private String name;
    @Column(length = 1000)
    private String description;
    @OneToMany(mappedBy = "region")
    private Collection<Whisky> whisky;


    public Region() {
    }

    public Region(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Collection<Whisky> getWhisky() {
        return whisky;
    }

    public void setWhisky(Collection<Whisky> whisky) {
        this.whisky = whisky;
    }
}
