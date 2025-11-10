package org.mitocode.platform.domain.model.valueobjects;

import java.math.BigDecimal;

public record Location(
    BigDecimal latitude,
    BigDecimal longitude
) { }
