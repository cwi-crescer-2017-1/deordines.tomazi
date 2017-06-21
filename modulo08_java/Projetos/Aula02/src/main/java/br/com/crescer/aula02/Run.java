/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deordines.tomazi
 */
public class Run {

    public static void main(String[] args) throws IOException {
        final File file = new File("aula2.txt");
        file.createNewFile();

        System.out.println(file.getAbsolutePath());
    }
}
