/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Implementacao;

import MapeamentoCidades.Entidades.Cidade;
import MapeamentoCidades.Interfaces.CidadeDao;
import br.com.crescer.aula03.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author deordines.tomazi
 */
public class CidadeDaoImpl implements CidadeDao {

    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (ID, NOME, ESTADO) VALUES (?,?,?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ? ESTADO = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";

    @Override
    public void Insert(Cidade c) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_CIDADE)) {

            preparedStatement.setLong(1, c.getId());
            preparedStatement.setString(2, c.getNome());
            preparedStatement.setLong(3, c.getIdEstado());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Update(Cidade c) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_CIDADE)) {

            preparedStatement.setString(1, c.getNome());
            preparedStatement.setLong(2, c.getIdEstado());
            preparedStatement.setLong(3, c.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Delete(Cidade c) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_CIDADE)) {

            preparedStatement.setLong(1, c.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Cidade LoadBy(Long id) {
        final Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_CIDADE)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    cidade.setId(resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                    cidade.setIdEstado(resultSet.getLong("SIGLA"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidade;
    }
}