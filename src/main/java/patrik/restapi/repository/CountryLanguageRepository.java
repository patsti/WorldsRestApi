package patrik.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patrik.restapi.persistobjects.CountryLanguagePO;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguagePO, Long> {
}
