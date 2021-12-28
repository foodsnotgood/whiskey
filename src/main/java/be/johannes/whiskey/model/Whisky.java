package be.johannes.whiskey.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateAdded;
    @ManyToMany(mappedBy = "whiskies")
    private Collection<User> users;

    public Whisky() {
    }
}
