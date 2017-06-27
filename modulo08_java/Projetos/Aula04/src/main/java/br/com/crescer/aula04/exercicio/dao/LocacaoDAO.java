/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicio.dao;

import br.com.crescer.aula04.exercicio.entidades.Locacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Deordines
 */
public class LocacaoDAO extends AbstractCrudDAO<Locacao, Long> {

    public LocacaoDAO(EntityManager entityManager) {
        super(Locacao.class, entityManager);
    }
}