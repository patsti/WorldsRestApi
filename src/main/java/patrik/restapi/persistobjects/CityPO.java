package patrik.restapi.persistobjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="CityPO.findAllOrderedByNameDescending",
            query = "SELECT c FROM CityPO c ORDER BY c.name DESC"),
        @NamedQuery(name="CityPO.findCitiesNotCountrycode",
                query = "SELECT c FROM CityPO c WHERE c.countrycode != :countrycode"),
        @NamedQuery(name="CityPO.findCitiesWithCountrycode",
                query = "SELECT c FROM CityPO c WHERE c.countrycode = :countrycode")
})
@Table(name = "city")
public class CityPO implements Serializable{
    private final static long serialVersionUID = 1337;
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    Integer id;
    private String name;
    private String countrycode;
    private String district;
    private Integer population;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountrycode() {
        return countrycode;
    }
    public String getDistrict() {
        return district;
    }
    public Integer getPopulation() {
        return population;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString(){
        return name;
    }

}
