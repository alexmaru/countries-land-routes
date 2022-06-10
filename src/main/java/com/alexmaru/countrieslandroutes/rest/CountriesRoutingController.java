package com.alexmaru.countrieslandroutes.rest;

import com.alexmaru.countrieslandroutes.rest.dto.Routing;
import com.alexmaru.countrieslandroutes.service.RoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesRoutingController {

    @Autowired
    private RoutingService routingService;

    @RequestMapping(value="/routing/{originCountry}/{destinationCountry}", method= RequestMethod.GET)
    public ResponseEntity<Routing> getRouting(@PathVariable(value = "originCountry") @NotBlank String originCountry,
                                              @PathVariable(value = "destinationCountry") @NotBlank String destinationCountry) {
        List<String> path = routingService.getRoute(originCountry, destinationCountry);
        if (path.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(new Routing(path));

    }

}
