package org.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "https://swapi.dev/api/")
public interface StarWarsService {

    public static final String MSG_ERROR = "fallback";

    @GET
    @Path("starships")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3, unit = ChronoUnit.SECONDS)
    @Fallback(fallbackMethod = "getStarshipFallback")
    @CircuitBreaker(
        requestVolumeThreshold = 2,
        failureRatio = 5,
        delay = 3000L,
        successThreshold = 2
    )
    public String getStarShips();

    default String getStarshipFallback() {
        return MSG_ERROR;
    }
}
