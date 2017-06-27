/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicio.dao;

import br.com.crescer.aula04.exercicio.entidades.Video;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Deordines
 */
public class VideoDAO extends AbstractCrudDAO<Video, Long> {

    public VideoDAO(EntityManager entityManager) {
        super(Video.class, entityManager);
    }
}