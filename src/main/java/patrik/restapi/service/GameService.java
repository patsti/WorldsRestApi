package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.City;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.GameResponseObject;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.persistobjects.CountryPO;
import patrik.restapi.repository.CountryLanguageRepository;
import patrik.restapi.utils.WorldConverter;

import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private final CityService cityService;
    private final CountryService countryService;
//    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public GameService(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
//        this.countryLanguageRepository = countryLanguageRepository;
    }

    public GameResponseObject createGame(int seed) {
        Random random = new Random(seed);
        // Fetch 1st City
        List<CityPO> cityPOList1  = cityService.getCitiesList();
        int index = random.nextInt(cityPOList1.size());
        CityPO cityPO1 = cityPOList1.get(index);
        // Fetch 2nd City
        List<CityPO> cityPOList2 = cityService.getCityNotInCountryCode(cityPO1.getCountrycode());
        int index2 = random.nextInt(cityPOList2.size());
        CityPO cityPO2 = cityPOList1.get(index2);

        CountryPO countryPO1 = countryService.getCountryPoByCountryCode(cityPO1.getCountrycode());
        CountryPO countryPO2 = countryService.getCountryPoByCountryCode(cityPO2.getCountrycode());

        GameResponseObject gameResponseObject = new GameResponseObject();
        gameResponseObject.addItem(WorldConverter.cityPoToCity(cityPO1));
        gameResponseObject.addItem(WorldConverter.countryPoToCountry(countryPO1));
        gameResponseObject.addItem(WorldConverter.cityPoToCity(cityPO2));
        gameResponseObject.addItem(WorldConverter.countryPoToCountry(countryPO2));


        return gameResponseObject;
    }
}
