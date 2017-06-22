/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;

import br.com.crescer.Interfaces.CalendarUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author deordines.tomazi
 */
public class CalendarUtilsImpl implements CalendarUtils {
    
        public static void main (String[] args) {
        ListaExercicio1 executar = new ListaExercicio1();
        
        
        try {
            System.out.println(executar.diaSemana(new SimpleDateFormat("dd/MM/yyyy").parse("21/06/2017")));
        } catch (Exception e) {
            // ..
        }
        
        try {
            System.out.println(executar.tempoDecorrido(new SimpleDateFormat("dd/MM/yyyy").parse("18/08/1993")));
        } catch (Exception e) {
            // ..
        }
    }
    /*
    O método diaSemana recebe uma data e devolve o dia da semana conforme enum.
    O método tempoDecorrido recebe uma data e devolve o tempo decorrido até a data atual no formato 30 ano(s), 3 messe(s) e 12 dia(s)
    */
    
    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        calendar.get(Calendar.YEAR);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DAY_OF_YEAR);
        
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return DiaSemana.DOMINGO;
            case 2:
                return DiaSemana.SEGUNDA_FEIRA;
            case 3:
                return DiaSemana.TERCA_FEIRA;
            case 4:
                return DiaSemana.QUARTA_FEIRA;
            case 5:
                return DiaSemana.QUINTA_FEIRA;
            case 6:
                return DiaSemana.SEXTA_FEIRA;
            case 7:
                return DiaSemana.SABADO;
            default:
                return null;
        }
    }

    @Override
    public String tempoDecorrido(Date date) {
        Calendar calendar = Calendar.getInstance();
        Date diferencaEntreDatas = new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime());
        calendar.setTime(diferencaEntreDatas);
        
        String string = String.format("%1$d anos(s), %2$d mes(es) e %3$d dia(s)", Calendar.YEAR - 1970, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        return string;
//        Calendar calendarStart = Calendar.getInstance();
//        Calendar calendarEnd = Calendar.getInstance();
        
        
//        calendarStart.setTime(date);
//        calendarEnd.set(Calendar.get(Calendar.YEAR), Calendar.get(Calendar.MONTH), Calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        
//        final int ano = calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR);
//        final int mes = calendarEnd.get(Calendar.MONTH) - calendarStart.get(Calendar.MONTH);
//        final int dia = calendarEnd.get(Calendar.DAY_OF_MONTH) - calendarStart.get(Calendar.DAY_OF_MONTH);
//        
//        String string = String.format("%1$d anos(s), %2$d mes(es) e %3$d dia(s)", ano, mes, dia);
//        return string;
    }
    
    private Date getHoraZero(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, 0, 0, 0);
        return calendar.getTime();
    }
}
