package org.mitocode.platform.interfaces.rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.services.ShipmentService;
import org.mitocode.platform.infrastructure.mappers.ShipmentMapper;
import org.mitocode.platform.interfaces.resources.Result;
import org.mitocode.platform.interfaces.resources.request.CreateShipmentRequest;

@Path("/mitocode-platform/v1/shipments")
public class ShipmentController {

    @Inject
    ShipmentService shipmentService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShipment(@Valid CreateShipmentRequest request) {
        Shipment shipment = ShipmentMapper.mapCreateShipmentRequestToShipment(request);
        Shipment createdShipment = shipmentService.createShipment(shipment);
        var result = Result.builder().data(createdShipment).build();
        return Response.ok(result).build();
    }

}
