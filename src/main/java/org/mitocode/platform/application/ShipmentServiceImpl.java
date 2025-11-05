package org.mitocode.platform.application;

import jakarta.enterprise.context.ApplicationScoped;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.services.ShipmentService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ShipmentServiceImpl implements ShipmentService {

    private static final List<Shipment> shipments = new ArrayList<>();

    @Override
    public void addNewShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    @Override
    public List<Shipment> getShipments() {
        return shipments;
    }
}
