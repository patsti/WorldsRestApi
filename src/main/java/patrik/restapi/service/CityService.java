package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.City;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.persistobjects.CityPO;
import patrik.restapi.repository.CityRepository;
import patrik.restapi.utils.WorldConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String getCities() {
//        return cityRepository.findCitiesAndLanguages("AFG");
        List<CityPO> cities = cityRepository.findAll();
        ResponseObject responseObject = new ResponseObject();
        List<City> cityList = WorldConverter.convertCityPoListToCityList(cities);
        responseObject.setCityList(cityList);
        try {
            return CityService.toString(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<CityPO> getCitiesList() {
        return cityRepository.findAll();
    }

    public List<CityPO> getCityNotInCountryCode(String code) {
        return cityRepository.findCitiesNotCountrycode(code);
    }
    public String getCityByCountryCode(String code) {
        /*List<CityPO> citiesPO = cityRepository.findCitiesAndLanguages(code);
        ResponseObject responseObject = new ResponseObject();
        List<City> cityList = WorldConverter.convertCityPoListToCityList(citiesPO);
        responseObject.setCityList(cityList);

        try {
            return CityService.toString(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "";
    }

    /** Read the object from Base64 string. */
    private static Object fromString( String s ) throws IOException ,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
