package org.mitocode.platform.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum ItemType {
    FOOD("food"),
    HOUSEHOLD_APPLIANCE("household_appliance"),
    FURNITURE("furniture"),
    OTHERS("others");

    private final String value;

    @JsonCreator
    public static ItemType createFromValue(String value) {
        return Stream.of(values())
                .filter(itemType -> itemType.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El valor " + value + " no es un tipo de item valido"));
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
