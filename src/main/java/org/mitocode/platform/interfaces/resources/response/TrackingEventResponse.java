package org.mitocode.platform.interfaces.resources.response;

import lombok.Builder;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Location;

import java.time.LocalDateTime;

@Builder
public record TrackingEventResponse(
    String code,
    ShipmentStatus status,
    ShipmentResponse associatedShipment,
    Location location,
    LocalDateTime createdAt,
    LocalDateTime lastModifiedAt
) {
}
