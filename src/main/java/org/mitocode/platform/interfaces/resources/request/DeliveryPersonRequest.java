package org.mitocode.platform.interfaces.resources.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeliveryPersonRequest(
    @NotBlank(message = "El campo firstName no puede ser blanco, vacio o nulo")
    String firstName,

    @NotBlank(message = "El campo lastName no puede ser blanco, vacio o nulo")
    String lastName,

    @NotBlank(message = "El campo licensePlate no puede ser blanco, vacio o nulo")
    String licensePlate,

    @NotNull(message = "El campo customerId no puede ser nulo")
    boolean isAvailable
) {
}
