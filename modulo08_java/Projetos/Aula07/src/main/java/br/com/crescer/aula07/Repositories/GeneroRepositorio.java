/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Repositories;

import br.com.crescer.aula07.Entidades.Genero;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author deordines.tomazi
 */
public interface GeneroRepositorio extends CrudRepository<Genero, Long> {

}
