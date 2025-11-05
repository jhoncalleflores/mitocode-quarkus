package org.mitocode.platform.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mitocode.platform.domain.services.ShipmentService;

@Path("/mitocode-platform/v1/shipments")
public class ShipmentController {

    @Inject
    ShipmentService shipmentService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShipments(){
        return Response.ok(shipmentService.getShipments()).build();
    }

}
