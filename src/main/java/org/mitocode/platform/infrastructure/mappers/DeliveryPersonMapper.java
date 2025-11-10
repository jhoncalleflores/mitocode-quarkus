package org.mitocode.platform.infrastructure.mappers;

import lombok.experimental.UtilityClass;
import org.mitocode.platform.domain.model.entities.DeliveryPerson;
import org.mitocode.platform.interfaces.resources.request.DeliveryPersonRequest;

@UtilityClass
public final class DeliveryPersonMapper {

    public static DeliveryPerson mapDeliveryPersonRequestToResponse(DeliveryPersonRequest request) {
        return DeliveryPerson.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .licensePlate(request.licensePlate())
                .isAvailable(request.isAvailable())
                .build();
    }

}
