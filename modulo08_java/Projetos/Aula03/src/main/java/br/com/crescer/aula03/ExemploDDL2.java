package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 * @author carloshenrique
 */
public class ExemploDDL2 {
    
    public static void main(String[] args) {
        final TableUtilsImpl EXECUTAR = new TableUtilsImpl();
        EXECUTAR.Create();
        EXECUTAR.Insert();
        EXECUTAR.Drop();
    }
}