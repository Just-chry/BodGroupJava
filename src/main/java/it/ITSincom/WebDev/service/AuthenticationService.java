package it.ITSincom.WebDev.service;

import it.ITSincom.WebDev.persistance.model.Utente;
import it.ITSincom.WebDev.persistance.repository.SessionRepository;
import it.ITSincom.WebDev.persistance.repository.UtenteRepository;
import it.ITSincom.WebDev.service.exception.SessionCreationException;
import it.ITSincom.WebDev.service.exception.WrongUsernameOrPasswordException;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.SQLException;
import java.util.Optional;

@ApplicationScoped
public class AuthenticationService {

    private final UtenteRepository utenteRepository;
    private final SessionRepository sessionRepository;

    public AuthenticationService(UtenteRepository utenteRepository, SessionRepository sessionRepository) {
        this.utenteRepository = utenteRepository;
        this.sessionRepository = sessionRepository;
    }

    public int login(String username, String password) throws WrongUsernameOrPasswordException, SessionCreationException {
        Optional<Utente> maybeUtente = utenteRepository.findByUsernameAndPassword(username, password);
        if (maybeUtente.isPresent()) {
            Utente u = maybeUtente.get();
            try {
                return sessionRepository.insertSession(u.getId());
            } catch (SQLException e) {
                throw new SessionCreationException(e);
            }
        } else {
            throw new WrongUsernameOrPasswordException();
        }
    }

    public void logout(int sessionId){
        sessionRepository.delete(sessionId);
    }
}
