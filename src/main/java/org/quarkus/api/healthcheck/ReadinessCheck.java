package org.quarkus.api.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quarkus.service.StarWarsService;

import static org.quarkus.service.StarWarsService.MSG_ERROR;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;

    public HealthCheckResponse call() {
        if (starWarsService.getStarShips().contains(MSG_ERROR))
            return HealthCheckResponse.down("ERROR");
        else
            return HealthCheckResponse.up("OK");
    }
}
