package patrik.restapi.utils;

import junit.framework.TestCase;
import patrik.restapi.objects.City;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.CountryLanguage;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.persistobjects.CountryLanguagePO;
import patrik.restapi.persistobjects.CountryPO;

public class WorldConverterTest extends TestCase {
    CityPO cityPO;
    CountryPO countryPO;
    CountryLanguagePO countryLanguagePO;

    public void setUp() throws Exception {
        super.setUp();
        cityPO = new CityPO();
        cityPO.setId(1337);
        cityPO.setDistrict("disctrict");
        cityPO.setName("CityName");
        cityPO.setCountrycode("CityCountryCode");
        cityPO.setPopulation(1337);

        countryPO = new CountryPO();
        countryPO.setName("CountryName");
        countryPO.setCode("CountryCode");

        countryLanguagePO = new CountryLanguagePO();
        countryLanguagePO.setLanguage("Language");
        countryLanguagePO.setCountrycode("LanguageCountryCode");
    }

    public void testConvertCityPoListToCityList() {
    }

    public void testCityPoToCity() {
        City city = WorldConverter.cityPoToCity(cityPO);
        assertEquals(cityPO.getName(), city.getName());
        assertEquals(cityPO.getCountrycode(), city.getCountrycode());
    }

    public void testCountryPoToCountry() {
        Country country = WorldConverter.countryPoToCountry(countryPO);
        assertEquals(countryPO.getName(), country.getName());
        assertEquals(countryPO.getCode(), country.getCountrycode());
    }

    public void testCountryLanguagePoToCountryLanguage() {
        CountryLanguage countryLanguage = WorldConverter.countryLanguagePoToCountryLanguage(countryLanguagePO);
        assertEquals(countryLanguagePO.getLanguage(), countryLanguage.getLanguage());
        assertEquals(countryLanguagePO.getCountrycode(), countryLanguage.getCountrycode());
    }
}