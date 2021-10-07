package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.CountryLanguage;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.persistobjects.CountryLanguagePO;
import patrik.restapi.repository.CountryLanguageRepository;
import patrik.restapi.utils.WorldConverter;

import java.util.List;

@Service
public class CountryLanguageService {
    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public ResponseObject getAllCountryLanguages() {
        List<CountryLanguagePO> countryLanguagePOList = countryLanguageRepository.findAll();
        List<CountryLanguage> countryLanguageList = WorldConverter.convertCountryLanguagePoListToCountryLanguageList(countryLanguagePOList);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setCountryLanguageList(countryLanguageList);

        return responseObject;
    }

    public ResponseObject getLanguagesByCountryCode(String countrycode) {
        List<CountryLanguagePO> countryLanguagePOList = countryLanguageRepository.findCountryLanguageByCountrycode(countrycode);
        ResponseObject responseObject = new ResponseObject();
        List<CountryLanguage> cityList = WorldConverter.convertCountryLanguagePoListToCountryLanguageList(countryLanguagePOList);
        responseObject.setCountryLanguageList(cityList);

        return responseObject;
    }
}
