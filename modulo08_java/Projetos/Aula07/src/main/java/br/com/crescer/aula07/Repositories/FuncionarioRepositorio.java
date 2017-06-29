/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Repositories;

import br.com.crescer.aula07.Entidades.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Deordines
 */
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {
    
}
