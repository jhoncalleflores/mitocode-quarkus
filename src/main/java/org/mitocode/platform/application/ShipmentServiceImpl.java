package org.mitocode.platform.application;

import jakarta.enterprise.context.ApplicationScoped;
import org.mitocode.platform.domain.model.entities.DeliveryPerson;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.model.entities.TrackingEvent;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Location;
import org.mitocode.platform.domain.services.ShipmentService;
import org.mitocode.platform.infrastructure.mappers.TrackingEventMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ShipmentServiceImpl implements ShipmentService {

    private static final List<Shipment> shipments = new ArrayList<>();
    private static final List<TrackingEvent> trackingEvents = new ArrayList<>();

    @Override
    public Shipment createShipment(Shipment shipment) {
        shipment.persist();
        shipments.add(shipment);
        return shipment;
    }

    @Override
    public TrackingEvent updateShipmentStatus(String code, ShipmentStatus newShipmentStatus, Location location) {
        Optional<Shipment> existingShipment = shipments.stream()
                .filter(shipment -> shipment.getCode().equals(code))
                .findFirst();
        if(existingShipment.isEmpty()) {
            throw new IllegalArgumentException("No se encontro Shipment con code " + code);
        }
        TrackingEvent newTrackingEvent = TrackingEventMapper.createTrackingWithLocationAndShipment(
                location, existingShipment.get()
        );
        newTrackingEvent.persist();
        trackingEvents.add(newTrackingEvent);
        return newTrackingEvent;
    }

    @Override
    public Shipment assignDeliveryPerson(DeliveryPerson deliveryPerson, String existingShipmentCode) {
        Optional<Shipment> existingShipment = shipments.stream()
                .filter(shipment -> shipment.getCode().equals(existingShipmentCode))
                .findFirst();
        if(existingShipment.isEmpty()) {
            throw new IllegalArgumentException("No se encontro Shipment con code " + existingShipmentCode);
        }
        deliveryPerson.persist();
        existingShipment.get().setAssignedDeliveryPerson(deliveryPerson);
        return existingShipment.get();
    }

    @Override
    public List<Shipment> getShipmentsByCustomerId(String customerId) {
        return shipments.stream()
                .filter(shipment -> shipment.getCustomerId().equals(customerId))
                .toList();
    }

    @Override
    public List<TrackingEvent> getTrackingByShipmentCode(String code) {
        return trackingEvents.stream().filter(
                trackingEvent -> trackingEvent.getAssociatedShipment().getCode().equals(code)
        ).toList();
    }
}
