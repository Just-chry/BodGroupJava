package it.ITSincom.WebDev.rest.exception;

import it.ITSincom.WebDev.service.exception.SessionCreationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SessionCreationExceptionMapper implements ExceptionMapper<SessionCreationException> {

    @Override
    public Response toResponse(SessionCreationException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .build();
    }
}