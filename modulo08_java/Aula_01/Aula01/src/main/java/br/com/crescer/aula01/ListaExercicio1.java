/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;

import br.com.crescer.Interfaces.CalendarUtils;
import br.com.crescer.Interfaces.Parcelator;
import br.com.crescer.Interfaces.StringUtils;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Deordines
 */
public class ListaExercicio1 implements StringUtils, CalendarUtils, Parcelator {
    
    public static void main (String[] args) {
        ListaExercicio1 executar = new ListaExercicio1();
        
        System.out.println(executar.isEmpty(""));
        System.out.println(executar.isEmpty("Oi"));
        System.out.println(executar.inverter(""));
        System.out.println(executar.inverter("Inverter"));
        System.out.println(executar.contaVogais("abcdefghijklmnopqrstuvxwyz"));
        System.out.println(executar.contaVogais("abcdefghijklmnopqrstuvxwyz".toUpperCase()));
        System.out.println(executar.isPalindromo("ovo"));
        System.out.println(executar.isPalindromo("Ame a ema"));
        System.out.println(executar.isPalindromo("A sogra má e amargosa"));
    }
    
    public String RemoverAcentuacao(String string) {
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        return string;
    }
    
    /*
    O método isEmpty deve validar se a string está nula e vazia.
    O método inverter deve inverter uma string caso a mesma não estiver vazia, exemplo - carlos > solrac
    O método contarVogais que conte o nº de vogais da String (a,e,i,o,u), exemplo - carlos > 2
    O método isPalindromo deve identificar se a string é um palíndromo, ou seja se quando invertida ela tem os mesmos caracteres sem os espaços,
    acentuação e case sensitive, exemplo - "ovo", "Ame a ema", "A sogra má e amargosa")
     */
    
    @Override
    public boolean isEmpty(String string) {
        return string == null || string.isEmpty();
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
    // ---------------------------------------- //
    
    /*
    O método diaSemana recebe uma data e devolve o dia da semana conforme enum.
    O método tempoDecorrido recebe uma data e devolve o tempo decorrido até a data atual no formato 30 ano(s), 3 messe(s) e 12 dia(s)
    */
    
    @Override
    public DiaSemana diaSemana(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tempoDecorrido(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // ---------------------------------------- //
    
    /*
    O método calcular deve retornar um map com a data de vencimento (dd/MM/yyyy) da parcela e o valor (R$ .....).
    */
    
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
