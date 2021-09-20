package patrik.restapi.utils;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import patrik.restapi.objects.City;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.CountryLanguage;
import patrik.restapi.persistobjects.CityPO;

import java.io.IOException;

public class UtilsTest extends TestCase {
    City city;
    Country country;
    CountryLanguage countryLanguage;

    public void setUp() throws Exception {
        super.setUp();
        city = new City();
        city.setId(1337);
        city.setDistrict("disctrict");
        city.setName("CityName");
        city.setCountrycode("countrycode");
        city.setPopulation(1337);

        country = new Country();
        country.setName("CountryName");

        countryLanguage = new CountryLanguage();
        countryLanguage.setLanguage("Language");
    }

    public void testVerifySerializer() throws IOException, ClassNotFoundException {
        String serializedCity = Utils.serialize(city);
        City deserializedCity = (City) Utils.deserialize(serializedCity);
        String serializedCountry = Utils.serialize(country);
        Country deserializedCountry = (Country) Utils.deserialize(serializedCountry);
        String serializedCountryLanguage = Utils.serialize(countryLanguage);
        CountryLanguage deserializedCountryLanguage = (CountryLanguage) Utils.deserialize(serializedCountryLanguage);

        assertEquals(city.getName(), deserializedCity.getName());
        assertEquals(country.getName(), deserializedCountry.getName());
        assertEquals(countryLanguage.getLanguage(), deserializedCountryLanguage.getLanguage());
    }
}