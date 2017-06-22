package MapeamentoCidades.Implementacao;

import MapeamentoCidades.Entidades.Pais;
import MapeamentoCidades.Interfaces.PaisDao;
import br.com.crescer.Aula03.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author deordines.tomazi
 */
public class PaisDaoImpl implements PaisDao {

    private static final String INSERT_PAIS = "INSERT INTO PAIS (ID, NOME, SIGLA) VALUES (?,?, ?)";
    private static final String UPDATE_PAIS = "UPDATE PAIS SET NOME = ? SIGLA = ? WHERE ID = ?";
    private static final String DELETE_PAIS = "DELETE FROM PAIS WHERE ID = ?";
    private static final String LOAD_PAIS = "SELECT * FROM PAIS WHERE ID = ?";

    @Override
    public void Insert(Pais p) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_PAIS)) {

            preparedStatement.setLong(1, p.getId());
            preparedStatement.setString(2, p.getNome());
            preparedStatement.setString(3, p.getSigla());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Update(Pais p) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_PAIS)) {

            preparedStatement.setString(1, p.getNome());
            preparedStatement.setString(2, p.getSigla());
            preparedStatement.setLong(3, p.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Delete(Pais p) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_PAIS)) {

            preparedStatement.setLong(1, p.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Pais LoadBy(Long id) {
        final Pais pais = new Pais();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_PAIS)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pais.setId(resultSet.getLong("ID"));
                    pais.setNome(resultSet.getString("NOME"));
                    pais.setSigla(resultSet.getString("SIGLA"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pais;
    }
}