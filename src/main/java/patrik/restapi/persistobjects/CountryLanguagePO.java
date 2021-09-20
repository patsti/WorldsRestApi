package patrik.restapi.persistobjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguagePO implements Serializable {
    private final static long serialVersionUID = 1339;
    @Id
    @SequenceGenerator(
            name = "language_sequence",
            sequenceName = "language_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "language_sequence"
    )
    String countrycode;
    String language;
    String isofficial;
    Float percentage;

    public String getCountrycode() {
        return countrycode;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsofficial() {
        return isofficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
