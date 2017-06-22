/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.Aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deordines.tomazi
 */
public final class ConnectionUtils {
    
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String USER = "AULAJAVA";
    private final static String PASS = "AULAJAVA";
        
    private ConnectionUtils() {
    
    }
    
    public final static Connection getConnection() throws SQLException {
        try {
            final Connection connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException sqlE) {
            return null;
        }
    }
}
