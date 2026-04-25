package org.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "https://swapi.dev/api/")
public interface StarWarsService {


    @GET
    @Path("starships")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3, unit = ChronoUnit.SECONDS)
    @Fallback(fallbackMethod = "getStarshipFallback")
    public String getStarShips();

    default String getStarshipFallback() {
        return "fallback";
    }
}
