package patrik.restapi.persistobjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="CountryPO.findCountryByCode",
                query = "SELECT c FROM CountryPO c WHERE c.code = :countrycode")
})
@Table(name = "country")
public class CountryPO implements Serializable {
    private final static long serialVersionUID = 1338;
    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    String code;
    String name;
    String continent;
    String region;
    Float surfacearea;
    Integer indepyear;
    Integer population;
    Float lifeexpectancy;
    Float gnp;
    Float gnpold;
    String localname;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public Float getSurfacearea() {
        return surfacearea;
    }

    public Integer getIndepyear() {
        return indepyear;
    }

    public Integer getPopulation() {
        return population;
    }

    public Float getLifeexpectancy() {
        return lifeexpectancy;
    }

    public Float getGnp() {
        return gnp;
    }

    public Float getGnpold() {
        return gnpold;
    }

    public String getLocalname() {
        return localname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSurfacearea(Float surfacearea) {
        this.surfacearea = surfacearea;
    }

    public void setIndepyear(Integer indepyear) {
        this.indepyear = indepyear;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setLifeexpectancy(Float lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    public void setGnpold(Float gnpold) {
        this.gnpold = gnpold;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }
}
