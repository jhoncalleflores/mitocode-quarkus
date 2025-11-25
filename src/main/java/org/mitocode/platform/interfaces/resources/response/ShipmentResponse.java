package org.mitocode.platform.interfaces.resources.response;

import lombok.Builder;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Item;

import java.time.LocalDateTime;

@Builder
public record ShipmentResponse(
    String code,
    String customerId,
    ShipmentStatus currentStatus,
    Item item,
    DeliveryPersonResponse assignedDeliveryPerson,
    LocalDateTime createdAt,
    LocalDateTime lastModifiedAt
) {
}
