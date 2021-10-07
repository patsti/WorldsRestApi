package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.City;
import patrik.restapi.objects.CompareAbstract;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.GameResponseObject;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.persistobjects.CountryPO;
import patrik.restapi.utils.WorldConverter;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private final String EMPTY = "";
    private final CityService cityService;
    private final CountryService countryService;

    @Autowired
    public GameService(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    public GameResponseObject createGame(int seed) {
        Random random = new Random(seed);
        // Fetch random Cities
        City city1 = fetchRandomCity(EMPTY, random);
        City city2 = fetchRandomCity(city1.getCountrycode(), random);
        // Fetch corresponding countries
        Country country1 = fetchCorrespondingCountry(city1);
        Country country2 = fetchCorrespondingCountry(city2);
        // Package quiz into game object
        GameResponseObject gameResponseObject = new GameResponseObject();
        gameResponseObject.addItem(city1);
        gameResponseObject.addItem(city2);
        gameResponseObject.addItem(country1);
        gameResponseObject.addItem(country2);
        // Randomize order
        Collections.shuffle(gameResponseObject.getItems());

        return gameResponseObject;
    }

    private City fetchRandomCity(String skipCountryCode, Random random) {
        List<CityPO> cityPOList;
        if (skipCountryCode == null || skipCountryCode.equals(EMPTY)) {
            cityPOList = cityService.getCitiesList();
        } else {
            cityPOList = cityService.getCityNotInCountryCode(skipCountryCode);
        }
        int randomIndex = random.nextInt(cityPOList.size());
        CityPO cityPO2 = cityPOList.get(randomIndex);

        return WorldConverter.cityPoToCity(cityPO2);
    }

    private Country fetchCorrespondingCountry(CompareAbstract correspondingItem) {
        CountryPO countryPO = countryService.getCountryPoByCountryCode(correspondingItem.getCountrycode());

        return WorldConverter.countryPoToCountry(countryPO);
    }
}
