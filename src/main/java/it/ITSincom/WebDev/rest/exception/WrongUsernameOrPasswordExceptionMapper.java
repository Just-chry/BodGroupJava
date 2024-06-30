package it.ITSincom.WebDev.rest.exception;

import it.ITSincom.WebDev.service.exception.WrongUsernameOrPasswordException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WrongUsernameOrPasswordExceptionMapper implements ExceptionMapper<WrongUsernameOrPasswordException> {
    @Override
    public Response toResponse(WrongUsernameOrPasswordException exception){
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(exception.getMessage())
                .build();
    }
}