package org.mitocode.platform.domain.model.valueobjects;

import lombok.Builder;
import org.mitocode.platform.domain.model.enums.ItemType;

import java.math.BigDecimal;

@Builder
public record Item (
    BigDecimal weight,
    ItemType itemType,
    boolean isFragile
) {}
