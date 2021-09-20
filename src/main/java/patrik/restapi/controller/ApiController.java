
package patrik.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patrik.restapi.objects.GameResponseObject;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.service.CityService;
import patrik.restapi.service.CountryLanguageService;
import patrik.restapi.service.CountryService;
import patrik.restapi.service.GameService;
import patrik.restapi.utils.Utils;

@RestController
@RequestMapping("/")
public class ApiController {

    private final CityService cityService;
    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;
    private final GameService gameService;

    @Autowired
    public ApiController(CityService cityService, CountryService countryService, CountryLanguageService countryLanguageService, GameService gameService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
        this.gameService = gameService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public String getHelpText() throws Exception {
        String cities = null;
        try {
            cities = cityService.getCities();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/api/init-game", produces = "application/json")
    public String initGame(@RequestParam(value = "seed", required = false, defaultValue = "0") Integer seed) throws Exception {
        GameResponseObject gameResponseObject = gameService.createGame(seed);

        return Utils.serialize(gameResponseObject);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/city", produces = "application/json")
    public String getCity(@RequestParam("countrycode") String countrycode) throws Exception {

        return cityService.getCityByCountryCode(countrycode);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/countries", produces = "application/json")
    public String getCountries(@RequestParam("countrycode") String countrycode) throws Exception {
        ResponseObject responseObject = countryService.getAllCountries();

        return Utils.serialize(responseObject);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/countrylanguages", produces = "application/json")
    public String getCountryLanguages(@RequestParam(value="countrycode", required = false, defaultValue = "") String countrycode) throws Exception {
        ResponseObject responseObject = countryLanguageService.getAllCountryLanguages();

        return Utils.serialize(responseObject);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/country-by-code", produces = "application/json")
    public String getCountryByCode(@RequestParam("countrycode") String countrycode) throws Exception {

        return countryService.getCountryByCountryCode(countrycode);
    }
}
