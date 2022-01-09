package be.johannes.whiskey.repositories;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.model.Whisky;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WhiskyRepository extends CrudRepository<Whisky, Integer> {
    @Query("select w from Whisky w where :query is null or upper(w.name) like upper(concat('%', :query, '%')) " +
            "or upper(w.distillery) like upper(concat('%', :query, '%')) " +
            "or upper(w.region.name) like upper(concat('%', :query, '%')) " +
            "or upper(w.moreInfo) like upper(concat('%', :query, '%'))")
    List<Whisky> findByQuery(@Param("query") String query);

    @Query("select w from Whisky w where w.region.id = :regionId")
    List<Whisky> findByRegionId(@Param("regionId") Integer id);

    List<Whisky> findAllByUsers(User user);

    List<Whisky> findAllByUsersAndRegion(User user, Region region);
}
