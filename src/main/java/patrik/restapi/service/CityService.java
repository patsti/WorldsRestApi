package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.City;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.repository.CityRepository;
import patrik.restapi.utils.WorldConverter;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public ResponseObject getAllCities() {
        List<CityPO> cities = cityRepository.findAll();
        ResponseObject responseObject = new ResponseObject();
        List<City> cityList = WorldConverter.convertCityPoListToCityList(cities);
        responseObject.setCityList(cityList);

        return responseObject;
    }

    public List<CityPO> getCitiesList() {

        return cityRepository.findAll();
    }

    public List<CityPO> getCityNotInCountryCode(String code) {

        return cityRepository.findCitiesNotCountrycode(code);
    }

    public ResponseObject getCityByCountryCode(String code) {
        List<CityPO> cities = cityRepository.findCitiesWithCountrycode(code);
        ResponseObject responseObject = new ResponseObject();
        List<City> cityList = WorldConverter.convertCityPoListToCityList(cities);
        responseObject.setCityList(cityList);

        return responseObject;
    }
}
