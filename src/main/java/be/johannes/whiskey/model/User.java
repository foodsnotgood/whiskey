package be.johannes.whiskey.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
    @Id
    private Integer id;
    @NotNull(message = "Cannot be null")
    private String username;
    @NotNull(message = "Cannot be null")
    private String email;
    private String password;
    @ManyToMany
    private Collection<Whisky> whiskies;

    public User() {
    }
}
