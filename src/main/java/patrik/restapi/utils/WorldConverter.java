package patrik.restapi.utils;

import patrik.restapi.objects.City;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.CountryLanguage;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.persistobjects.CountryLanguagePO;
import patrik.restapi.persistobjects.CountryPO;

import java.util.ArrayList;
import java.util.List;

public class WorldConverter {

    public static List<City> convertCityPoListToCityList(List<CityPO> cityPOList) {
        List<City> cityList = new ArrayList<>();
        for (CityPO cityPo : cityPOList) {
            cityList.add(cityPoToCity(cityPo));
        }

        return cityList;
    }

    public static List<Country> convertCountryPoListToCountryList(List<CountryPO> countryPOList) {
        List<Country> countryList = new ArrayList<>();
        for (CountryPO countryPo : countryPOList) {
            countryList.add(countryPoToCountry(countryPo));
        }

        return countryList;
    }

    public static List<CountryLanguage> convertCountryLanguagePoListToCountryLanguageList(List<CountryLanguagePO> countryLanguagePOList) {
        List<CountryLanguage> countryLanguageList = new ArrayList<>();
        for (CountryLanguagePO countryLanguagePO : countryLanguagePOList) {
            countryLanguageList.add(countryLanguagePoToCountryLanguage(countryLanguagePO));
        }

        return countryLanguageList;
    }

    public static City cityPoToCity(CityPO cityPO) {
        City city = new City();
        city.setCountrycode(cityPO.getCountrycode());
        city.setId(cityPO.getId());
        city.setName(cityPO.getName());
        city.setDistrict(cityPO.getDistrict());
        city.setPopulation(cityPO.getPopulation());

        return city;
    }

    public static Country countryPoToCountry(CountryPO countryPO) {
        Country country = new Country();
        country.setCountrycode(countryPO.getCode());
        country.setName(countryPO.getName());
        country.setContinent(countryPO.getContinent());
        country.setRegion(countryPO.getRegion());
        country.setSurfacearea(countryPO.getSurfacearea());
        country.setIndepyear(countryPO.getIndepyear());
        country.setPopulation(countryPO.getPopulation());
        country.setLifeexpectancy(countryPO.getLifeexpectancy());
        country.setGnp(countryPO.getGnp());
        country.setGnpold(countryPO.getGnpold());
        country.setLocalname(countryPO.getLocalname());

        return country;
    }

    public static CountryLanguage countryLanguagePoToCountryLanguage(CountryLanguagePO countryLanguagePO) {
        CountryLanguage countryLanguage = new CountryLanguage();
        countryLanguage.setCountrycode(countryLanguagePO.getCountrycode());
        countryLanguage.setName(countryLanguagePO.getLanguage());
        countryLanguage.setIsofficial(countryLanguagePO.getIsofficial());
        countryLanguage.setPercentage(countryLanguagePO.getPercentage());

        return countryLanguage;
    }
}
