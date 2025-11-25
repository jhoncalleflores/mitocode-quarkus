package org.mitocode.platform.infrastructure.exceptions.handlers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.mitocode.platform.interfaces.resources.Result;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException exception) {
        var result = Result
                        .builder()
                        .data(exception.getDescription())
                        .httpStatus(exception.getType().getStatus())
                        .build();

        return Response
                .status(exception.getType().getStatus())
                .entity(result)
                .build();
    }
}
