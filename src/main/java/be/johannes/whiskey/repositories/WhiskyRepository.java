package be.johannes.whiskey.repositories;

import be.johannes.whiskey.model.Whisky;
import org.springframework.data.repository.CrudRepository;

public interface WhiskyRepository extends CrudRepository<Whisky, Integer> {
}
