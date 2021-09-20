package patrik.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import patrik.restapi.persistobjects.CountryPO;

@Repository
public interface CountryRepository extends JpaRepository<CountryPO, Long> {
    CountryPO findCountryByCode(@Param("countrycode") String countrycode);
}
