package wse.bdovbysh;

import org.springframework.stereotype.Component;
import wse.bdovbysh.entity.Country;
import wse.bdovbysh.entity.ObjectFactory;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dovbysh on 12.10.2015.
 */
@Component
public class RepositoryStub {
    private static List<Country> countryList;

    @PostConstruct
    private void initialize(){

        countryList = new ArrayList<Country>();

        Country poland = new ObjectFactory().createCountry();
        poland.setRegionID(BigDecimal.ONE);
        poland.setCountryID(BigInteger.TEN);
        poland.setCountryName("Poland");

        Country spain = new ObjectFactory().createCountry();
        spain.setCountryID(BigInteger.ZERO);
        spain.setCountryName("Spain");
        spain.setRegionID(BigDecimal.TEN);

        countryList.add(poland);
        countryList.add(spain);
    }

    public Country getCountryByName(String name){
        if (name==null || name.isEmpty()){
            throw new IllegalArgumentException("Country name is empty");
        }
        Country country = null;
        for (Country c : countryList) {
            if (name.equals(c.getCountryName())) {
                country = c;
            }
        }
        return country;
    }
}
