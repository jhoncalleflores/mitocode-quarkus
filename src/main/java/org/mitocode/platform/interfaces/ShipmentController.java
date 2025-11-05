package org.mitocode.platform.interfaces;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mitocode.platform.domain.model.entities.Shipment;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Path("/mitocode-platform/v1/shipments")
public class ShipmentController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShipments(){
        return Response.ok("All shipments").build();
    }

}
