package com.alexmaru.countrieslandroutes.service;

import com.alexmaru.countrieslandroutes.model.Country;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("countryService")
public class CountryServiceImpl implements CountryService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Country> getCountries() {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Country[] countries = objectMapper.readValue(new File("src/main/resources/countries.json"), Country[].class);
            return new ArrayList<>(Arrays.asList(countries));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
