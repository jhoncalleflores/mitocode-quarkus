package org.mitocode.platform.domain.model.valueobjects;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Item (
    BigDecimal weight,
    BigDecimal estimatedPrice
) {}
