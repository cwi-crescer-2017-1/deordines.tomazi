/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.Exercicios;

import br.com.crescer.Interfaces.ReaderUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Deordines
 */
public class ReaderUtilsImpl implements ReaderUtils {
    
    public static void main (String[] args) {
        ReaderUtilsImpl executar = new ReaderUtilsImpl();
        
        System.out.println(executar.read("arquivoTeste.txt"));
    }
    
    /*
    O método read receba o nome do arquivo e exiba seu conteúdo.
    O arquivo deve ser apenas do tipo .txt, caso contrário exibir lançar um exception.
    Caso não localize-o, então deve lançar um exception.
    */
    
    @Override
    public String read(String string) {
        try {
            final File file = new File(string);
            
            if (!string.contains(".txt")) {
                return new String("Somente arquivo de extensão .txt pode ser lido.");
            } else if (file.isDirectory() || !file.exists()) {
                return new String("Arquivo não encontrado");
            }
            
            final Reader reader = new FileReader(string);
            final BufferedReader bufferReader = new BufferedReader(reader);
            final StringBuilder builder = new StringBuilder();
            
            bufferReader
                    .lines()
                    .forEach(linha -> builder.append(linha + System.getProperty("line.separator")));
            
            return builder.toString();
        } catch (Exception e) {
            //
        }
        return null;
    }
}
