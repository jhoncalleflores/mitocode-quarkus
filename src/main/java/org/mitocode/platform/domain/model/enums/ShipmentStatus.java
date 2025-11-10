package org.mitocode.platform.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum ShipmentStatus {
    CREATED("created", List.of("picked_up")),
    PICKED_UP("picked_up", List.of("in_transit")),
    IN_TRANSIT("in_transit", List.of("at_sorting_center", "out_for_delivery")),
    AT_SORTING_CENTER("at_sorting_center", List.of("in_transit", "out_for_delivery")),
    OUT_FOR_DELIVERY("out_for_delivery",  List.of("delivered", "incident")),
    DELIVERED("delivery", List.of()),
    INCIDENT("incident", List.of("in_transit", "out_for_delivery")),;

    private final String state;
    private final List<String> nextStates;

    public boolean isValidNextState(String nextState) {
        return nextStates.contains(nextState);
    }

    @JsonValue
    public String getState() {
        return state;
    }

    @JsonCreator
    public static ShipmentStatus createFromState(String state) {
        return Stream.of(ShipmentStatus.values())
                .filter(shipmentStatus -> shipmentStatus.state.equals(state))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El valor " + state + " no es un estado valido"));
    }

}
