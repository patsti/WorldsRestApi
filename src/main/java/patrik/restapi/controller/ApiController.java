
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

        return Utils.getHelpText();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/api/init-game", produces = "application/json")
    public String initGame(@RequestParam(value = "seed", required = false, defaultValue = "0") Integer seed) throws Exception {
        GameResponseObject gameResponseObject = gameService.createGame(seed);

        return Utils.serialize(gameResponseObject);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/city", produces = "application/json")
    public String getCity(@RequestParam(value = "countrycode", required = false, defaultValue = "") String countrycode) throws Exception {
        if (countrycode.isEmpty()) {
            return Utils.serialize(cityService.getAllCities());
        }

        return Utils.serialize(cityService.getCityByCountryCode(countrycode));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/countries", produces = "application/json")
    public String getCountries(@RequestParam(value = "countrycode", required = false, defaultValue = "") String countrycode) throws Exception {
        if (countrycode.isEmpty()) {
            return Utils.serialize(countryService.getAllCountries());
        }

        return Utils.serialize(countryService.getCountryByCountryCode(countrycode));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/countrylanguages", produces = "application/json")
    public String getCountryLanguages(@RequestParam(value = "countrycode", required = false, defaultValue = "") String countrycode) throws Exception {
        if (countrycode.isEmpty()) {
            return Utils.serialize(countryLanguageService.getAllCountryLanguages());
        }

        return Utils.serialize(countryLanguageService.getLanguagesByCountryCode(countrycode));
    }
}
