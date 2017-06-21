/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.Interfaces;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Deordines
 */
public interface Parcelator {

    Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento);

}