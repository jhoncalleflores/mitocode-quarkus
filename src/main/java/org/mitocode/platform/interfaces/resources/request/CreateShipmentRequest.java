package org.mitocode.platform.interfaces.resources.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mitocode.platform.domain.model.valueobjects.Item;

public record CreateShipmentRequest(
    @NotBlank(message = "El campo customerId no puede ser blanco, vacio o nulo")
    String customerId,

    @NotNull(message = "El campo item no puede ser nulo")
    Item item
) {
}
