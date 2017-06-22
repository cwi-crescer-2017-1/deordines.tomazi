/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author deordines.tomazi
 */
public class ExemploDDL {

    private static final String DML = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  SIGLA VARCHAR2(10) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";

    public static void main(String[] args) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "AULAJAVA";
        final String pass = "AULAJAVA";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
            final Statement statement = connection.createStatement();) {
            statement.executeQuery(DML);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}