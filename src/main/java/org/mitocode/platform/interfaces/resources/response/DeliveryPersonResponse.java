package org.mitocode.platform.interfaces.resources.response;

import lombok.Builder;

@Builder
public record DeliveryPersonResponse(
    String code,
    String firstName,
    String lastName,
    String licensePlate,
    boolean isAvailable
) {}
