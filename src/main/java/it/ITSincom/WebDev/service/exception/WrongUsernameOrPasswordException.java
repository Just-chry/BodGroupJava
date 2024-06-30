package it.ITSincom.WebDev.service.exception;

public class WrongUsernameOrPasswordException extends Exception {
    public WrongUsernameOrPasswordException() {
        super("Username o password errati");
    }
}
