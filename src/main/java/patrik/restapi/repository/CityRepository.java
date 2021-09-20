package patrik.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import patrik.restapi.persistobjects.CityPO;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityPO, Long> {

    List<CityPO> findAllOrderedByNameDescending();
    List<CityPO> findCitiesNotCountrycode(@Param("countrycode") String countrycode);
}
