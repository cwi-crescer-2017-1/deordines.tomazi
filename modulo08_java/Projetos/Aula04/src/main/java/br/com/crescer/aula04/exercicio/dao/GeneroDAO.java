/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicio.dao;

import br.com.crescer.aula04.exercicio.entidades.Genero;
import java.util.List;

/**
 *
 * @author Deordines
 */
public class GeneroDAO extends AbstractCrudDAO<Genero, Long> {

    public GeneroDAO() {
        super(Genero.class);
    }
}