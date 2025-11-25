package org.mitocode.platform.infrastructure.mappers;

import lombok.experimental.UtilityClass;
import org.mitocode.platform.domain.model.entities.DeliveryPerson;
import org.mitocode.platform.interfaces.resources.request.DeliveryPersonRequest;
import org.mitocode.platform.interfaces.resources.response.DeliveryPersonResponse;

@UtilityClass
public final class DeliveryPersonMapper {

    public static DeliveryPerson mapDeliveryPersonRequestToDeliveryPerson(DeliveryPersonRequest request) {
        return DeliveryPerson.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .licensePlate(request.licensePlate())
                .isAvailable(request.isAvailable())
                .build();
    }

    public static DeliveryPersonResponse mapDeliveryPersonToResponse(DeliveryPerson deliveryPerson) {
        if (deliveryPerson == null) { return null; }

        return DeliveryPersonResponse.builder()
                .code(deliveryPerson.getCode())
                .firstName(deliveryPerson.getFirstName())
                .lastName(deliveryPerson.getLastName())
                .licensePlate(deliveryPerson.getLicensePlate())
                .isAvailable(deliveryPerson.isAvailable())
                .build();
    }

}
