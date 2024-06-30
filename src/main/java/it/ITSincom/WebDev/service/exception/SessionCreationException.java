package it.ITSincom.WebDev.service.exception;
import java.sql.SQLException;

public class SessionCreationException extends Exception {
    public SessionCreationException(String message) {
        super(message);
    }

    public SessionCreationException(SQLException cause) {
        super(cause);
    }
}

