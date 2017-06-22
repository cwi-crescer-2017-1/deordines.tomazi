/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;

import br.com.crescer.Interfaces.StringUtils;
import java.text.Normalizer;

/**
 *
 * @author deordines.tomazi
 */
public class StringUtilsImpl implements StringUtils {
    
    /*
    O método isEmpty deve validar se a string está nula e vazia.
    O método inverter deve inverter uma string caso a mesma não estiver vazia, exemplo - carlos > solrac
    O método contarVogais que conte o nº de vogais da String (a,e,i,o,u), exemplo - carlos > 2
    O método isPalindromo deve identificar se a string é um palíndromo, ou seja se quando invertida ela tem os mesmos caracteres sem os espaços,
    acentuação e case sensitive, exemplo - "ovo", "Ame a ema", "A sogra má e amargosa")
     */
    
    public String RemoverAcentuacao(String string) {
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        return string;
    }
    
    @Override
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    @Override
    public String inverter(String string) {
        if (!isEmpty(string))
        {
            StringBuilder builder = new StringBuilder();
            builder.append(string);
            builder.reverse();
            return builder.toString();
        }
        return null;
    }

    @Override
    public int contaVogais(String string) {
        string = string.replaceAll("(?i)[(b-d)(f-h)(j-n)(p-t)(v-z)]", "");
        return string.length();
    }

    @Override
    public boolean isPalindromo(String string) {
        string = RemoverAcentuacao(string);
        string = string.replaceAll(" ", "").toLowerCase();
        
        char[] letrasNormais = string.toCharArray();
        char[] letrasInvertidas = new char[0];
        String stringInvertida = inverter(string);
        letrasInvertidas = stringInvertida.toCharArray();
        
        for (int i = 0; i < letrasNormais.length; i++) {
            if (letrasNormais[i] != letrasInvertidas[i]) {
                return false;
            }
        }

        return true;
    }
}
