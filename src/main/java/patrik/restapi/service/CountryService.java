package patrik.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrik.restapi.objects.Country;
import patrik.restapi.objects.ResponseObject;
import patrik.restapi.persistobjects.CountryPO;
import patrik.restapi.repository.CountryRepository;
import patrik.restapi.utils.WorldConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
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

    /**
     * Read the object from Base64 string.
     */
    private static Object fromString(String s) throws IOException,
            ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /**
     * Write the object to a Base64 string.
     */
    private static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
