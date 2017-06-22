/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.Exercicios;

import br.com.crescer.Interfaces.WriterUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author Deordines
 */
public class WriterUtilsImpl implements WriterUtils {
    
    /*
    O método write recebe o nome do arquivo e o conteúdo que deve ser gravado.
    O arquivo deve ser apenas do tipo .txt, caso contrário exibir lançar um exception.
    Caso não localize-o, então deve lançar um exception.
    */
    
    @Override
    public void write(String file, String conteudo) {
        final File newFile = new File(file);
        
        try {
            if (!file.contains(".txt")) {
                throw new Exception("Somente arquivo de extensão .txt pode ser lido.");
            } else if (newFile.isDirectory() || !newFile.exists()) {
                throw new Exception("Arquivo não encontrado");
            }
            
            final Writer writer = new FileWriter(newFile, true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.append(conteudo);
            bufferedWriter.append(System.getProperty("line.separator"));
            bufferedWriter.flush();            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
