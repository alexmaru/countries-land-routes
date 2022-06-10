package com.alexmaru.countrieslandroutes.service;

import com.alexmaru.countrieslandroutes.model.Country;
import com.alexmaru.countrieslandroutes.utils.GraphUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("routingService")
public class RoutingServiceImpl implements RoutingService {

    @Autowired
    CountryService countryService;

    @Override
    public List<String> getRoute(String originCountry, String destinationCountry) {
        List<Country> countries = countryService.getCountries();
        Map<String, List<String>> adjacentList = new HashMap<>();
        countries.forEach(country -> adjacentList.put(country.getCca3(), country.getBorders()));
        GraphUtil graphUtil = new GraphUtil(adjacentList);

        return graphUtil.computePath(originCountry, destinationCountry);
    }
}
