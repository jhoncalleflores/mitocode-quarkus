package org.mitocode.platform.domain.services;

import org.mitocode.platform.domain.model.entities.DeliveryPerson;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.model.entities.TrackingEvent;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Location;

import java.util.List;

public interface ShipmentService {
    Shipment createShipment(Shipment shipment);
    TrackingEvent updateShipmentStatus(String code, ShipmentStatus newShipmentStatus, Location location);
    Shipment assignDeliveryPerson(DeliveryPerson deliveryPerson, String existingShipmentCode);
    List<Shipment> getShipmentsByCustomerId(String customerId);
    List<TrackingEvent> getTrackingByShipmentCode(String code);
}
