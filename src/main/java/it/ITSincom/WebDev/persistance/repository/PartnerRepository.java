package it.ITSincom.WebDev.persistance.repository;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import it.ITSincom.WebDev.persistance.model.Partner;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PartnerRepository {

    private final AgroalDataSource dataSource;

    public PartnerRepository(@DataSource("db2") AgroalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Partner> findAll() {
        List<Partner> partners = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT TOP 10 * FROM PartnerContracts")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Partner partner = new Partner();
                        partner.setPartnerCode(resultSet.getString("PartnerCode"));
                        partner.setPartnerName(resultSet.getString("PartnerName"));
                        partner.setContractCode(resultSet.getString("ContractCode"));
                        partner.setContractDescription(resultSet.getString("ContractDescription"));
                        partner.setContractStart(resultSet.getDate("ContractStart").toLocalDate());
                        partner.setContractEnd(resultSet.getDate("ContractEnd").toLocalDate());
                        partner.setFinalPriceExcludingVAT(resultSet.getDouble("FinalPriceExcludingVAT"));
                        partner.setProductCode(resultSet.getString("ProductCode"));
                        partner.setProductName(resultSet.getString("ProductName"));
                        partner.setTime(resultSet.getDate("Time").toLocalDate());
                        partners.add(partner);
                    }
                    return partners;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Partner> findByName(String name) {
        List<Partner> partners = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM PartnerContracts WHERE PartnerName = ?")) {
                statement.setString(1, name);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Partner partner = new Partner();
                        partner.setPartnerCode(resultSet.getString("PartnerCode"));
                        partner.setPartnerName(resultSet.getString("PartnerName"));
                        partner.setContractCode(resultSet.getString("ContractCode"));
                        partner.setContractDescription(resultSet.getString("ContractDescription"));
                        partner.setContractStart(resultSet.getDate("ContractStart").toLocalDate());
                        partner.setContractEnd(resultSet.getDate("ContractEnd").toLocalDate());
                        partner.setFinalPriceExcludingVAT(resultSet.getDouble("FinalPriceExcludingVAT"));
                        partner.setProductCode(resultSet.getString("ProductCode"));
                        partner.setProductName(resultSet.getString("ProductName"));
                        partner.setTime(resultSet.getDate("Time").toLocalDate());
                        partners.add(partner);
                    }
                    return partners;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
