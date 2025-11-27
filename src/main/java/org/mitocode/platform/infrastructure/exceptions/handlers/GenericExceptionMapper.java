package org.mitocode.platform.infrastructure.exceptions.handlers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.mitocode.platform.interfaces.resources.Result;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        String message = exception.getMessage();

        var result = Result
                        .builder()
                        .data(message)
                        .httpStatus(Response.Status.INTERNAL_SERVER_ERROR)
                        .build();

        return Response.serverError().entity(result).build();
    }
}
