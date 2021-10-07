package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.persistobjects.CountryPO;
import patrik.restapi.repository.CountryRepository;
import patrik.restapi.utils.WorldConverter;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public ResponseObject getCountryByCountryCode(String code) {
        CountryPO countryPO = countryRepository.findCountryByCode(code);
        Country country = WorldConverter.countryPoToCountry(countryPO);
        ResponseObject responseObject = new ResponseObject();
        List<Country> countryList = new ArrayList<>();
        countryList.add(country);
        responseObject.setCountryList(countryList);
        return responseObject;
    }

    public ResponseObject getAllCountries() {
        List<CountryPO> countryPOList = countryRepository.findAll();
        List<Country> countryList = WorldConverter.convertCountryPoListToCountryList(countryPOList);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setCountryList(countryList);
        return responseObject;
    }

    public CountryPO getCountryPoByCountryCode(String code) {
        return countryRepository.findCountryByCode(code);
    }

}
