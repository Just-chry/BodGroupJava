package it.ITSincom.WebDev.persistance.repository;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class SessionRepository {
    private final AgroalDataSource dataSource;

    public SessionRepository(@DataSource("db1") AgroalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insertSession(int id) throws SQLException {

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO sessione (id_utente) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        throw new SQLException("Cannot insert new session for partecipante " + id);
    }

    public int delete(int sessionId) {

        try {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement("DELETE FROM sessione WHERE ID_Sessione = ?")) {
                    statement.setInt(1, sessionId);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sessionId;
    }
}
