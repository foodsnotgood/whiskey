package be.johannes.whiskey.repositories;

import be.johannes.whiskey.model.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Integer> {

    @Query("select r from Region r where :region is null or upper(:region) = upper(r.name)")
    Optional<Region> findByName(@Param("region") String regionString);
}
