/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Implementacao;

import MapeamentoCidades.Entidades.Estado;
import MapeamentoCidades.Interfaces.EstadoDao;
import br.com.crescer.aula03.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author deordines.tomazi
 */
public class EstadoDaoImpl implements EstadoDao {
    
    private static final String INSERT_ESTADO = "INSERT INTO ESTADO (ID, NOME, UF, PAIS) VALUES (?,?,?,?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ? UF = ? PAIS = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";

    @Override
    public void Insert(Estado e) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)) {

            preparedStatement.setLong(1, e.getId());
            preparedStatement.setString(2, e.getNome());
            preparedStatement.setString(3, e.getUf());
            preparedStatement.setLong(4, e.getIdPais());


            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Update(Estado e) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)) {

            preparedStatement.setString(1, e.getNome());
            preparedStatement.setString(2, e.getUf());
            preparedStatement.setLong(3, e.getIdPais());

            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void Delete(Estado e) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADO)) {

            preparedStatement.setLong(1, e.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Estado LoadBy(Long id) {
        final Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADO)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUf(resultSet.getString("UF"));
                    estado.setIdPais(resultSet.getLong("PAIS"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }
}