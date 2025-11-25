package org.mitocode.platform.interfaces.rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.model.entities.TrackingEvent;
import org.mitocode.platform.domain.services.ShipmentService;
import org.mitocode.platform.infrastructure.mappers.DeliveryPersonMapper;
import org.mitocode.platform.infrastructure.mappers.ShipmentMapper;
import org.mitocode.platform.infrastructure.mappers.TrackingEventMapper;
import org.mitocode.platform.interfaces.resources.Result;
import org.mitocode.platform.interfaces.resources.request.CreateShipmentRequest;
import org.mitocode.platform.interfaces.resources.request.DeliveryPersonRequest;
import org.mitocode.platform.interfaces.resources.request.UpdateShipmentStatusRequest;

import java.util.List;

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
        var result = Result
                        .builder()
                        .data(ShipmentMapper.mapShipmentToShipmentResponse(createdShipment))
                        .build();
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{code}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateShipmentStatus(@PathParam("code") String existingShipmentCode, @Valid UpdateShipmentStatusRequest request) {
        TrackingEvent trackingEvent = shipmentService.updateShipmentStatus(existingShipmentCode, request.newShipmentStatus(), request.location());
        var result = Result
                        .builder()
                        .data(TrackingEventMapper.mapTrackingEventToTrackingEventResponse(trackingEvent))
                        .build();
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{code}/assign-delivery-person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDeliveryPerson(@PathParam("code") String existingShipmentCode, @Valid DeliveryPersonRequest request) {
        Shipment shipment = shipmentService.assignDeliveryPerson(DeliveryPersonMapper.mapDeliveryPersonRequestToDeliveryPerson(request), existingShipmentCode);
        var result = Result
                        .builder()
                        .data(ShipmentMapper.mapShipmentToShipmentResponse(shipment))
                        .build();
        return Response.ok(result).build();
    }

    @GET
    @Path("/customers/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShipmentsByCustomerId(@PathParam("customerId") String customerId) {
        List<Shipment> shipments = shipmentService.getShipmentsByCustomerId(customerId);
        var result = Result
                        .builder()
                        .data(ShipmentMapper.mapShipmentsToShipmentResponses(shipments))
                        .build();
        return Response.ok(result).build();
    }

    @GET
    @Path("/{code}/tracking")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrackingByShipment(@PathParam("code") String existingShipmentCode) {
        List<TrackingEvent> trackingEvents = shipmentService.getTrackingByShipmentCode(existingShipmentCode);
        var result = Result
                .builder()
                .data(TrackingEventMapper.mapTrackingEventsToResponses(trackingEvents))
                .build();
        return Response.ok(result).build();
    }

}
