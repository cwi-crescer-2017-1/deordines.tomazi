/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03.Exercicios;

import br.com.crescer.Aula03.ConnectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author deordines.tomazi
 */
public class SQLUtilsImpl implements SQLUtils {

    /*
    Deve possuir um metodo que execute as instruções contidas dentro de um arquivo, o mesmo tem que ser um ".sql".
    Deve receber um instrução sql (query) e retorna um tabela com o nome das colunas e linhas.
    Deve possuir um metodo onde possa ser importado um arquivo ".csv".
    Deve possuir um metodo onde possa ser exportado um arquivo ".csv".
     */
    
    @Override
    public void runFile(String filename) {
        try {
            final File file = new File(filename);

            if (!filename.contains(".sql")) {
                throw new Exception("Somente arquivo de extensão .txt pode ser lido.");
            } else if (file.isDirectory() || !file.exists()) {
                throw new Exception("Arquivo não encontrado");
            }

            final Reader reader = new FileReader(filename);
            final BufferedReader bufferReader = new BufferedReader(reader);
            ArrayList<String> comandosSQL = new ArrayList<String>();

            bufferReader
                    .lines()
                    .forEach(linha -> comandosSQL.add(linha));
            
            try (final Connection connection = ConnectionUtils.getConnection()) {
                PreparedStatement preparedStatement;
                for (String s : comandosSQL) {
                    System.out.println(s);
                    preparedStatement = connection.prepareStatement(s);
                    preparedStatement.executeUpdate();
                    System.out.println(connection.isClosed());
                }
            } catch (SQLException ex) {
                //
            }
        } catch (Exception e) {
            //
        }
    }

    @Override
    public String executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
