package be.johannes.whiskey.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
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
}
