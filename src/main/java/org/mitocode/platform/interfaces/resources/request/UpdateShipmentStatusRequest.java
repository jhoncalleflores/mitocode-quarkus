package org.mitocode.platform.interfaces.resources.request;

import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Location;

public record UpdateShipmentStatusRequest(
    ShipmentStatus newShipmentStatus,
    Location location
) { }
