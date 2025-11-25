package org.mitocode.platform.infrastructure.exceptions.handlers;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BusinessException extends RuntimeException {
    private final UUID id;
    private final BusinessErrorType type;
    private final String description;

    @Builder
    public BusinessException(BusinessErrorType businessErrorType, String description) {
        super(description);
        this.id = UUID.randomUUID();
        this.description = businessErrorType.getDescription().formatted(description);
        this.type = businessErrorType;
    }

}
