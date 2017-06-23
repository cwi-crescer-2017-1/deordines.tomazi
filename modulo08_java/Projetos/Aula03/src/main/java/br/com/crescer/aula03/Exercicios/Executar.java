/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03.Exercicios;

/**
 *
 * @author deordines.tomazi
 */
public class Executar {
    
    public static void main (String[] args) {
        final SQLUtils sqlUtils = new SQLUtilsImpl();
        
//        sqlUtils.runFile("arquivo.sql");
        System.out.println(sqlUtils.executeQuery("SELECT * FROM CIDADE WHERE ID = 3000"));

    }
}
