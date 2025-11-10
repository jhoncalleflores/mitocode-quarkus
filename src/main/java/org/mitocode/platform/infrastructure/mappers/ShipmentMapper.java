package org.mitocode.platform.infrastructure.mappers;

import lombok.experimental.UtilityClass;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.interfaces.resources.request.CreateShipmentRequest;
import org.mitocode.platform.interfaces.resources.response.ShipmentResponse;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public final class ShipmentMapper {

    public static Shipment mapCreateShipmentRequestToShipment(CreateShipmentRequest request) {
        return Shipment.builder()
                .customerId(request.customerId())
                .item(request.item())
                .createdAt(LocalDateTime.now())
                .currentStatus(ShipmentStatus.CREATED)
                .build();
    }

    public static ShipmentResponse mapShipmentToShipmentResponse(Shipment shipment) {
        return ShipmentResponse.builder()
                .code(shipment.getCode())
                .customerId(shipment.getCustomerId())
                .currentStatus(shipment.getCurrentStatus())
                .item(shipment.getItem())
                .assignedDeliveryPerson(shipment.getAssignedDeliveryPerson())
                .createdAt(shipment.getCreatedAt())
                .lastModifiedAt(shipment.getLastModifiedAt())
                .build();
    }

    public static List<ShipmentResponse> mapShipmentsToShipmentResponses(List<Shipment> shipments) {
        return shipments.stream().map(ShipmentMapper::mapShipmentToShipmentResponse).toList();
    }
}
