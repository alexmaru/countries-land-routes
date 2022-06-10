package com.alexmaru.countrieslandroutes.service;

import java.util.List;

public interface RoutingService {

    List<String> getRoute(String originCountry, String destinationCountry);

}
