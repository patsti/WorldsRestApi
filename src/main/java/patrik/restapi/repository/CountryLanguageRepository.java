package patrik.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import patrik.restapi.persistobjects.CountryLanguagePO;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguagePO, Long> {
    List<CountryLanguagePO> findCountryLanguageByCountrycode(@Param("countrycode") String countrycode);
}
