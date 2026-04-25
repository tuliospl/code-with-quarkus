package org.quarkus;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path( "/unipds")
public class UniPDSResource {

    private int i = 0;

    @GET
    public int getI() {
        return i;
    }

    @POST
    public void addI() {
        i++;
    }

    @DELETE
    public void removeI() {
        i--;
    }

    @PUT
    public void setI(int x) {
        i = x;
    }


}
