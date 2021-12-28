package be.johannes.whiskey.repositories;

import be.johannes.whiskey.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
