/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.Exercicios;

import br.com.crescer.Interfaces.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deordines
 */
public class FileUtilsImpl implements FileUtils {

    /*
    O método mk deve criar um arquivo ou diretório.
    O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
    O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    */
        
    @Override
    public boolean mk(String string) {
        try {
            return new File(string).createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean rm(String string) {
        final File file = new File(string);
        
        if (file.isFile()) {
            return file.delete();
        } else {
            System.out.println("Arquivo inválido");
            return false;
        }
    }

    @Override
    public String ls(String string) {
        final File file = new File(string);
        
        if (file.isFile()) {
            return file.getAbsolutePath();
        } else {
            final String[] lista = file.list();
            
            StringBuilder builder = new StringBuilder();
            
            for (String s : lista) {
                builder.append(s + System.getProperty("line.separator"));
            }
            return builder.toString();
        }
    }

    @Override
    public boolean mv(String in, String out) {
        final File fileIn = new File(in);
        final File fileOut = new File(out);
        
        if (fileIn.isDirectory() || fileOut.isDirectory()) {
            System.out.println("Arquivo inválido");
            return false;
        } else {
            try {
                Files.move(fileIn.toPath(), fileOut.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                //
            }
            return true;
        }
    }
    
}
