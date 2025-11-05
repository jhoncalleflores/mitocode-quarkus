package org.mitocode.platform.domain.services;

import org.mitocode.platform.domain.model.entities.Shipment;

import java.util.List;

public interface ShipmentService {
    void addNewShipment(Shipment shipment);
    List<Shipment> getShipments();
}
