/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Comentario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Deordines
 */
public interface ComentarioRepositorio extends CrudRepository<Comentario, Long> {
    
}
