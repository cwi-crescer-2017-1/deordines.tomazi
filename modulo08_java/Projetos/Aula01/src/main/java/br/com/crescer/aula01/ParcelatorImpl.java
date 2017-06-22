/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;

import br.com.crescer.Interfaces.Parcelator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author deordines.tomazi
 */
public class ParcelatorImpl implements Parcelator {
    
    /*
    O método calcular deve retornar um map com a data de vencimento (dd/MM/yyyy) da parcela e o valor (R$ .....).
    */
    
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        final DateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
        final Calendar calendar = Calendar.getInstance();
        
        final BigDecimal qtdParcelas = BigDecimal.valueOf(numeroParcelas);
        final BigDecimal multiplicador = BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
        final BigDecimal vlTotal = valorParcelar.multiply(multiplicador);
        final BigDecimal vlParcela = vlTotal.divide(qtdParcelas, 2, RoundingMode.HALF_UP);

        BigDecimal vlResto = vlParcela.multiply(qtdParcelas).subtract(vlTotal);

        final Map<String, BigDecimal> map = new LinkedHashMap<>();

        calendar.setTime(dataPrimeiroVencimento);

        for (int i = 0; i < numeroParcelas; i++) {
            map.put(formatoData.format(calendar.getTime()), vlParcela.subtract(vlResto));
            vlResto = BigDecimal.ZERO;
            calendar.add(Calendar.MONTH, 1);
        }
        return map;
    }
}
