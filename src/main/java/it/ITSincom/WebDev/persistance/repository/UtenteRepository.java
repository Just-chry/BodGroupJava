package it.ITSincom.WebDev.persistance.repository;

import it.ITSincom.WebDev.persistance.model.Utente;
import jakarta.enterprise.context.ApplicationScoped;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

@ApplicationScoped
public class UtenteRepository {

    private final DataSource dataSource;

    public UtenteRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<Utente> findByUsernameAndPassword(String username, String password) {
        try {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement("SELECT id, username, password FROM Utente WHERE username = ? AND password = ?")) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    var resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Utente utente = new Utente();
                        utente.setId(resultSet.getInt("id"));
                        utente.setUsername(resultSet.getString("username"));
                        return Optional.of(utente);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
