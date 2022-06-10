package com.alexmaru.countrieslandroutes.rest.dto;

import java.util.List;

public class Routing {

    private List<String> route;

    public Routing(List<String> route) {
        this.route = route;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }
}